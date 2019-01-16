
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="DetalleCarga" type="{http://conectorunico/schemas}cargaVirtual" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Token" use="required" type="{http://conectorunico/schemas}t_Token" />
 *       &lt;attribute name="TipoCarga" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;totalDigits value="1"/>
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "detalleCarga"
})
@XmlRootElement(name = "cargaVirtualesRequest")
public class CargaVirtualesRequest {

    @XmlElement(name = "DetalleCarga", required = true)
    protected List<CargaVirtual> detalleCarga;
    @XmlAttribute(name = "Token", required = true)
    protected String token;
    @XmlAttribute(name = "TipoCarga", required = true)
    protected int tipoCarga;

    /**
     * Gets the value of the detalleCarga property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleCarga property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleCarga().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CargaVirtual }
     * 
     * 
     */
    public List<CargaVirtual> getDetalleCarga() {
        if (detalleCarga == null) {
            detalleCarga = new ArrayList<CargaVirtual>();
        }
        return this.detalleCarga;
    }

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
     * Gets the value of the tipoCarga property.
     * 
     */
    public int getTipoCarga() {
        return tipoCarga;
    }

    /**
     * Sets the value of the tipoCarga property.
     * 
     */
    public void setTipoCarga(int value) {
        this.tipoCarga = value;
    }

}
