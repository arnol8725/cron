package com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ZHRLOGERR_VNTEMP complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ZHRLOGERR_VNTEMP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}SAPStructure">
 *       &lt;sequence>
 *         &lt;element name="MANDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="PERNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="AEDTM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="CONSECUTIVO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="UNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="FOLIO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="REFERENCIA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="TEXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="TCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="DYNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="DYNUMB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="MSGTYP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="MSGSPRA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="MSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="MSGNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="MSGV1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="MSGV2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="MSGV3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="MSGV4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="ENV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="FLDNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZHRLOGERR_VNTEMP", propOrder = {
    "mandt",
    "pernr",
    "aedtm",
    "consecutivo",
    "uname",
    "folio",
    "referencia",
    "text",
    "tcode",
    "dyname",
    "dynumb",
    "msgtyp",
    "msgspra",
    "msgid",
    "msgnr",
    "msgv1",
    "msgv2",
    "msgv3",
    "msgv4",
    "env",
    "fldname"
})
public class ZHRLOGERRVNTEMP
    extends SAPStructure
{

    @XmlElement(name = "MANDT", namespace = "")
    protected String mandt;
    @XmlElement(name = "PERNR", namespace = "")
    protected String pernr;
    @XmlElement(name = "AEDTM", namespace = "")
    protected String aedtm;
    @XmlElement(name = "CONSECUTIVO", namespace = "")
    protected String consecutivo;
    @XmlElement(name = "UNAME", namespace = "")
    protected String uname;
    @XmlElement(name = "FOLIO", namespace = "")
    protected String folio;
    @XmlElement(name = "REFERENCIA", namespace = "")
    protected String referencia;
    @XmlElement(name = "TEXT", namespace = "")
    protected String text;
    @XmlElement(name = "TCODE", namespace = "")
    protected String tcode;
    @XmlElement(name = "DYNAME", namespace = "")
    protected String dyname;
    @XmlElement(name = "DYNUMB", namespace = "")
    protected String dynumb;
    @XmlElement(name = "MSGTYP", namespace = "")
    protected String msgtyp;
    @XmlElement(name = "MSGSPRA", namespace = "")
    protected String msgspra;
    @XmlElement(name = "MSGID", namespace = "")
    protected String msgid;
    @XmlElement(name = "MSGNR", namespace = "")
    protected String msgnr;
    @XmlElement(name = "MSGV1", namespace = "")
    protected String msgv1;
    @XmlElement(name = "MSGV2", namespace = "")
    protected String msgv2;
    @XmlElement(name = "MSGV3", namespace = "")
    protected String msgv3;
    @XmlElement(name = "MSGV4", namespace = "")
    protected String msgv4;
    @XmlElement(name = "ENV", namespace = "")
    protected String env;
    @XmlElement(name = "FLDNAME", namespace = "")
    protected String fldname;

    /**
     * Obtiene el valor de la propiedad mandt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMANDT() {
        return mandt;
    }

    /**
     * Define el valor de la propiedad mandt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMANDT(String value) {
        this.mandt = value;
    }

    /**
     * Obtiene el valor de la propiedad pernr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERNR() {
        return pernr;
    }

    /**
     * Define el valor de la propiedad pernr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERNR(String value) {
        this.pernr = value;
    }

    /**
     * Obtiene el valor de la propiedad aedtm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAEDTM() {
        return aedtm;
    }

    /**
     * Define el valor de la propiedad aedtm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAEDTM(String value) {
        this.aedtm = value;
    }

    /**
     * Obtiene el valor de la propiedad consecutivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONSECUTIVO() {
        return consecutivo;
    }

    /**
     * Define el valor de la propiedad consecutivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONSECUTIVO(String value) {
        this.consecutivo = value;
    }

    /**
     * Obtiene el valor de la propiedad uname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNAME() {
        return uname;
    }

    /**
     * Define el valor de la propiedad uname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNAME(String value) {
        this.uname = value;
    }

    /**
     * Obtiene el valor de la propiedad folio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFOLIO() {
        return folio;
    }

    /**
     * Define el valor de la propiedad folio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFOLIO(String value) {
        this.folio = value;
    }

    /**
     * Obtiene el valor de la propiedad referencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFERENCIA() {
        return referencia;
    }

    /**
     * Define el valor de la propiedad referencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFERENCIA(String value) {
        this.referencia = value;
    }

    /**
     * Obtiene el valor de la propiedad text.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEXT() {
        return text;
    }

    /**
     * Define el valor de la propiedad text.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTEXT(String value) {
        this.text = value;
    }

    /**
     * Obtiene el valor de la propiedad tcode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTCODE() {
        return tcode;
    }

    /**
     * Define el valor de la propiedad tcode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTCODE(String value) {
        this.tcode = value;
    }

    /**
     * Obtiene el valor de la propiedad dyname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDYNAME() {
        return dyname;
    }

    /**
     * Define el valor de la propiedad dyname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDYNAME(String value) {
        this.dyname = value;
    }

    /**
     * Obtiene el valor de la propiedad dynumb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDYNUMB() {
        return dynumb;
    }

    /**
     * Define el valor de la propiedad dynumb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDYNUMB(String value) {
        this.dynumb = value;
    }

    /**
     * Obtiene el valor de la propiedad msgtyp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGTYP() {
        return msgtyp;
    }

    /**
     * Define el valor de la propiedad msgtyp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGTYP(String value) {
        this.msgtyp = value;
    }

    /**
     * Obtiene el valor de la propiedad msgspra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGSPRA() {
        return msgspra;
    }

    /**
     * Define el valor de la propiedad msgspra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGSPRA(String value) {
        this.msgspra = value;
    }

    /**
     * Obtiene el valor de la propiedad msgid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGID() {
        return msgid;
    }

    /**
     * Define el valor de la propiedad msgid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGID(String value) {
        this.msgid = value;
    }

    /**
     * Obtiene el valor de la propiedad msgnr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGNR() {
        return msgnr;
    }

    /**
     * Define el valor de la propiedad msgnr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGNR(String value) {
        this.msgnr = value;
    }

    /**
     * Obtiene el valor de la propiedad msgv1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGV1() {
        return msgv1;
    }

    /**
     * Define el valor de la propiedad msgv1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGV1(String value) {
        this.msgv1 = value;
    }

    /**
     * Obtiene el valor de la propiedad msgv2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGV2() {
        return msgv2;
    }

    /**
     * Define el valor de la propiedad msgv2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGV2(String value) {
        this.msgv2 = value;
    }

    /**
     * Obtiene el valor de la propiedad msgv3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGV3() {
        return msgv3;
    }

    /**
     * Define el valor de la propiedad msgv3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGV3(String value) {
        this.msgv3 = value;
    }

    /**
     * Obtiene el valor de la propiedad msgv4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGV4() {
        return msgv4;
    }

    /**
     * Define el valor de la propiedad msgv4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGV4(String value) {
        this.msgv4 = value;
    }

    /**
     * Obtiene el valor de la propiedad env.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENV() {
        return env;
    }

    /**
     * Define el valor de la propiedad env.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENV(String value) {
        this.env = value;
    }

    /**
     * Obtiene el valor de la propiedad fldname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLDNAME() {
        return fldname;
    }

    /**
     * Define el valor de la propiedad fldname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLDNAME(String value) {
        this.fldname = value;
    }

}
