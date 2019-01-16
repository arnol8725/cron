
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
 *         &lt;element name="CargaVirtualesIUSASPPIResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
    "cargaVirtualesIUSASPPIResult"
})
@XmlRootElement(name = "CargaVirtualesIUSASPPIResponse")
public class CargaVirtualesIUSASPPIResponse {

    @XmlElement(name = "CargaVirtualesIUSASPPIResult")
    protected Object cargaVirtualesIUSASPPIResult;

    /**
     * Gets the value of the cargaVirtualesIUSASPPIResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCargaVirtualesIUSASPPIResult() {
        return cargaVirtualesIUSASPPIResult;
    }

    /**
     * Sets the value of the cargaVirtualesIUSASPPIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCargaVirtualesIUSASPPIResult(Object value) {
        this.cargaVirtualesIUSASPPIResult = value;
    }

}
