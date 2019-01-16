
package com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto;

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
 *         &lt;element name="Sistema" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tienda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Pedido" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "sistema",
    "tienda",
    "pedido"
})
@XmlRootElement(name = "Parametros_Entrada", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_Ped_Cent_Consul_Uniformes")
public class ParametrosEntrada {

    @XmlElement(name = "Sistema", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_Ped_Cent_Consul_Uniformes", required = true)
    protected String sistema;
    @XmlElement(name = "Tienda", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_Ped_Cent_Consul_Uniformes", required = true)
    protected String tienda;
    @XmlElement(name = "Pedido", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_Ped_Cent_Consul_Uniformes", required = true)
    protected String pedido;

    /**
     * Gets the value of the sistema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSistema() {
        return sistema;
    }

    /**
     * Sets the value of the sistema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSistema(String value) {
        this.sistema = value;
    }

    /**
     * Gets the value of the tienda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTienda() {
        return tienda;
    }

    /**
     * Sets the value of the tienda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTienda(String value) {
        this.tienda = value;
    }

    /**
     * Gets the value of the pedido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPedido() {
        return pedido;
    }

    /**
     * Sets the value of the pedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPedido(String value) {
        this.pedido = value;
    }

}
