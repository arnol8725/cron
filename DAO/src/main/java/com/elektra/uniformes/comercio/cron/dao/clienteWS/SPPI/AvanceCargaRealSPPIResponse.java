
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
 *         &lt;element name="AvanceCargaRealSPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="AvanceCargaRealSPPI" type="{http://tempuri.org/}ArrayOfAvanceCargaReal" minOccurs="0"/>
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
    "avanceCargaRealSPPIResult",
    "avanceCargaRealSPPI"
})
@XmlRootElement(name = "AvanceCargaRealSPPIResponse")
public class AvanceCargaRealSPPIResponse {

    @XmlElement(name = "AvanceCargaRealSPPIResult")
    protected Object avanceCargaRealSPPIResult;
    @XmlElement(name = "AvanceCargaRealSPPI")
    protected ArrayOfAvanceCargaReal avanceCargaRealSPPI;

    /**
     * Gets the value of the avanceCargaRealSPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAvanceCargaRealSPPIResult() {
        return avanceCargaRealSPPIResult;
    }

    /**
     * Sets the value of the avanceCargaRealSPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAvanceCargaRealSPPIResult(Object value) {
        this.avanceCargaRealSPPIResult = value;
    }

    /**
     * Gets the value of the avanceCargaRealSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAvanceCargaReal }
     *     
     */
    public ArrayOfAvanceCargaReal getAvanceCargaRealSPPI() {
        return avanceCargaRealSPPI;
    }

    /**
     * Sets the value of the avanceCargaRealSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAvanceCargaReal }
     *     
     */
    public void setAvanceCargaRealSPPI(ArrayOfAvanceCargaReal value) {
        this.avanceCargaRealSPPI = value;
    }

}
