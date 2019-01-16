
package com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto;
//mx.com.elektra.esquemas.ekt._1_0.esq_entr_consulta
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
 *         &lt;element name="Sistema" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Detalle" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Tienda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "detalle"
})
@XmlRootElement(name = "Entrada", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_Consulta")
public class Entrada {

    @XmlElement(name = "Sistema", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_Consulta", required = true)
    protected String sistema;
    @XmlElement(name = "Detalle", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_Consulta", required = true)
    protected List<Entrada.Detalle> detalle;

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
     * Gets the value of the detalle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Entrada.Detalle }
     * 
     * 
     */
    public List<Entrada.Detalle> getDetalle() {
        if (detalle == null) {
            detalle = new ArrayList<Entrada.Detalle>();
        }
        return this.detalle;
    }


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
     *         &lt;element name="Tienda" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "tienda",
        "folio"
    })
    public static class Detalle {

        @XmlElement(name = "Tienda", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_Consulta", required = true)
        protected String tienda;
        @XmlElement(name = "Folio", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_Consulta", required = true)
        protected String folio;

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
         * Gets the value of the folio property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFolio() {
            return folio;
        }

        /**
         * Sets the value of the folio property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFolio(String value) {
            this.folio = value;
        }

    }

}
