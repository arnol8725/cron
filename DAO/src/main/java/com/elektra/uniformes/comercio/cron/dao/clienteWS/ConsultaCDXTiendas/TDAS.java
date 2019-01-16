
package com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaCDXTiendas;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2}CD"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2}Nom_CD"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2}Num_TDA"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2}Nam_TDA"/>
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
    "cd",
    "nomCD",
    "numTDA",
    "namTDA"
})
@XmlRootElement(name = "TDAS")
public class TDAS {

    @XmlElement(name = "CD", required = true)
    protected String cd;
    @XmlElement(name = "Nom_CD", required = true)
    protected String nomCD;
    @XmlElement(name = "Num_TDA", required = true)
    protected String numTDA;
    @XmlElement(name = "Nam_TDA", required = true)
    protected String namTDA;

    /**
     * Gets the value of the cd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCD() {
        return cd;
    }

    /**
     * Sets the value of the cd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCD(String value) {
        this.cd = value;
    }

    /**
     * Gets the value of the nomCD property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCD() {
        return nomCD;
    }

    /**
     * Sets the value of the nomCD property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCD(String value) {
        this.nomCD = value;
    }

    /**
     * Gets the value of the numTDA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTDA() {
        return numTDA;
    }

    /**
     * Sets the value of the numTDA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTDA(String value) {
        this.numTDA = value;
    }

    /**
     * Gets the value of the namTDA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamTDA() {
        return namTDA;
    }

    /**
     * Sets the value of the namTDA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamTDA(String value) {
        this.namTDA = value;
    }

}
