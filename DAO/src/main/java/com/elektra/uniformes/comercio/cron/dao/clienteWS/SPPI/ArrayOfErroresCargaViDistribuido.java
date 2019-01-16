
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfErroresCargaViDistribuido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfErroresCargaViDistribuido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErroresCargaViDistribuido" type="{http://tempuri.org/}ErroresCargaViDistribuido" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfErroresCargaViDistribuido", propOrder = {
    "erroresCargaViDistribuido"
})
public class ArrayOfErroresCargaViDistribuido {

    @XmlElement(name = "ErroresCargaViDistribuido")
    protected List<ErroresCargaViDistribuido> erroresCargaViDistribuido;

    /**
     * Gets the value of the erroresCargaViDistribuido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the erroresCargaViDistribuido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErroresCargaViDistribuido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErroresCargaViDistribuido }
     * 
     * 
     */
    public List<ErroresCargaViDistribuido> getErroresCargaViDistribuido() {
        if (erroresCargaViDistribuido == null) {
            erroresCargaViDistribuido = new ArrayList<ErroresCargaViDistribuido>();
        }
        return this.erroresCargaViDistribuido;
    }

}
