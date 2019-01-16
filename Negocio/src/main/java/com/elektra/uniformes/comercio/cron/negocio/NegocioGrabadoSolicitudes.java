/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.CorreoDAO;
import com.elektra.uniformes.comercio.cron.dao.SolicitudDAO;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.GrabaPedidoAbasto.IntfWSVTAMAYOREOService;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.GrabaPedidoAbasto.ParametroSalida;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.GrabaPedidoAbasto.Parametros;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.GrabaPedidoAbasto.Parametros.DETALLE;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.GrabaPedidoAbasto.PortType;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.AltasPedidos;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.ArrayOfAltasPedidos;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.ArrayOfint;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.CreaPedido;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.GeneraPedido;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.IWSUniformes;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.ObjectFactory;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.ReciveDatos;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.WSUniformes;
import com.elektra.uniformes.comercio.cron.dao.modelo.SOAPLoggingHandler;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDetalle;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDTO;
import com.elektra.uniformes.comercio.cron.util.TiendaCifrado;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
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
 * @author kortizl
 */
@Component("negocioGrabadoSolicitudes")
public class NegocioGrabadoSolicitudes {

    @Autowired
    @Qualifier("correoDAO")
    private CorreoDAO correoDAO;   
    
    @Autowired
    @Qualifier("solicitudDAO")
    private SolicitudDAO solicitudDAO;
    
    @Autowired
    @Qualifier("formatFecha")
    private SimpleDateFormat dateFormat;
    
    @Value("#{propiedadesCronUniformesComercio['WS_ABASTO_OP_QNAME']}")
    private String WS_ABASTO_OP_QNAME;
    
    @Value("#{propiedadesCronUniformesComercio['WS_ABASTO_ENDPOINT']}")
    private String WS_ABASTO_ENDPOINT;
    
    @Value("#{propiedadesCronUniformesComercio['CLASE_CONNECT_TIMEOUT']}")
    private String CLASE_CONNECT_TIMEOUT;
    
    @Value("#{propiedadesCronUniformesComercio['CLASE_REQUEST_TIMEOUT']}")
    private String CLASE_REQUEST_TIMEOUT;
    
    @Value("#{propiedadesCronUniformesComercio['TIEMPO_TIMEOUT']}")
    private int TIEMPO_TIMEOUT;
    
    /**
     * CRON GRABA SOLICITUDES
     */
    public void cronGrabarSolicitudes(){    
        solicitudDAO.actualizaCancelacionesXEmpleadoInactivo();
        this.procesosGrabadoSolicitudes(solicitudDAO.getSolicitudesPendientesTienda(),"TIENDA");
        this.procesosGrabadoSolicitudes(solicitudDAO.getSolicitudesPendientesGCDSem(),"CD");
        this.procesosGrabadoSolicitudes(solicitudDAO.getSolicitudesPendientesGCDVolNvoIngreso(),"CD");
    }
    
    /**
     * Proceso de grabado generico para solicitudes
     * @param solicitudes
     * @throws Exception 
     */
    private void procesosGrabadoSolicitudes(ArrayList<SolicitudDTO> solicitudes, String cadenaTipo){
        int noSucursal = 0;
        for (SolicitudDTO solicitud : solicitudes) {
            if(cadenaTipo.trim().equals("TIENDA")){
                if(noSucursal == 0 || noSucursal != solicitud.getNoSucursal()){
                    noSucursal = solicitud.getNoSucursal();
                    this.grabarSolicitudDetalleFantasma(noSucursal,solicitud.getCadenaDirIP());
                }
                this.grabarSolicitudDetalleEnTienda(solicitud);
            }else if(cadenaTipo.trim().equals("CD")){
                this.grabarSolicitudDetalleEnCDWSAbasto(solicitud);
            }
        }
        if(!solicitudes.isEmpty()){
            solicitudDAO.actualizaEstatusSolicitudesDetalle(solicitudes);
        }
    }
    
