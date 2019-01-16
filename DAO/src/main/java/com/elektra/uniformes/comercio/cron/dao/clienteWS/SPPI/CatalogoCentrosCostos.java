
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
 *         &lt;element name="ClaveUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdSistemaSatelital" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SoloPresupuestados" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "claveUsuario",
    "idSistemaSatelital",
    "soloPresupuestados",
    "catalogoCentrosCostos"
})
@XmlRootElement(name = "CatalogoCentrosCostos")
public class CatalogoCentrosCostos {

    @XmlElement(name = "ClaveUsuario")
    protected String claveUsuario;
    @XmlElement(name = "IdSistemaSatelital")
    protected int idSistemaSatelital;
    @XmlElement(name = "SoloPresupuestados")
    protected int soloPresupuestados;
    @XmlElement(name = "CatalogoCentrosCostos")
    protected ArrayOfCatalogoCentroCosto catalogoCentrosCostos;

    /**
     * Gets the value of the claveUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveUsuario() {
        return claveUsuario;
    }

    /**
     * Sets the value of the claveUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveUsuario(String value) {
        this.claveUsuario = value;
    }

    /**
     * Gets the value of the idSistemaSatelital property.
     * 
     */
    public int getIdSistemaSatelital() {
        return idSistemaSatelital;
    }

    /**
     * Sets the value of the idSistemaSatelital property.
     * 
     */
    public void setIdSistemaSatelital(int value) {
        this.idSistemaSatelital = value;
    }

    /**
     * Gets the value of the soloPresupuestados property.
     * 
     */
    public int getSoloPresupuestados() {
        return soloPresupuestados;
    }

    /**
     * Sets the value of the soloPresupuestados property.
     * 
     */
    public void setSoloPresupuestados(int value) {
        this.soloPresupuestados = value;
    }

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
