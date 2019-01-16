/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.EstatusAbastoDAO;
import com.elektra.uniformes.comercio.cron.dao.NotaCargoEntradaDAO;
import com.elektra.uniformes.comercio.cron.dao.SolicitudDAO;
import com.elektra.uniformes.comercio.cron.dao.TiposErrorDAO;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto.Entrada;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto.IntfPEDCENTCONSULTASTATUSService;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto.Parametros3;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto.PortType;
import com.elektra.uniformes.comercio.cron.dao.modelo.NotaCargoEntrada;
import com.elektra.uniformes.comercio.cron.dao.modelo.SOAPLoggingHandler;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDTO;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDetalle;
import com.elektra.uniformes.comercio.cron.dao.modelo.TipoSolicitudPendiente;
import java.net.URL;
import java.util.ArrayList;
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
 * @author User
 */

@Component("negocioActualizacionNotaCargoEntrada")
public class NegocioActualizacionNotaCargoEntrada {
    
    @Value("#{propiedadesCronUniformesComercio['WS_ABASTO_CONS_PED_ENDPOINT']}")
    private String WS_ABASTO_CONS_PED_ENDPOINT;
    
    @Autowired
    @Qualifier("notaCargoEntradaDAO")
    private NotaCargoEntradaDAO notaCargoEntradaDAO;
    
    @Autowired
    @Qualifier("solicitudDAO")
    private SolicitudDAO solicitudDAO;
    
    @Autowired
    @Qualifier("estatusAbastoDAO")
    private EstatusAbastoDAO estatusAbastoDAO;
    
    @Autowired
    @Qualifier("tiposErrorDAO")
    private TiposErrorDAO tiposErrorDAO;    
    
    /** 
     * CRON ACTUALIZA NOTASCARGOENTRADA
     */
    public void cronActualizaNotasCargoEntrada(){
        estatusAbastoDAO.creaEstatusAbasto();
        tiposErrorDAO.creaTiposError();
        this.actualizarNotasCargoEntrada(solicitudDAO.getSolicitudesPendientesGCDACTCDNCNE(TipoSolicitudPendiente.ACTUALIZAR_NC_NE));
    }
    
    /** 
     * Graba las notas de cargo y entrada
     * Proceso para consulta al WSAbasto e insertar las notas de cargo y entrada
     * Consulta los estatus del WSAbasto llamado: PED_CENT_STATUS_NEOp
     * @param solicitudes 
     * @param notas 
     */
    public void actualizarNotasCargoEntrada(ArrayList<SolicitudDTO> solicitudes){      
        ArrayList<NotaCargoEntrada> notas = new ArrayList<NotaCargoEntrada>();
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();  
        SOAPLoggingHandler slh = null;
        try{ 
            //Apunta la ubicacion del WSDL en resources
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL wsdlLocation = classloader.getResource("WS_PED_CENT_CONSULTA_UNIFORMES.wsdl");
            //Cliente WSImport
            IntfPEDCENTCONSULTASTATUSService wsAbasto  = new IntfPEDCENTCONSULTASTATUSService(wsdlLocation,new QName("http://servicios.elektra.com.mx/ekt/1.0/ws_ped_cent_consulta_uniformes", "intfPED_CENT_CONSULTA_STATUS-service"));                  
            PortType port = (PortType) wsAbasto.getIntfwsPEDCENTCONSULTASTATUSEndpoint0();
            BindingProvider bp = (BindingProvider)port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,WS_ABASTO_CONS_PED_ENDPOINT);
            //Guarda el response del Web Services
            Binding binding = bp.getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            slh = new SOAPLoggingHandler();
            handlerChain.add(slh);
            binding.setHandlerChain(handlerChain); 
            
            for (SolicitudDTO solicitud : solicitudes) {
                for (SolicitudDetalle solicitudDetalle : solicitud.getSolicitudesDetalle()) {
                    Entrada pe = new Entrada(); 
                    pe.setSistema("PROD");
                    
                    Entrada.Detalle detalle = new Entrada.Detalle();
                    detalle.setFolio(String.valueOf(solicitudDetalle.getNoPedido()));
                    detalle.setTienda(String.valueOf(solicitud.getNoSucursal()));
                    pe.getDetalle().add(detalle);
                    
                    Parametros3 respuesta = port.pedCENTCONSULTASTATUSNEOp(pe); 
                    
                    if(isDiferenteConsultaNoExiste(respuesta)){
                        //VALIDA EL ESTATUS Y MENSAJE DE LA TABLA TAESTATUSABASTO Y SE AMBOS CASOS ES VACIO LO INSERTA O ACTUALIZA
                        if(estatusAbastoDAO.isEstatusAbasto(respuesta.getSalida().get(0).getStatCode().trim(),respuesta.getSalida().get(0).getMsg().toUpperCase().trim()) || (respuesta.getSalida().get(0).getStatCode().isEmpty() && respuesta.getSalida().get(0).getMsg().isEmpty())){
                            NotaCargoEntrada notaCargoEntrada = new NotaCargoEntrada(respuesta.getSalida().get(0), solicitud ,solicitudDetalle,slh.getXMLResponse()); 
                            notas.add(notaCargoEntrada);
                        }else{
                            NotaCargoEntrada nota = new NotaCargoEntrada(respuesta.getSalida().get(0), solicitud,solicitudDetalle,slh.getXMLResponse());
                            nota.setError(true);
                            nota.setMsjError("Error: Respuestas del WSAbasto");         
                            notas.add(nota);
                        }
                    }
                }
            }
            if(!notas.isEmpty()){
                notaCargoEntradaDAO.guardaNotasCargoEntrada(notas);
            }
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } 
    }
    
    private boolean isDiferenteConsultaNoExiste(Parametros3 respuesta){
        return !respuesta.getSalida().get(0).getMsg().trim().toUpperCase().equals(tiposErrorDAO.busquedaTipoErrorIDError(90).getCadenaDescripcion());
    }
    
}