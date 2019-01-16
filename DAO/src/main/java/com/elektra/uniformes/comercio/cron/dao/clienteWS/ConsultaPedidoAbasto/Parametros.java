
package com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto;
//esq_salid_ped_cent_consul_uniformes
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
 *         &lt;element name="detalle" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="canal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="id_tienda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tienda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="almacen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="cliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="pedido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="status_pedido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fecha_cancelacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tipo_entrega" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tipo_venta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tipo_pedido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fecha_entrega" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fecha_creacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sku" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="cantidad_req" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="num_remision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fecha_remision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="status_remision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fecha_conf_remision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="carga" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ruta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "detalle"
})
@XmlRootElement(name = "Parametros", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes")
public class Parametros {

    @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
    protected List<Parametros.Detalle> detalle;

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
     * {@link Parametros.Detalle }
     * 
     * 
     */
    public List<Parametros.Detalle> getDetalle() {
        if (detalle == null) {
            detalle = new ArrayList<Parametros.Detalle>();
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
     *         &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="canal" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="id_tienda" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tienda" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="almacen" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="cliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="pedido" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="status_pedido" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fecha_cancelacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tipo_entrega" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tipo_venta" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tipo_pedido" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fecha_entrega" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fecha_creacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="sku" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="cantidad_req" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="num_remision" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fecha_remision" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="status_remision" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fecha_conf_remision" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="carga" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ruta" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "pais",
        "canal",
        "idTienda",
        "tienda",
        "almacen",
        "cliente",
        "pedido",
        "statusPedido",
        "fechaCancelacion",
        "tipoEntrega",
        "tipoVenta",
        "tipoPedido",
        "fechaEntrega",
        "fechaCreacion",
        "sku",
        "cantidadReq",
        "numRemision",
        "fechaRemision",
        "statusRemision",
        "fechaConfRemision",
        "carga",
        "ruta",
        "mensaje"
    })
    public static class Detalle {

        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String pais;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String canal;
        @XmlElement(name = "id_tienda", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String idTienda;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String tienda;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String almacen;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String cliente;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String pedido;
        @XmlElement(name = "status_pedido", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String statusPedido;
        @XmlElement(name = "fecha_cancelacion", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String fechaCancelacion;
        @XmlElement(name = "tipo_entrega", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String tipoEntrega;
        @XmlElement(name = "tipo_venta", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String tipoVenta;
        @XmlElement(name = "tipo_pedido", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String tipoPedido;
        @XmlElement(name = "fecha_entrega", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String fechaEntrega;
        @XmlElement(name = "fecha_creacion", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String fechaCreacion;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String sku;
        @XmlElement(name = "cantidad_req", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String cantidadReq;
        @XmlElement(name = "num_remision", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String numRemision;
        @XmlElement(name = "fecha_remision", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String fechaRemision;
        @XmlElement(name = "status_remision", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String statusRemision;
        @XmlElement(name = "fecha_conf_remision", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String fechaConfRemision;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String carga;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String ruta;
        @XmlElement(namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Ped_Cent_Consul_Uniformes", required = true)
        protected String mensaje;

        /**
         * Gets the value of the pais property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPais() {
            return pais;
        }

        /**
         * Sets the value of the pais property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPais(String value) {
            this.pais = value;
        }

        /**
         * Gets the value of the canal property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCanal() {
            return canal;
        }

        /**
         * Sets the value of the canal property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCanal(String value) {
            this.canal = value;
        }

        /**
         * Gets the value of the idTienda property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdTienda() {
            return idTienda;
        }

        /**
         * Sets the value of the idTienda property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdTienda(String value) {
            this.idTienda = value;
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
         * Gets the value of the almacen property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAlmacen() {
            return almacen;
        }

        /**
         * Sets the value of the almacen property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAlmacen(String value) {
            this.almacen = value;
        }

        /**
         * Gets the value of the cliente property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCliente() {
            return cliente;
        }

        /**
         * Sets the value of the cliente property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCliente(String value) {
            this.cliente = value;
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

        /**
         * Gets the value of the statusPedido property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatusPedido() {
            return statusPedido;
        }

        /**
         * Sets the value of the statusPedido property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatusPedido(String value) {
            this.statusPedido = value;
        }

        /**
         * Gets the value of the fechaCancelacion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaCancelacion() {
            return fechaCancelacion;
        }

        /**
         * Sets the value of the fechaCancelacion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaCancelacion(String value) {
            this.fechaCancelacion = value;
        }

        /**
         * Gets the value of the tipoEntrega property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipoEntrega() {
            return tipoEntrega;
        }

        /**
         * Sets the value of the tipoEntrega property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipoEntrega(String value) {
            this.tipoEntrega = value;
        }

        /**
         * Gets the value of the tipoVenta property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipoVenta() {
            return tipoVenta;
        }

        /**
         * Sets the value of the tipoVenta property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipoVenta(String value) {
            this.tipoVenta = value;
        }

        /**
         * Gets the value of the tipoPedido property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipoPedido() {
            return tipoPedido;
        }

        /**
         * Sets the value of the tipoPedido property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipoPedido(String value) {
            this.tipoPedido = value;
        }

        /**
         * Gets the value of the fechaEntrega property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaEntrega() {
            return fechaEntrega;
        }

        /**
         * Sets the value of the fechaEntrega property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaEntrega(String value) {
            this.fechaEntrega = value;
        }

        /**
         * Gets the value of the fechaCreacion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaCreacion() {
            return fechaCreacion;
        }

        /**
         * Sets the value of the fechaCreacion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaCreacion(String value) {
            this.fechaCreacion = value;
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
         * Gets the value of the cantidadReq property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCantidadReq() {
            return cantidadReq;
        }

        /**
         * Sets the value of the cantidadReq property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCantidadReq(String value) {
            this.cantidadReq = value;
        }

        /**
         * Gets the value of the numRemision property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumRemision() {
            return numRemision;
        }

        /**
         * Sets the value of the numRemision property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumRemision(String value) {
            this.numRemision = value;
        }

        /**
         * Gets the value of the fechaRemision property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaRemision() {
            return fechaRemision;
        }

        /**
         * Sets the value of the fechaRemision property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaRemision(String value) {
            this.fechaRemision = value;
        }

        /**
         * Gets the value of the statusRemision property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatusRemision() {
            return statusRemision;
        }

        /**
         * Sets the value of the statusRemision property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatusRemision(String value) {
            this.statusRemision = value;
        }

        /**
         * Gets the value of the fechaConfRemision property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaConfRemision() {
            return fechaConfRemision;
        }

        /**
         * Sets the value of the fechaConfRemision property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaConfRemision(String value) {
            this.fechaConfRemision = value;
        }

        /**
         * Gets the value of the carga property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCarga() {
            return carga;
        }

        /**
         * Sets the value of the carga property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCarga(String value) {
            this.carga = value;
        }

        /**
         * Gets the value of the ruta property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRuta() {
            return ruta;
        }

        /**
         * Sets the value of the ruta property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRuta(String value) {
            this.ruta = value;
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

    }

}
