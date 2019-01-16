
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
 *         &lt;element name="DetalleDisponibleSPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="msgerror" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DetalleDisponible" type="{http://tempuri.org/}ArrayOfDetalleDisponible" minOccurs="0"/>
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
    "detalleDisponibleSPPIResult",
    "msgerror",
    "detalleDisponible"
})
@XmlRootElement(name = "DetalleDisponibleSPPIResponse")
public class DetalleDisponibleSPPIResponse {

    @XmlElement(name = "DetalleDisponibleSPPIResult")
    protected Object detalleDisponibleSPPIResult;
    protected String msgerror;
    @XmlElement(name = "DetalleDisponible")
    protected ArrayOfDetalleDisponible detalleDisponible;

    /**
     * Gets the value of the detalleDisponibleSPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDetalleDisponibleSPPIResult() {
        return detalleDisponibleSPPIResult;
    }

    /**
     * Sets the value of the detalleDisponibleSPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDetalleDisponibleSPPIResult(Object value) {
        this.detalleDisponibleSPPIResult = value;
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
     * Gets the value of the detalleDisponible property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleDisponible }
     *     
     */
    public ArrayOfDetalleDisponible getDetalleDisponible() {
        return detalleDisponible;
    }

    /**
     * Sets the value of the detalleDisponible property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleDisponible }
     *     
     */
    public void setDetalleDisponible(ArrayOfDetalleDisponible value) {
        this.detalleDisponible = value;
    }

}
