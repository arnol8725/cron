
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
 *         &lt;element name="CargaRealesSPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
    "cargaRealesSPPIResult",
    "carga",
    "erroresCarga"
})
@XmlRootElement(name = "CargaRealesSPPIResponse")
public class CargaRealesSPPIResponse {

    @XmlElement(name = "CargaRealesSPPIResult")
    protected Object cargaRealesSPPIResult;
    @XmlElement(name = "Carga")
    protected String carga;
    @XmlElement(name = "ErroresCarga")
    protected ArrayOfErroresCargaRe erroresCarga;

    /**
     * Gets the value of the cargaRealesSPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCargaRealesSPPIResult() {
        return cargaRealesSPPIResult;
    }

    /**
     * Sets the value of the cargaRealesSPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCargaRealesSPPIResult(Object value) {
        this.cargaRealesSPPIResult = value;
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
