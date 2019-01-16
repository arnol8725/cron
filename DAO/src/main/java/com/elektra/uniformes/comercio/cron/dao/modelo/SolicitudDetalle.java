/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao.modelo;

import com.elektra.mapper.anotaciones.PropiedadMap;

/**
 *
 * @author kortizl
 */
public class SolicitudDetalle {
         
    @PropiedadMap(id=true, campo="FIIDDETALLE")
    private int noIDDetalle; 
    
    @PropiedadMap(id=true, campo="FIPEDIDO")
    private int noPedido; 
    
    @PropiedadMap(id=true,campo="FISKU")
    private int noSKU; 
    
    @PropiedadMap(campo="FIESTATUSSOL")
    private int noEstatusSol;
    
    @PropiedadMap(campo="FITALLA")
    private int noTalla; 
    
    @PropiedadMap(campo="FICANTIDAD")
    private int noCantidad;

    @PropiedadMap(campo="FIRUTA")
    private int noRutaCDWS; //WSAbasto
    
    private int noEstatusCDWS; //WSAbasto
    
    private String cadenaXMLResponseWS;  //WSAbasto
    
    private String cadenaDescripcionBitacora;  
    
    private String cadenaMensajeCDWS; //WSAbasto
    
    private int noEstatusRemisionWS; //WSAbasto
    
    private int noIDManhantan; //WSAbasto
        
    private boolean error;
    
    private String mensaje;

    public int getNoIDDetalle() {
        return noIDDetalle;
    }

    public void setNoIDDetalle(int noIDDetalle) {
        this.noIDDetalle = noIDDetalle;
    }

    public int getNoPedido() {
        return noPedido;
    }

    public void setNoPedido(int noPedido) {
        this.noPedido = noPedido;
    }

    public int getNoSKU() {
        return noSKU;
    }

    public void setNoSKU(int noSKU) {
        this.noSKU = noSKU;
    }

    public int getNoTalla() {
        return noTalla;
    }

    public void setNoTalla(int noTalla) {
        this.noTalla = noTalla;
    }

    public int getNoCantidad() {
        return noCantidad;
    }

    public void setNoCantidad(int noCantidad) {
        this.noCantidad = noCantidad;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public int getNoEstatusCDWS() {
        return noEstatusCDWS;
    }

    public void setNoEstatusCDWS(int noEstatusCDWS) {
        this.noEstatusCDWS = noEstatusCDWS;
    }
    
    public void setNoEstatusCDWS(String noEstatusCDWS) {
        this.noEstatusCDWS = this.regresaNumero(noEstatusCDWS);
    }

    public String getCadenaDescripcionBitacora() {
        return espacioVacio(cadenaDescripcionBitacora);
    }

    public void setCadenaDescripcionBitacora(String cadenaDescripcionBitacora) {
        this.cadenaDescripcionBitacora = cadenaDescripcionBitacora;
    }

    public String getCadenaMensajeCDWS() {
        return espacioVacio(cadenaMensajeCDWS);
    }

    public void setCadenaMensajeCDWS(String cadenaMensajeCDWS) {
        this.cadenaMensajeCDWS = cadenaMensajeCDWS;
    }

    public String getCadenaXMLResponseWS() {
        return espacioVacio(cadenaXMLResponseWS);
    }

    public void setCadenaXMLResponseWS(String cadenaXMLResponseWS) {
        this.cadenaXMLResponseWS = cadenaXMLResponseWS;
    }

    public int getNoEstatusSol() {
        return noEstatusSol;
    }

    public void setNoEstatusSol(int noEstatusSol) {
        this.noEstatusSol = noEstatusSol;
    }
    
    public int getNoRutaCDWS() {
        return noRutaCDWS;
    }

    public void setNoRutaCDWS(int noRutaCDWS) {
        this.noRutaCDWS = noRutaCDWS;
    }
   
    public void setNoRutaCDWS(String noRutaCDWS) {
        this.noRutaCDWS = regresaNumero(noRutaCDWS);
    }

    public void setNoEstatusRemisionWS(int noEstatusRemisionWS) {
        this.noEstatusRemisionWS = noEstatusRemisionWS;
    }
    
    public void setNoEstatusRemisionWS(String noEstatusRemisionWS) {
        this.noEstatusRemisionWS = regresaNumero(noEstatusRemisionWS);
    }    
    
    public int getNoEstatusRemisionWS() {
        return noEstatusRemisionWS;
    }

    public int getNoIDManhantan() {
        return noIDManhantan;
    }

    public void setNoIDManhantan(int noIDManhantan) {
        this.noIDManhantan = noIDManhantan;
    }
    
    public void setNoIDManhantan(String noIDManhantan) {
        this.noIDManhantan = regresaNumero(noIDManhantan);
    }
    
    public String espacioVacio(String cadena){
        if(cadena == null || cadena.equals("")){
            return " ";
        }else{
            return cadena;
        }
    }
    
    public int regresaNumero(String string) {
        try {           
            if(string == null || string.equals("")){
                string = "0";
            }
            return Integer.valueOf(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
