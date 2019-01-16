
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDetalleDisponible complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDetalleDisponible">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetalleDisponible" type="{http://tempuri.org/}DetalleDisponible" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDetalleDisponible", propOrder = {
    "detalleDisponible"
})
public class ArrayOfDetalleDisponible {

    @XmlElement(name = "DetalleDisponible")
    protected List<DetalleDisponible> detalleDisponible;

    /**
     * Gets the value of the detalleDisponible property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleDisponible property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleDisponible().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleDisponible }
     * 
     * 
     */
    public List<DetalleDisponible> getDetalleDisponible() {
        if (detalleDisponible == null) {
            detalleDisponible = new ArrayList<DetalleDisponible>();
        }
        return this.detalleDisponible;
    }

}
