
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfErroresCargaReDistribuido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfErroresCargaReDistribuido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErroresCargaReDistribuido" type="{http://tempuri.org/}ErroresCargaReDistribuido" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfErroresCargaReDistribuido", propOrder = {
    "erroresCargaReDistribuido"
})
public class ArrayOfErroresCargaReDistribuido {

    @XmlElement(name = "ErroresCargaReDistribuido")
    protected List<ErroresCargaReDistribuido> erroresCargaReDistribuido;

    /**
     * Gets the value of the erroresCargaReDistribuido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the erroresCargaReDistribuido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErroresCargaReDistribuido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErroresCargaReDistribuido }
     * 
     * 
     */
    public List<ErroresCargaReDistribuido> getErroresCargaReDistribuido() {
        if (erroresCargaReDistribuido == null) {
            erroresCargaReDistribuido = new ArrayList<ErroresCargaReDistribuido>();
        }
        return this.erroresCargaReDistribuido;
    }

}
