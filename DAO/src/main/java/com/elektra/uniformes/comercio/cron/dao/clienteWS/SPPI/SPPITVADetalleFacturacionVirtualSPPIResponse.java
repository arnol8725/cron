
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
 *         &lt;element name="SPPITVADetalleFacturacionVirtualSPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="msgerror" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DetalleCargaVirtualSPPI" type="{http://tempuri.org/}ArrayOfDetalleVirtualFacturacion" minOccurs="0"/>
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
    "sppitvaDetalleFacturacionVirtualSPPIResult",
    "msgerror",
    "detalleCargaVirtualSPPI"
})
@XmlRootElement(name = "SPPITVADetalleFacturacionVirtualSPPIResponse")
public class SPPITVADetalleFacturacionVirtualSPPIResponse {

    @XmlElement(name = "SPPITVADetalleFacturacionVirtualSPPIResult")
    protected Object sppitvaDetalleFacturacionVirtualSPPIResult;
    protected String msgerror;
    @XmlElement(name = "DetalleCargaVirtualSPPI")
    protected ArrayOfDetalleVirtualFacturacion detalleCargaVirtualSPPI;

    /**
     * Gets the value of the sppitvaDetalleFacturacionVirtualSPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSPPITVADetalleFacturacionVirtualSPPIResult() {
        return sppitvaDetalleFacturacionVirtualSPPIResult;
    }

    /**
     * Sets the value of the sppitvaDetalleFacturacionVirtualSPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSPPITVADetalleFacturacionVirtualSPPIResult(Object value) {
        this.sppitvaDetalleFacturacionVirtualSPPIResult = value;
    }

    /**
     * Gets the value of the msgerror property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgerror() {
        return msgerror;
    }

    /**
     * Sets the value of the msgerror property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgerror(String value) {
        this.msgerror = value;
    }

    /**
     * Gets the value of the detalleCargaVirtualSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleVirtualFacturacion }
     *     
     */
    public ArrayOfDetalleVirtualFacturacion getDetalleCargaVirtualSPPI() {
        return detalleCargaVirtualSPPI;
    }

    /**
     * Sets the value of the detalleCargaVirtualSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleVirtualFacturacion }
     *     
     */
    public void setDetalleCargaVirtualSPPI(ArrayOfDetalleVirtualFacturacion value) {
        this.detalleCargaVirtualSPPI = value;
    }

}
