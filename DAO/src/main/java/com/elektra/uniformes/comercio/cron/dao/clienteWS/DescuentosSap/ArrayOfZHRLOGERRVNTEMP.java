
package com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfZHRLOGERR_VNTEMP complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfZHRLOGERR_VNTEMP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ZHRLOGERR_VNTEMP" type="{http://tempuri.org/}ZHRLOGERR_VNTEMP" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfZHRLOGERR_VNTEMP", propOrder = {
    "zhrlogerrvntemp"
})
public class ArrayOfZHRLOGERRVNTEMP {

    @XmlElement(name = "ZHRLOGERR_VNTEMP", nillable = true)
    protected List<ZHRLOGERRVNTEMP> zhrlogerrvntemp;

    /**
     * Gets the value of the zhrlogerrvntemp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zhrlogerrvntemp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZHRLOGERRVNTEMP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZHRLOGERRVNTEMP }
     * 
     * 
     */
    public List<ZHRLOGERRVNTEMP> getZHRLOGERRVNTEMP() {
        if (zhrlogerrvntemp == null) {
            zhrlogerrvntemp = new ArrayList<ZHRLOGERRVNTEMP>();
        }
        return this.zhrlogerrvntemp;
    }

}
