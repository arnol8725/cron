
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CatalogoCentroCosto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CatalogoCentroCosto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClaveCentro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DescripcionCentro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Compania" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Proyecto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UnidadNegocio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogoCentroCosto", propOrder = {
    "claveCentro",
    "descripcionCentro",
    "compania",
    "proyecto",
    "unidadNegocio"
})
public class CatalogoCentroCosto {

    @XmlElement(name = "ClaveCentro")
    protected String claveCentro;
    @XmlElement(name = "DescripcionCentro")
    protected String descripcionCentro;
    @XmlElement(name = "Compania")
    protected int compania;
    @XmlElement(name = "Proyecto")
    protected int proyecto;
    @XmlElement(name = "UnidadNegocio")
    protected int unidadNegocio;

    /**
     * Gets the value of the claveCentro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveCentro() {
        return claveCentro;
    }

    /**
     * Sets the value of the claveCentro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveCentro(String value) {
        this.claveCentro = value;
    }

    /**
     * Gets the value of the descripcionCentro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionCentro() {
        return descripcionCentro;
    }

    /**
     * Sets the value of the descripcionCentro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionCentro(String value) {
        this.descripcionCentro = value;
    }

    /**
     * Gets the value of the compania property.
     * 
     */
    public int getCompania() {
        return compania;
    }

    /**
     * Sets the value of the compania property.
     * 
     */
    public void setCompania(int value) {
        this.compania = value;
    }

    /**
     * Gets the value of the proyecto property.
     * 
     */
    public int getProyecto() {
        return proyecto;
    }

    /**
     * Sets the value of the proyecto property.
     * 
     */
    public void setProyecto(int value) {
        this.proyecto = value;
    }

    /**
     * Gets the value of the unidadNegocio property.
     * 
     */
    public int getUnidadNegocio() {
        return unidadNegocio;
    }

    /**
     * Sets the value of the unidadNegocio property.
     * 
     */
    public void setUnidadNegocio(int value) {
        this.unidadNegocio = value;
    }

}
