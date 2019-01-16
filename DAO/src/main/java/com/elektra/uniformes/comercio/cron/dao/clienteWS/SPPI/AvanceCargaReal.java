
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AvanceCargaReal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AvanceCargaReal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FolioCarga" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FechaCarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PorcentajeAvance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="FechaInicioCarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaFinCarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegistrosTotales" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RegistrosAceptados" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RegistrosRechazados" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Numdocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvanceCargaReal", propOrder = {
    "folioCarga",
    "fechaCarga",
    "usuario",
    "porcentajeAvance",
    "fechaInicioCarga",
    "fechaFinCarga",
    "registrosTotales",
    "registrosAceptados",
    "registrosRechazados",
    "numdocumento"
})
public class AvanceCargaReal {

    @XmlElement(name = "FolioCarga")
    protected int folioCarga;
    @XmlElement(name = "FechaCarga")
    protected String fechaCarga;
    @XmlElement(name = "Usuario")
    protected String usuario;
    @XmlElement(name = "PorcentajeAvance")
    protected double porcentajeAvance;
    @XmlElement(name = "FechaInicioCarga")
    protected String fechaInicioCarga;
    @XmlElement(name = "FechaFinCarga")
    protected String fechaFinCarga;
    @XmlElement(name = "RegistrosTotales")
    protected int registrosTotales;
    @XmlElement(name = "RegistrosAceptados")
    protected int registrosAceptados;
    @XmlElement(name = "RegistrosRechazados")
    protected int registrosRechazados;
    @XmlElement(name = "Numdocumento")
    protected String numdocumento;

    /**
     * Gets the value of the folioCarga property.
     * 
     */
    public int getFolioCarga() {
        return folioCarga;
    }

    /**
     * Sets the value of the folioCarga property.
     * 
     */
    public void setFolioCarga(int value) {
        this.folioCarga = value;
    }

    /**
     * Gets the value of the fechaCarga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCarga() {
        return fechaCarga;
    }

    /**
     * Sets the value of the fechaCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCarga(String value) {
        this.fechaCarga = value;
    }

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Gets the value of the porcentajeAvance property.
     * 
     */
    public double getPorcentajeAvance() {
        return porcentajeAvance;
    }

    /**
     * Sets the value of the porcentajeAvance property.
     * 
     */
    public void setPorcentajeAvance(double value) {
        this.porcentajeAvance = value;
    }

    /**
     * Gets the value of the fechaInicioCarga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInicioCarga() {
        return fechaInicioCarga;
    }

    /**
     * Sets the value of the fechaInicioCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInicioCarga(String value) {
        this.fechaInicioCarga = value;
    }

    /**
     * Gets the value of the fechaFinCarga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFinCarga() {
        return fechaFinCarga;
    }

    /**
     * Sets the value of the fechaFinCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFinCarga(String value) {
        this.fechaFinCarga = value;
    }

    /**
     * Gets the value of the registrosTotales property.
     * 
     */
    public int getRegistrosTotales() {
        return registrosTotales;
    }

    /**
     * Sets the value of the registrosTotales property.
     * 
     */
    public void setRegistrosTotales(int value) {
        this.registrosTotales = value;
    }

    /**
     * Gets the value of the registrosAceptados property.
     * 
     */
    public int getRegistrosAceptados() {
        return registrosAceptados;
    }

    /**
     * Sets the value of the registrosAceptados property.
     * 
     */
    public void setRegistrosAceptados(int value) {
        this.registrosAceptados = value;
    }

    /**
     * Gets the value of the registrosRechazados property.
     * 
     */
    public int getRegistrosRechazados() {
        return registrosRechazados;
    }

    /**
     * Sets the value of the registrosRechazados property.
     * 
     */
    public void setRegistrosRechazados(int value) {
        this.registrosRechazados = value;
    }

    /**
     * Gets the value of the numdocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumdocumento() {
        return numdocumento;
    }

    /**
     * Sets the value of the numdocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumdocumento(String value) {
        this.numdocumento = value;
    }

}
