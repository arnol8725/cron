/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;
import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.modelo.CargaSPPIDTO;
import com.elektra.uniformes.comercio.cron.dao.modelo.CentroDistribucionXTiendas;
import com.elektra.uniformes.comercio.cron.dao.modelo.DescuentoSAPXPedido;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDetalle;
import com.elektra.uniformes.comercio.cron.dao.modelo.EstructuraCorreo;
import com.elektra.uniformes.comercio.cron.dao.modelo.NotaCargoEntrada;
import com.elektra.uniformes.comercio.cron.dao.modelo.RemisionPedido;
import com.elektra.uniformes.comercio.cron.dao.modelo.ResponseSolicitudDetalleDescuentoSAP;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDTO;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDetalleDescuentoSAP;
import com.elektra.uniformes.comercio.cron.dao.modelo.TiendaAT;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("correoDAO")
public class CorreoDAO {
    
    @Autowired
    @Qualifier("formatFecha")
    private static SimpleDateFormat dateFormat;
    
    @Value("#{propiedadesCronUniformesComercio['TEST_MAIL_SRVUNIFORMESCOMERCIO']}")
    private String TEST_MAIL_SRVUNIFORMESCOMERCIO;
    
    @Value("#{propiedadesCronUniformesComercio['KMAIL']}")
    private String KMAIL;
    
    @Value("#{propiedadesCronUniformesComercio['PMAIL']}")
    private String PMAIL;
    
    @Value("#{propiedadesCronUniformesComercio['HOST']}")
    private String HOST;           
    
    /**
     * Metodo principal para el envio de correo 
     * @param arregloGenerico recibe un 
     * @param clase
     * @param metodo
     * @param inicio
     * @param cadenaError
     */
    public void envio(Object[] arregloGenerico, String clase, String metodo, Date inicio, String cadenaError){        
        try{
            if(TEST_MAIL_SRVUNIFORMESCOMERCIO.trim().equals("ON") && arregloGenerico.length > 0){
                if(cadenaError.isEmpty()){
                    cadenaError = "No ocurrieron errores en la clase: "+ this.getClass() + " Metodo: " + metodo;                
                }else{
                    cadenaError = "ERROR en la clase: " + this.getClass() + " Metodo: " + metodo + " Excepcion: " + cadenaError; 
                }   
                Date fin = new Date();
                LogeoDAO.getInstancia().logExcepcion("Envio del correo en la clase: " + clase + " Metodo: " + metodo);  

                String host = HOST;
                // Get system properties
                Properties properties = System.getProperties();
                // Setup mail server
                properties.setProperty("mail.smtp.host", host);
                // Get the default Session object.
                Session session = Session.getDefaultInstance(properties);
                MimeMessage message = new MimeMessage(session);
                // Set From: header field of the header.
                message.setFrom(new InternetAddress("uniformescomercio@elektra.com.mx", "Uniformes Comercio"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(KMAIL.split(",")[0],KMAIL.split(",")[1]));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(PMAIL.split(",")[0],PMAIL.split(",")[1]));
                //String cadenaFechaActual = dateFormat.format(new Date());
                Date fechaActual = new Date();
                String cadenaFechaActual = fechaActual.toString();
                message.setSubject("Reporte SRVUniformesComercio: [Clase:" + clase + ",Metodo:" + metodo + "] Fecha:" + cadenaFechaActual);
                // Create the message part
                StringBuilder sb = new StringBuilder();
                EstructuraCorreo estructura = new EstructuraCorreo();
                sb.append("<html>");
                sb.append(estructura.head());
                sb.append("<body>");
                    sb.append(estructura.salto());
                    sb.append(estructura.h2("Ha concluido el cron de la clase: " + clase));
                    sb.append(estructura.salto());
                    sb.append(estructura.h3("Inicio:" + inicio + " Termino: " + fin));    
                    sb.append(estructura.salto());               
                    sb.append(estructura.h3("Error " + cadenaError));                
                    sb.append(estructura.salto());
                    sb.append(estructura.h3("Se procesaron :" + arregloGenerico.length ));        
                    sb.append(body(arregloGenerico,cadenaError,estructura));
                sb.append("</body>");
                sb.append("</html>");   
                message.setContent(sb.toString(), "text/html");
                Transport.send(message);
            }else if(TEST_MAIL_SRVUNIFORMESCOMERCIO.trim().equals("OFF") || TEST_MAIL_SRVUNIFORMESCOMERCIO.trim().equals("")){
                LogeoDAO.getInstancia().logExcepcion("Desahabilitado el Envio del correo en la clase: " + clase + " Metodo: " + metodo);  
            }
        }catch(MessagingException me){
            LogeoDAO.getInstancia().logExcepcion("Error envio de correo");
            LogeoDAO.getInstancia().logStackExcepcion(me);
        }catch(UnsupportedEncodingException ue){
            LogeoDAO.getInstancia().logExcepcion("Error envio de correo");
            LogeoDAO.getInstancia().logStackExcepcion(ue);        
        }catch(ParseException p){
            LogeoDAO.getInstancia().logExcepcion("Error envio de correo");
            LogeoDAO.getInstancia().logStackExcepcion(p);        
        }
    }
    
