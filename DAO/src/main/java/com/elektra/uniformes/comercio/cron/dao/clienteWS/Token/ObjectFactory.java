
package com.elektra.uniformes.comercio.cron.dao.clienteWS.Token;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Token package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Token
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtieneTokenRequest }
     * 
     */
    public ObtieneTokenRequest createObtieneTokenRequest() {
        return new ObtieneTokenRequest();
    }

    /**
     * Create an instance of {@link ObtieneHoraRequest }
     * 
     */
    public ObtieneHoraRequest createObtieneHoraRequest() {
        return new ObtieneHoraRequest();
    }

    /**
     * Create an instance of {@link ObtieneTokenResponse }
     * 
     */
    public ObtieneTokenResponse createObtieneTokenResponse() {
        return new ObtieneTokenResponse();
    }

    /**
     * Create an instance of {@link ObtieneHoraResponse }
     * 
     */
    public ObtieneHoraResponse createObtieneHoraResponse() {
        return new ObtieneHoraResponse();
    }

}
