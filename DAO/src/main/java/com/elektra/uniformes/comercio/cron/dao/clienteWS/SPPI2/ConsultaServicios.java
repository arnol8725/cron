
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaServicios complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultaServicios">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CentroCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TipoServicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Servicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NaturalezaServicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tarifa" type="{http://conectorunico/schemas}t_Importe"/>
 *         &lt;element name="Moneda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaServicios", propOrder = {
    "centroCliente",
    "tipoServicio",
    "servicio",
    "naturalezaServicio",
    "tarifa",
    "moneda"
})
public class ConsultaServicios {

    @XmlElement(name = "CentroCliente", required = true)
    protected String centroCliente;
    @XmlElement(name = "TipoServicio", required = true)
    protected String tipoServicio;
    @XmlElement(name = "Servicio", required = true)
    protected String servicio;
    @XmlElement(name = "NaturalezaServicio", required = true)
    protected String naturalezaServicio;
    @XmlElement(name = "Tarifa", required = true)
    protected BigDecimal tarifa;
    @XmlElement(name = "Moneda", required = true)
    protected String moneda;

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
     * Gets the value of the tipoServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Sets the value of the tipoServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoServicio(String value) {
        this.tipoServicio = value;
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
     * Gets the value of the naturalezaServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaturalezaServicio() {
        return naturalezaServicio;
    }

    /**
     * Sets the value of the naturalezaServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaturalezaServicio(String value) {
        this.naturalezaServicio = value;
    }

    /**
     * Gets the value of the tarifa property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTarifa() {
        return tarifa;
    }

    /**
     * Sets the value of the tarifa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTarifa(BigDecimal value) {
        this.tarifa = value;
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

}
