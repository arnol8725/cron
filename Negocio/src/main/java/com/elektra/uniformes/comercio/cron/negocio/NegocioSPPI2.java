/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.CargaSPPIDAO;
import com.elektra.uniformes.comercio.cron.dao.CorreoDAO;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2.AvanceCargaRealRequest;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2.AvanceCargaRealResponse;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2.CargaReal;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2.CargaRealesRequest;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2.CargaRealesResponse;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2.ConectorUnicoPort;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2.ConectorUnicoPortService;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2.DetalleCargaRealRequest;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2.DetalleCargaRealResponse;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.Token.GeneraTokenPort;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.Token.GeneraTokenPortService;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.Token.ObtieneTokenRequest;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.Token.ObtieneTokenResponse;
import com.elektra.uniformes.comercio.cron.dao.modelo.CargaSPPIDTO;
import com.elektra.uniformes.comercio.cron.dao.modelo.SOAPLoggingHandler;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
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

/**
 *
 * @author lrodriguez
 */
@Component("negocioSPPI2")
public class NegocioSPPI2 {
    
    @Autowired
    @Qualifier("cargaSPPIDAO")
    private CargaSPPIDAO cargaSPPIDAO;
    
    @Autowired
    @Qualifier("correoDAO")
    private CorreoDAO correoDAO;
    
    @Value("#{propiedadesCronUniformesComercio['WS_SPPI_2']}")
    private String WS_SPPI_2;
    
    @Value("#{propiedadesCronUniformesComercio['WS_TOKEN']}")
    private String WS_TOKEN; 
    
    @Value("#{propiedadesCronUniformesComercio['TAMANO_PEDIDOS_SPPI']}")
    private int TAMANO_PEDIDOS_SPPI; 
    
    @Value("#{propiedadesCronUniformesComercio['LOG_XML_TAMANO_PEDIDOS_SPPI']}")
    private String LOG_XML_TAMANO_PEDIDOS_SPPI; 
    
    private final static int OK = 1;
    
    /**
     * CRON DE SPPI
     */
    private void cronSPPI() throws Exception{
        LogeoDAO.getInstancia().logExcepcion("Inicia Cron SPPI V2.0 : " + new Date());
        if (validaFinDeSemana() && cargaSPPIDAO.validaDiaEnvio()) {/* validar si es dia habil*/
            this.grabadoSPPI();
        }
        LogeoDAO.getInstancia().logExcepcion("Termino Cron SPPI V2.0 : " + new Date());
    }
    
