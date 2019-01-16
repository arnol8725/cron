
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
 *         &lt;element name="CatalogoServiciosResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="CatalogoServicios" type="{http://tempuri.org/}ArrayOfCatalogoServicio" minOccurs="0"/>
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
    "catalogoServiciosResult",
    "catalogoServicios"
})
@XmlRootElement(name = "CatalogoServiciosResponse")
public class CatalogoServiciosResponse {

    @XmlElement(name = "CatalogoServiciosResult")
    protected Object catalogoServiciosResult;
    @XmlElement(name = "CatalogoServicios")
    protected ArrayOfCatalogoServicio catalogoServicios;

    /**
     * Gets the value of the catalogoServiciosResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCatalogoServiciosResult() {
        return catalogoServiciosResult;
    }

    /**
     * Sets the value of the catalogoServiciosResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCatalogoServiciosResult(Object value) {
        this.catalogoServiciosResult = value;
    }

    /**
     * Gets the value of the catalogoServicios property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCatalogoServicio }
     *     
     */
    public ArrayOfCatalogoServicio getCatalogoServicios() {
        return catalogoServicios;
    }

    /**
     * Sets the value of the catalogoServicios property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCatalogoServicio }
     *     
     */
    public void setCatalogoServicios(ArrayOfCatalogoServicio value) {
        this.catalogoServicios = value;
    }

}
