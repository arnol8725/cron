
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ConectorUnico", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://10.50.92.35/WsConectorUnicoQA/ConectorUnico/ConectorUnico.asmx?WSDL")
public class ConectorUnico
    extends Service
{

    private final static URL CONECTORUNICO_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.ConectorUnico.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.ConectorUnico.class.getResource(".");
            url = new URL(baseUrl, "http://10.50.92.35/WsConectorUnicoQA/ConectorUnico/ConectorUnico.asmx?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://10.50.92.35/WsConectorUnicoQA/ConectorUnico/ConectorUnico.asmx?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CONECTORUNICO_WSDL_LOCATION = url;
    }

    public ConectorUnico(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConectorUnico() {
        super(CONECTORUNICO_WSDL_LOCATION, new QName("http://tempuri.org/", "ConectorUnico"));
    }

    /**
     * 
     * @return
     *     returns ConectorUnicoSoap
     */
    @WebEndpoint(name = "ConectorUnicoSoap")
    public ConectorUnicoSoap getConectorUnicoSoap() {
        return super.getPort(new QName("http://tempuri.org/", "ConectorUnicoSoap"), ConectorUnicoSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConectorUnicoSoap
     */
    @WebEndpoint(name = "ConectorUnicoSoap")
    public ConectorUnicoSoap getConectorUnicoSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "ConectorUnicoSoap"), ConectorUnicoSoap.class, features);
    }

}