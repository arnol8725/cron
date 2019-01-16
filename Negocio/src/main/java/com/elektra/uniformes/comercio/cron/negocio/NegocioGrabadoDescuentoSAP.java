/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.DescuentoSAPDAO;
import com.elektra.uniformes.comercio.cron.dao.TiposErrorDAO;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap.ArrayOfZHRLOGERRVNTEMP;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap.EmpCargaDescUniforme;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap.SrvDesc;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap.SrvDescSoap;
import com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap.ZHRLOGERRVNTEMP;
import com.elektra.uniformes.comercio.cron.dao.modelo.ResponseSolicitudDetalleDescuentoSAP;
import com.elektra.uniformes.comercio.cron.dao.modelo.SOAPLoggingHandler;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDetalleDescuentoSAP;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Luis
 */
@Component("negocioGrabadoDescuentoSAP")
public class NegocioGrabadoDescuentoSAP {
    
    //WS_GRABA_DESCUENTOS_SAP
    @Value("#{propiedadesCronUniformesComercio['WS_GRABA_DESCUENTOS_SAP']}")
    public String WS_GRABA_DESCUENTOS_SAP;     
    
    //#sIdNeg
    @Value("#{propiedadesCronUniformesComercio['ID_NEGOCIO']}")
    public String ID_NEGOCIO;  
    //#sUsr
    @Value("#{propiedadesCronUniformesComercio['USUARIO_WS_PDS']}")
    public String USUARIO_WS_PDS;      
    //#sPwd
    @Value("#{propiedadesCronUniformesComercio['CONTRASENA_WS_PDS']}")
    public String CONTRASENA_WS_PDS; 
    
    @Autowired
    @Qualifier("descuentoSAPDAO")
    private DescuentoSAPDAO descuentoSAPDAO;  
    
        
    @Autowired
    @Qualifier("tiposErrorDAO")
    private TiposErrorDAO tiposErrorDAO;    
        
    /**
     * CRON ACTUALIZA ESTATUSCD
     */
    public void cronGrabaDescuentosSAP() {  
        tiposErrorDAO.creaTiposError();
        this.grabaDescuentosSAP();       
    }
    
    /**
     * CRON DE GRABA DESCUENTOS SAP
     */
    private void grabaDescuentosSAP(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();        
        try{                                    
            // CONSULTA DEL STORED PROCEDURE DE LA BD DE UNIFORMES
            ArrayList<SolicitudDetalleDescuentoSAP> solicitudesDescuentosSAP = descuentoSAPDAO.getSolicitudesDetalleDescuentosSAP();  
            
            // PREPARA GUARDAR EL SEGUIMIENTO DE LOS DESCUENTOS SAP            
            ArrayList<ResponseSolicitudDetalleDescuentoSAP> seguimientos = new ArrayList<ResponseSolicitudDetalleDescuentoSAP>();
            
            for (SolicitudDetalleDescuentoSAP pedidoDescuentoSAP : solicitudesDescuentosSAP) {      
                  
                EmpCargaDescUniforme cargaDescuentoUniforme = new EmpCargaDescUniforme();
                cargaDescuentoUniforme.setSIdNeg(ID_NEGOCIO);
                cargaDescuentoUniforme.setSUsr(USUARIO_WS_PDS);
                cargaDescuentoUniforme.setSPwd(CONTRASENA_WS_PDS);
                cargaDescuentoUniforme.setSPer(pedidoDescuentoSAP.getCadenaIDEmpleadoSAP()); //IDEMPLEADOSAP
                cargaDescuentoUniforme.setSBegda(pedidoDescuentoSAP.getCadenaFechaDescuento()); //FECHA DESCUENTO
                cargaDescuentoUniforme.setDImporte(pedidoDescuentoSAP.getPrecisionPrecioTotal()); //TOTAL A PAGAR
                cargaDescuentoUniforme.setDTAmort(pedidoDescuentoSAP.getPrecisionDescuentoSemanal()); //DESCUENTO SEMANAL
                cargaDescuentoUniforme.setSReferencia(pedidoDescuentoSAP.getCadenaRefenciaSAP()); //REFERENCIA SAP                          
                cargaDescuentoUniforme.setItErr(this.inicializacionArrayZhrLogerError()); //LOG DE ERRORES
                //ALMACENA 
                ResponseSolicitudDetalleDescuentoSAP seguimiento = this.responseGrabaDescuentosSAP(
                    pedidoDescuentoSAP,
                    cargaDescuentoUniforme
                );                    
                seguimientos.add(seguimiento);                
            }
            
            if(!seguimientos.isEmpty()){
                // EJECUTA EL STORED PROCEDURE PARA EL GUARDADO DE SEGUIMIENTOS
                descuentoSAPDAO.guardaDistribucionSAP(seguimientos);
            }
        }catch(Exception ex){
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + ex.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(ex);     
        }
    }

