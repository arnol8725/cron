
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cargaReal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cargaReal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmpresaClienteId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CompaniaClienteId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CentroCliente" type="{http://conectorunico/schemas}t_CentroCliente"/>
 *         &lt;element name="Importe" type="{http://conectorunico/schemas}t_Importe"/>
 *         &lt;element name="NumEmpleado" type="{http://conectorunico/schemas}t_NumEmpleado"/>
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cargaReal", propOrder = {
    "empresaClienteId",
    "companiaClienteId",
    "centroCliente",
    "importe",
    "numEmpleado",
    "descripcion"
})
public class CargaReal {

    @XmlElement(name = "EmpresaClienteId", required = true)
    protected String empresaClienteId;
    @XmlElement(name = "CompaniaClienteId", required = true)
    protected String companiaClienteId;
    @XmlElement(name = "CentroCliente", required = true)
    protected String centroCliente;
    @XmlElement(name = "Importe", required = true)
    protected BigDecimal importe;
    @XmlElement(name = "NumEmpleado", required = true)
    protected String numEmpleado;
    @XmlElement(name = "Descripcion", required = true)
    protected String descripcion;

    /**
     * Gets the value of the empresaClienteId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpresaClienteId() {
        return empresaClienteId;
    }

    /**
     * Sets the value of the empresaClienteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpresaClienteId(String value) {
        this.empresaClienteId = value;
    }

    /**
     * Gets the value of the companiaClienteId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompaniaClienteId() {
        return companiaClienteId;
    }

    /**
     * Sets the value of the companiaClienteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompaniaClienteId(String value) {
        this.companiaClienteId = value;
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
     * Gets the value of the importe property.
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
     * Sets the value of the importe property.
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
     * Gets the value of the numEmpleado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumEmpleado() {
        return numEmpleado;
    }

    /**
     * Sets the value of the numEmpleado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumEmpleado(String value) {
        this.numEmpleado = value;
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

}