    /**
     * Logica del correo a enviar
     * @param arregloGenerico
     * @param cadenaError
     * @param estructura
     * @return 
     */
    private static StringBuilder body(Object[] arregloGenerico,String cadenaError, EstructuraCorreo estructura) throws ParseException{  
        StringBuilder sb = new StringBuilder();        
        if(arregloGenerico.length > 0){     
            //CORREOS TIENDA
            if(arregloGenerico[0] instanceof TiendaAT){                
                sb.append(tablaTiendaAT(arregloGenerico,estructura));
            }//CORREOS SOLICITUDES
            else if(arregloGenerico[0] instanceof SolicitudDTO){
                sb.append(tablaSolicitudesPendientes(arregloGenerico,estructura));
            }//CORREO NOTASCARGOENTRADA
            else if(arregloGenerico[0] instanceof NotaCargoEntrada){
                sb.append(tablaNotasCargoEntrada(arregloGenerico,estructura));
            }//CORREO SOLICITUD DETALLE SAP
            else if(arregloGenerico[0] instanceof SolicitudDetalleDescuentoSAP){                
                sb.append(tablaSolicitudesDetalleDescuentosSAP(arregloGenerico,estructura));
            }//CORREO RESPUESTA DE WS SAP            
            else if(arregloGenerico[0] instanceof ResponseSolicitudDetalleDescuentoSAP){                
                sb.append(tablaDistribucionesSAP(arregloGenerico,estructura));
            }//CORREO DESCUENTOSAPXPEDIDO
            else if(arregloGenerico[0] instanceof DescuentoSAPXPedido){                
                sb.append(tablaDescuentosSAPXPedidos(arregloGenerico,estructura));
            } 
            else if (arregloGenerico[0] instanceof RemisionPedido) {
                sb.append(tablaRemisiones(arregloGenerico, estructura));
            } 
            else if (arregloGenerico[0] instanceof CargaSPPIDTO) {
                sb.append(tablaSPPI(arregloGenerico, estructura));
            }
            else if (arregloGenerico[0] instanceof CentroDistribucionXTiendas) {
                sb.append(tablaCDXTiendas(arregloGenerico, estructura));
            } 
        }                   
        return sb;
    }
    
    /**
     * Realiza la tabla en html para en el envio del correo
     */    
    private static StringBuilder tablaTiendaAT(Object[] arregloGenerico, EstructuraCorreo estructura){
        StringBuilder sb = new StringBuilder();
        ArrayList<TiendaAT> tiendas = new ArrayList(Arrays.asList(arregloGenerico));                
        sb.append(estructura.salto());
        sb.append("<table>");
            sb.append(
                estructura.tr(
                    estructura.th("noTiendaId") + 
                    estructura.th("noCanalId") + 
                    estructura.th("noPaisId") + 
                    estructura.th("cadenaDescripcionTienda") +
                    estructura.th("cadenaDireccionIp")
                )
            );
            for (TiendaAT tienda : tiendas) {    
                sb.append(
                    estructura.tr(
                        estructura.td(tienda.getNoTiendaId()) +
                        estructura.td(tienda.getNoCanalId()) +
                        estructura.td(tienda.getNoPaisId()) +
                        estructura.td(tienda.getCadenaDescripcionTienda()) +
                        estructura.td(tienda.getCadenaDireccionIp())
                    )
                );                    
            }
        return sb.append("</table>");
    }    
    
