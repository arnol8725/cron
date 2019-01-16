package com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="It_Err" type="{http://tempuri.org/}ArrayOfZHRLOGERR_VNTEMP" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itErr"
})
@XmlRootElement(name = "Emp_Carga_Desc_UniformeResponse")
public class EmpCargaDescUniformeResponse {

    @XmlElement(name = "It_Err")
    protected ArrayOfZHRLOGERRVNTEMP itErr;

    /**
     * Obtiene el valor de la propiedad itErr.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfZHRLOGERRVNTEMP }
     *     
     */
    public ArrayOfZHRLOGERRVNTEMP getItErr() {
        return itErr;
    }

    /**
     * Define el valor de la propiedad itErr.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfZHRLOGERRVNTEMP }
     *     
     */
    public void setItErr(ArrayOfZHRLOGERRVNTEMP value) {
        this.itErr = value;
    }

}
