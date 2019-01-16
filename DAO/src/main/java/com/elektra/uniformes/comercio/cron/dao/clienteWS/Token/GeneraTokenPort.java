
package com.elektra.uniformes.comercio.cron.dao.clienteWS.Token;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "GeneraTokenPort", targetNamespace = "http://generatoken.com.mx/definitions")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GeneraTokenPort {


    /**
     * 
     * @param obtieneHoraRequest
     * @return
     *     returns Token.ObtieneHoraResponse
     */
    @WebMethod(operationName = "ObtieneHora")
    @WebResult(name = "ObtieneHoraResponse", targetNamespace = "http://generatoken/schemas", partName = "ObtieneHoraResponse")
    public ObtieneHoraResponse obtieneHora(
        @WebParam(name = "ObtieneHoraRequest", targetNamespace = "http://generatoken/schemas", partName = "ObtieneHoraRequest")
        ObtieneHoraRequest obtieneHoraRequest);

    /**
     * 
     * @param obtieneTokenRequest
     * @return
     *     returns Token.ObtieneTokenResponse
     */
    @WebMethod(operationName = "ObtieneToken")
    @WebResult(name = "ObtieneTokenResponse", targetNamespace = "http://generatoken/schemas", partName = "ObtieneTokenResponse")
    public ObtieneTokenResponse obtieneToken(
        @WebParam(name = "ObtieneTokenRequest", targetNamespace = "http://generatoken/schemas", partName = "ObtieneTokenRequest")
        ObtieneTokenRequest obtieneTokenRequest);

}