
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for detalleCargaReal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detalleCargaReal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CentroProveedor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Servicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Compania" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CentroCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Proyecto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MontoCantidad" type="{http://conectorunico/schemas}t_Importe"/>
 *         &lt;element name="UnidadNegocio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NumEmpleado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Orden" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Moneda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EstatusCarga" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Factura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmpresaIntercompania" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CentroIntercompania" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleCargaReal", propOrder = {
    "centroProveedor",
    "servicio",
    "compania",
    "centroCliente",
    "descripcion",
    "proyecto",
    "montoCantidad",
    "unidadNegocio",
    "numEmpleado",
    "orden",
    "moneda",
    "estatusCarga",
    "observaciones",
    "factura",
    "empresaIntercompania",
    "centroIntercompania"
})
public class DetalleCargaReal {

    @XmlElement(name = "CentroProveedor", required = true)
    protected String centroProveedor;
    @XmlElement(name = "Servicio", required = true)
    protected String servicio;
    @XmlElement(name = "Compania")
    protected int compania;
    @XmlElement(name = "CentroCliente", required = true)
    protected String centroCliente;
    @XmlElement(name = "Descripcion", required = true)
    protected String descripcion;
    @XmlElement(name = "Proyecto")
    protected int proyecto;
    @XmlElement(name = "MontoCantidad", required = true)
    protected BigDecimal montoCantidad;
    @XmlElement(name = "UnidadNegocio")
    protected int unidadNegocio;
    @XmlElement(name = "NumEmpleado", required = true)
    protected String numEmpleado;
    @XmlElement(name = "Orden", required = true)
    protected String orden;
    @XmlElement(name = "Moneda", required = true)
    protected String moneda;
    @XmlElement(name = "EstatusCarga", required = true)
    protected String estatusCarga;
    @XmlElement(name = "Observaciones", required = true)
    protected String observaciones;
    @XmlElement(name = "Factura", required = true)
    protected String factura;
    @XmlElement(name = "EmpresaIntercompania", required = true)
    protected String empresaIntercompania;
    @XmlElement(name = "CentroIntercompania", required = true)
    protected String centroIntercompania;

    /**
     * Gets the value of the centroProveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroProveedor() {
        return centroProveedor;
    }

    /**
     * Sets the value of the centroProveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroProveedor(String value) {
        this.centroProveedor = value;
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
     * Gets the value of the centroCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroCliente() {
        return centroCliente;
    }

    /**
     * Sets the value of the centroCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroCliente(String value) {
        this.centroCliente = value;
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
     * Gets the value of the montoCantidad property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoCantidad() {
        return montoCantidad;
    }

    /**
     * Sets the value of the montoCantidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoCantidad(BigDecimal value) {
        this.montoCantidad = value;
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
     * Gets the value of the numEmpleado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumEmpleado() {
        return numEmpleado;
    }

    /**
     * Sets the value of the numEmpleado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumEmpleado(String value) {
        this.numEmpleado = value;
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
     * Gets the value of the estatusCarga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusCarga() {
        return estatusCarga;
    }

    /**
     * Sets the value of the estatusCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusCarga(String value) {
        this.estatusCarga = value;
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

    /**
     * Gets the value of the empresaIntercompania property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpresaIntercompania() {
        return empresaIntercompania;
    }

    /**
     * Sets the value of the empresaIntercompania property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpresaIntercompania(String value) {
        this.empresaIntercompania = value;
    }

    /**
     * Gets the value of the centroIntercompania property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroIntercompania() {
        return centroIntercompania;
    }

    /**
     * Sets the value of the centroIntercompania property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroIntercompania(String value) {
        this.centroIntercompania = value;
    }

}
