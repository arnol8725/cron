
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
 *         &lt;element ref="{http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd}CD"/>
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
    "cd"
})
@XmlRootElement(name = "Parametro", namespace = "http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd")
public class Parametro {

    @XmlElement(name = "CD", namespace = "http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd")
    protected int cd;

    /**
     * Gets the value of the cd property.
     * 
     */
    public int getCD() {
        return cd;
    }

    /**
     * Sets the value of the cd property.
     * 
     */
    public void setCD(int value) {
        this.cd = value;
    }

}
