
package com.elektra.uniformes.comercio.cron.dao.clienteWS.Token;

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
 *         &lt;element name="FinVigencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InicioVigencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TiempoVigencia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "finVigencia",
    "inicioVigencia",
    "tiempoVigencia",
    "token"
})
@XmlRootElement(name = "ObtieneTokenResponse")
public class ObtieneTokenResponse {

    @XmlElement(name = "Codigo")
    protected int codigo;
    @XmlElement(name = "Mensaje", required = true)
    protected String mensaje;
    @XmlElement(name = "FinVigencia", required = true)
    protected String finVigencia;
    @XmlElement(name = "InicioVigencia", required = true)
    protected String inicioVigencia;
    @XmlElement(name = "TiempoVigencia")
    protected int tiempoVigencia;
    @XmlElement(name = "Token", required = true)
    protected String token;

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
     * Gets the value of the finVigencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinVigencia() {
        return finVigencia;
    }

    /**
     * Sets the value of the finVigencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinVigencia(String value) {
        this.finVigencia = value;
    }

    /**
     * Gets the value of the inicioVigencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInicioVigencia() {
        return inicioVigencia;
    }

    /**
     * Sets the value of the inicioVigencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInicioVigencia(String value) {
        this.inicioVigencia = value;
    }

    /**
     * Gets the value of the tiempoVigencia property.
     * 
     */
    public int getTiempoVigencia() {
        return tiempoVigencia;
    }

    /**
     * Sets the value of the tiempoVigencia property.
     * 
     */
    public void setTiempoVigencia(int value) {
        this.tiempoVigencia = value;
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

}
