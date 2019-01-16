/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.dao.modelo;
import Com.Elektra.Log.Dao.LogeoDAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/*
 * Clase implementada para la obtener el request y response de WS Tipo SOAP
 * 
 */
public class SOAPLoggingHandler implements LogicalHandler<LogicalMessageContext> {

    private static PrintStream out = System.out;
    private String XMLRequest = "";
    private String XMLResponse = "";
    
    
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(LogicalMessageContext smc) {
        logToSystemOut(smc);
        return true;
    }

    @Override
    public boolean handleFault(LogicalMessageContext smc) {
        logToSystemOut(smc);
        return true;
    }

    // nothing to clean up
    @Override
    public void close(MessageContext messageContext) {}

    /*
     * Check the MESSAGE_OUTBOUND_PROPERTY in the context
     * to see if this is an outgoing or incoming message.
     * Write a brief message to the print stream and
     * output the message. The writeTo() method can throw
     * SOAPException or IOException
     */
    private void logToSystemOut(LogicalMessageContext c) {      
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();  
        Boolean outboundProperty = (Boolean) c.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        LogicalMessage logicalMessage = c.getMessage();
        Source payload = logicalMessage.getPayload();
        //imprimir el payload
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Result result = new StreamResult(out);
            transformer.transform(payload, result);
            String XML = new String(out.toByteArray(), "UTF-8");
            if (outboundProperty) {                                
                XMLRequest = XML;
            } else {                                
                XMLResponse = "--REQUEST--\n"  + XMLRequest + "--RESPONSE--\n" + XML;
            }
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
        } 
    }

    public String getXMLRequest() {
        return XMLRequest;
    }

    public String getXMLResponse() {
        return XMLResponse;
    }
    
}