
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
 *         &lt;element name="folio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DetalleCargaRealSPPI" type="{http://tempuri.org/}ArrayOfDetalleCargaRealDistribuido" minOccurs="0"/>
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
    "folio",
    "detalleCargaRealSPPI"
})
@XmlRootElement(name = "DetalleCargaRealSPPIDistribuido")
public class DetalleCargaRealSPPIDistribuido {

    @XmlElement(name = "ClaveUsuario")
    protected String claveUsuario;
    @XmlElement(name = "IdSistemaSatelital")
    protected int idSistemaSatelital;
    protected int folio;
    @XmlElement(name = "DetalleCargaRealSPPI")
    protected ArrayOfDetalleCargaRealDistribuido detalleCargaRealSPPI;

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
     * Gets the value of the folio property.
     * 
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Sets the value of the folio property.
     * 
     */
    public void setFolio(int value) {
        this.folio = value;
    }

    /**
     * Gets the value of the detalleCargaRealSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleCargaRealDistribuido }
     *     
     */
    public ArrayOfDetalleCargaRealDistribuido getDetalleCargaRealSPPI() {
        return detalleCargaRealSPPI;
    }

    /**
     * Sets the value of the detalleCargaRealSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleCargaRealDistribuido }
     *     
     */
    public void setDetalleCargaRealSPPI(ArrayOfDetalleCargaRealDistribuido value) {
        this.detalleCargaRealSPPI = value;
    }

}
