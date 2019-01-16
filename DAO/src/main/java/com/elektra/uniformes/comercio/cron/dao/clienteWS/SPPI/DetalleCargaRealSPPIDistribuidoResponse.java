
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
 *         &lt;element name="DetalleCargaRealSPPIDistribuidoResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="DetalleCargaRealSPPI" type="{http://tempuri.org/}ArrayOfDetalleCargaRealDistribuido" minOccurs="0"/>
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
    "detalleCargaRealSPPIDistribuidoResult",
    "detalleCargaRealSPPI"
})
@XmlRootElement(name = "DetalleCargaRealSPPIDistribuidoResponse")
public class DetalleCargaRealSPPIDistribuidoResponse {

    @XmlElement(name = "DetalleCargaRealSPPIDistribuidoResult")
    protected Object detalleCargaRealSPPIDistribuidoResult;
    @XmlElement(name = "DetalleCargaRealSPPI")
    protected ArrayOfDetalleCargaRealDistribuido detalleCargaRealSPPI;

    /**
     * Gets the value of the detalleCargaRealSPPIDistribuidoResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDetalleCargaRealSPPIDistribuidoResult() {
        return detalleCargaRealSPPIDistribuidoResult;
    }

    /**
     * Sets the value of the detalleCargaRealSPPIDistribuidoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDetalleCargaRealSPPIDistribuidoResult(Object value) {
        this.detalleCargaRealSPPIDistribuidoResult = value;
    }

    /**
     * Gets the value of the detalleCargaRealSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleCargaRealDistribuido }
     *     
     */
    public ArrayOfDetalleCargaRealDistribuido getDetalleCargaRealSPPI() {
        return detalleCargaRealSPPI;
    }

    /**
     * Sets the value of the detalleCargaRealSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleCargaRealDistribuido }
     *     
     */
    public void setDetalleCargaRealSPPI(ArrayOfDetalleCargaRealDistribuido value) {
        this.detalleCargaRealSPPI = value;
    }

}
