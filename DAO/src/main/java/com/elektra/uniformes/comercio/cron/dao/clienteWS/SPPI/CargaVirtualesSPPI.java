
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
 *         &lt;element name="DetalleCarga" type="{http://tempuri.org/}ArrayOfDetalleCargaVi" minOccurs="0"/>
 *         &lt;element name="TipoCarga" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Carga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErroresCarga" type="{http://tempuri.org/}ArrayOfErroresCargaVi" minOccurs="0"/>
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
    "detalleCarga",
    "tipoCarga",
    "carga",
    "erroresCarga"
})
@XmlRootElement(name = "CargaVirtualesSPPI")
public class CargaVirtualesSPPI {

    @XmlElement(name = "ClaveUsuario")
    protected String claveUsuario;
    @XmlElement(name = "IdSistemaSatelital")
    protected int idSistemaSatelital;
    @XmlElement(name = "DetalleCarga")
    protected ArrayOfDetalleCargaVi detalleCarga;
    @XmlElement(name = "TipoCarga")
    protected int tipoCarga;
    @XmlElement(name = "Carga")
    protected String carga;
    @XmlElement(name = "ErroresCarga")
    protected ArrayOfErroresCargaVi erroresCarga;

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
     * Gets the value of the detalleCarga property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleCargaVi }
     *     
     */
    public ArrayOfDetalleCargaVi getDetalleCarga() {
        return detalleCarga;
    }

    /**
     * Sets the value of the detalleCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleCargaVi }
     *     
     */
    public void setDetalleCarga(ArrayOfDetalleCargaVi value) {
        this.detalleCarga = value;
    }

    /**
     * Gets the value of the tipoCarga property.
     * 
     */
    public int getTipoCarga() {
        return tipoCarga;
    }

    /**
     * Sets the value of the tipoCarga property.
     * 
     */
    public void setTipoCarga(int value) {
        this.tipoCarga = value;
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
     *     {@link ArrayOfErroresCargaVi }
     *     
     */
    public ArrayOfErroresCargaVi getErroresCarga() {
        return erroresCarga;
    }

    /**
     * Sets the value of the erroresCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfErroresCargaVi }
     *     
     */
    public void setErroresCarga(ArrayOfErroresCargaVi value) {
        this.erroresCarga = value;
    }

}
