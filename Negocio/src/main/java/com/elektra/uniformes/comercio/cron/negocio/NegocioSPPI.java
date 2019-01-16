/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.CargaSPPIDAO;
import com.elektra.uniformes.comercio.cron.dao.CorreoDAO;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.ArrayOfDetalleCargaRe;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.AvanceCargaReal;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.AvanceCargaRealSPPI;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.AvanceCargaRealSPPIResponse;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CargaRealesSPPI;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CargaRealesSPPIResponse;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.ConectorUnico;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.ConectorUnicoSoap;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.DetalleCargaRe;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.ErroresCargaRe;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.tienda.ObjectFactory;
import com.elektra.uniformes.comercio.cron.dao.modelo.CargaSPPIDTO;
import com.elektra.uniformes.comercio.cron.dao.modelo.RemisionPedido;
import com.elektra.uniformes.comercio.cron.util.SoapPeticionRespuestaHandler;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.xml.bind.JAXB;
import javax.xml.namespace.QName;
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
@Component("negocioSPPI")
public class NegocioSPPI {
    
    @Autowired
    @Qualifier("cargaSPPIDAO")
    private CargaSPPIDAO cargaSPPIDAO;
    @Autowired
    @Qualifier("correoDAO")
    private CorreoDAO correoDAO;
    @Value("#{propiedadesCronUniformesComercio['WS_SPPI']}")
    private String WS_SPPI;
    
    public void procesaSPPI() throws Exception {
        ArrayList<CargaSPPIDTO> pendientesSPPI = null;
        ArrayList<CargaSPPIDTO> pendientesActualizarSPPI = null;
        String msjErrorGral = "";
        Date inicioProc = new Date();
        try {
            
            if (validaFinDeSemana() && cargaSPPIDAO.validaDiaEnvio()) {/* validar si es dia habil*/
                /*carga*/
                LogeoDAO.getInstancia().logExcepcion("INICIA PROCESO CARGA SPPI : " + new Date());
                LogeoDAO.getInstancia().logExcepcion("Consulta pedidos pendientes para carga SPPI ");
                pendientesSPPI = cargaSPPIDAO.consultaPendientesSPPI();
                int pedObt = pendientesSPPI.size();
                LogeoDAO.getInstancia().logExcepcion("Pedidos pendientes para carga SPPI : " + pedObt);
                if (pedObt > 0) {
                    for (CargaSPPIDTO carga : pendientesSPPI) {
                        this.cargaSPPIWS(carga);
                    }
                    msjErrorGral = cargaSPPIDAO.actualizaSPPI(pendientesSPPI);
                } else {
                    LogeoDAO.getInstancia().logExcepcion("No se obtuvieron pedidos pendientes para carga SPPI");
                }
                /*actualización avance*/
                LogeoDAO.getInstancia().logExcepcion("Consulta pedidos pendientes para actualizar avance SPPI ");
                pendientesActualizarSPPI = cargaSPPIDAO.consultaSPPIPorActualizar();
                int pedAObt = pendientesActualizarSPPI.size();
                LogeoDAO.getInstancia().logExcepcion("Pedidos pendientes para actualizar SPPI : " + pedAObt);
                if (pedAObt > 0) {
                    for (CargaSPPIDTO carga : pendientesActualizarSPPI) {
                        this.actualizaSPPIWS(carga);
                    }
                    msjErrorGral = cargaSPPIDAO.actualizaSPPI(pendientesActualizarSPPI);
                } else {
                    LogeoDAO.getInstancia().logExcepcion("No se obtuvieron pendientes para actualizar SPPI");
                }
                LogeoDAO.getInstancia().logExcepcion("FIN PROCESO CARGA SPPI : " + new Date());
            }
        } catch (Exception ex) {
            msjErrorGral = ex.getMessage();
            LogeoDAO.getInstancia().logExcepcion("1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: actualizaRemisiones \n"
                    + "3. Excepcion: " + ex.getMessage());
        } finally {
            correoDAO.envio(pendientesSPPI.toArray(), this.getClass().toString(), "procesaSPPI => Solicitudes pendientes de aplicar en SPPI", inicioProc, msjErrorGral);
            correoDAO.envio(pendientesActualizarSPPI.toArray(), this.getClass().toString(), "procesaSPPI => Solicitudes avance en SPPI", inicioProc, msjErrorGral);
        }
    }
    
