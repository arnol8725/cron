
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for t_AcronimoMoneda.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="t_AcronimoMoneda">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;pattern value="[A-Z]{3}"/>
 *     &lt;enumeration value="MXN"/>
 *     &lt;enumeration value="USD"/>
 *     &lt;enumeration value="DOP"/>
 *     &lt;enumeration value="GTQ"/>
 *     &lt;enumeration value="HNL"/>
 *     &lt;enumeration value="PEN"/>
 *     &lt;enumeration value="SVC"/>
 *     &lt;enumeration value="PAB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "t_AcronimoMoneda")
@XmlEnum
public enum TAcronimoMoneda {

    MXN,
    USD,
    DOP,
    GTQ,
    HNL,
    PEN,
    SVC,
    PAB;

    public String value() {
        return name();
    }

    public static TAcronimoMoneda fromValue(String v) {
        return valueOf(v);
    }

}
