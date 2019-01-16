
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

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
 *         &lt;element name="Proveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ano" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Mes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AvanceCargaVirtualSPPI" type="{http://tempuri.org/}ArrayOfAvanceCargaVirtual" minOccurs="0"/>
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
    "proveedor",
    "cliente",
    "servicio",
    "ano",
    "mes",
    "avanceCargaVirtualSPPI"
})
@XmlRootElement(name = "SPPITVAAvanceCargaVirtualSPPI")
public class SPPITVAAvanceCargaVirtualSPPI {

    @XmlElement(name = "Proveedor")
    protected String proveedor;
    @XmlElement(name = "Cliente")
    protected int cliente;
    @XmlElement(name = "Servicio")
    protected String servicio;
    @XmlElement(name = "Ano")
    protected int ano;
    @XmlElement(name = "Mes")
    protected int mes;
    @XmlElement(name = "AvanceCargaVirtualSPPI")
    protected ArrayOfAvanceCargaVirtual avanceCargaVirtualSPPI;

    /**
     * Gets the value of the proveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Sets the value of the proveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProveedor(String value) {
        this.proveedor = value;
    }

    /**
     * Gets the value of the cliente property.
     * 
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * Sets the value of the cliente property.
     * 
     */
    public void setCliente(int value) {
        this.cliente = value;
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
     * Gets the value of the ano property.
     * 
     */
    public int getAno() {
        return ano;
    }

    /**
     * Sets the value of the ano property.
     * 
     */
    public void setAno(int value) {
        this.ano = value;
    }

    /**
     * Gets the value of the mes property.
     * 
     */
    public int getMes() {
        return mes;
    }

    /**
     * Sets the value of the mes property.
     * 
     */
    public void setMes(int value) {
        this.mes = value;
    }

    /**
     * Gets the value of the avanceCargaVirtualSPPI property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAvanceCargaVirtual }
     *     
     */
    public ArrayOfAvanceCargaVirtual getAvanceCargaVirtualSPPI() {
        return avanceCargaVirtualSPPI;
    }

    /**
     * Sets the value of the avanceCargaVirtualSPPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAvanceCargaVirtual }
     *     
     */
    public void setAvanceCargaVirtualSPPI(ArrayOfAvanceCargaVirtual value) {
        this.avanceCargaVirtualSPPI = value;
    }

}
