
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
 *         &lt;element name="ReEmpresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DetalleCarga" type="{http://tempuri.org/}ArrayOfDetalleVirtualIUSA" minOccurs="0"/>
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
    "reEmpresa",
    "reProveedor",
    "reArea",
    "reServicio",
    "detalleCarga"
})
@XmlRootElement(name = "CargaVirtualesIUSASPPI")
public class CargaVirtualesIUSASPPI {

    @XmlElement(name = "ReEmpresa")
    protected String reEmpresa;
    @XmlElement(name = "ReProveedor")
    protected String reProveedor;
    @XmlElement(name = "ReArea")
    protected String reArea;
    @XmlElement(name = "ReServicio")
    protected String reServicio;
    @XmlElement(name = "DetalleCarga")
    protected ArrayOfDetalleVirtualIUSA detalleCarga;

    /**
     * Gets the value of the reEmpresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReEmpresa() {
        return reEmpresa;
    }

    /**
     * Sets the value of the reEmpresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReEmpresa(String value) {
        this.reEmpresa = value;
    }

    /**
     * Gets the value of the reProveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReProveedor() {
        return reProveedor;
    }

    /**
     * Sets the value of the reProveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReProveedor(String value) {
        this.reProveedor = value;
    }

    /**
     * Gets the value of the reArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReArea() {
        return reArea;
    }

    /**
     * Sets the value of the reArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReArea(String value) {
        this.reArea = value;
    }

    /**
     * Gets the value of the reServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReServicio() {
        return reServicio;
    }

    /**
     * Sets the value of the reServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReServicio(String value) {
        this.reServicio = value;
    }

    /**
     * Gets the value of the detalleCarga property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleVirtualIUSA }
     *     
     */
    public ArrayOfDetalleVirtualIUSA getDetalleCarga() {
        return detalleCarga;
    }

    /**
     * Sets the value of the detalleCarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleVirtualIUSA }
     *     
     */
    public void setDetalleCarga(ArrayOfDetalleVirtualIUSA value) {
        this.detalleCarga = value;
    }

}
