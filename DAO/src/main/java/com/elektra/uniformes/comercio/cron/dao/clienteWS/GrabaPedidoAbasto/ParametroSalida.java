
package com.elektra.uniformes.comercio.cron.dao.clienteWS.GrabaPedidoAbasto;

import java.math.BigDecimal;
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
 *         &lt;element name="Estatus" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Mensaje1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Mensaje2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Mensaje3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Mensaje4" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "estatus",
    "fecha",
    "mensaje1",
    "mensaje2",
    "mensaje3",
    "mensaje4"
})
@XmlRootElement(name = "Parametro_Salida")
public class ParametroSalida {

    @XmlElement(name = "Estatus", required = true)
    protected BigDecimal estatus;
    @XmlElement(name = "Fecha", required = true)
    protected BigDecimal fecha;
    @XmlElement(name = "Mensaje1", required = true)
    protected String mensaje1;
    @XmlElement(name = "Mensaje2", required = true)
    protected String mensaje2;
    @XmlElement(name = "Mensaje3", required = true)
    protected String mensaje3;
    @XmlElement(name = "Mensaje4", required = true)
    protected String mensaje4;

    /**
     * Gets the value of the estatus property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEstatus() {
        return estatus;
    }

    /**
     * Sets the value of the estatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEstatus(BigDecimal value) {
        this.estatus = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFecha(BigDecimal value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the mensaje1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje1() {
        return mensaje1;
    }

    /**
     * Sets the value of the mensaje1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje1(String value) {
        this.mensaje1 = value;
    }

    /**
     * Gets the value of the mensaje2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje2() {
        return mensaje2;
    }

    /**
     * Sets the value of the mensaje2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje2(String value) {
        this.mensaje2 = value;
    }

    /**
     * Gets the value of the mensaje3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje3() {
        return mensaje3;
    }

    /**
     * Sets the value of the mensaje3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje3(String value) {
        this.mensaje3 = value;
    }

    /**
     * Gets the value of the mensaje4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje4() {
        return mensaje4;
    }

    /**
     * Sets the value of the mensaje4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje4(String value) {
        this.mensaje4 = value;
    }

}
