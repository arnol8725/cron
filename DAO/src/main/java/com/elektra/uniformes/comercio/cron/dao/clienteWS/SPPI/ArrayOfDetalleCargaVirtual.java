
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDetalleCargaVirtual complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDetalleCargaVirtual">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetalleCargaVirtual" type="{http://tempuri.org/}DetalleCargaVirtual" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDetalleCargaVirtual", propOrder = {
    "detalleCargaVirtual"
})
public class ArrayOfDetalleCargaVirtual {

    @XmlElement(name = "DetalleCargaVirtual")
    protected List<DetalleCargaVirtual> detalleCargaVirtual;

    /**
     * Gets the value of the detalleCargaVirtual property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleCargaVirtual property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleCargaVirtual().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleCargaVirtual }
     * 
     * 
     */
    public List<DetalleCargaVirtual> getDetalleCargaVirtual() {
        if (detalleCargaVirtual == null) {
            detalleCargaVirtual = new ArrayList<DetalleCargaVirtual>();
        }
        return this.detalleCargaVirtual;
    }

}