    /**
     * Realiza la tabla en html para en el envio del correo
     */
    private static StringBuilder tablaSolicitudesPendientes(Object[] arregloGenerico, EstructuraCorreo estructura){
        StringBuilder sb = new StringBuilder();
        ArrayList<SolicitudDTO> solicitudes = new ArrayList(Arrays.asList(arregloGenerico));
        sb.append(estructura.salto());
        sb.append("<table>");         
            sb.append(
                estructura.tr(
                    estructura.th("FIFOLIOSOLICITUD") + 
                    estructura.th("FIIDEMPLEADO") + 
                    estructura.th("FIIDDETALLE") + 
                    estructura.th("FIPAIS") + 
                    estructura.th("FICANAL") +        
                    estructura.th("FISUCURSAL") +        
                    estructura.th("FIPEDIDO") + 
                    estructura.th("FISKU") +    
                    estructura.th("FITALLA") + 
                    estructura.th("FICANTIDAD") +  
                    estructura.th("FIESTATUSSOL") +                                 
                    estructura.th("FIESTATUSCD") +                                                                
                    estructura.th("MENSAJE INFO.") +   
                    estructura.th("ERROR")                               
                )
            );                                
            for (SolicitudDTO solicitud : solicitudes) { 
                for (SolicitudDetalle detalle : solicitud.getSolicitudesDetalle()) {                      
                    sb.append(
                        estructura.tr(
                            estructura.td(solicitud.getNoFolioSolicitud()) +
                            estructura.td(solicitud.getNoEmpleado()) +
                            estructura.td(detalle.getNoIDDetalle()) +                
                            estructura.td(solicitud.getNoPais()) +
                            estructura.td(solicitud.getNoCanal()) +
                            estructura.td(solicitud.getNoSucursal()) +
                            estructura.td(detalle.getNoPedido()) +                                            
                            estructura.td(detalle.getNoSKU()) +   
                            estructura.td(detalle.getNoTalla()) +         
                            estructura.td(detalle.getNoCantidad()) +   
                            estructura.td(detalle.getNoEstatusSol()) +               
                            estructura.td(detalle.getNoEstatusCDWS()) + 
                            estructura.td(detalle.getMensaje() == null ? "Sin consultar a CD" : detalle.getMensaje()) +
                            estructura.td   
                            (
                                detalle.isError() 
                                    ?  "Error"
                                    :  "OK"
                            )  
                        )    
                    );
                }
            }
        return sb.append("</table>");
    }
    
