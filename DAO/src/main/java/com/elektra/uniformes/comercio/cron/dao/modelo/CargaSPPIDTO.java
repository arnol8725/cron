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
public class CargaSPPIDTO {
    @PropiedadMap(campo="FIFOLIOSOLICITUD")
    private int foliosolicitud;
    @PropiedadMap(campo="FIIDDETALLE")
    private int detalle;
    @PropiedadMap(campo="FIEMPLEADO")
    private int numEmpleado;
    @PropiedadMap(campo="FIPAIS")
    private int pais;
    @PropiedadMap(campo="FICANAL")
    private int canal;
    @PropiedadMap(campo="FISUCURSAL")
    private int tienda;
    @PropiedadMap(campo="FIPEDIDO")
    private int pedido;
    private String datosProceso;
    @PropiedadMap(campo="FISKU")
    private int sku;
    @PropiedadMap(campo="FICECO")
    private int ceco;
    @PropiedadMap(campo="FIESTATUS")
    private int estatus;
    @PropiedadMap(campo="FIESTATUSPEDIDO")
    private int estatusPedido;
    @PropiedadMap(campo="FIFOLIOCARGA")
    private int carga;
    @PropiedadMap(campo="FIPORCAVANCE")
    private int avance;
    @PropiedadMap(campo="FCCLAVEUSUARIO")
    private String claveUsuario;
    @PropiedadMap(campo="FCIDSISTEMASATELITAL")
    private String sistemaSatelital;
    @PropiedadMap(campo="FCCLAVECENTROPROVEEDOR")
    private String claveCentroProveedor;
    @PropiedadMap(campo="FCCLAVESERVICIO")
    private String claveServicio;
    @PropiedadMap(campo="FCCLAVESOCIEDAD")
    private String claveSociedad;
    @PropiedadMap(campo="FCDESCRIPCION")
    private String descripcion;
    @PropiedadMap(campo="FCCONCEPTO")
    private String concepto;
    @PropiedadMap(campo="FCMONEDA")
    private String moneda;
    @PropiedadMap(campo="FECHA_INICIAL")
    private String fechaInicial;
    @PropiedadMap(campo="FECHA_FINAL")
    private String fechaFinal;
    @PropiedadMap(campo="IMPORTETOTAL")
    private double importeTotal;
    @PropiedadMap(campo="FCORDEN")
    private String orden;
    @PropiedadMap(campo="FCOBSERVACIONES")
    private String observaciones;
    @PropiedadMap(campo="FCDOCUMENTO")
    private String documento;
    @PropiedadMap(campo="FCIDSISTEMA")
    private String idSistema;
    @PropiedadMap(campo="FCCOMPANIACLIENTEID")
    private String companiaClienteID;
    @PropiedadMap(campo="FCEMPRESACLIENTEID")
    private String empresaClienteID;
    /**
     * @return the foliosolicitud
     */
    public int getFoliosolicitud() {
        return foliosolicitud;
    }

    /**
     * @param foliosolicitud the foliosolicitud to set
     */
    public void setFoliosolicitud(int foliosolicitud) {
        this.foliosolicitud = foliosolicitud;
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
     * @return the tienda
     */
    public int getTienda() {
        return tienda;
    }

    /**
     * @param tienda the tienda to set
     */
    public void setTienda(int tienda) {
        this.tienda = tienda;
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
     * @return the ceco
     */
    public int getCeco() {
        return ceco;
    }

    /**
     * @param ceco the ceco to set
     */
    public void setCeco(int ceco) {
        this.ceco = ceco;
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
     * @return the carga
     */
    public int getCarga() {
        return carga;
    }

    /**
     * @param carga the carga to set
     */
    public void setCarga(int carga) {
        this.carga = carga;
    }

    /**
     * @return the avance
     */
    public int getAvance() {
        return avance;
    }

    /**
     * @param avance the avance to set
     */
    public void setAvance(int avance) {
        this.avance = avance;
    }

    /**
     * @return the claveUsuario
     */
    public String getClaveUsuario() {
        return claveUsuario;
    }

    /**
     * @param claveUsuario the claveUsuario to set
     */
    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    /**
     * @return the sistemaSatelital
     */
    public String getSistemaSatelital() {
        return sistemaSatelital;
    }

    /**
     * @param sistemaSatelital the sistemaSatelital to set
     */
    public void setSistemaSatelital(String sistemaSatelital) {
        this.sistemaSatelital = sistemaSatelital;
    }

    /**
     * @return the claveCentroProveedor
     */
    public String getClaveCentroProveedor() {
        return claveCentroProveedor;
    }

    /**
     * @param claveCentroProveedor the claveCentroProveedor to set
     */
    public void setClaveCentroProveedor(String claveCentroProveedor) {
        this.claveCentroProveedor = claveCentroProveedor;
    }

    /**
     * @return the claveServicio
     */
    public String getClaveServicio() {
        return claveServicio;
    }

    /**
     * @param claveServicio the claveServicio to set
     */
    public void setClaveServicio(String claveServicio) {
        this.claveServicio = claveServicio;
    }

    /**
     * @return the claveSociedad
     */
    public String getClaveSociedad() {
        return claveSociedad;
    }

    /**
     * @param claveSociedad the claveSociedad to set
     */
    public void setClaveSociedad(String claveSociedad) {
        this.claveSociedad = claveSociedad;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the fechaInicial
     */
    public String getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return the fechaFinal
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return the importeTotal
     */
    public double getImporteTotal() {
        return importeTotal;
    }

    /**
     * @param importeTotal the importeTotal to set
     */
    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    /**
     * @return the orden
     */
    public String getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(String orden) {
        this.orden = orden;
    }

    /**
     * @return the numEmpleado
     */
    public int getNumEmpleado() {
        return numEmpleado;
    }

    /**
     * @param numEmpleado the numEmpleado to set
     */
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
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
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the estatusPedido
     */
    public int getEstatusPedido() {
        return estatusPedido;
    }

    /**
     * @param estatusPedido the estatusPedido to set
     */
    public void setEstatusPedido(int estatusPedido) {
        this.estatusPedido = estatusPedido;
    }

    /**
     * @return the datosProceso
     */
    public String getDatosProceso() {
        return datosProceso;
    }

    /**
     * @param datosProceso the datosProceso to set
     */
    public void setDatosProceso(String datosProceso) {
        this.datosProceso = datosProceso;
    }

    public String getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(String idSistema) {
        this.idSistema = idSistema;
    }

    public String getCompaniaClienteID() {
        return companiaClienteID;
    }

    public void setCompaniaClienteID(String companiaClienteID) {
        this.companiaClienteID = companiaClienteID;
    }

    public String getEmpresaClienteID() {
        return empresaClienteID;
    }

    public void setEmpresaClienteID(String empresaClienteID) {
        this.empresaClienteID = empresaClienteID;
    }
    
}
