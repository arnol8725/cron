
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="Token" use="required" type="{http://conectorunico/schemas}t_Token" />
 *       &lt;attribute name="FolioCarga" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "avanceCargaRealRequest")
public class AvanceCargaRealRequest {

    @XmlAttribute(name = "Token", required = true)
    protected String token;
    @XmlAttribute(name = "FolioCarga", required = true)
    protected int folioCarga;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the folioCarga property.
     * 
     */
    public int getFolioCarga() {
        return folioCarga;
    }

    /**
     * Sets the value of the folioCarga property.
     * 
     */
    public void setFolioCarga(int value) {
        this.folioCarga = value;
    }

}
