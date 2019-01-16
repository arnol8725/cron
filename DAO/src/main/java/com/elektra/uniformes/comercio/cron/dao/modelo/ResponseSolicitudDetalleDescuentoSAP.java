/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao.modelo;


import com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap.ZHRLOGERRVNTEMP;
import java.util.ArrayList;

 public class ResponseSolicitudDetalleDescuentoSAP {
        
    private int noFolioSolicitud;
    
    private int noIDDetalle;
    
    private int noPais;
    
    private int noCanal;
    
    private int noIDSucursal;
    
    private int noPedido;
    
    private int noSKU;
    
    private String cadenaRefenciaSAP;
    
    private int noEstatusCorrectoResponseSAP;  
    
    private ZHRLOGERRVNTEMP zhrLoger;
    
    private String cadenaXMLRequest;
    
    private String cadenaXMLResponse;
    
    private String cadenaTEXTXMLResponse;
    
    private int noError;
    
    private ArrayList<TipoError> tiposError;
    
    public ResponseSolicitudDetalleDescuentoSAP(SolicitudDetalleDescuentoSAP pedidoDescuentoSAP,
        ZHRLOGERRVNTEMP zhrLoger,String cadenaXMLRequest,String cadenaXMLResponse, ArrayList<TipoError> tiposError
    ){
        this.noFolioSolicitud = pedidoDescuentoSAP.getNoFolioSolicitud();
        this.noIDDetalle = pedidoDescuentoSAP.getNoIDDetalle();
        this.noPais = pedidoDescuentoSAP.getNoPais();
        this.noCanal = pedidoDescuentoSAP.getNoCanal();
        this.noIDSucursal = pedidoDescuentoSAP.getNoSucursal();
        this.noPedido = pedidoDescuentoSAP.getNoPedido();
        this.noSKU = pedidoDescuentoSAP.getNoSKU();
        this.cadenaRefenciaSAP = pedidoDescuentoSAP.getCadenaRefenciaSAP();
        this.zhrLoger = zhrLoger;
        this.cadenaXMLRequest = regresaCadena(cadenaXMLRequest);
        this.cadenaXMLResponse = regresaCadena(cadenaXMLResponse);
        this.tiposError = tiposError;
    }               

    public int getNoFolioSolicitud() {
        return noFolioSolicitud;
    }

    public int getNoIDDetalle() {
        return noIDDetalle;
    }

    public int getNoPais() {
        return noPais;
    }

    public int getNoCanal() {
        return noCanal;
    }

    public int getNoIDSucursal() {
        return noIDSucursal;
    }

    public int getNoPedido() {
        return noPedido;
    }
    
    public int getNoSKU() {
        return noSKU;
    }

    public String getCadenaRefenciaSAP() {
        return cadenaRefenciaSAP;
    }
    
    /**
     * Si no existe problema devuelve 1
     * @return 
     */
    public int getNoEstatusCorrectoResponseSAP() {
        String TEXT = this.zhrLoger.getTEXT().toUpperCase().trim();
        String MSGTYP = this.zhrLoger.getMSGTYP().toUpperCase().trim();
        String MSGSPRA = this.zhrLoger.getMSGSPRA().toUpperCase().trim();
        String TCODE = this.zhrLoger.getTCODE().toUpperCase().trim();
        boolean tipoError1 = MSGSPRA.equals("S") && MSGTYP.equals("E"); // Por si hubo un cambio
        boolean tipoError2 = MSGTYP.equals("E") || MSGTYP.equals("S");
        if(!this.cadenaXMLRequest.equals("ERROR")){
            if( (!(tipoError1 || tipoError2)) || busquedaTiposError(TEXT) == 112){
                return 1;
            }else{
                if(busquedaTiposError(TEXT) == 112){
                    return 1;
                }else{
                    return 0;
                }
            }  
        }
        return 0;
    }
    
    public String getCadenaXMLRequest() {
        return cadenaXMLRequest;
    }

    public String getCadenaXMLResponse() {
        return cadenaXMLResponse;
    }

    public String getCadenaTEXTXMLResponse() {
        this.cadenaTEXTXMLResponse = this.zhrLoger.getTEXT().trim();
        return cadenaTEXTXMLResponse;
    }
    
    /**
     * Retorna el numero de error para insertarlo en la bitacora
     * @return 
     */
    public int getNoError() {
        return busquedaTiposError(this.zhrLoger.getTEXT().trim().toUpperCase()) == 0 ? 1 : busquedaTiposError(this.zhrLoger.getTEXT().trim().toUpperCase()) ;
    }
    
    public int busquedaTiposError(String cadena){
        int numeroError = 0;
        for (TipoError tipoError : tiposError) {
            if(tipoError.getCadenaDescripcion().equals(cadena)){
                numeroError = tipoError.getNoIDError();
            }
        }
        return numeroError;
    }
      
    public String regresaCadena(String cadena){
        String espacio = " ";
        if(cadena.equals("") || cadena == null){
            return espacio;
        }else{
            return cadena;
        }
    }
}