    private void cargaSPPIWS(CargaSPPIDTO cargaP) throws Exception {
        try {
            CargaRealesSPPI carga = new CargaRealesSPPI();
            carga.setClaveUsuario(cargaP.getClaveUsuario());
            carga.setIdSistemaSatelital(Integer.valueOf(cargaP.getSistemaSatelital()));
            carga.setClaveCentroProvedor(cargaP.getClaveCentroProveedor());
            carga.setClaveServicio(cargaP.getClaveServicio());
            carga.setClaveSociedad(cargaP.getClaveSociedad());
            carga.setDescripcion(cargaP.getDescripcion());
            carga.setConcepto(Integer.valueOf(cargaP.getConcepto()));
            carga.setMoneda(cargaP.getMoneda());
            carga.setFechaInicial(cargaP.getFechaInicial());
            carga.setFechaFinal(cargaP.getFechaFinal());
            carga.setImporteTotal(cargaP.getImporteTotal());
            ArrayOfDetalleCargaRe detalle = new ArrayOfDetalleCargaRe();
            DetalleCargaRe detalleCarga = new DetalleCargaRe();
            detalle.getDetalleCargaRe().add(detalleCarga);
            detalleCarga.setCCliente(String.valueOf(cargaP.getCeco()));
            detalleCarga.setImporte(cargaP.getImporteTotal());
            detalleCarga.setNumEmpleado(String.valueOf(cargaP.getNumEmpleado()));
            detalleCarga.setOrden(cargaP.getOrden());
            detalleCarga.setDescripcion(String.format("Folio: %d Tienda: %d Pedido: %d", cargaP.getFoliosolicitud(), cargaP.getTienda(), cargaP.getPedido()));
            carga.setDetalleCarga(detalle);
            
            ConectorUnico conu = new ConectorUnico(new URL(WS_SPPI), new QName("http://tempuri.org/", "ConectorUnico"));
            ConectorUnicoSoap conSoap = conu.getPort(ConectorUnicoSoap.class);
            /*Handler para obtener peticion y respuesta ws soap*/
            BindingProvider prov = (BindingProvider) conSoap;
            List<Handler> handlers = prov.getBinding().getHandlerChain();
            SoapPeticionRespuestaHandler spr = new SoapPeticionRespuestaHandler();
            handlers.add(spr);
            prov.getBinding().setHandlerChain(handlers);
            CargaRealesSPPIResponse rspCarga = conSoap.cargaRealesSPPI(carga);
            cargaP.setDatosProceso(this.formatPeticionRespuesta(spr.getPeticion(), spr.getRespuesta()));
            cargaP.setDocumento("aplicado");
            for (ErroresCargaRe error : rspCarga.getErroresCarga().getErroresCargaRe()) {
                if (error.getError().equals("OK")) {
                    cargaP.setObservaciones("Aplicado Correctamente");
                    cargaP.setCarga(Integer.parseInt(rspCarga.getCarga()));
                    cargaP.setEstatus(1);
                } else {
                    cargaP.setObservaciones(error.getError());
                    cargaP.setCarga(0);
                    cargaP.setEstatus(0);
                }
            }
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion("Ocurrió un error al consultar ws cargaSPPI" + e.getMessage());
            cargaP.setObservaciones(e.getMessage());
            cargaP.setEstatus(0);
            cargaP.setCarga(0);
        }
    }
    
    private void actualizaSPPIWS(CargaSPPIDTO cargaP) throws Exception {
        try {
            AvanceCargaRealSPPI cargaReal = new AvanceCargaRealSPPI();
            cargaReal.setClaveUsuario(cargaP.getClaveUsuario());
            cargaReal.setIdSistemaSatelital(Integer.valueOf(cargaP.getSistemaSatelital()));
            cargaReal.setFolio(cargaP.getCarga());
            ConectorUnico conu = new ConectorUnico(new URL(WS_SPPI), new QName("http://tempuri.org/", "ConectorUnico"));
            ConectorUnicoSoap conSoap = conu.getPort(ConectorUnicoSoap.class);
            /*Handler para obtener peticion y respuesta ws soap*/
            BindingProvider prov = (BindingProvider) conSoap;
            List<Handler> handlers = prov.getBinding().getHandlerChain();
            SoapPeticionRespuestaHandler spr = new SoapPeticionRespuestaHandler();
            handlers.add(spr);
            prov.getBinding().setHandlerChain(handlers);
            AvanceCargaRealSPPIResponse rspAv = conSoap.avanceCargaRealSPPI(cargaReal);
            cargaP.setDatosProceso(this.formatPeticionRespuesta(spr.getPeticion(), spr.getRespuesta()));
            if (rspAv.getAvanceCargaRealSPPI() == null || rspAv.getAvanceCargaRealSPPI().getAvanceCargaReal().isEmpty()) {
                cargaP.setObservaciones("No se encotró información de la carga " + cargaP.getCarga() + " en SPPI");
                cargaP.setDocumento("error");
                cargaP.setEstatus(0);
            }
            
            for (AvanceCargaReal avance : rspAv.getAvanceCargaRealSPPI().getAvanceCargaReal()) {
                if (avance.getRegistrosRechazados() > 0) {
                    cargaP.setObservaciones("Existen " + avance.getRegistrosRechazados() + " registros rechazados de la carga " + cargaP.getCarga() + " en SPPI");
                    cargaP.setDocumento("error");
                    cargaP.setEstatus(0);
                } else {
                    int avancePorc = (int) avance.getPorcentajeAvance();
                    String doc = avancePorc == 100 ? avance.getNumdocumento() : "Procesando";
                    int estatus = avancePorc == 100 ? 3 : 2;
                    cargaP.setAvance(avancePorc);
                    cargaP.setDocumento(doc);
                    cargaP.setEstatus(estatus);
                    cargaP.setObservaciones("actualiza avance :" + avancePorc + "%");
                }
            }
            
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion("Ocurrió un error al consultar ws avanceCarga" + e.getMessage());
            cargaP.setObservaciones(e.getMessage());
            cargaP.setEstatus(0);
            cargaP.setDocumento("error");
        }
    }
    
    private boolean validaFinDeSemana() {
        boolean valido = true;
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());
        
        if ((c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (Calendar.DAY_OF_WEEK == Calendar.SUNDAY)) {  //or sunday   
            valido = false;
        }
        
        return valido;
    }
    
    public String formatPeticionRespuesta(String peticion, String respuesta) {
        StringBuilder petResp = new StringBuilder();
        petResp.append("----peticion-----\n");
        petResp.append(peticion);
        petResp.append("----respuesta-----\n");
        petResp.append(respuesta);
        int resp = petResp.length();
        if (resp < 3999) {
            return petResp.toString();
        } else {
            return petResp.toString().substring(0, 3999);
        }
    }
}
