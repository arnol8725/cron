
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CatalogoServicio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CatalogoServicio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DescripcionServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoServicio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NaturalezaServicio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Tarifa" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Moneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogoServicio", propOrder = {
    "cProveedor",
    "servicio",
    "descripcionServicio",
    "tipoServicio",
    "naturalezaServicio",
    "tarifa",
    "moneda"
})
public class CatalogoServicio {

    @XmlElement(name = "CProveedor")
    protected String cProveedor;
    @XmlElement(name = "Servicio")
    protected String servicio;
    @XmlElement(name = "DescripcionServicio")
    protected String descripcionServicio;
    @XmlElement(name = "TipoServicio")
    protected int tipoServicio;
    @XmlElement(name = "NaturalezaServicio")
    protected int naturalezaServicio;
    @XmlElement(name = "Tarifa")
    protected double tarifa;
    @XmlElement(name = "Moneda")
    protected String moneda;

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
     * Gets the value of the descripcionServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    /**
     * Sets the value of the descripcionServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionServicio(String value) {
        this.descripcionServicio = value;
    }

    /**
     * Gets the value of the tipoServicio property.
     * 
     */
    public int getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Sets the value of the tipoServicio property.
     * 
     */
    public void setTipoServicio(int value) {
        this.tipoServicio = value;
    }

    /**
     * Gets the value of the naturalezaServicio property.
     * 
     */
    public int getNaturalezaServicio() {
        return naturalezaServicio;
    }

    /**
     * Sets the value of the naturalezaServicio property.
     * 
     */
    public void setNaturalezaServicio(int value) {
        this.naturalezaServicio = value;
    }

    /**
     * Gets the value of the tarifa property.
     * 
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Sets the value of the tarifa property.
     * 
     */
    public void setTarifa(double value) {
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
