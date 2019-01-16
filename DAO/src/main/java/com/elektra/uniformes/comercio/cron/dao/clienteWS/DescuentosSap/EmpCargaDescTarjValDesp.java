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
 *         &lt;element name="Empleado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Importe" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "empleado",
    "inicio",
    "importe",
    "referencia",
    "itErr"
})
@XmlRootElement(name = "Emp_Carga_Desc_Tarj_ValDesp")
public class EmpCargaDescTarjValDesp {

    protected String sIdNeg;
    protected String sUsr;
    protected String sPwd;
    @XmlElement(name = "Empleado")
    protected String empleado;
    @XmlElement(name = "Inicio")
    protected String inicio;
    @XmlElement(name = "Importe", required = true)
    protected BigDecimal importe;
    @XmlElement(name = "Referencia")
    protected String referencia;
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
     * Obtiene el valor de la propiedad empleado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpleado() {
        return empleado;
    }

    /**
     * Define el valor de la propiedad empleado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpleado(String value) {
        this.empleado = value;
    }

    /**
     * Obtiene el valor de la propiedad inicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInicio() {
        return inicio;
    }

    /**
     * Define el valor de la propiedad inicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInicio(String value) {
        this.inicio = value;
    }

    /**
     * Obtiene el valor de la propiedad importe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImporte() {
        return importe;
    }

    /**
     * Define el valor de la propiedad importe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImporte(BigDecimal value) {
        this.importe = value;
    }

    /**
     * Obtiene el valor de la propiedad referencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencia() {
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
    public void setReferencia(String value) {
        this.referencia = value;
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
