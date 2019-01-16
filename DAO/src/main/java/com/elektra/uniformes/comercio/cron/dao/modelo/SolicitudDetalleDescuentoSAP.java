/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.dao.modelo;

import com.elektra.mapper.anotaciones.PropiedadMap;
import java.math.BigDecimal;

/**
 * Modelo para solicitud detalle sap
 * @author Luis
 */
public class SolicitudDetalleDescuentoSAP {
     
    @PropiedadMap(campo="FCIDEMPLEADOSAP")
    private String cadenaIDEmpleadoSAP;
    
    @PropiedadMap(campo="FCFECHADESCUENTO")
    private String cadenaFechaDescuento;
    
    @PropiedadMap(campo="FIPEDIDO")
    private int noPedido;
    
    @PropiedadMap(campo="FCPRECIOTOTAL")
    private String precisionPrecioTotal;
    
    @PropiedadMap(campo="FCDESCUENTOSEMANAL")
    private String precisionDescuentoSemanal;
    
    @PropiedadMap(campo="FIFOLIOSOLICITUD")
    private int noFolioSolicitud;
    
    @PropiedadMap(campo="FIIDDETALLE")
    private int noIDDetalle;
    
    @PropiedadMap(campo="FIPAIS")
    private int noPais;
    
    @PropiedadMap(campo="FICANAL")
    private int noCanal;
    
    @PropiedadMap(campo="FISUCURSAL")
    private int noSucursal;
    
    @PropiedadMap(campo="FISKU")
    private int noSKU;
    
    @PropiedadMap(campo="FIESTATUSSOL")
    private int noIDEstatusPedido;
    
    @PropiedadMap(campo="FCREFENCIASAP")
    private String cadenaRefenciaSAP;    

    public String getCadenaIDEmpleadoSAP() {
        return cadenaIDEmpleadoSAP;
    }

    public void setCadenaIDEmpleadoSAP(String cadenaIDEmpleadoSAP) {
        this.cadenaIDEmpleadoSAP = cadenaIDEmpleadoSAP;
    }

    public String getCadenaFechaDescuento() {
        return cadenaFechaDescuento;
    }

    public void setCadenaFechaDescuento(String cadenaFechaDescuento) {
        this.cadenaFechaDescuento = cadenaFechaDescuento;
    }

    public int getNoPedido() {
        return noPedido;
    }

    public void setNoPedido(int noPedido) {
        this.noPedido = noPedido;
    }

    public BigDecimal getPrecisionPrecioTotal() {
        return new BigDecimal(precisionPrecioTotal);
    }

    public void setPrecisionPrecioTotal(String precisionPrecioTotal) {
        this.precisionPrecioTotal = precisionPrecioTotal;
    }

    public BigDecimal getPrecisionDescuentoSemanal() {
        return new BigDecimal(precisionDescuentoSemanal);
    }

    public void setPrecisionDescuentoSemanal(String precisionDescuentoSemanal) {
        this.precisionDescuentoSemanal = precisionDescuentoSemanal;
    }

    public int getNoFolioSolicitud() {
        return noFolioSolicitud;
    }

    public void setNoFolioSolicitud(int noFolioSolicitud) {
        this.noFolioSolicitud = noFolioSolicitud;
    }

    public int getNoIDDetalle() {
        return noIDDetalle;
    }

    public void setNoIDDetalle(int noIDDetalle) {
        this.noIDDetalle = noIDDetalle;
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

    public int getNoSKU() {
        return noSKU;
    }

    public void setNoSKU(int noSKU) {
        this.noSKU = noSKU;
    }

    public int getNoIDEstatusPedido() {
        return noIDEstatusPedido;
    }

    public void setNoIDEstatusPedido(int noIDEstatusPedido) {
        this.noIDEstatusPedido = noIDEstatusPedido;
    }

    public String getCadenaRefenciaSAP() {
        return cadenaRefenciaSAP;
    }

    public void setCadenaRefenciaSAP(String cadenaRefenciaSAP) {
        this.cadenaRefenciaSAP = cadenaRefenciaSAP;
    }
        
}

