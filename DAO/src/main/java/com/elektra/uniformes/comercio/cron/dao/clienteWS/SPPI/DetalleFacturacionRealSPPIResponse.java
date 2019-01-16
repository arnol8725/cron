
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
 *         &lt;element name="DetalleFacturacionRealSPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="msgerror" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DetalleCargaRealSPPI" type="{http://tempuri.org/}ArrayOfDetalleRealFacturacion" minOccurs="0"/>
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
    "detalleFacturacionRealSPPIResult",
    "msgerror",
    "detalleCargaRealSPPI"
})
@XmlRootElement(name = "DetalleFacturacionRealSPPIResponse")
public class DetalleFacturacionRealSPPIResponse {

    @XmlElement(name = "DetalleFacturacionRealSPPIResult")
    protected Object detalleFacturacionRealSPPIResult;
    protected String msgerror;
    @XmlElement(name = "DetalleCargaRealSPPI")
    protected ArrayOfDetalleRealFacturacion detalleCargaRealSPPI;

    /**
     * Gets the value of the detalleFacturacionRealSPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDetalleFacturacionRealSPPIResult() {
        return detalleFacturacionRealSPPIResult;
    }

    /**
     * Sets the value of the detalleFacturacionRealSPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDetalleFacturacionRealSPPIResult(Object value) {
        this.detalleFacturacionRealSPPIResult = value;
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
     * Gets the value of the detalleCargaRealSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleRealFacturacion }
     *     
     */
    public ArrayOfDetalleRealFacturacion getDetalleCargaRealSPPI() {
        return detalleCargaRealSPPI;
    }

    /**
     * Sets the value of the detalleCargaRealSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleRealFacturacion }
     *     
     */
    public void setDetalleCargaRealSPPI(ArrayOfDetalleRealFacturacion value) {
        this.detalleCargaRealSPPI = value;
    }

}
