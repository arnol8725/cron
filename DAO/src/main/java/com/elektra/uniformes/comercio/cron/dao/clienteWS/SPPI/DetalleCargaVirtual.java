
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DetalleCargaVirtual complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DetalleCargaVirtual">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Compania" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Proyecto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UnidadNegocio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MontoCantidad" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Moneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusCarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Factura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetalleCargaVirtual", propOrder = {
    "cProveedor",
    "servicio",
    "compania",
    "cCliente",
    "descripcion",
    "proyecto",
    "unidadNegocio",
    "montoCantidad",
    "moneda",
    "statusCarga",
    "observaciones",
    "factura"
})
public class DetalleCargaVirtual {

    @XmlElement(name = "CProveedor")
    protected String cProveedor;
    @XmlElement(name = "Servicio")
    protected String servicio;
    @XmlElement(name = "Compania")
    protected int compania;
    @XmlElement(name = "CCliente")
    protected String cCliente;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "Proyecto")
    protected int proyecto;
    @XmlElement(name = "UnidadNegocio")
    protected int unidadNegocio;
    @XmlElement(name = "MontoCantidad")
    protected double montoCantidad;
    @XmlElement(name = "Moneda")
    protected String moneda;
    @XmlElement(name = "StatusCarga")
    protected String statusCarga;
    @XmlElement(name = "Observaciones")
    protected String observaciones;
    @XmlElement(name = "Factura")
    protected String factura;

    /**
     * Gets the value of the cProveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCProveedor() {
        return cProveedor;
    }

    /**
     * Sets the value of the cProveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCProveedor(String value) {
        this.cProveedor = value;
    }

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
     * Gets the value of the compania property.
     * 
     */
    public int getCompania() {
        return compania;
    }

    /**
     * Sets the value of the compania property.
     * 
     */
    public void setCompania(int value) {
        this.compania = value;
    }

    /**
     * Gets the value of the cCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCliente() {
        return cCliente;
    }

    /**
     * Sets the value of the cCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCliente(String value) {
        this.cCliente = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
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
     * Gets the value of the unidadNegocio property.
     * 
     */
    public int getUnidadNegocio() {
        return unidadNegocio;
    }

    /**
     * Sets the value of the unidadNegocio property.
     * 
     */
    public void setUnidadNegocio(int value) {
        this.unidadNegocio = value;
    }

    /**
     * Gets the value of the montoCantidad property.
     * 
     */
    public double getMontoCantidad() {
        return montoCantidad;
    }

    /**
     * Sets the value of the montoCantidad property.
     * 
     */
    public void setMontoCantidad(double value) {
        this.montoCantidad = value;
    }

    /**
     * Gets the value of the moneda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Sets the value of the moneda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoneda(String value) {
        this.moneda = value;
    }

    /**
     * Gets the value of the statusCarga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCarga() {
        return statusCarga;
    }

    /**
     * Sets the value of the statusCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCarga(String value) {
        this.statusCarga = value;
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

}