    /**
     * Realiza la tabla en html para en el envio del correo
     */
    private static StringBuilder tablaNotasCargoEntrada(Object[] arregloGenerico, EstructuraCorreo estructura){
        StringBuilder sb = new StringBuilder();
        ArrayList<NotaCargoEntrada> notas = new ArrayList(Arrays.asList(arregloGenerico));
        sb.append(estructura.salto());
        sb.append("<table>");         
            sb.append(
                estructura.tr(
                    estructura.th("FIFOLIOSOLICITUD") +
                    estructura.th("FIIDDETALLE") +
                    estructura.th("FIPAIS") +
                    estructura.th("FICANAL") +        
                    estructura.th("FIPEDIDO") + 
                    estructura.th("FISUCURSAL") + 
                    estructura.th("FISKU") + 
                    estructura.th("FICANTIDADREQ") + 
                    estructura.th("FICANTIDADSURT") +        
                    estructura.th("FIFOLIOREMISION") +        
                    estructura.th("FIRUTA") +    
                    estructura.th("FINOTACARGO") + 
                    estructura.th("FINOTAENTRADA") +  
                    estructura.th("FCESTREMISION") +                                                              
                    estructura.th("FCOBSERVACIONESNC") +   
                    estructura.th("FCOBSERVACIONESNE") +
                    estructura.th("FDFECHAACTCD") +
                    estructura.th("MSJ")
                )
            );                                
            for (NotaCargoEntrada nota : notas) {                    
                    sb.append(
                        estructura.tr(
                            estructura.td(nota.getNoFolioSolicitud()) +         //FIFOLIOSOLICITUD
                            estructura.td(nota.getNoIDDetalle()) +              //FIIDDETALLE
                            estructura.td(nota.getNoPais()) +                   //FIPAIS           
                            estructura.td(nota.getNoCanal()) +                  //FICANAL
                            estructura.td(nota.getNoPedido()) +                 //FIPEDIDO                                     
                            estructura.td(nota.getNoTienda()) +                 //FISUCURSAL
                            estructura.td(nota.getNoSKU()) +                    //FISKU       
                            estructura.td(nota.getNoCantidadRequerida()) +      //FICANTIDADREQ  
                            estructura.td(nota.getNoCantidadSurtida()) +        //FICANTIDADSURT              
                            estructura.td(nota.getNoFolioRemision()) +          //FIFOLIOREMISION
                            estructura.td(nota.getNoRuta()) +                   //FIRUTA
                            estructura.td(nota.getNoNotaCargo()) +              //FINOTACARGO
                            estructura.td(nota.getNoNotaEntrada()) +            //FINOTAENTRADA        
                            estructura.td(nota.getCadenaDescripcionRemision())+ //FCESTREMISION
                            estructura.td(nota.getCadenaObservacionesNC()) +    //FCOBSERVACIONESNC
                            estructura.td(nota.getCadenaObservacionesNE()) +    //FCOBSERVACIONESNE
                            estructura.td(nota.getCadenaFechaActualizacion()) + //FDFECHAACTCD 
                            (
                                nota.isError() 
                                    ?  estructura.td(nota.getMsjError())
                                    :  estructura.td("OK")
                            )  
                        )    
                    );              
            }
        return sb.append("</table>");
    }
    
    /**
     * Realiza la tabla en html para en el envio del correo.
     * El contenido son las respuestas de los datos recibidos por el Web Services WSDescuentosSAP.
     */
    private static StringBuilder tablaSolicitudesDetalleDescuentosSAP(Object[] arregloGenerico, EstructuraCorreo estructura){
        StringBuilder sb = new StringBuilder();       
        ArrayList<SolicitudDetalleDescuentoSAP> solicitudes = new ArrayList(Arrays.asList(arregloGenerico));                                    
        sb.append(estructura.salto());
            sb.append("<table>");
                sb.append(
                    estructura.tr(
                        estructura.th("NoFolioSolicitud") + 
                        estructura.th("NoIDDetalle") + 
                        estructura.th("NoPais") + 
                        estructura.th("NoCanal") +
                        estructura.th("NoPedido") + 
                        estructura.th("NoSucursal") + 
                        estructura.th("NoSKU") + 
                        estructura.th("CadenaFechaDescuento") + 
                        estructura.th("CadenaIDEmpleadoSAP") +                                     
                        estructura.th("CadenaRefenciaSAP") +                                     
                        estructura.th("NoIDEstatusPedido") + 
                        estructura.th("PrecisionDescuentoSemanal") +
                        estructura.th("PrecisionPrecioTotal")
                    )
                );
                for (SolicitudDetalleDescuentoSAP solicitudDetalle : solicitudes) {    
                    sb.append(
                        estructura.tr(
                            estructura.td(solicitudDetalle.getNoFolioSolicitud()) +
                            estructura.td(solicitudDetalle.getNoIDDetalle()) +
                            estructura.td(solicitudDetalle.getNoPais()) +
                            estructura.td(solicitudDetalle.getNoCanal()) +
                            estructura.td(solicitudDetalle.getNoPedido()) +    
                            estructura.td(solicitudDetalle.getNoSucursal()) + 
                            estructura.td(solicitudDetalle.getNoSKU()) +         
                            estructura.td(solicitudDetalle.getCadenaFechaDescuento()) +
                            estructura.td(solicitudDetalle.getCadenaIDEmpleadoSAP()) +
                            estructura.td(solicitudDetalle.getCadenaRefenciaSAP()) +                                            
                            estructura.td(solicitudDetalle.getNoIDEstatusPedido()) +                                            
                            estructura.td(solicitudDetalle.getPrecisionDescuentoSemanal().toString()) +
                            estructura.td(solicitudDetalle.getPrecisionPrecioTotal().toString())
                        )
                    );                    
                }
        return sb.append("</table>");                
    }
    
