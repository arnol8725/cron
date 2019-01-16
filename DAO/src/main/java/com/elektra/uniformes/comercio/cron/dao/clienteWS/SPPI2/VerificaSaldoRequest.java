
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="Token" use="required" type="{http://conectorunico/schemas}t_Token" />
 *       &lt;attribute name="ClaveCentroProvedor" use="required" type="{http://conectorunico/schemas}t_ClaveCentroProvedor" />
 *       &lt;attribute name="ClaveServicio" use="required" type="{http://conectorunico/schemas}t_ClaveServicio" />
 *       &lt;attribute name="ClaveSociedad" use="required" type="{http://conectorunico/schemas}t_ClaveSociedad" />
 *       &lt;attribute name="Concepto" use="required" type="{http://conectorunico/schemas}t_Concepto" />
 *       &lt;attribute name="FechaFinal" use="required" type="{http://conectorunico/schemas}t_FormatoFecha" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "verificaSaldoRequest")
public class VerificaSaldoRequest {

    @XmlAttribute(name = "Token", required = true)
    protected String token;
    @XmlAttribute(name = "ClaveCentroProvedor", required = true)
    protected String claveCentroProvedor;
    @XmlAttribute(name = "ClaveServicio", required = true)
    protected String claveServicio;
    @XmlAttribute(name = "ClaveSociedad", required = true)
    protected String claveSociedad;
    @XmlAttribute(name = "Concepto", required = true)
    protected int concepto;
    @XmlAttribute(name = "FechaFinal", required = true)
    protected String fechaFinal;

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
     * Gets the value of the claveCentroProvedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveCentroProvedor() {
        return claveCentroProvedor;
    }

    /**
     * Sets the value of the claveCentroProvedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveCentroProvedor(String value) {
        this.claveCentroProvedor = value;
    }

    /**
     * Gets the value of the claveServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveServicio() {
        return claveServicio;
    }

    /**
     * Sets the value of the claveServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveServicio(String value) {
        this.claveServicio = value;
    }

    /**
     * Gets the value of the claveSociedad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveSociedad() {
        return claveSociedad;
    }

    /**
     * Sets the value of the claveSociedad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveSociedad(String value) {
        this.claveSociedad = value;
    }

    /**
     * Gets the value of the concepto property.
     * 
     */
    public int getConcepto() {
        return concepto;
    }

    /**
     * Sets the value of the concepto property.
     * 
     */
    public void setConcepto(int value) {
        this.concepto = value;
    }

    /**
     * Gets the value of the fechaFinal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Sets the value of the fechaFinal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFinal(String value) {
        this.fechaFinal = value;
    }

}
