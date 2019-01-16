
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCatalogoServicio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCatalogoServicio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CatalogoServicio" type="{http://tempuri.org/}CatalogoServicio" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCatalogoServicio", propOrder = {
    "catalogoServicio"
})
public class ArrayOfCatalogoServicio {

    @XmlElement(name = "CatalogoServicio")
    protected List<CatalogoServicio> catalogoServicio;

    /**
     * Gets the value of the catalogoServicio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the catalogoServicio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCatalogoServicio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CatalogoServicio }
     * 
     * 
     */
    public List<CatalogoServicio> getCatalogoServicio() {
        if (catalogoServicio == null) {
            catalogoServicio = new ArrayList<CatalogoServicio>();
        }
        return this.catalogoServicio;
    }

}
