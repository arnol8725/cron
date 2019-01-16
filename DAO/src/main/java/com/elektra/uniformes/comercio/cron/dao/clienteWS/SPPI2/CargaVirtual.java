
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cargaVirtual complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cargaVirtual">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CentroProveedor" type="{http://conectorunico/schemas}t_CentroProveedor"/>
 *         &lt;element name="Servicio" type="{http://conectorunico/schemas}t_Servicio"/>
 *         &lt;element name="Compania" type="{http://conectorunico/schemas}t_Compania"/>
 *         &lt;element name="CentroCliente" type="{http://conectorunico/schemas}t_CentroCliente"/>
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Proyecto" type="{http://conectorunico/schemas}t_Proyecto"/>
 *         &lt;element name="UnidadNegocio" type="{http://conectorunico/schemas}t_UnidadNegocio"/>
 *         &lt;element name="MontoCantidad" type="{http://conectorunico/schemas}t_Importe"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cargaVirtual", propOrder = {
    "centroProveedor",
    "servicio",
    "compania",
    "centroCliente",
    "descripcion",
    "proyecto",
    "unidadNegocio",
    "montoCantidad"
})
public class CargaVirtual {

    @XmlElement(name = "CentroProveedor", required = true)
    protected String centroProveedor;
    @XmlElement(name = "Servicio", required = true)
    protected String servicio;
    @XmlElement(name = "Compania")
    protected int compania;
    @XmlElement(name = "CentroCliente", required = true)
    protected String centroCliente;
    @XmlElement(name = "Descripcion", required = true)
    protected String descripcion;
    @XmlElement(name = "Proyecto")
    protected int proyecto;
    @XmlElement(name = "UnidadNegocio")
    protected int unidadNegocio;
    @XmlElement(name = "MontoCantidad", required = true)
    protected BigDecimal montoCantidad;

    /**
     * Gets the value of the centroProveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroProveedor() {
        return centroProveedor;
    }

    /**
     * Sets the value of the centroProveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroProveedor(String value) {
        this.centroProveedor = value;
    }

    /**
     * Gets the value of the servicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicio() {
        return servicio;
    }

    /**
     * Sets the value of the servicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicio(String value) {
        this.servicio = value;
    }

    /**
     * Gets the value of the compania property.
     * 
     */
    public int getCompania() {
        return compania;
    }

    /**
     * Sets the value of the compania property.
     * 
     */
    public void setCompania(int value) {
        this.compania = value;
    }

    /**
     * Gets the value of the centroCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroCliente() {
        return centroCliente;
    }

    /**
     * Sets the value of the centroCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroCliente(String value) {
        this.centroCliente = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the proyecto property.
     * 
     */
    public int getProyecto() {
        return proyecto;
    }

    /**
     * Sets the value of the proyecto property.
     * 
     */
    public void setProyecto(int value) {
        this.proyecto = value;
    }

    /**
     * Gets the value of the unidadNegocio property.
     * 
     */
    public int getUnidadNegocio() {
        return unidadNegocio;
    }

    /**
     * Sets the value of the unidadNegocio property.
     * 
     */
    public void setUnidadNegocio(int value) {
        this.unidadNegocio = value;
    }

    /**
     * Gets the value of the montoCantidad property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoCantidad() {
        return montoCantidad;
    }

    /**
     * Sets the value of the montoCantidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoCantidad(BigDecimal value) {
        this.montoCantidad = value;
    }

}
