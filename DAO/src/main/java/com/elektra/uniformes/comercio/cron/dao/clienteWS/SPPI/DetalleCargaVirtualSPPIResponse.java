
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
 *         &lt;element name="DetalleCargaVirtualSPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="DetalleCargaVirtualSPPI" type="{http://tempuri.org/}ArrayOfDetalleCargaVirtual" minOccurs="0"/>
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
    "detalleCargaVirtualSPPIResult",
    "detalleCargaVirtualSPPI"
})
@XmlRootElement(name = "DetalleCargaVirtualSPPIResponse")
public class DetalleCargaVirtualSPPIResponse {

    @XmlElement(name = "DetalleCargaVirtualSPPIResult")
    protected Object detalleCargaVirtualSPPIResult;
    @XmlElement(name = "DetalleCargaVirtualSPPI")
    protected ArrayOfDetalleCargaVirtual detalleCargaVirtualSPPI;

    /**
     * Gets the value of the detalleCargaVirtualSPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDetalleCargaVirtualSPPIResult() {
        return detalleCargaVirtualSPPIResult;
    }

    /**
     * Sets the value of the detalleCargaVirtualSPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDetalleCargaVirtualSPPIResult(Object value) {
        this.detalleCargaVirtualSPPIResult = value;
    }

    /**
     * Gets the value of the detalleCargaVirtualSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleCargaVirtual }
     *     
     */
    public ArrayOfDetalleCargaVirtual getDetalleCargaVirtualSPPI() {
        return detalleCargaVirtualSPPI;
    }

    /**
     * Sets the value of the detalleCargaVirtualSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleCargaVirtual }
     *     
     */
    public void setDetalleCargaVirtualSPPI(ArrayOfDetalleCargaVirtual value) {
        this.detalleCargaVirtualSPPI = value;
    }

}
