/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao.modelo;

import com.elektra.mapper.anotaciones.PropiedadMap;
import java.util.ArrayList;

/**
 *
 * @author kortizl
 */
public class SolicitudDTO {
    
    @PropiedadMap(id=true, campo="FIFOLIOSOLICITUD")
    private int noFolioSolicitud; //solicitud  
    
    @PropiedadMap(campo="FIEMPLEADO")
    private int noEmpleado; //empleado
    
    @PropiedadMap(campo="FIPAIS")
    private int noPais; //pais
    
    @PropiedadMap(campo="FICANAL")
    private int noCanal; //canal
    
    @PropiedadMap(campo="FISUCURSAL")
    private int noSucursal; //sucursal
    
    @PropiedadMap(campo="FCDIRIP")
    private String cadenaDirIP; //ipTienda

    @PropiedadMap(lista=true, tipoComplejo = "com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDetalle")
    private ArrayList<SolicitudDetalle> solicitudesDetalle;
    
    private boolean error;
    
    private String mensaje;

    public int getNoFolioSolicitud() {
        return noFolioSolicitud;
    }

    public void setNoFolioSolicitud(int noFolioSolicitud) {
        this.noFolioSolicitud = noFolioSolicitud;
    }

    public int getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(int noEmpleado) {
        this.noEmpleado = noEmpleado;
    }

    public int getNoPais() {
        return noPais;
    }

    public void setNoPais(int noPais) {
        this.noPais = noPais;
    }

    public int getNoCanal() {
        return noCanal;
    }

    public void setNoCanal(int noCanal) {
        this.noCanal = noCanal;
    }

    public int getNoSucursal() {
        return noSucursal;
    }

    public void setNoSucursal(int noSucursal) {
        this.noSucursal = noSucursal;
    }

    public String getCadenaDirIP() {
        return cadenaDirIP;
    }

    public void setCadenaDirIP(String cadenaDirIP) {
        this.cadenaDirIP = cadenaDirIP;
    }

    public ArrayList<SolicitudDetalle> getSolicitudesDetalle() {
        return solicitudesDetalle;
    }

    public void setSolicitudesDetalle(ArrayList<SolicitudDetalle> solicitudesDetalle) {
        this.solicitudesDetalle = solicitudesDetalle;
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
 
    
}
