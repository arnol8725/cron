/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import Com.Elektra.Log.Dao.LogeoDAO;

import com.elektra.uniformes.comercio.cron.dao.CDDAO;
import com.elektra.uniformes.comercio.cron.dao.CorreoDAO;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaCDXTiendas.IntfGETInventarioService;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaCDXTiendas.Parametro;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaCDXTiendas.TDAS;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaCDXTiendas.TSalida;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaCDXTiendas.PortType;
import com.elektra.uniformes.comercio.cron.dao.modelo.CentroDistribucion;
import com.elektra.uniformes.comercio.cron.dao.modelo.CentroDistribucionXTiendas;
import com.elektra.uniformes.comercio.cron.dao.modelo.SOAPLoggingHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("negocioActualizacionCDXTiendas")
public class NegocioActualizacionCDXTiendas {
    
    @Autowired
    @Qualifier("cdDAO")
    private CDDAO cdDAO;    
    
    @Value("#{propiedadesCronUniformesComercio['WS_ABASTO_CONS_CD_X_TIENDAS']}")
    public String WS_ABASTO_CONS_CD_X_TIENDAS;    
    
    @Autowired
    @Qualifier("correoDAO")
    private CorreoDAO correoDAO;  

    /**
     * CRON DE ACTUALIZA CD X TIENDAS
     */
    private void cronActualizaCDXTiendas(){
       actualizaCDXTiendas();
    }
    
    /**
     * Contiene la ejecucion de la inicializacion de las tiendas 
     */
    public void actualizaCDXTiendas(){ 
        boolean isInicializado = true;  
        Date inicio = new Date();
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName(); 
        String error = "";
        ArrayList<CentroDistribucionXTiendas> lista = new ArrayList<CentroDistribucionXTiendas>();
        try{
            for (CentroDistribucion cd : cdDAO.getCentrosDistribucion()) {
                CentroDistribucionXTiendas cdxtiendas = actualizaCD(cd);
                //Logica Inicializa la tabla 
                if(!cdxtiendas.getTiendas().isEmpty() && isInicializado){
                    cdDAO.inicializaCDXTiendas();
                    isInicializado = false;
                }
                cdDAO.actualizaCDXTiendas(cdxtiendas);
                lista.add(cdxtiendas);
            }
        }catch(Exception e){
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);
        }finally{
            correoDAO.envio(lista.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);  
        }
    }
    
    /**
     * Se conecta al Web Services de Abasto para consultar las tiendas del CD
     * @param cd
     * @return 
     */
    public CentroDistribucionXTiendas actualizaCD(CentroDistribucion cd){
        SOAPLoggingHandler slh = null;
        CentroDistribucionXTiendas centroDistribucionXtiendas = null;
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();  
        try{
            centroDistribucionXtiendas = new CentroDistribucionXTiendas();
            //Apunta la ubicacion del WSDL en resources
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL wsdlLocation = classloader.getResource("WS_M_CATALOG_TDA.wsdl");           
            IntfGETInventarioService wsCDXTiendas = new IntfGETInventarioService(wsdlLocation,new QName("http://xmlns.example.com/1404945899682", "intfGET_Inventario-service"));
            PortType port = (PortType) wsCDXTiendas.getIntfwsGETInventarioEndpoint0();
            BindingProvider bp = (BindingProvider)port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,WS_ABASTO_CONS_CD_X_TIENDAS);
            //Guarda el response del Web Services
            Binding binding = bp.getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            slh = new SOAPLoggingHandler();
            handlerChain.add(slh);
            binding.setHandlerChain(handlerChain); 
            
            Parametro entrada = new Parametro();
            entrada.setCD(cd.getNoCD());
            
            TSalida respuesta = port.getInventarioOp(entrada);
            ArrayList<TDAS> listaSalida = new ArrayList<TDAS>(respuesta.getTDAS());
            for (TDAS response : listaSalida) {
                String cadenaCd = response.getCD().trim();
                String cadenaTienda = response.getNumTDA().trim();
                String nombreTienda = response.getNamTDA().trim();
                String nombreCD = response.getNomCD().trim();
                if(!isRespuestaVacia(cadenaCd,cadenaTienda)){
                    centroDistribucionXtiendas.setNoCD(Integer.parseInt(cadenaCd));
                    centroDistribucionXtiendas.getTiendas().add(Integer.parseInt(cadenaTienda));
                    centroDistribucionXtiendas.setMsj("OK");
                }else{
                    centroDistribucionXtiendas.setNoCD(Integer.parseInt(cadenaCd));
                    centroDistribucionXtiendas.setError(true);
                    centroDistribucionXtiendas.setMsj("Error WSAbasto");
                    LogeoDAO.getInstancia().logExcepcion(
                        "1. Respuestas inesperadas WSAbasto, en la clase: " + this.getClass().getName() + "\n" +
                        "2. Nombre del metodo: " + nombreMetodo + "\n" +
                        "3. URL: " + WS_ABASTO_CONS_CD_X_TIENDAS + "\n" +
                        "4. CD:" + cadenaCd + "\n" +
                        "5. Tienda:" + cadenaTienda
                    );
                }
            }       
        } catch (Exception e) {
            centroDistribucionXtiendas.setNoCD(cd.getNoCD());
            centroDistribucionXtiendas.setError(true);
            centroDistribucionXtiendas.setMsj(e.getMessage());
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } 
        return centroDistribucionXtiendas;
    }
    
    /**
     * Verifica si la respuesta es vacia
     * @param cd
     * @param tienda
     * @return 
     */
    public boolean isRespuestaVacia(String cd, String tienda){
       return ( cd.trim().isEmpty() || cd.trim().equals("") ) ||
              ( tienda.trim().isEmpty() || tienda.trim().equals("") );
    }
    
}