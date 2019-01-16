
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
 *         &lt;element name="SPPITVADetalleCargaVirtualSPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="DetalleCargaVirtualSPPI" type="{http://tempuri.org/}ArrayOfDetalleCargaVirtualDistribuido" minOccurs="0"/>
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
    "sppitvaDetalleCargaVirtualSPPIResult",
    "detalleCargaVirtualSPPI"
})
@XmlRootElement(name = "SPPITVADetalleCargaVirtualSPPIResponse")
public class SPPITVADetalleCargaVirtualSPPIResponse {

    @XmlElement(name = "SPPITVADetalleCargaVirtualSPPIResult")
    protected Object sppitvaDetalleCargaVirtualSPPIResult;
    @XmlElement(name = "DetalleCargaVirtualSPPI")
    protected ArrayOfDetalleCargaVirtualDistribuido detalleCargaVirtualSPPI;

    /**
     * Gets the value of the sppitvaDetalleCargaVirtualSPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSPPITVADetalleCargaVirtualSPPIResult() {
        return sppitvaDetalleCargaVirtualSPPIResult;
    }

    /**
     * Sets the value of the sppitvaDetalleCargaVirtualSPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSPPITVADetalleCargaVirtualSPPIResult(Object value) {
        this.sppitvaDetalleCargaVirtualSPPIResult = value;
    }

    /**
     * Gets the value of the detalleCargaVirtualSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleCargaVirtualDistribuido }
     *     
     */
    public ArrayOfDetalleCargaVirtualDistribuido getDetalleCargaVirtualSPPI() {
        return detalleCargaVirtualSPPI;
    }

    /**
     * Sets the value of the detalleCargaVirtualSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleCargaVirtualDistribuido }
     *     
     */
    public void setDetalleCargaVirtualSPPI(ArrayOfDetalleCargaVirtualDistribuido value) {
        this.detalleCargaVirtualSPPI = value;
    }

}
