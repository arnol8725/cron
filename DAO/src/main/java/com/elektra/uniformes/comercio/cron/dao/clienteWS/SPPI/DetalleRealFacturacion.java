
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DetalleRealFacturacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DetalleRealFacturacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Factura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Proveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Emisora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClienteSociedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Orden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmpresaDistribuido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CClienteDistribuido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Importe" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Unidades" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tarifa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Proyecto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Empleado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Concepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentoSAP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CiaCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetalleRealFacturacion", propOrder = {
    "servicio",
    "factura",
    "fecha",
    "proveedor",
    "emisora",
    "clienteSociedad",
    "cliente",
    "orden",
    "empresaDistribuido",
    "cClienteDistribuido",
    "importe",
    "unidades",
    "tarifa",
    "proyecto",
    "empleado",
    "observaciones",
    "concepto",
    "documentoSAP",
    "ciaCliente"
})
public class DetalleRealFacturacion {

    @XmlElement(name = "Servicio")
    protected String servicio;
    @XmlElement(name = "Factura")
    protected String factura;
    @XmlElement(name = "Fecha")
    protected String fecha;
    @XmlElement(name = "Proveedor")
    protected String proveedor;
    @XmlElement(name = "Emisora")
    protected String emisora;
    @XmlElement(name = "ClienteSociedad")
    protected String clienteSociedad;
    @XmlElement(name = "Cliente")
    protected String cliente;
    @XmlElement(name = "Orden")
    protected String orden;
    @XmlElement(name = "EmpresaDistribuido")
    protected String empresaDistribuido;
    @XmlElement(name = "CClienteDistribuido")
    protected String cClienteDistribuido;
    @XmlElement(name = "Importe")
    protected double importe;
    @XmlElement(name = "Unidades")
    protected String unidades;
    @XmlElement(name = "Tarifa")
    protected String tarifa;
    @XmlElement(name = "Proyecto")
    protected int proyecto;
    @XmlElement(name = "Empleado")
    protected String empleado;
    @XmlElement(name = "Observaciones")
    protected String observaciones;
    @XmlElement(name = "Concepto")
    protected String concepto;
    @XmlElement(name = "DocumentoSAP")
    protected String documentoSAP;
    @XmlElement(name = "CiaCliente")
    protected String ciaCliente;

    /**
     * Gets the value of the servicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicio() {
        return servicio;
    }

    /**
     * Sets the value of the servicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicio(String value) {
        this.servicio = value;
    }

    /**
     * Gets the value of the factura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactura() {
        return factura;
    }

    /**
     * Sets the value of the factura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactura(String value) {
        this.factura = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the proveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Sets the value of the proveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProveedor(String value) {
        this.proveedor = value;
    }

    /**
     * Gets the value of the emisora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmisora() {
        return emisora;
    }

    /**
     * Sets the value of the emisora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmisora(String value) {
        this.emisora = value;
    }

    /**
     * Gets the value of the clienteSociedad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteSociedad() {
        return clienteSociedad;
    }

    /**
     * Sets the value of the clienteSociedad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteSociedad(String value) {
        this.clienteSociedad = value;
    }

    /**
     * Gets the value of the cliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Sets the value of the cliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCliente(String value) {
        this.cliente = value;
    }

    /**
     * Gets the value of the orden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrden() {
        return orden;
    }

    /**
     * Sets the value of the orden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrden(String value) {
        this.orden = value;
    }

    /**
     * Gets the value of the empresaDistribuido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpresaDistribuido() {
        return empresaDistribuido;
    }

    /**
     * Sets the value of the empresaDistribuido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpresaDistribuido(String value) {
        this.empresaDistribuido = value;
    }

    /**
     * Gets the value of the cClienteDistribuido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCClienteDistribuido() {
        return cClienteDistribuido;
    }

    /**
     * Sets the value of the cClienteDistribuido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCClienteDistribuido(String value) {
        this.cClienteDistribuido = value;
    }

    /**
     * Gets the value of the importe property.
     * 
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Sets the value of the importe property.
     * 
     */
    public void setImporte(double value) {
        this.importe = value;
    }

    /**
     * Gets the value of the unidades property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidades() {
        return unidades;
    }

    /**
     * Sets the value of the unidades property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidades(String value) {
        this.unidades = value;
    }

    /**
     * Gets the value of the tarifa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarifa() {
        return tarifa;
    }

    /**
     * Sets the value of the tarifa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarifa(String value) {
        this.tarifa = value;
    }

    /**
     * Gets the value of the proyecto property.
     * 
     */
    public int getProyecto() {
        return proyecto;
    }

    /**
     * Sets the value of the proyecto property.
     * 
     */
    public void setProyecto(int value) {
        this.proyecto = value;
    }

    /**
     * Gets the value of the empleado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpleado() {
        return empleado;
    }

    /**
     * Sets the value of the empleado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpleado(String value) {
        this.empleado = value;
    }

    /**
     * Gets the value of the observaciones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Sets the value of the observaciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

    /**
     * Gets the value of the concepto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Sets the value of the concepto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConcepto(String value) {
        this.concepto = value;
    }

    /**
     * Gets the value of the documentoSAP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoSAP() {
        return documentoSAP;
    }

    /**
     * Sets the value of the documentoSAP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoSAP(String value) {
        this.documentoSAP = value;
    }

    /**
     * Gets the value of the ciaCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiaCliente() {
        return ciaCliente;
    }

    /**
     * Sets the value of the ciaCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiaCliente(String value) {
        this.ciaCliente = value;
    }

}
