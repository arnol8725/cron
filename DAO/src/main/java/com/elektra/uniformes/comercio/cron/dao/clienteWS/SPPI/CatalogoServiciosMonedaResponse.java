
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
 *         &lt;element name="CatalogoServiciosMonedaResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
    "catalogoServiciosMonedaResult",
    "catalogoServicios"
})
@XmlRootElement(name = "CatalogoServiciosMonedaResponse")
public class CatalogoServiciosMonedaResponse {

    @XmlElement(name = "CatalogoServiciosMonedaResult")
    protected Object catalogoServiciosMonedaResult;
    @XmlElement(name = "CatalogoServicios")
    protected ArrayOfCatalogoServicio catalogoServicios;

    /**
     * Gets the value of the catalogoServiciosMonedaResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCatalogoServiciosMonedaResult() {
        return catalogoServiciosMonedaResult;
    }

    /**
     * Sets the value of the catalogoServiciosMonedaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCatalogoServiciosMonedaResult(Object value) {
        this.catalogoServiciosMonedaResult = value;
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
