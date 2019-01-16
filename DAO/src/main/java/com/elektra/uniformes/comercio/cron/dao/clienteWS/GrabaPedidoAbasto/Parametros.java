
package com.elektra.uniformes.comercio.cron.dao.clienteWS.GrabaPedidoAbasto;

import java.math.BigDecimal;
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
 *         &lt;element name="Tpo_Operacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Pais" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Canal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Store_nbr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Pedido" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Tipped" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Fecentr" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Apepcl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Apemcl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Delegac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Cp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Colonia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Calle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Numerint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Telcel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pedidoobs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lugentobs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Adicional1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Adicional2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DETALLE" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="skuequ" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="preuni" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="totventa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="descuen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="flete" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sku" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "tpoOperacion",
    "pais",
    "canal",
    "cd",
    "storeNbr",
    "pedido",
    "tipped",
    "fecentr",
    "nombre",
    "apepcl",
    "apemcl",
    "estado",
    "delegac",
    "cp",
    "colonia",
    "calle",
    "numero",
    "numerint",
    "telefono",
    "telcel",
    "pedidoobs",
    "lugentobs",
    "adicional1",
    "adicional2",
    "detalle"
})
@XmlRootElement(name = "Parametros", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo")
public class Parametros {

    @XmlElement(name = "Tpo_Operacion", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo")
    protected int tpoOperacion;
    @XmlElement(name = "Pais", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected BigDecimal pais;
    @XmlElement(name = "Canal", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected BigDecimal canal;
    @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String cd;
    @XmlElement(name = "Store_nbr", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String storeNbr;
    @XmlElement(name = "Pedido", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected BigDecimal pedido;
    @XmlElement(name = "Tipped", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String tipped;
    @XmlElement(name = "Fecentr", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected BigDecimal fecentr;
    @XmlElement(name = "Nombre", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String nombre;
    @XmlElement(name = "Apepcl", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String apepcl;
    @XmlElement(name = "Apemcl", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String apemcl;
    @XmlElement(name = "Estado", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String estado;
    @XmlElement(name = "Delegac", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String delegac;
    @XmlElement(name = "Cp", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String cp;
    @XmlElement(name = "Colonia", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String colonia;
    @XmlElement(name = "Calle", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String calle;
    @XmlElement(name = "Numero", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String numero;
    @XmlElement(name = "Numerint", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String numerint;
    @XmlElement(name = "Telefono", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String telefono;
    @XmlElement(name = "Telcel", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String telcel;
    @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String pedidoobs;
    @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String lugentobs;
    @XmlElement(name = "Adicional1", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String adicional1;
    @XmlElement(name = "Adicional2", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected String adicional2;
    @XmlElement(name = "DETALLE", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
    protected List<Parametros.DETALLE> detalle;

    /**
     * Gets the value of the tpoOperacion property.
     * 
     */
    public int getTpoOperacion() {
        return tpoOperacion;
    }

    /**
     * Sets the value of the tpoOperacion property.
     * 
     */
    public void setTpoOperacion(int value) {
        this.tpoOperacion = value;
    }

    /**
     * Gets the value of the pais property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPais() {
        return pais;
    }

    /**
     * Sets the value of the pais property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPais(BigDecimal value) {
        this.pais = value;
    }

    /**
     * Gets the value of the canal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCanal() {
        return canal;
    }

    /**
     * Sets the value of the canal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCanal(BigDecimal value) {
        this.canal = value;
    }

    /**
     * Gets the value of the cd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCd() {
        return cd;
    }

    /**
     * Sets the value of the cd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCd(String value) {
        this.cd = value;
    }

    /**
     * Gets the value of the storeNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreNbr() {
        return storeNbr;
    }

    /**
     * Sets the value of the storeNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreNbr(String value) {
        this.storeNbr = value;
    }

    /**
     * Gets the value of the pedido property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPedido() {
        return pedido;
    }

    /**
     * Sets the value of the pedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPedido(BigDecimal value) {
        this.pedido = value;
    }

    /**
     * Gets the value of the tipped property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipped() {
        return tipped;
    }

    /**
     * Sets the value of the tipped property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipped(String value) {
        this.tipped = value;
    }

    /**
     * Gets the value of the fecentr property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFecentr() {
        return fecentr;
    }

    /**
     * Sets the value of the fecentr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFecentr(BigDecimal value) {
        this.fecentr = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the apepcl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApepcl() {
        return apepcl;
    }

    /**
     * Sets the value of the apepcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApepcl(String value) {
        this.apepcl = value;
    }

    /**
     * Gets the value of the apemcl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApemcl() {
        return apemcl;
    }

    /**
     * Sets the value of the apemcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApemcl(String value) {
        this.apemcl = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the delegac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelegac() {
        return delegac;
    }

    /**
     * Sets the value of the delegac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelegac(String value) {
        this.delegac = value;
    }

    /**
     * Gets the value of the cp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCp() {
        return cp;
    }

    /**
     * Sets the value of the cp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCp(String value) {
        this.cp = value;
    }

    /**
     * Gets the value of the colonia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Sets the value of the colonia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColonia(String value) {
        this.colonia = value;
    }

    /**
     * Gets the value of the calle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Sets the value of the calle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalle(String value) {
        this.calle = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Gets the value of the numerint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerint() {
        return numerint;
    }

    /**
     * Sets the value of the numerint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerint(String value) {
        this.numerint = value;
    }

    /**
     * Gets the value of the telefono property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets the value of the telefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Gets the value of the telcel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelcel() {
        return telcel;
    }

    /**
     * Sets the value of the telcel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelcel(String value) {
        this.telcel = value;
    }

    /**
     * Gets the value of the pedidoobs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPedidoobs() {
        return pedidoobs;
    }

    /**
     * Sets the value of the pedidoobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPedidoobs(String value) {
        this.pedidoobs = value;
    }

    /**
     * Gets the value of the lugentobs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugentobs() {
        return lugentobs;
    }

    /**
     * Sets the value of the lugentobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugentobs(String value) {
        this.lugentobs = value;
    }

    /**
     * Gets the value of the adicional1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdicional1() {
        return adicional1;
    }

    /**
     * Sets the value of the adicional1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdicional1(String value) {
        this.adicional1 = value;
    }

    /**
     * Gets the value of the adicional2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdicional2() {
        return adicional2;
    }

    /**
     * Sets the value of the adicional2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdicional2(String value) {
        this.adicional2 = value;
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
     *    getDETALLE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parametros.DETALLE }
     * 
     * 
     */
    public List<Parametros.DETALLE> getDETALLE() {
        if (detalle == null) {
            detalle = new ArrayList<Parametros.DETALLE>();
        }
        return this.detalle;
    }

    public void setDETALLE(ArrayList<DETALLE> arDET) {
        this.detalle = arDET;
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
     *         &lt;element name="skuequ" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="preuni" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="totventa" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="descuen" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="flete" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="sku" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "skuequ",
        "preuni",
        "totventa",
        "descuen",
        "flete",
        "sku",
        "qty"
    })
    public static class DETALLE {

        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
        protected String skuequ;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
        protected String preuni;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
        protected String totventa;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
        protected String descuen;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
        protected String flete;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
        protected String sku;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", required = true)
        protected String qty;

        /**
         * Gets the value of the skuequ property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSkuequ() {
            return skuequ;
        }

        /**
         * Sets the value of the skuequ property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSkuequ(String value) {
            this.skuequ = value;
        }

        /**
         * Gets the value of the preuni property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPreuni() {
            return preuni;
        }

        /**
         * Sets the value of the preuni property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPreuni(String value) {
            this.preuni = value;
        }

        /**
         * Gets the value of the totventa property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTotventa() {
            return totventa;
        }

        /**
         * Sets the value of the totventa property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTotventa(String value) {
            this.totventa = value;
        }

        /**
         * Gets the value of the descuen property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescuen() {
            return descuen;
        }

        /**
         * Sets the value of the descuen property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescuen(String value) {
            this.descuen = value;
        }

        /**
         * Gets the value of the flete property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFlete() {
            return flete;
        }

        /**
         * Sets the value of the flete property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFlete(String value) {
            this.flete = value;
        }

        /**
         * Gets the value of the sku property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSku() {
            return sku;
        }

        /**
         * Sets the value of the sku property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSku(String value) {
            this.sku = value;
        }

        /**
         * Gets the value of the qty property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQty() {
            return qty;
        }

        /**
         * Sets the value of the qty property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQty(String value) {
            this.qty = value;
        }

    }

}
