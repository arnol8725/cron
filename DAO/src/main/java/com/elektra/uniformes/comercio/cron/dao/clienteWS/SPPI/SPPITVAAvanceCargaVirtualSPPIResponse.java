
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
 *         &lt;element name="SPPITVAAvanceCargaVirtualSPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="AvanceCargaVirtualSPPI" type="{http://tempuri.org/}ArrayOfAvanceCargaVirtual" minOccurs="0"/>
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
    "sppitvaAvanceCargaVirtualSPPIResult",
    "avanceCargaVirtualSPPI"
})
@XmlRootElement(name = "SPPITVAAvanceCargaVirtualSPPIResponse")
public class SPPITVAAvanceCargaVirtualSPPIResponse {

    @XmlElement(name = "SPPITVAAvanceCargaVirtualSPPIResult")
    protected Object sppitvaAvanceCargaVirtualSPPIResult;
    @XmlElement(name = "AvanceCargaVirtualSPPI")
    protected ArrayOfAvanceCargaVirtual avanceCargaVirtualSPPI;

    /**
     * Gets the value of the sppitvaAvanceCargaVirtualSPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSPPITVAAvanceCargaVirtualSPPIResult() {
        return sppitvaAvanceCargaVirtualSPPIResult;
    }

    /**
     * Sets the value of the sppitvaAvanceCargaVirtualSPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSPPITVAAvanceCargaVirtualSPPIResult(Object value) {
        this.sppitvaAvanceCargaVirtualSPPIResult = value;
    }

    /**
     * Gets the value of the avanceCargaVirtualSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAvanceCargaVirtual }
     *     
     */
    public ArrayOfAvanceCargaVirtual getAvanceCargaVirtualSPPI() {
        return avanceCargaVirtualSPPI;
    }

    /**
     * Sets the value of the avanceCargaVirtualSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAvanceCargaVirtual }
     *     
     */
    public void setAvanceCargaVirtualSPPI(ArrayOfAvanceCargaVirtual value) {
        this.avanceCargaVirtualSPPI = value;
    }

}
