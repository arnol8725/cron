
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
 *         &lt;element name="CatalogoCentrosCostos" type="{http://tempuri.org/}ArrayOfCatalogoCentroCosto" minOccurs="0"/>
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
    "catalogoCentrosCostos"
})
@XmlRootElement(name = "SPPITVACatalogoCentrosCostos")
public class SPPITVACatalogoCentrosCostos {

    @XmlElement(name = "CatalogoCentrosCostos")
    protected ArrayOfCatalogoCentroCosto catalogoCentrosCostos;

    /**
     * Gets the value of the catalogoCentrosCostos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCatalogoCentroCosto }
     *     
     */
    public ArrayOfCatalogoCentroCosto getCatalogoCentrosCostos() {
        return catalogoCentrosCostos;
    }

    /**
     * Sets the value of the catalogoCentrosCostos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCatalogoCentroCosto }
     *     
     */
    public void setCatalogoCentrosCostos(ArrayOfCatalogoCentroCosto value) {
        this.catalogoCentrosCostos = value;
    }

}
