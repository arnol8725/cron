package com.elektra.uniformes.comercio.cron.dao.clienteWS.DescuentosSap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Srv_Desc", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://10.50.179.18:90/WebServiceSap_Desc/Srv_Desc.asmx?WSDL")
public class SrvDesc
    extends Service
{

    private final static URL SRVDESC_WSDL_LOCATION;
    private final static WebServiceException SRVDESC_EXCEPTION;
    private final static QName SRVDESC_QNAME = new QName("http://tempuri.org/", "Srv_Desc");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://10.50.179.18:90/WebServiceSap_Desc/Srv_Desc.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SRVDESC_WSDL_LOCATION = url;
        SRVDESC_EXCEPTION = e;
    }

    public SrvDesc() {
        super(__getWsdlLocation(), SRVDESC_QNAME);
    }

//    public SrvDesc(WebServiceFeature... features) {
//        super(__getWsdlLocation(), SRVDESC_QNAME, features);
//    }

    public SrvDesc(URL wsdlLocation) {
        super(wsdlLocation, SRVDESC_QNAME);
    }

//    public SrvDesc(URL wsdlLocation, WebServiceFeature... features) {
//        super(wsdlLocation, SRVDESC_QNAME, features);
//    }

    public SrvDesc(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

//    public SrvDesc(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
//        super(wsdlLocation, serviceName, features);
//    }

    /**
     * 
     * @return
     *     returns SrvDescSoap
     */
    @WebEndpoint(name = "Srv_DescSoap")
    public SrvDescSoap getSrvDescSoap() {
        return super.getPort(new QName("http://tempuri.org/", "Srv_DescSoap"), SrvDescSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SrvDescSoap
     */
    @WebEndpoint(name = "Srv_DescSoap")
    public SrvDescSoap getSrvDescSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Srv_DescSoap"), SrvDescSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SRVDESC_EXCEPTION!= null) {
            throw SRVDESC_EXCEPTION;
        }
        return SRVDESC_WSDL_LOCATION;
    }

}