    /**
     * Realiza la tabla en html para en el envio del correo.
     * El contenido son las respuestas de los datos recibidos por el Web Services WSDescuentosSAP.
     */
    private static StringBuilder tablaDistribucionesSAP(Object[] arregloGenerico, EstructuraCorreo estructura){
        StringBuilder sb = new StringBuilder();       
        ArrayList<ResponseSolicitudDetalleDescuentoSAP> responseDistribucionesSAP = new ArrayList(Arrays.asList(arregloGenerico));                                    
        sb.append(estructura.salto());
            sb.append("<table>");
                sb.append(
                    estructura.tr(
                        estructura.th("NoFolioSolicitud") + 
                        estructura.th("NoIDDetalle") + 
                        estructura.th("NoPais") + 
                        estructura.th("NoCanal") +
                        estructura.th("NoIDSucursal") + 
                        estructura.th("NoPedido") + 
                        estructura.th("NoSKU") + 
                        estructura.th("CadenaRefenciaSAP") + 
                        estructura.th("NoEstatusCorrectoResponseSAP") +                                     
                        estructura.th("CadenaXMLRequest") +                                     
                        estructura.th("CadenaXMLResponse") + 
                        estructura.th("FIIDError") +
                        estructura.th("MSJ")
                    )
                );
                for (ResponseSolicitudDetalleDescuentoSAP ditribuciones : responseDistribucionesSAP) {    
                    sb.append(
                        estructura.tr(
                            estructura.td(ditribuciones.getNoFolioSolicitud()) +
                            estructura.td(ditribuciones.getNoIDDetalle()) +
                            estructura.td(ditribuciones.getNoPais()) +
                            estructura.td(ditribuciones.getNoCanal()) +
                            estructura.td(ditribuciones.getNoIDSucursal()) +
                            estructura.td(ditribuciones.getNoPedido()) +
                            estructura.td(ditribuciones.getNoSKU()) +                                            
                            estructura.td(ditribuciones.getCadenaRefenciaSAP()) +                                            
                            estructura.td(ditribuciones.getNoEstatusCorrectoResponseSAP()) +                                            
                            estructura.td(ditribuciones.getCadenaXMLRequest()) +                                            
                            estructura.td(ditribuciones.getCadenaXMLResponse()) +                                                                            
                            estructura.td(ditribuciones.getNoError()) +
                            (
                                ditribuciones.getNoError() == 0
                                    ? estructura.td("OK")
                                    : estructura.td(ditribuciones.getCadenaTEXTXMLResponse())
                            )      
                                
                        )
                    );                    
                }
        return sb.append("</table>");                
    }
               
    /**
     * Realiza la tabla en html para en el envio del correo.
     * El contenido son las respuestas de los datos recibidos por el Web Services WSDescuentosSAP.
     */
    private static StringBuilder tablaDescuentosSAPXPedidos(Object[] arregloGenerico, EstructuraCorreo estructura) throws ParseException{
        StringBuilder sb = new StringBuilder();       
        ArrayList<DescuentoSAPXPedido> descuentosXPedidos = new ArrayList(Arrays.asList(arregloGenerico));                                    
        sb.append(estructura.salto());
            sb.append("<table>");
                sb.append(
                    estructura.tr(
                        estructura.th("NoFolioSolicitud") + 
                        estructura.th("NoPedido") + 
                        estructura.th("NoSemanaActual") + 
                        estructura.th("CadenaNomina") +
                        estructura.th("CadenaNumeroEmpleado") + 
                        estructura.th("CadenaReferencia") + 
                        estructura.th("CadenaSociedad") + 
                        estructura.th("PrecisionPago") + 
                        estructura.th("PrecisionSaldo") +                                     
                        estructura.th("PresicionTotal") +                                     
                        estructura.th("FdFechaPago")
                    )
                );
                for (DescuentoSAPXPedido descuento : descuentosXPedidos) {    
                    sb.append(
                        estructura.tr(
                            estructura.td(descuento.getNoFolioSolicitud()) +
                            estructura.td(descuento.getNoPedido()) +
                            estructura.td(descuento.getNoSemanaActual()) +
                            estructura.td(descuento.getCadenaNomina()) +
                            estructura.td(descuento.getCadenaNumeroEmpleado()) +
                            estructura.td(descuento.getCadenaReferencia()) +
                            estructura.td(descuento.getCadenaSociedad()) +                                            
                            estructura.td(descuento.getPrecisionPago().toString()) +                                            
                            estructura.td(descuento.getPrecisionSaldo().toString()) +                                            
                            estructura.td(descuento.getPresicionTotal().toString()) +                                            
                            estructura.td(descuento.getFdFechaPago().toString())                                      
                        )
                    );                    
                }
        return sb.append("</table>");                
    }
    
