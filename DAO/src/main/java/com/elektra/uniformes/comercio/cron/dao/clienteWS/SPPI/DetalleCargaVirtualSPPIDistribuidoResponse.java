
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
 *         &lt;element name="DetalleCargaVirtualSPPIDistribuidoResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
    "detalleCargaVirtualSPPIDistribuidoResult",
    "detalleCargaVirtualSPPI"
})
@XmlRootElement(name = "DetalleCargaVirtualSPPIDistribuidoResponse")
public class DetalleCargaVirtualSPPIDistribuidoResponse {

    @XmlElement(name = "DetalleCargaVirtualSPPIDistribuidoResult")
    protected Object detalleCargaVirtualSPPIDistribuidoResult;
    @XmlElement(name = "DetalleCargaVirtualSPPI")
    protected ArrayOfDetalleCargaVirtualDistribuido detalleCargaVirtualSPPI;

    /**
     * Gets the value of the detalleCargaVirtualSPPIDistribuidoResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDetalleCargaVirtualSPPIDistribuidoResult() {
        return detalleCargaVirtualSPPIDistribuidoResult;
    }

    /**
     * Sets the value of the detalleCargaVirtualSPPIDistribuidoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDetalleCargaVirtualSPPIDistribuidoResult(Object value) {
        this.detalleCargaVirtualSPPIDistribuidoResult = value;
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
