
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for avanceCargaVirtual complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="avanceCargaVirtual">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FolioCarga" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FechaCarga" type="{http://conectorunico/schemas}t_FormatoFecha"/>
 *         &lt;element name="Usuario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PorcentajeAvance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FechaInicioCarga" type="{http://conectorunico/schemas}t_FormatoFecha"/>
 *         &lt;element name="FechaFinCarga" type="{http://conectorunico/schemas}t_FormatoFecha"/>
 *         &lt;element name="RegistrosTotales" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RegistrosAceptados" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RegistrosRechazados" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EstatusCarga" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "avanceCargaVirtual", propOrder = {
    "folioCarga",
    "fechaCarga",
    "usuario",
    "porcentajeAvance",
    "fechaInicioCarga",
    "fechaFinCarga",
    "registrosTotales",
    "registrosAceptados",
    "registrosRechazados",
    "estatusCarga",
    "observaciones"
})
public class AvanceCargaVirtual {

    @XmlElement(name = "FolioCarga")
    protected int folioCarga;
    @XmlElement(name = "FechaCarga", required = true)
    protected String fechaCarga;
    @XmlElement(name = "Usuario", required = true)
    protected String usuario;
    @XmlElement(name = "PorcentajeAvance")
    protected int porcentajeAvance;
    @XmlElement(name = "FechaInicioCarga", required = true)
    protected String fechaInicioCarga;
    @XmlElement(name = "FechaFinCarga", required = true)
    protected String fechaFinCarga;
    @XmlElement(name = "RegistrosTotales")
    protected int registrosTotales;
    @XmlElement(name = "RegistrosAceptados")
    protected int registrosAceptados;
    @XmlElement(name = "RegistrosRechazados")
    protected int registrosRechazados;
    @XmlElement(name = "EstatusCarga", required = true)
    protected String estatusCarga;
    @XmlElement(name = "Observaciones", required = true)
    protected String observaciones;

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
    public int getPorcentajeAvance() {
        return porcentajeAvance;
    }

    /**
     * Sets the value of the porcentajeAvance property.
     * 
     */
    public void setPorcentajeAvance(int value) {
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

}