    private static StringBuilder tablaRemisiones(Object[] arregloGenerico, EstructuraCorreo estructura) {
        StringBuilder sb = new StringBuilder();
        ArrayList<RemisionPedido> remisiones = new ArrayList(Arrays.asList(arregloGenerico));
        sb.append(estructura.salto());
        sb.append("<table>");
        sb.append(
                estructura.tr(
                estructura.th("Sucursal")
                + estructura.th("Pedido")
                + estructura.th("Remisión")
                + estructura.th("SKU")
                + estructura.th("Cantidad")
                + estructura.th("empleado Recibe")
                + estructura.th("Observaciones")
                + estructura.th("Estatus")));
        for (RemisionPedido rem : remisiones) {
            sb.append(
                    estructura.tr(
                    estructura.td(rem.getSucursal())
                    + estructura.td(rem.getPedido())
                    + estructura.td(rem.getRemision())
                    + estructura.td(rem.getSku())
                    + estructura.td(rem.getCantidad())
                    + estructura.td(rem.getEmpleado())
                    + estructura.td(rem.getObs())
                    + estructura.td(rem.getEstatus())));
        }
        return sb.append("</table>");
    }

    private static StringBuilder tablaSPPI(Object[] arregloGenerico, EstructuraCorreo estructura) {
        StringBuilder sb = new StringBuilder();
        ArrayList<CargaSPPIDTO> sppi = new ArrayList(Arrays.asList(arregloGenerico));
        sb.append(estructura.salto());
        sb.append("<table>");
        sb.append(
                estructura.tr(
                estructura.th("Solicitud")
                + estructura.th("Detalle")
                + estructura.th("Pedido")
                + estructura.th("SKU")
                + estructura.th("Folio Carga")
                + estructura.th("Avance")
                + estructura.th("Documento")
                + estructura.th("Observaciones")
                + estructura.th("Estatus")));
        for (CargaSPPIDTO carga : sppi) {
            sb.append(
                    estructura.tr(
                    estructura.td(carga.getFoliosolicitud())
                    + estructura.td(carga.getDetalle())
                    + estructura.td(carga.getPedido())
                    + estructura.td(carga.getSku())
                    + estructura.td(carga.getCarga())
                    + estructura.td(carga.getAvance())
                    + estructura.td(carga.getDocumento())
                    + estructura.td(carga.getObservaciones())
                    + estructura.td(carga.getEstatus())));
        }
        return sb.append("</table>");
    }
    
    /**
     * Realiza la tabla en html para en el envio del correo.
     */
    private static StringBuilder tablaCDXTiendas(Object[] arregloGenerico, EstructuraCorreo estructura) throws ParseException{
        StringBuilder sb = new StringBuilder();       
        ArrayList<CentroDistribucionXTiendas> cdXTiendas = new ArrayList(Arrays.asList(arregloGenerico));                                    
        sb.append(estructura.salto());
            sb.append("<table>");
                sb.append(
                    estructura.tr(
                        estructura.th("NoCD") + 
                        estructura.th("NoTienda") + 
                        estructura.th("CadenaMsj")
                    )
                );
                
                for (CentroDistribucionXTiendas cdXTienda : cdXTiendas) {
                    for (Integer tienda : cdXTienda.getTiendasArreglo()) {
                        sb.append(
                            estructura.tr(
                                estructura.td(cdXTienda.getNoCD()) +
                                estructura.td(tienda) +
                                estructura.td(cdXTienda.getMsj())                                     
                            )
                        );  
                    }
                }
                      
        return sb.append("</table>");                
    }
}
