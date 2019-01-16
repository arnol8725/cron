
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDetalleCargaViDistribuido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDetalleCargaViDistribuido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetalleCargaViDistribuido" type="{http://tempuri.org/}DetalleCargaViDistribuido" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDetalleCargaViDistribuido", propOrder = {
    "detalleCargaViDistribuido"
})
public class ArrayOfDetalleCargaViDistribuido {

    @XmlElement(name = "DetalleCargaViDistribuido")
    protected List<DetalleCargaViDistribuido> detalleCargaViDistribuido;

    /**
     * Gets the value of the detalleCargaViDistribuido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleCargaViDistribuido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleCargaViDistribuido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleCargaViDistribuido }
     * 
     * 
     */
    public List<DetalleCargaViDistribuido> getDetalleCargaViDistribuido() {
        if (detalleCargaViDistribuido == null) {
            detalleCargaViDistribuido = new ArrayList<DetalleCargaViDistribuido>();
        }
        return this.detalleCargaViDistribuido;
    }

}
