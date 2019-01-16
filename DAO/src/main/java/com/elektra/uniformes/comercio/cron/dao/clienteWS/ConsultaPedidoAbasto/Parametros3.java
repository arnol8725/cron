
package com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto;
//ParametrosEsqSalidConsulta
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Salida" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Tienda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="FolioWM" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Ref_Field_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Sku" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Cantq_Req" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Create_Date_Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Wave_Nbr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Stat_Code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Cant_Sur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Mod_Date_Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Pkt_Ctrl_Nbr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="FolRem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="FecRem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Ruta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Msg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Notadecargo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="NotadeEntrada" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="StsRemision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ObservacionesNC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ObservacionesNE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "salida"
})
@XmlRootElement(name = "Parametros", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta")
public class Parametros3 {

    @XmlElement(name = "Salida", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
    protected List<Parametros3 .Salida> salida;

    /**
     * Gets the value of the salida property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salida property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalida().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parametros3 .Salida }
     * 
     * 
     */
    public List<Parametros3 .Salida> getSalida() {
        if (salida == null) {
            salida = new ArrayList<Parametros3 .Salida>();
        }
        return this.salida;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Tienda" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="FolioWM" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Ref_Field_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Sku" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Cantq_Req" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Create_Date_Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Wave_Nbr" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Stat_Code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Cant_Sur" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Mod_Date_Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Pkt_Ctrl_Nbr" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="FolRem" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="FecRem" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Ruta" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Msg" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Notadecargo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="NotadeEntrada" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="StsRemision" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ObservacionesNC" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ObservacionesNE" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "cd",
        "tienda",
        "folioWM",
        "refField3",
        "sku",
        "descripcion",
        "cantqReq",
        "createDateTime",
        "waveNbr",
        "statCode",
        "cantSur",
        "modDateTime",
        "pktCtrlNbr",
        "folRem",
        "fecRem",
        "ruta",
        "msg",
        "notadecargo",
        "notadeEntrada",
        "stsRemision",
        "observacionesNC",
        "observacionesNE"
    })
    public static class Salida {

        @XmlElement(name = "Cd", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String cd;
        @XmlElement(name = "Tienda", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String tienda;
        @XmlElement(name = "FolioWM", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String folioWM;
        @XmlElement(name = "Ref_Field_3", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String refField3;
        @XmlElement(name = "Sku", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String sku;
        @XmlElement(name = "Descripcion", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String descripcion;
        @XmlElement(name = "Cantq_Req", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String cantqReq;
        @XmlElement(name = "Create_Date_Time", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String createDateTime;
        @XmlElement(name = "Wave_Nbr", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String waveNbr;
        @XmlElement(name = "Stat_Code", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String statCode;
        @XmlElement(name = "Cant_Sur", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String cantSur;
        @XmlElement(name = "Mod_Date_Time", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String modDateTime;
        @XmlElement(name = "Pkt_Ctrl_Nbr", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String pktCtrlNbr;
        @XmlElement(name = "FolRem", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String folRem;
        @XmlElement(name = "FecRem", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String fecRem;
        @XmlElement(name = "Ruta", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String ruta;
        @XmlElement(name = "Msg", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String msg;
        @XmlElement(name = "Notadecargo", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String notadecargo;
        @XmlElement(name = "NotadeEntrada", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String notadeEntrada;
        @XmlElement(name = "StsRemision", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String stsRemision;
        @XmlElement(name = "ObservacionesNC", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String observacionesNC;
        @XmlElement(name = "ObservacionesNE", namespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Salid_Consulta", required = true)
        protected String observacionesNE;

        /**
         * Gets the value of the cd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCd() {
            return cd;
        }

        /**
         * Sets the value of the cd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCd(String value) {
            this.cd = value;
        }

        /**
         * Gets the value of the tienda property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTienda() {
            return tienda;
        }

        /**
         * Sets the value of the tienda property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTienda(String value) {
            this.tienda = value;
        }

        /**
         * Gets the value of the folioWM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFolioWM() {
            return folioWM;
        }

        /**
         * Sets the value of the folioWM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFolioWM(String value) {
            this.folioWM = value;
        }

        /**
         * Gets the value of the refField3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRefField3() {
            return refField3;
        }

        /**
         * Sets the value of the refField3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRefField3(String value) {
            this.refField3 = value;
        }

        /**
         * Gets the value of the sku property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSku() {
            return sku;
        }

        /**
         * Sets the value of the sku property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSku(String value) {
            this.sku = value;
        }

        /**
         * Gets the value of the descripcion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * Sets the value of the descripcion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescripcion(String value) {
            this.descripcion = value;
        }

        /**
         * Gets the value of the cantqReq property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCantqReq() {
            return cantqReq;
        }

        /**
         * Sets the value of the cantqReq property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCantqReq(String value) {
            this.cantqReq = value;
        }

        /**
         * Gets the value of the createDateTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCreateDateTime() {
            return createDateTime;
        }

        /**
         * Sets the value of the createDateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCreateDateTime(String value) {
            this.createDateTime = value;
        }

        /**
         * Gets the value of the waveNbr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWaveNbr() {
            return waveNbr;
        }

        /**
         * Sets the value of the waveNbr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWaveNbr(String value) {
            this.waveNbr = value;
        }

        /**
         * Gets the value of the statCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatCode() {
            return statCode;
        }

        /**
         * Sets the value of the statCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatCode(String value) {
            this.statCode = value;
        }

        /**
         * Gets the value of the cantSur property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCantSur() {
            return cantSur;
        }

        /**
         * Sets the value of the cantSur property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCantSur(String value) {
            this.cantSur = value;
        }

        /**
         * Gets the value of the modDateTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModDateTime() {
            return modDateTime;
        }

        /**
         * Sets the value of the modDateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModDateTime(String value) {
            this.modDateTime = value;
        }

        /**
         * Gets the value of the pktCtrlNbr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPktCtrlNbr() {
            return pktCtrlNbr;
        }

        /**
         * Sets the value of the pktCtrlNbr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPktCtrlNbr(String value) {
            this.pktCtrlNbr = value;
        }

        /**
         * Gets the value of the folRem property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFolRem() {
            return folRem;
        }

        /**
         * Sets the value of the folRem property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFolRem(String value) {
            this.folRem = value;
        }

        /**
         * Gets the value of the fecRem property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFecRem() {
            return fecRem;
        }

        /**
         * Sets the value of the fecRem property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFecRem(String value) {
            this.fecRem = value;
        }

        /**
         * Gets the value of the ruta property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRuta() {
            return ruta;
        }

        /**
         * Sets the value of the ruta property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRuta(String value) {
            this.ruta = value;
        }

        /**
         * Gets the value of the msg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMsg() {
            return msg;
        }

        /**
         * Sets the value of the msg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMsg(String value) {
            this.msg = value;
        }

        /**
         * Gets the value of the notadecargo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotadecargo() {
            return notadecargo;
        }

        /**
         * Sets the value of the notadecargo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotadecargo(String value) {
            this.notadecargo = value;
        }

        /**
         * Gets the value of the notadeEntrada property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotadeEntrada() {
            return notadeEntrada;
        }

        /**
         * Sets the value of the notadeEntrada property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotadeEntrada(String value) {
            this.notadeEntrada = value;
        }

        /**
         * Gets the value of the stsRemision property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStsRemision() {
            return stsRemision;
        }

        /**
         * Sets the value of the stsRemision property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStsRemision(String value) {
            this.stsRemision = value;
        }

        /**
         * Gets the value of the observacionesNC property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObservacionesNC() {
            return observacionesNC;
        }

        /**
         * Sets the value of the observacionesNC property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObservacionesNC(String value) {
            this.observacionesNC = value;
        }

        /**
         * Gets the value of the observacionesNE property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObservacionesNE() {
            return observacionesNE;
        }

        /**
         * Sets the value of the observacionesNE property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObservacionesNE(String value) {
            this.observacionesNE = value;
        }

    }

}
