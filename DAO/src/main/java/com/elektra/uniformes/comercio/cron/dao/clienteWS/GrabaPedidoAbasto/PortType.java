
package com.elektra.uniformes.comercio.cron.dao.clienteWS.GrabaPedidoAbasto;

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
@WebService(name = "portType", targetNamespace = "http://xmlns.example.com/1379022754225")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PortType {


    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.AbastoProd.ParametroSalida
     */
    @WebMethod(operationName = "WS__VTA__MAYOREOOp", action = "/BusinessProcesses/intfWS_VTA_MAYOREO-service.serviceagent/intfwsWS_VTA_MAYOREOEndpoint3/WS__VTA__MAYOREOOp")
    @WebResult(name = "Parametro_Salida", targetNamespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Sal_mayoreo", partName = "parameters")
    public ParametroSalida wsVTAMAYOREOOp(
        @WebParam(name = "Parametros", targetNamespace = "http://esquemas.elektra.com.mx/ekt/1.0/Esq_Entr_mayoreo", partName = "parameters")
        Parametros parameters);

}
