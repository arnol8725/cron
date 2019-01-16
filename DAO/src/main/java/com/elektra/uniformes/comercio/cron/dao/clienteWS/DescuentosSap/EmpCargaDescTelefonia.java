package com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sIdNeg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sUsr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sPer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sFecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dImporte" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="sReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="It_Err" type="{http://tempuri.org/}ArrayOfZHRLOGERR_VNTEMP" minOccurs="0"/>
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
    "sIdNeg",
    "sUsr",
    "sPwd",
    "sPer",
    "sFecha",
    "dImporte",
    "sReferencia",
    "itErr"
})
@XmlRootElement(name = "Emp_Carga_Desc_Telefonia")
public class EmpCargaDescTelefonia {

    protected String sIdNeg;
    protected String sUsr;
    protected String sPwd;
    protected String sPer;
    protected String sFecha;
    @XmlElement(required = true)
    protected BigDecimal dImporte;
    protected String sReferencia;
    @XmlElement(name = "It_Err")
    protected ArrayOfZHRLOGERRVNTEMP itErr;

    /**
     * Obtiene el valor de la propiedad sIdNeg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIdNeg() {
        return sIdNeg;
    }

    /**
     * Define el valor de la propiedad sIdNeg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIdNeg(String value) {
        this.sIdNeg = value;
    }

    /**
     * Obtiene el valor de la propiedad sUsr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUsr() {
        return sUsr;
    }

    /**
     * Define el valor de la propiedad sUsr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUsr(String value) {
        this.sUsr = value;
    }

    /**
     * Obtiene el valor de la propiedad sPwd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPwd() {
        return sPwd;
    }

    /**
     * Define el valor de la propiedad sPwd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPwd(String value) {
        this.sPwd = value;
    }

    /**
     * Obtiene el valor de la propiedad sPer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPer() {
        return sPer;
    }

    /**
     * Define el valor de la propiedad sPer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPer(String value) {
        this.sPer = value;
    }

    /**
     * Obtiene el valor de la propiedad sFecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFecha() {
        return sFecha;
    }

    /**
     * Define el valor de la propiedad sFecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFecha(String value) {
        this.sFecha = value;
    }

    /**
     * Obtiene el valor de la propiedad dImporte.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDImporte() {
        return dImporte;
    }

    /**
     * Define el valor de la propiedad dImporte.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDImporte(BigDecimal value) {
        this.dImporte = value;
    }

    /**
     * Obtiene el valor de la propiedad sReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSReferencia() {
        return sReferencia;
    }

    /**
     * Define el valor de la propiedad sReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSReferencia(String value) {
        this.sReferencia = value;
    }

    /**
     * Obtiene el valor de la propiedad itErr.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfZHRLOGERRVNTEMP }
     *     
     */
    public ArrayOfZHRLOGERRVNTEMP getItErr() {
        return itErr;
    }

    /**
     * Define el valor de la propiedad itErr.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfZHRLOGERRVNTEMP }
     *     
     */
    public void setItErr(ArrayOfZHRLOGERRVNTEMP value) {
        this.itErr = value;
    }

}
