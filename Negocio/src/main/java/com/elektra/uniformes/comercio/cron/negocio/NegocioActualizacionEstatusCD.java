/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.EstatusAbastoDAO;
import com.elektra.uniformes.comercio.cron.dao.SolicitudDAO;
import com.elektra.uniformes.comercio.cron.dao.TiposErrorDAO;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDetalle;
import com.elektra.uniformes.comercio.cron.dao.modelo.SOAPLoggingHandler;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDTO;
import com.elektra.uniformes.comercio.cron.dao.modelo.TipoSolicitudPendiente;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.ws.BindingProvider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto.IntfPEDCENTCONSULTASTATUSService;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto.Parametros;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto.ParametrosEntrada;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto.PortType;

import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Binding;
import javax.xml.ws.handler.Handler;

/**
 *
 * @author kortizl
 */
@Component("negocioActualizacionEstatusCD")
public class NegocioActualizacionEstatusCD {
    
    @Autowired
    @Qualifier("solicitudDAO")
    private SolicitudDAO solicitudDAO;
    
    @Autowired
    @Qualifier("estatusAbastoDAO")
    private EstatusAbastoDAO estatusAbastoDAO;
    
    @Autowired
    @Qualifier("tiposErrorDAO")
    private TiposErrorDAO tiposErrorDAO;   
   
    @Value("#{propiedadesCronUniformesComercio['WS_ABASTO_CONS_PED_ENDPOINT']}")
    private String WS_ABASTO_CONS_PED_ENDPOINT;
    
    /**
     * CRON ACTUALIZA ESTATUSCD
     */
    public void cronActualizaEstatusCD() {   
        estatusAbastoDAO.creaEstatusAbasto();
        tiposErrorDAO.creaTiposError();
        this.actualizaEstatusSolicitudesDetalle(solicitudDAO.getSolicitudesPendientesGCDACTCDNCNE(TipoSolicitudPendiente.ACTUALIZAR_CD));       
    }
   
     /**
     * Actualiza los estatus en base a una solicitud
     * @param solicitudes
     */
    private void actualizaEstatusSolicitudesDetalle(ArrayList<SolicitudDTO> solicitudes){
        for (SolicitudDTO solicitud : solicitudes) {
            this.consultaEstatusWSAbasto(solicitud);    
        }
        if(!solicitudes.isEmpty()){
            solicitudDAO.actualizaEstatusSolicitudesDetalle(solicitudes);
        }
    }
        
    /**
     * Consulta los estatus del WSAbasto llamado: PED_CENT_CONSULTA_UNIFORMESOp
     * @param solicitud 
     */
    private void consultaEstatusWSAbasto(SolicitudDTO solicitud) {
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();   
        SOAPLoggingHandler slh = null;
        try {
            for (SolicitudDetalle solicitudDetalle : solicitud.getSolicitudesDetalle()) {   
                ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                URL wsdlLocation = classloader.getResource("WS_PED_CENT_CONSULTA_UNIFORMES.wsdl");                
                IntfPEDCENTCONSULTASTATUSService wsAbasto  = new IntfPEDCENTCONSULTASTATUSService(wsdlLocation,new QName("http://servicios.elektra.com.mx/ekt/1.0/ws_ped_cent_consulta_uniformes", "intfPED_CENT_CONSULTA_STATUS-service"));                  
                
                PortType port = (PortType) wsAbasto.getIntfwsPEDCENTCONSULTASTATUSEndpoint0();
                
                BindingProvider bp = (BindingProvider)port;
                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_ABASTO_CONS_PED_ENDPOINT);
                Binding binding = bp.getBinding();
                List<Handler> handlerChain = binding.getHandlerChain();
                slh = new SOAPLoggingHandler();
                handlerChain.add(slh);
                binding.setHandlerChain(handlerChain);                                      
                
                ParametrosEntrada pe = new ParametrosEntrada(); 
                pe.setSistema("PROD");                
                pe.setPedido(String.valueOf(solicitudDetalle.getNoPedido()));               
                pe.setTienda(String.valueOf(solicitud.getNoSucursal()));       
   
                Parametros parametros = port.pedCENTCONSULTAUNIFORMESOp(pe);
                List<Parametros.Detalle> detalles = parametros.getDetalle();

                if (parametros != null && parametros.getDetalle().size() > 0) {
                    for (Parametros.Detalle detalle : detalles) {                                                                                          
                        if( isDiferenteNoHayRegistros(detalle) && (!isVacio(detalle)) ){
                            //VALIDA EL ESTATUS Y MENSAJE DE LA TABLA TAESTATUSABASTO
                                if (estatusAbastoDAO.isEstatusAbasto(detalle.getStatusPedido().trim(),detalle.getMensaje().toUpperCase().trim())) {     
                                    solicitudDetalle.setNoRutaCDWS(detalle.getRuta().trim().isEmpty() ? 0 : Integer.parseInt(detalle.getRuta().trim()));
                                    solicitudDetalle.setNoEstatusCDWS(detalle.getStatusPedido().trim());
                                    solicitudDetalle.setNoEstatusRemisionWS(detalle.getStatusRemision());
                                    solicitudDetalle.setCadenaMensajeCDWS(detalle.getMensaje());
                                    solicitudDetalle.setNoIDManhantan(detalle.getAlmacen());
                                    solicitudDetalle.setMensaje("OK");
                                //SI NO CONTIENE ESTATUS VALIDOS LOS TOMA COMO ERROR
                                }else{
                                    solicitudDetalle.setError(true);
                                    solicitudDetalle.setMensaje("Error Consulta Estatus:" + detalle.getMensaje());
                                    solicitudDetalle.setCadenaMensajeCDWS(detalle.getMensaje());
                                    solicitudDetalle.setCadenaXMLResponseWS(slh.getXMLResponse());
                                }
                            
                        }
                    }
                }
            }
        } catch (Exception e) {
            solicitud.setError(true);
            solicitud.setMensaje(e.getMessage());
            for (SolicitudDetalle detalle : solicitud.getSolicitudesDetalle()) {
                if (solicitud.isError()) {
                    detalle.setError(true);
                    detalle.setMensaje("ERROR WSAbasto");
                    detalle.setCadenaXMLResponseWS("ERROR:" + e.getMessage());
                }
            }
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage() + "\n" +
                "4. Informacion extra:" + "\n" +
                "   No. Folio Solicitud:" + solicitud.getNoFolioSolicitud() + "\n" +
                "   No. Empleado:" + solicitud.getNoEmpleado() + "\n" +
                "   Tienda:" + solicitud.getNoSucursal()
            );

            LogeoDAO.getInstancia().logStackExcepcion(e);
        }
    }
    
    /**
     * Verifica un mensaje del Web Services de Abasto
     * @param detalle
     * @return 
     */
    private boolean isDiferenteNoHayRegistros(Parametros.Detalle detalle){
        return !detalle.getMensaje().trim().toUpperCase().equals(tiposErrorDAO.busquedaTipoErrorIDError(80).getCadenaDescripcion());
    }
    
    /**
     * Mientras que sea el estatus y mensaje vacios
     * @param detalle
     * @return 
     */
    private boolean isVacio(Parametros.Detalle detalle){
        return (detalle.getStatusPedido().trim().isEmpty() && detalle.getMensaje().trim().isEmpty()) || detalle.getStatusPedido().trim().isEmpty();
    }
}