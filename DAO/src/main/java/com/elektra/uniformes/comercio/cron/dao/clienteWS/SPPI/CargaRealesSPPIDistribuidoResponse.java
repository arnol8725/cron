
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
 *         &lt;element name="CargaRealesSPPIDistribuidoResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Carga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErroresCarga" type="{http://tempuri.org/}ArrayOfErroresCargaReDistribuido" minOccurs="0"/>
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
    "cargaRealesSPPIDistribuidoResult",
    "carga",
    "erroresCarga"
})
@XmlRootElement(name = "CargaRealesSPPIDistribuidoResponse")
public class CargaRealesSPPIDistribuidoResponse {

    @XmlElement(name = "CargaRealesSPPIDistribuidoResult")
    protected Object cargaRealesSPPIDistribuidoResult;
    @XmlElement(name = "Carga")
    protected String carga;
    @XmlElement(name = "ErroresCarga")
    protected ArrayOfErroresCargaReDistribuido erroresCarga;

    /**
     * Gets the value of the cargaRealesSPPIDistribuidoResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCargaRealesSPPIDistribuidoResult() {
        return cargaRealesSPPIDistribuidoResult;
    }

    /**
     * Sets the value of the cargaRealesSPPIDistribuidoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCargaRealesSPPIDistribuidoResult(Object value) {
        this.cargaRealesSPPIDistribuidoResult = value;
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
     *     {@link ArrayOfErroresCargaReDistribuido }
     *     
     */
    public ArrayOfErroresCargaReDistribuido getErroresCarga() {
        return erroresCarga;
    }

    /**
     * Sets the value of the erroresCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfErroresCargaReDistribuido }
     *     
     */
    public void setErroresCarga(ArrayOfErroresCargaReDistribuido value) {
        this.erroresCarga = value;
    }

}
