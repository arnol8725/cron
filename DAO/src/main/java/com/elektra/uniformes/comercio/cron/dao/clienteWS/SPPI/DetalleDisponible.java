
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DetalleDisponible complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DetalleDisponible">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClienteCia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnidadNegocios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Disponible" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Moneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Proyecto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PresupuestoPlan" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetalleDisponible", propOrder = {
    "clienteCia",
    "cliente",
    "unidadNegocios",
    "servicio",
    "disponible",
    "moneda",
    "proyecto",
    "presupuestoPlan"
})
public class DetalleDisponible {

    @XmlElement(name = "ClienteCia")
    protected String clienteCia;
    @XmlElement(name = "Cliente")
    protected String cliente;
    @XmlElement(name = "UnidadNegocios")
    protected String unidadNegocios;
    @XmlElement(name = "Servicio")
    protected String servicio;
    @XmlElement(name = "Disponible")
    protected double disponible;
    @XmlElement(name = "Moneda")
    protected String moneda;
    @XmlElement(name = "Proyecto")
    protected String proyecto;
    @XmlElement(name = "PresupuestoPlan")
    protected double presupuestoPlan;

    /**
     * Gets the value of the clienteCia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteCia() {
        return clienteCia;
    }

    /**
     * Sets the value of the clienteCia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteCia(String value) {
        this.clienteCia = value;
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
     * Gets the value of the unidadNegocios property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidadNegocios() {
        return unidadNegocios;
    }

    /**
     * Sets the value of the unidadNegocios property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidadNegocios(String value) {
        this.unidadNegocios = value;
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
     * Gets the value of the disponible property.
     * 
     */
    public double getDisponible() {
        return disponible;
    }

    /**
     * Sets the value of the disponible property.
     * 
     */
    public void setDisponible(double value) {
        this.disponible = value;
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
     * Gets the value of the proyecto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyecto() {
        return proyecto;
    }

    /**
     * Sets the value of the proyecto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyecto(String value) {
        this.proyecto = value;
    }

    /**
     * Gets the value of the presupuestoPlan property.
     * 
     */
    public double getPresupuestoPlan() {
        return presupuestoPlan;
    }

    /**
     * Sets the value of the presupuestoPlan property.
     * 
     */
    public void setPresupuestoPlan(double value) {
        this.presupuestoPlan = value;
    }

}
