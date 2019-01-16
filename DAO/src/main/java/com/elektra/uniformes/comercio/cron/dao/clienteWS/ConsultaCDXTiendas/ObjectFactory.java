
package com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaCDXTiendas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ConsultaCDXTiendas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NumTDA_QNAME = new QName("http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2", "Num_TDA");
    private final static QName _CD2_QNAME = new QName("http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2", "CD");
    private final static QName _NamTDA_QNAME = new QName("http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2", "Nam_TDA");
    private final static QName _NomCD_QNAME = new QName("http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2", "Nom_CD");
    private final static QName _CD1_QNAME = new QName("http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd", "CD");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ConsultaCDXTiendas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Parametro }
     * 
     */
    public Parametro createParametro() {
        return new Parametro();
    }

    /**
     * Create an instance of {@link TSalida }
     * 
     */
    public TSalida createTSalida() {
        return new TSalida();
    }

    /**
     * Create an instance of {@link TDAS }
     * 
     */
    public TDAS createTDAS() {
        return new TDAS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2", name = "Num_TDA")
    public JAXBElement<String> createNumTDA(String value) {
        return new JAXBElement<String>(_NumTDA_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2", name = "CD")
    public JAXBElement<String> createCD2(String value) {
        return new JAXBElement<String>(_CD2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2", name = "Nam_TDA")
    public JAXBElement<String> createNamTDA(String value) {
        return new JAXBElement<String>(_NamTDA_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd2", name = "Nom_CD")
    public JAXBElement<String> createNomCD(String value) {
        return new JAXBElement<String>(_NomCD_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/WS_M_CATALOG_TDA/SharedResources/SchemaDefinitions/Custom/EKT/Schema.xsd", name = "CD")
    public JAXBElement<Integer> createCD1(Integer value) {
        return new JAXBElement<Integer>(_CD1_QNAME, Integer.class, null, value);
    }

}
