
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Concepto" type="{http://conectorunico/schemas}t_Concepto"/>
 *         &lt;element name="FechaInicial" type="{http://conectorunico/schemas}t_FormatoFecha"/>
 *         &lt;element name="FechaFinal" type="{http://conectorunico/schemas}t_FormatoFecha"/>
 *         &lt;element name="DetalleCarga" type="{http://conectorunico/schemas}cargaReal" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Token" use="required" type="{http://conectorunico/schemas}t_Token" />
 *       &lt;attribute name="ClaveCentroProvedor" use="required" type="{http://conectorunico/schemas}t_ClaveCentroProvedor" />
 *       &lt;attribute name="ClaveServicio" use="required" type="{http://conectorunico/schemas}t_ClaveServicio" />
 *       &lt;attribute name="ClaveSociedad" use="required" type="{http://conectorunico/schemas}t_ClaveSociedad" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "descripcion",
    "concepto",
    "fechaInicial",
    "fechaFinal",
    "detalleCarga"
})
@XmlRootElement(name = "cargaRealesRequest")
public class CargaRealesRequest {

    @XmlElement(name = "Descripcion", required = true)
    protected String descripcion;
    @XmlElement(name = "Concepto")
    protected int concepto;
    @XmlElement(name = "FechaInicial", required = true)
    protected String fechaInicial;
    @XmlElement(name = "FechaFinal", required = true)
    protected String fechaFinal;
    @XmlElement(name = "DetalleCarga", required = true)
    protected List<CargaReal> detalleCarga;
    @XmlAttribute(name = "Token", required = true)
    protected String token;
    @XmlAttribute(name = "ClaveCentroProvedor", required = true)
    protected String claveCentroProvedor;
    @XmlAttribute(name = "ClaveServicio", required = true)
    protected String claveServicio;
    @XmlAttribute(name = "ClaveSociedad", required = true)
    protected String claveSociedad;

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
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
     * Gets the value of the fechaInicial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInicial() {
        return fechaInicial;
    }

    /**
     * Sets the value of the fechaInicial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInicial(String value) {
        this.fechaInicial = value;
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

    /**
     * Gets the value of the detalleCarga property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleCarga property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleCarga().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CargaReal }
     * 
     * 
     */
    public List<CargaReal> getDetalleCarga() {
        if (detalleCarga == null) {
            detalleCarga = new ArrayList<CargaReal>();
        }
        return this.detalleCarga;
    }

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

}
