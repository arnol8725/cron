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
public class RemisionPedido {
    @PropiedadMap(campo="FIFOLIOSOLICITUD")
    private int solicitud;
    @PropiedadMap(campo="FIDETALLE")
    private int detalle;
    @PropiedadMap(campo="FIPAIS")
    private int pais;
    @PropiedadMap(campo="FICANAL")
    private int canal;
    @PropiedadMap(campo="FISUCURSAL")
    private int sucursal;
    @PropiedadMap(campo="FIPEDIDO")
    private int pedido;
    @PropiedadMap(campo="FINUMREMISION")
    private int remision;
    @PropiedadMap(campo="FISKU")
    private int sku;
    @PropiedadMap(campo="FICANTIDAD")
    private int cantidad;
    @PropiedadMap(campo="FIIDEMPLEADO")
    private int empleado;
    @PropiedadMap(campo="FCDIVISION")
    private String div;
    @PropiedadMap(campo="FCOBSERVACIONES")
    private String obs;
    @PropiedadMap(campo="FDREGISTRO")
    private String fecha;
    @PropiedadMap(campo="FIESTATUS")
    private int estatus;

    /**
     * @return the solicitud
     */
    public int getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(int solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * @return the detalle
     */
    public int getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(int detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the pais
     */
    public int getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(int pais) {
        this.pais = pais;
    }

    /**
     * @return the canal
     */
    public int getCanal() {
        return canal;
    }

    /**
     * @param canal the canal to set
     */
    public void setCanal(int canal) {
        this.canal = canal;
    }

    /**
     * @return the sucursal
     */
    public int getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the pedido
     */
    public int getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the sku
     */
    public int getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(int sku) {
        this.sku = sku;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the empleado
     */
    public int getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the div
     */
    public String getDiv() {
        return div;
    }

    /**
     * @param div the div to set
     */
    public void setDiv(String div) {
        this.div = div;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the estatus
     */
    public int getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the remision
     */
    public int getRemision() {
        return remision;
    }

    /**
     * @param remision the remision to set
     */
    public void setRemision(int remision) {
        this.remision = remision;
    }
}
