
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
 *         &lt;element name="DetalleCargaRealSPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="DetalleCargaRealSPPI" type="{http://tempuri.org/}ArrayOfDetalleCargaReal" minOccurs="0"/>
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
    "detalleCargaRealSPPIResult",
    "detalleCargaRealSPPI"
})
@XmlRootElement(name = "DetalleCargaRealSPPIResponse")
public class DetalleCargaRealSPPIResponse {

    @XmlElement(name = "DetalleCargaRealSPPIResult")
    protected Object detalleCargaRealSPPIResult;
    @XmlElement(name = "DetalleCargaRealSPPI")
    protected ArrayOfDetalleCargaReal detalleCargaRealSPPI;

    /**
     * Gets the value of the detalleCargaRealSPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDetalleCargaRealSPPIResult() {
        return detalleCargaRealSPPIResult;
    }

    /**
     * Sets the value of the detalleCargaRealSPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDetalleCargaRealSPPIResult(Object value) {
        this.detalleCargaRealSPPIResult = value;
    }

    /**
     * Gets the value of the detalleCargaRealSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleCargaReal }
     *     
     */
    public ArrayOfDetalleCargaReal getDetalleCargaRealSPPI() {
        return detalleCargaRealSPPI;
    }

    /**
     * Sets the value of the detalleCargaRealSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleCargaReal }
     *     
     */
    public void setDetalleCargaRealSPPI(ArrayOfDetalleCargaReal value) {
        this.detalleCargaRealSPPI = value;
    }

}
