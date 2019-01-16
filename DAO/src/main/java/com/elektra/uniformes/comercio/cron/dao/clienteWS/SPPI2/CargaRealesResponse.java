
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FolioCarga" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ErroresCarga" type="{http://conectorunico/schemas}errorCargaReal" maxOccurs="unbounded"/>
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
    "codigo",
    "mensaje",
    "folioCarga",
    "erroresCarga"
})
@XmlRootElement(name = "cargaRealesResponse")
public class CargaRealesResponse {

    @XmlElement(name = "Codigo")
    protected int codigo;
    @XmlElement(name = "Mensaje", required = true)
    protected String mensaje;
    @XmlElement(name = "FolioCarga")
    protected int folioCarga;
    @XmlElement(name = "ErroresCarga", required = true)
    protected List<ErrorCargaReal> erroresCarga;

    /**
     * Gets the value of the codigo property.
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     * 
     */
    public void setCodigo(int value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the mensaje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Sets the value of the mensaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

    /**
     * Gets the value of the folioCarga property.
     * 
     */
    public int getFolioCarga() {
        return folioCarga;
    }

    /**
     * Sets the value of the folioCarga property.
     * 
     */
    public void setFolioCarga(int value) {
        this.folioCarga = value;
    }

    /**
     * Gets the value of the erroresCarga property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the erroresCarga property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErroresCarga().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorCargaReal }
     * 
     * 
     */
    public List<ErrorCargaReal> getErroresCarga() {
        if (erroresCarga == null) {
            erroresCarga = new ArrayList<ErrorCargaReal>();
        }
        return this.erroresCarga;
    }

}