    /**
     * Respuesta del WS SAP
     * @param cargaDescuentoUniforme 
     */
    private ResponseSolicitudDetalleDescuentoSAP responseGrabaDescuentosSAP(
        SolicitudDetalleDescuentoSAP pedidoDescuentoSAP, 
        EmpCargaDescUniforme cargaDescuentoUniforme
    ){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();
        ResponseSolicitudDetalleDescuentoSAP spdSAP = null;
        SOAPLoggingHandler slh = null;
        try{            
            URL url = new URL(WS_GRABA_DESCUENTOS_SAP);
            SrvDesc wsPedidoDescuentosSAP  = new SrvDesc(url);  
            SrvDescSoap port = wsPedidoDescuentosSAP.getSrvDescSoap();             
            //Guarda el response del Web Services
            Binding binding = ((BindingProvider)port).getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            slh = new SOAPLoggingHandler();
            handlerChain.add(slh);
            binding.setHandlerChain(handlerChain);
                    
            //REQUEST Y RESPONSE WS SAP            
            ZHRLOGERRVNTEMP responseZhrLoger = port.empCargaDescUniforme(
                cargaDescuentoUniforme
            ).getItErr().getZHRLOGERRVNTEMP().get(0);                 

            spdSAP = new ResponseSolicitudDetalleDescuentoSAP(
                pedidoDescuentoSAP,
                responseZhrLoger,
                slh.getXMLRequest(),
                slh.getXMLResponse(),
                tiposErrorDAO.tiposError
            );

        } catch(Exception e){
            spdSAP = new ResponseSolicitudDetalleDescuentoSAP(
                pedidoDescuentoSAP,
                this.generaZhrLogerError(e.getMessage()),
                 "ERROR",
                this.generaZhrLogerError(e.getMessage()).toString(),
                tiposErrorDAO.tiposError
            );           
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);     
        }   
        return spdSAP;
    }
    
    /**
     * Inicializa los mensajes de error para enviarlos al WS SAP
     * @return 
     */
    private ArrayOfZHRLOGERRVNTEMP inicializacionArrayZhrLogerError(){  
        ArrayOfZHRLOGERRVNTEMP listaZhrLogerError = new ArrayOfZHRLOGERRVNTEMP();
        ZHRLOGERRVNTEMP zhrLogerError = new ZHRLOGERRVNTEMP();        
        zhrLogerError.setMANDT("?"); // MANDT
        zhrLogerError.setPERNR("?"); //PERNR
        zhrLogerError.setAEDTM("?"); //AEDTM
        zhrLogerError.setCONSECUTIVO("?"); //CONSECUTIVO
        zhrLogerError.setUNAME("?"); //UNAME
        zhrLogerError.setFOLIO("?"); //FOLIO
        zhrLogerError.setREFERENCIA("?"); //REFERENCIA
        zhrLogerError.setTEXT("?"); //TEXT
        zhrLogerError.setTCODE("?"); //TCODE
        zhrLogerError.setDYNAME("?"); //DYNAME
        zhrLogerError.setDYNUMB("?"); //DYNUMB
        zhrLogerError.setMSGTYP("?"); //MSGTYP
        zhrLogerError.setMSGSPRA("?"); //MSGSPRA
        zhrLogerError.setMSGID("?"); //MSGID
        zhrLogerError.setMSGNR("?"); //MSGNR
        zhrLogerError.setMSGV1("?"); //MSGV1
        zhrLogerError.setMSGV2("?"); //MSGV2
        zhrLogerError.setMSGV3("?"); //MSGV3
        zhrLogerError.setMSGV4("?"); //MSGV4
        zhrLogerError.setENV("?"); //ENV
        zhrLogerError.setFLDNAME("?"); //FLDNAME  
        listaZhrLogerError.getZHRLOGERRVNTEMP().add(zhrLogerError);
        return listaZhrLogerError;
    }
    
    private ZHRLOGERRVNTEMP generaZhrLogerError(String texto){
        ZHRLOGERRVNTEMP zhrLogerError = new ZHRLOGERRVNTEMP();        
        zhrLogerError.setMANDT(""); // MANDT
        zhrLogerError.setPERNR(""); //PERNR
        zhrLogerError.setAEDTM(""); //AEDTM
        zhrLogerError.setCONSECUTIVO(""); //CONSECUTIVO
        zhrLogerError.setUNAME(""); //UNAME
        zhrLogerError.setFOLIO(""); //FOLIO
        zhrLogerError.setREFERENCIA(""); //REFERENCIA
        zhrLogerError.setTEXT("Error Web Service Descuentos SAP: " + texto); //TEXT
        zhrLogerError.setTCODE("1"); //TCODE
        zhrLogerError.setDYNAME(""); //DYNAME
        zhrLogerError.setDYNUMB(""); //DYNUMB
        zhrLogerError.setMSGTYP(""); //MSGTYP
        zhrLogerError.setMSGSPRA(""); //MSGSPRA
        zhrLogerError.setMSGID(""); //MSGID
        zhrLogerError.setMSGNR(""); //MSGNR
        zhrLogerError.setMSGV1(""); //MSGV1
        zhrLogerError.setMSGV2(""); //MSGV2
        zhrLogerError.setMSGV3(""); //MSGV3
        zhrLogerError.setMSGV4(""); //MSGV4
        zhrLogerError.setENV(""); //ENV
        zhrLogerError.setFLDNAME(""); //FLDNAME
        return zhrLogerError;
    }    
    
}
