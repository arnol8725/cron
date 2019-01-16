
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDetalleCargaVirtualDistribuido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDetalleCargaVirtualDistribuido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetalleCargaVirtualDistribuido" type="{http://tempuri.org/}DetalleCargaVirtualDistribuido" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDetalleCargaVirtualDistribuido", propOrder = {
    "detalleCargaVirtualDistribuido"
})
public class ArrayOfDetalleCargaVirtualDistribuido {

    @XmlElement(name = "DetalleCargaVirtualDistribuido")
    protected List<DetalleCargaVirtualDistribuido> detalleCargaVirtualDistribuido;

    /**
     * Gets the value of the detalleCargaVirtualDistribuido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleCargaVirtualDistribuido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleCargaVirtualDistribuido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleCargaVirtualDistribuido }
     * 
     * 
     */
    public List<DetalleCargaVirtualDistribuido> getDetalleCargaVirtualDistribuido() {
        if (detalleCargaVirtualDistribuido == null) {
            detalleCargaVirtualDistribuido = new ArrayList<DetalleCargaVirtualDistribuido>();
        }
        return this.detalleCargaVirtualDistribuido;
    }

}