    /**
     * Este metodo sirve para evitar perder numeros de pedidos
     * @param IPTienda
     * @param numTienda 
     */
    private boolean grabarSolicitudDetalleFantasma(int numTienda, String IPTienda){
        LogeoDAO.getInstancia().logExcepcion(
                "1. SolicitudDetalleF. " + "\n" +
                "2. No. Tienda: " + numTienda + "\n" +
                "3. IP: " + IPTienda
         );
        boolean webServicesTiendaActivo = false;
        
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();   
        SOAPLoggingHandler slh = null;
        try {
            ObjectFactory f = new ObjectFactory();
            GeneraPedido pedido = new GeneraPedido();
            ReciveDatos recive = new ReciveDatos();        
            recive.setKeyWs(f.createReciveDatosKeyWs("-1"));
            recive.setEmpleado(f.createReciveDatosEmpleado(String.valueOf("-1")));
            recive.setTipoUsuario(3);
            recive.setNoEmpIngreso(f.createReciveDatosNoEmpIngreso(String.valueOf("-1")));
            recive.setTipoSistema(1);
            recive.setTipoUniforme(0);
            recive.setEmpNvo(0);
            recive.setNumTienda(f.createReciveDatosNumTienda(String.valueOf(numTienda)));
            recive.setNegocio(3);
            List<Integer> skus = new ArrayList<Integer>();
            skus.add(0);
            ArrayOfint ai = new ArrayOfint();
            ai.setInt(skus);
            recive.setSku(f.createReciveDatosSku(ai));
            pedido.setRecive(f.createGeneraPedidoRecive(recive));
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL wsdlLocation = classloader.getResource("WSUniformes.wsdl");   
            WSUniformes wsTienda  = new WSUniformes(wsdlLocation,new QName("http://tempuri.org/", "WSUniformes"));                  
            IWSUniformes port = wsTienda.getPort(IWSUniformes.class);
            BindingProvider bp = (BindingProvider)port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://"+ IPTienda +"/WebServicioTienda/Elektra.Servicios.Datos.AdmonUniformes.WSUniformes.svc");   
            bp.getRequestContext().put(CLASE_CONNECT_TIMEOUT, TIEMPO_TIMEOUT);
            bp.getRequestContext().put(CLASE_REQUEST_TIMEOUT, TIEMPO_TIMEOUT);
            Binding binding = bp.getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            slh = new SOAPLoggingHandler();
            handlerChain.add(slh);
            binding.setHandlerChain(handlerChain);
            port.generaPedido(recive);
            webServicesTiendaActivo = true;
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);
        }
        return webServicesTiendaActivo;
    }
    
    /**
     * Graba el pedido en tienda en el web services
     * @param solicitud 
     */
    private void grabarSolicitudDetalleEnTienda(SolicitudDTO solicitud) {
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();   
        SOAPLoggingHandler slh = null;
        try {
            ObjectFactory f = new ObjectFactory();
            GeneraPedido pedido = new GeneraPedido();
            ReciveDatos recive = new ReciveDatos();

            String keyWs = TiendaCifrado.encriptaLlaveWsTienda(String.valueOf(solicitud.getNoSucursal()), solicitud.getCadenaDirIP(), String.valueOf(solicitud.getNoEmpleado()), "1");

            recive.setKeyWs(f.createReciveDatosKeyWs(keyWs));
            recive.setEmpleado(f.createReciveDatosEmpleado(String.valueOf(solicitud.getNoEmpleado())));
            recive.setTipoUsuario(new Integer(3));
            recive.setNoEmpIngreso(f.createReciveDatosNoEmpIngreso(String.valueOf(solicitud.getNoEmpleado())));
            recive.setTipoSistema(new Integer(1));
            recive.setTipoUniforme(new Integer(0));
            recive.setEmpNvo(new Integer(0));
            recive.setNumTienda(f.createReciveDatosNumTienda(String.valueOf(solicitud.getNoSucursal())));
            recive.setNegocio(new Integer(3));
            List<Integer> skus = new ArrayList<Integer>();
            //skus * cantidad
            for (SolicitudDetalle d : solicitud.getSolicitudesDetalle()) {
                for (int x = 0; x < d.getNoCantidad(); x++) {
                    skus.add(d.getNoSKU());
                }
            }
            ArrayOfint ar = new ArrayOfint();
            ar.setInt(skus);
            recive.setSku(f.createReciveDatosSku(ar));
            pedido.setRecive(f.createGeneraPedidoRecive(recive));

            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL wsdlLocation = classloader.getResource("WSUniformes.wsdl");   

            WSUniformes wsTienda  = new WSUniformes(wsdlLocation,new QName("http://tempuri.org/", "WSUniformes"));                  
                
            IWSUniformes port = wsTienda.getPort(IWSUniformes.class);
                
            BindingProvider bp = (BindingProvider)port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://"+ solicitud.getCadenaDirIP() +"/WebServicioTienda/Elektra.Servicios.Datos.AdmonUniformes.WSUniformes.svc");   
            bp.getRequestContext().put(CLASE_CONNECT_TIMEOUT, TIEMPO_TIMEOUT);
            bp.getRequestContext().put(CLASE_REQUEST_TIMEOUT, TIEMPO_TIMEOUT);
            Binding binding = bp.getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            slh = new SOAPLoggingHandler();
            handlerChain.add(slh);
            binding.setHandlerChain(handlerChain);
            
            CreaPedido cp = port.generaPedido(recive);
            String salida = (String) cp.getMsjSalida().getValue();
            int bandera = cp.getBanderaError();
            
            if (bandera == 0) {
                solicitud.setError(false);
                ArrayOfAltasPedidos ap = cp.getAltaPed().getValue();
                for (AltasPedidos pedidos : ap.getAltasPedidos()) {
                    ArrayOfint arSKU = pedidos.getSKU().getValue();
                    for (int skuPED : arSKU.getInt()) {
                        for (SolicitudDetalle solicituDetalle : solicitud.getSolicitudesDetalle()) {
                            if (skuPED == solicituDetalle.getNoSKU()) {
                                solicituDetalle.setError(false);
                                solicituDetalle.setNoPedido(pedidos.getNumPedido()); 
                                solicituDetalle.setCadenaDescripcionBitacora("SOLICITUD DETALLE GRABADA EN TIENDA");                             
                                break;
                            }
                        }
                    }
                }
            } else {
                solicitud.setError(true); //ACTIVA EL ERROR
                solicitud.setMensaje("Error WS Graba Tienda:" + salida); // SALIDA DEL WS
                //LOGS
                LogeoDAO.getInstancia().logExcepcion(
                "ERROR GRABAR SOLICITUD TIENDA:" + 
                "   No. Folio Solicitud:" + solicitud.getNoFolioSolicitud() + "\n" +
                "   No. Empleado:" + solicitud.getNoEmpleado() + "\n" +
                "   Tienda:" + solicitud.getNoSucursal());
            }
            //BUSCA LAS SOLICITUDES QUE TIENEN ERROR Y ASIGNA A SUS DETALLES
            for (SolicitudDetalle detalle : solicitud.getSolicitudesDetalle()) {
                if (solicitud.isError()) {
                    detalle.setError(true);
                    detalle.setMensaje("ERROR:" + salida);
                    detalle.setCadenaXMLResponseWS(slh.getXMLResponse());
                }
            }
            
        } catch (Exception e) {
            solicitud.setError(true);
            solicitud.setMensaje(e.getMessage());
            for (SolicitudDetalle detalle : solicitud.getSolicitudesDetalle()) {
                if (solicitud.isError()) {
                    detalle.setError(true);
                    detalle.setMensaje("ERROR WSTienda");
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
     * Graba el pedido de WSAbasto
     * @param solicitud 
     */
    private void grabarSolicitudDetalleEnCDWSAbasto(SolicitudDTO solicitud) {
    String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName(); 
    SOAPLoggingHandler slh = null;
        try {
            for (SolicitudDetalle solicitudDetalle : solicitud.getSolicitudesDetalle()) {
                Parametros parametros = new Parametros();
                parametros.setTpoOperacion(4);
                parametros.setPais(new BigDecimal(solicitud.getNoPais()));
                parametros.setCanal(new BigDecimal(solicitud.getNoCanal()));
                parametros.setCd("");
                parametros.setStoreNbr(String.valueOf(solicitud.getNoSucursal()));
                parametros.setPedido(new BigDecimal(solicitudDetalle.getNoPedido()));
                parametros.setTipped("UNIFORMES");
                parametros.setFecentr(BigDecimal.ZERO);
                parametros.setNombre("");
                parametros.setApepcl("");
                parametros.setApemcl("");
                parametros.setEstado("");
                parametros.setDelegac("");
                parametros.setCp("");
                parametros.setColonia("");
                parametros.setCalle("");
                parametros.setNumero("");
                parametros.setNumerint("");
                parametros.setTelefono("");
                parametros.setTelcel("");
                parametros.setPedidoobs("");
                parametros.setLugentobs("");
                parametros.setAdicional1(String.valueOf(solicitud.getNoEmpleado()));
                parametros.setAdicional2("");

                DETALLE DET = new DETALLE();
                ArrayList<DETALLE> arDET = new ArrayList<DETALLE>();
                DET.setSkuequ("");
                DET.setPreuni("");
                DET.setTotventa("");
                DET.setDescuen("");
                DET.setFlete("");
                DET.setSku(String.valueOf(solicitudDetalle.getNoSKU()));
                DET.setQty(String.valueOf(solicitudDetalle.getNoCantidad()));
                arDET.add(DET);
                parametros.setDETALLE(arDET);
                
                QName qname = new QName(WS_ABASTO_OP_QNAME, "intfWS_VTA_MAYOREO-service");
                ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                URL wsdlLocation = classloader.getResource("WS_VTA_MAYOREO.wsdl");  
                IntfWSVTAMAYOREOService AbastoWS = new IntfWSVTAMAYOREOService(wsdlLocation,qname);
                
                PortType port = AbastoWS.getIntfwsWSVTAMAYOREOEndpoint3();
                
                BindingProvider bp = (BindingProvider)port;
                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_ABASTO_ENDPOINT);
                //Guarda el response del Web Services
                Binding binding = ((BindingProvider)port).getBinding();
                List<Handler> handlerChain = binding.getHandlerChain();
                slh = new SOAPLoggingHandler();
                handlerChain.add(slh);
                binding.setHandlerChain(handlerChain);
                
                ParametroSalida resp = port.wsVTAMAYOREOOp(parametros);
                if (resp.getEstatus().compareTo(BigDecimal.ZERO) == 0 || resp.getMensaje1().toUpperCase().trim().equals("EL PEDIDO QUE DESEA INGRESAR YA EXISTE")) {
                    solicitud.setError(false);
                    solicitudDetalle.setError(false);
                    solicitudDetalle.setCadenaDescripcionBitacora("SOLICITUD DETALLE GRABADA EN CD");
                } else {
                    solicitud.setError(true);
                    solicitudDetalle.setError(true);
                    solicitud.setMensaje("Error WS Graba CD:" + resp.getMensaje1());
                    solicitudDetalle.setMensaje("Error WS Graba CD:" + resp.getMensaje1());
                    solicitudDetalle.setCadenaXMLResponseWS(slh.getXMLRequest());
                    LogeoDAO.getInstancia().logExcepcion(
                        "ERROR GRABAR SOLICITUD TIENDA:" + 
                        "   No. Folio Solicitud:" + solicitud.getNoFolioSolicitud() + "\n" +
                        "   No. Empleado:" + solicitud.getNoEmpleado() + "\n" +
                        "   Tienda:" + solicitud.getNoSucursal() + "\n" +
                        "   No. Pedido:" + solicitudDetalle.getNoPedido() + "\n" +
                        "   Mensaje Web Services:" + resp.getMensaje1());                
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
    
}