    /**
     * Inicia el proceso de grabado de SPPI y actualizacion
     */
    private void grabadoSPPI(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName(); 
        ArrayList<CargaSPPIDTO> pedidosSPPI = null;
        ArrayList<CargaSPPIDTO> avancePedidosSPPI = null;
        Date inicio = new Date();
        String mensajeError = "";
        try{    
            String token = "";
            pedidosSPPI = cargaSPPIDAO.consultaPendientesSPPI();
            avancePedidosSPPI = cargaSPPIDAO.consultaSPPIPorActualizar(); 
            
            //GRABADO DE PEDIDOS SPPI Y AVANCE DE PEDIDOS          
            if(pedidosSPPI != null){
                 LogeoDAO.getInstancia().logExcepcion("No. Pedidos pendientes de la carga SPPI :" + pedidosSPPI.size());
                if(!pedidosSPPI.isEmpty()){
                    ArrayList<CargaSPPIDTO> pedidosAux = new ArrayList<CargaSPPIDTO>();
                    for (CargaSPPIDTO pedido : pedidosSPPI) {
                        if(pedidosSPPI.indexOf(pedido) < TAMANO_PEDIDOS_SPPI){
                            //CONSULTA TOKEN
                            token = generaToken(    pedidosSPPI.get(0).getIdSistema().trim(),
                                                    pedidosSPPI.get(0).getClaveUsuario().trim(),
                                                    pedidosSPPI.get(0).getSistemaSatelital()).trim();
                            if(token.trim().isEmpty() || token.equals("")){
                                LogeoDAO.getInstancia().logExcepcion("No se grabo el pedido de la carga SPPI x token vacio");
                            }else{
                                this.grabaSPPI(pedido,token);     
                                pedidosAux.add(pedido);
                            }
                        }
                    }
                    if(!pedidosAux.isEmpty()){
                        mensajeError = cargaSPPIDAO.actualizaSPPI(pedidosAux);
                    }
                }
            }
            
            if(avancePedidosSPPI != null){
                LogeoDAO.getInstancia().logExcepcion("No. Pedidos actualizar avance de la carga SPPI :" + avancePedidosSPPI.size());
                if(!avancePedidosSPPI.isEmpty()){
                    ArrayList<CargaSPPIDTO> avanceAux = new ArrayList<CargaSPPIDTO>();
                    for (CargaSPPIDTO avancePedido : avancePedidosSPPI) {
                        if(avancePedidosSPPI.indexOf(avancePedido) < TAMANO_PEDIDOS_SPPI){    
                            //CONSULTA TOKEN
                            token = generaToken(    avancePedidosSPPI.get(0).getIdSistema().trim(),
                                                    avancePedidosSPPI.get(0).getClaveUsuario().trim(),
                                                    avancePedidosSPPI.get(0).getSistemaSatelital().trim());
                            if(token.trim().isEmpty() || token.equals("")){
                                LogeoDAO.getInstancia().logExcepcion("No se actualizo el avance de la carga SPPI x token vacio");
                            }else{
                                this.actualizaAvanceSPPI(avancePedido,token);
                                avanceAux.add(avancePedido);
                            }
                        }
                    }
                    if(!avanceAux.isEmpty()){
                        mensajeError = cargaSPPIDAO.actualizaSPPI(avanceAux);
                    }
                }
            }
        }catch(Exception e){
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            ); 
        }finally{
            correoDAO.envio(pedidosSPPI.toArray(), this.getClass().toString(), "procesaSPPI => Solicitudes pendientes de aplicar en SPPI", inicio, mensajeError);
            correoDAO.envio(avancePedidosSPPI.toArray(), this.getClass().toString(), "procesaSPPI => Solicitudes avance en SPPI", inicio, mensajeError);   
        }
        
    }
    
    /**
     * Graba los pedidos SPPI
     * @param pedidoSPPI
     * @param token 
     */
    public void grabaSPPI(CargaSPPIDTO pedidoSPPI, String token){
        SOAPLoggingHandler slh = null;
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();  
        try{
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL wsdlLocation = classloader.getResource("WS_SPPI_2.wsdl");
            ConectorUnicoPortService wsSPPI = new ConectorUnicoPortService(wsdlLocation,  new QName("http://conectorunico.com.mx/definitions", "ConectorUnicoPortService"));
            ConectorUnicoPort port = (ConectorUnicoPort)wsSPPI.getConectorUnicoPortSoap11();
            BindingProvider bp = (BindingProvider)port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_SPPI_2);
            //Guarda el response del Web Services
            Binding binding = bp.getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            slh = new SOAPLoggingHandler();
            handlerChain.add(slh);
            binding.setHandlerChain(handlerChain);   
            //cargaRealesRequest
            CargaRealesRequest cargaReales = new CargaRealesRequest();
            cargaReales.setClaveCentroProvedor(pedidoSPPI.getClaveCentroProveedor());
            cargaReales.setClaveServicio(pedidoSPPI.getClaveServicio().trim());
            cargaReales.setClaveSociedad(pedidoSPPI.getClaveSociedad().trim());
            cargaReales.setConcepto(Integer.parseInt(pedidoSPPI.getConcepto().trim()));
            cargaReales.setDescripcion(pedidoSPPI.getDescripcion().trim());
            cargaReales.setFechaInicial(pedidoSPPI.getFechaInicial());
            cargaReales.setFechaFinal(pedidoSPPI.getFechaFinal());           
            cargaReales.setToken(token);
            //DETALLE CARGA
            CargaReal cargaSPPI = new CargaReal();
            cargaSPPI.setCentroCliente(String.valueOf(pedidoSPPI.getCeco()));
            cargaSPPI.setDescripcion(String.format("Folio: %d Tienda: %d Pedido: %d", pedidoSPPI.getFoliosolicitud(), pedidoSPPI.getTienda(), pedidoSPPI.getPedido()));
            cargaSPPI.setCompaniaClienteId(pedidoSPPI.getCompaniaClienteID().trim());
            cargaSPPI.setEmpresaClienteId(pedidoSPPI.getEmpresaClienteID().trim());
            cargaSPPI.setImporte(BigDecimal.valueOf(pedidoSPPI.getImporteTotal()));
            cargaSPPI.setNumEmpleado(String.valueOf(pedidoSPPI.getNumEmpleado()));      
            cargaReales.getDetalleCarga().add(cargaSPPI);
            
            CargaRealesResponse response = port.cargaReales(cargaReales);
            pedidoSPPI.setDatosProceso(slh.getXMLRequest());
            pedidoSPPI.setDocumento("aplicado");
            if(LOG_XML_TAMANO_PEDIDOS_SPPI.trim().equals("TRUE")){
                LogeoDAO.getInstancia().logExcepcion(slh.getXMLResponse());
            }
            if(response.getCodigo() == OK){
                pedidoSPPI.setObservaciones("Aplicado Correctamente");
                pedidoSPPI.setCarga(response.getFolioCarga());
                pedidoSPPI.setEstatus(1);
            }else{       
                pedidoSPPI.setObservaciones(response.getMensaje().trim());
                pedidoSPPI.setCarga(0);
                pedidoSPPI.setEstatus(0);  
            }
            
        }catch(Exception e){
           LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);
            pedidoSPPI.setObservaciones(e.getMessage());
            pedidoSPPI.setEstatus(0);
            pedidoSPPI.setCarga(0);
        }
    }
    
    /**
     * Actualiza el ultimo avance de SPPI
     * @param avancePedidosSPPI
     * @param token 
     */
    public void actualizaAvanceSPPI(CargaSPPIDTO avancePedidosSPPI, String token){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();  
        SOAPLoggingHandler slh = null;
        try{
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL wsdlLocation = classloader.getResource("WS_SPPI_2.wsdl");
            ConectorUnicoPortService wsSPPI = new ConectorUnicoPortService(wsdlLocation,  new QName("http://conectorunico.com.mx/definitions", "ConectorUnicoPortService"));
            ConectorUnicoPort port = (ConectorUnicoPort)wsSPPI.getConectorUnicoPortSoap11();
            BindingProvider bp = (BindingProvider)port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_SPPI_2);
            //Guarda el response del Web Services
            Binding binding = bp.getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            slh = new SOAPLoggingHandler();
            handlerChain.add(slh);
            binding.setHandlerChain(handlerChain);   
            
            AvanceCargaRealRequest parametros = new AvanceCargaRealRequest();
            parametros.setFolioCarga(avancePedidosSPPI.getCarga());
            parametros.setToken(token);
            
            AvanceCargaRealResponse response = port.avanceCargaReal(parametros);
            avancePedidosSPPI.setDatosProceso(slh.getXMLResponse());
            
            if(LOG_XML_TAMANO_PEDIDOS_SPPI.trim().equals("TRUE")){
                LogeoDAO.getInstancia().logExcepcion(slh.getXMLResponse());
            }
            
            if(response.getAvanceCarga() == null || response.getAvanceCarga().isEmpty()){
                avancePedidosSPPI.setObservaciones("No se encontró información de la carga " + avancePedidosSPPI.getCarga() + " en SPPI");
                avancePedidosSPPI.setDocumento("error");
                avancePedidosSPPI.setEstatus(0);
            }
            
            if(response.getAvanceCarga().get(0).getRegistrosRechazados() > 0){
                avancePedidosSPPI.setObservaciones("Actualiza avance: existen " + response.getAvanceCarga().get(0).getRegistrosRechazados() + " registros rechazados de la carga " + avancePedidosSPPI.getCarga() + " en SPPI; Msj SPPI: " + response.getMensaje());
                avancePedidosSPPI.setDocumento("error");
                avancePedidosSPPI.setEstatus(0);
                //SI EXISTEN PROBLEMAS CONSULTAMOS DETALLECARGAREAL
                detalleCargaReal(avancePedidosSPPI, token);
            }else{
                int avancePorc = (int) response.getAvanceCarga().get(0).getPorcentajeAvance();
                String doc = avancePorc == 100 ? response.getAvanceCarga().get(0).getNumDocumento() : "Procesando";
                int estatus = avancePorc == 100 ? 3 : 2;
                avancePedidosSPPI.setAvance(avancePorc);
                avancePedidosSPPI.setDocumento(doc);
                avancePedidosSPPI.setEstatus(estatus);
                avancePedidosSPPI.setObservaciones("Actualiza avance :" + avancePorc + "%");          
            }
        }catch(Exception e){
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);
            avancePedidosSPPI.setObservaciones(e.getMessage());
            avancePedidosSPPI.setEstatus(0);
            avancePedidosSPPI.setDocumento("error");
        }
    }
    
    /**
     * Actualiza el detalle si existe un error
     * @param detallePedidosSPPI
     * @param token 
     */
    public void detalleCargaReal(CargaSPPIDTO detallePedidosSPPI, String token){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();  
        SOAPLoggingHandler slh = null;
        try{
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL wsdlLocation = classloader.getResource("WS_SPPI_2.wsdl");
            ConectorUnicoPortService wsSPPI = new ConectorUnicoPortService(wsdlLocation,  new QName("http://conectorunico.com.mx/definitions", "ConectorUnicoPortService"));
            ConectorUnicoPort port = (ConectorUnicoPort)wsSPPI.getConectorUnicoPortSoap11();
            BindingProvider bp = (BindingProvider)port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_SPPI_2);
            //Guarda el response del Web Services
            Binding binding = bp.getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            slh = new SOAPLoggingHandler();
            handlerChain.add(slh);
            binding.setHandlerChain(handlerChain);   
            DetalleCargaRealRequest parametros = new DetalleCargaRealRequest();
            parametros.setFolioCarga(detallePedidosSPPI.getCarga());
            parametros.setToken(token);
            
            DetalleCargaRealResponse response = port.detalleCargaReal(parametros);
            detallePedidosSPPI.setDatosProceso(slh.getXMLResponse());
            
            if(LOG_XML_TAMANO_PEDIDOS_SPPI.trim().equals("TRUE")){
                LogeoDAO.getInstancia().logExcepcion(slh.getXMLResponse());
            } 
            if(response.getDetalleCarga() == null || response.getDetalleCarga().isEmpty()){
                detallePedidosSPPI.setObservaciones("DetalleCargaReal:No se encontró información de la carga " + detallePedidosSPPI.getCarga() + " en SPPI");
                detallePedidosSPPI.setEstatus(0);
            }
            
            if(response.getCodigo() == OK){
                detallePedidosSPPI.setEstatus(0);
                detallePedidosSPPI.setObservaciones("DetalleCargaReal: " + response.getDetalleCarga().get(0).getObservaciones());
                /*if( detallePedidosSPPI.getNumEmpleado() == Integer.parseInt(response.getDetalleCarga().get(0).getNumEmpleado().trim()) && 
                    detallePedidosSPPI.getCeco() == Integer.parseInt(response.getDetalleCarga().get(0).getCentroCliente().trim())){
                    detallePedidosSPPI.setObservaciones("DetalleCargaReal: " + response.getDetalleCarga().get(0).getObservaciones());
                    detallePedidosSPPI.setEstatus(0);
                }else{
                    detallePedidosSPPI.setObservaciones("DetalleCargaReal: No concuerdan los datos del empleado y/o centro cliente");
                    detallePedidosSPPI.setEstatus(0);
                }*/
            }else{
                detallePedidosSPPI.setObservaciones("DetalleCargaReal: " + response.getMensaje());
                detallePedidosSPPI.setEstatus(0);
            }
        }catch(Exception e){
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);
            detallePedidosSPPI.setObservaciones(e.getMessage());
            detallePedidosSPPI.setEstatus(0);
            detallePedidosSPPI.setDocumento("error");
        }
    }    
    
    /**
     * Genera el token del usuario registrado
     * @param idSistema
     * @param idUsuario
     * @param idSistemaSatelital
     * @return 
     */
    public String generaToken(String idSistema, String idUsuario, String idSistemaSatelital){
        String token = "";
        SOAPLoggingHandler slh = null;
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();   
        try{
            //Apunta la ubicacion del WSDL en resources
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL wsdlLocation = classloader.getResource("WS_Token.wsdl");           
            GeneraTokenPortService wsToken = new GeneraTokenPortService(wsdlLocation,new QName("http://generatoken.com.mx/definitions", "GeneraTokenPortService"));
            GeneraTokenPort port = (GeneraTokenPort) wsToken.getGeneraTokenPortSoap11();
            
            BindingProvider bp = (BindingProvider)port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,WS_TOKEN);
            //Guarda el response del Web Services
            Binding binding = bp.getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            slh = new SOAPLoggingHandler();
            handlerChain.add(slh);
            binding.setHandlerChain(handlerChain);
            
            ObtieneTokenRequest parametros = new ObtieneTokenRequest();
            parametros.setIdSistema(idSistema);
            parametros.setIdUsuario(idUsuario);
            parametros.setIdSistemaSatelite(Integer.parseInt(idSistemaSatelital)); 
            
            ObtieneTokenResponse response = port.obtieneToken(parametros);
            
            if(response.getCodigo() == OK){
                token = response.getToken();
            }
        }catch(Exception e){
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);
        }
        return token;
    }    
    
    /**
     * Valida que sea fin de semana
     */
    private boolean validaFinDeSemana() {
        boolean valido = true;
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());
        if ((c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (Calendar.DAY_OF_WEEK == Calendar.SUNDAY)) {  //or sunday   
            valido = false;
        }
        return valido;
    }
}

