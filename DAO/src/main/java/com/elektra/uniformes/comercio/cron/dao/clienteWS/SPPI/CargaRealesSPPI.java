
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClaveUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdSistemaSatelital" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClaveCentroProvedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClaveServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClaveSociedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Concepto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Moneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaInicial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaFinal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImporteTotal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="DetalleCarga" type="{http://tempuri.org/}ArrayOfDetalleCargaRe" minOccurs="0"/>
 *         &lt;element name="Carga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErroresCarga" type="{http://tempuri.org/}ArrayOfErroresCargaRe" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "claveUsuario",
    "idSistemaSatelital",
    "claveCentroProvedor",
    "claveServicio",
    "claveSociedad",
    "descripcion",
    "concepto",
    "moneda",
    "fechaInicial",
    "fechaFinal",
    "importeTotal",
    "detalleCarga",
    "carga",
    "erroresCarga"
})
@XmlRootElement(name = "CargaRealesSPPI")
public class CargaRealesSPPI {

    @XmlElement(name = "ClaveUsuario")
    protected String claveUsuario;
    @XmlElement(name = "IdSistemaSatelital")
    protected int idSistemaSatelital;
    @XmlElement(name = "ClaveCentroProvedor")
    protected String claveCentroProvedor;
    @XmlElement(name = "ClaveServicio")
    protected String claveServicio;
    @XmlElement(name = "ClaveSociedad")
    protected String claveSociedad;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "Concepto")
    protected int concepto;
    @XmlElement(name = "Moneda")
    protected String moneda;
    @XmlElement(name = "FechaInicial")
    protected String fechaInicial;
    @XmlElement(name = "FechaFinal")
    protected String fechaFinal;
    @XmlElement(name = "ImporteTotal")
    protected double importeTotal;
    @XmlElement(name = "DetalleCarga")
    protected ArrayOfDetalleCargaRe detalleCarga;
    @XmlElement(name = "Carga")
    protected String carga;
    @XmlElement(name = "ErroresCarga")
    protected ArrayOfErroresCargaRe erroresCarga;

    /**
     * Gets the value of the claveUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveUsuario() {
        return claveUsuario;
    }

    /**
     * Sets the value of the claveUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveUsuario(String value) {
        this.claveUsuario = value;
    }

    /**
     * Gets the value of the idSistemaSatelital property.
     * 
     */
    public int getIdSistemaSatelital() {
        return idSistemaSatelital;
    }

    /**
     * Sets the value of the idSistemaSatelital property.
     * 
     */
    public void setIdSistemaSatelital(int value) {
        this.idSistemaSatelital = value;
    }

    /**
     * Gets the value of the claveCentroProvedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveCentroProvedor() {
        return claveCentroProvedor;
    }

    /**
     * Sets the value of the claveCentroProvedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveCentroProvedor(String value) {
        this.claveCentroProvedor = value;
    }

    /**
     * Gets the value of the claveServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveServicio() {
        return claveServicio;
    }

    /**
     * Sets the value of the claveServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveServicio(String value) {
        this.claveServicio = value;
    }

    /**
     * Gets the value of the claveSociedad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveSociedad() {
        return claveSociedad;
    }

    /**
     * Sets the value of the claveSociedad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveSociedad(String value) {
        this.claveSociedad = value;
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
     * Gets the value of the concepto property.
     * 
     */
    public int getConcepto() {
        return concepto;
    }

    /**
     * Sets the value of the concepto property.
     * 
     */
    public void setConcepto(int value) {
        this.concepto = value;
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
     * Gets the value of the fechaInicial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInicial() {
        return fechaInicial;
    }

    /**
     * Sets the value of the fechaInicial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInicial(String value) {
        this.fechaInicial = value;
    }

    /**
     * Gets the value of the fechaFinal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Sets the value of the fechaFinal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFinal(String value) {
        this.fechaFinal = value;
    }

    /**
     * Gets the value of the importeTotal property.
     * 
     */
    public double getImporteTotal() {
        return importeTotal;
    }

    /**
     * Sets the value of the importeTotal property.
     * 
     */
    public void setImporteTotal(double value) {
        this.importeTotal = value;
    }

    /**
     * Gets the value of the detalleCarga property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleCargaRe }
     *     
     */
    public ArrayOfDetalleCargaRe getDetalleCarga() {
        return detalleCarga;
    }

    /**
     * Sets the value of the detalleCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleCargaRe }
     *     
     */
    public void setDetalleCarga(ArrayOfDetalleCargaRe value) {
        this.detalleCarga = value;
    }

    /**
     * Gets the value of the carga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarga() {
        return carga;
    }

    /**
     * Sets the value of the carga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarga(String value) {
        this.carga = value;
    }

    /**
     * Gets the value of the erroresCarga property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfErroresCargaRe }
     *     
     */
    public ArrayOfErroresCargaRe getErroresCarga() {
        return erroresCarga;
    }

    /**
     * Sets the value of the erroresCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfErroresCargaRe }
     *     
     */
    public void setErroresCarga(ArrayOfErroresCargaRe value) {
        this.erroresCarga = value;
    }

}
