
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDetalleRealFacturacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDetalleRealFacturacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetalleRealFacturacion" type="{http://tempuri.org/}DetalleRealFacturacion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDetalleRealFacturacion", propOrder = {
    "detalleRealFacturacion"
})
public class ArrayOfDetalleRealFacturacion {

    @XmlElement(name = "DetalleRealFacturacion")
    protected List<DetalleRealFacturacion> detalleRealFacturacion;

    /**
     * Gets the value of the detalleRealFacturacion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleRealFacturacion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleRealFacturacion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleRealFacturacion }
     * 
     * 
     */
    public List<DetalleRealFacturacion> getDetalleRealFacturacion() {
        if (detalleRealFacturacion == null) {
            detalleRealFacturacion = new ArrayList<DetalleRealFacturacion>();
        }
        return this.detalleRealFacturacion;
    }

}
