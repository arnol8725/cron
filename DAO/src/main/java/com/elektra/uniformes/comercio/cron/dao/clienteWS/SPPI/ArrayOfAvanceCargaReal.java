
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAvanceCargaReal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAvanceCargaReal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AvanceCargaReal" type="{http://tempuri.org/}AvanceCargaReal" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAvanceCargaReal", propOrder = {
    "avanceCargaReal"
})
public class ArrayOfAvanceCargaReal {

    @XmlElement(name = "AvanceCargaReal")
    protected List<AvanceCargaReal> avanceCargaReal;

    /**
     * Gets the value of the avanceCargaReal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the avanceCargaReal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvanceCargaReal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AvanceCargaReal }
     * 
     * 
     */
    public List<AvanceCargaReal> getAvanceCargaReal() {
        if (avanceCargaReal == null) {
            avanceCargaReal = new ArrayList<AvanceCargaReal>();
        }
        return this.avanceCargaReal;
    }

}
