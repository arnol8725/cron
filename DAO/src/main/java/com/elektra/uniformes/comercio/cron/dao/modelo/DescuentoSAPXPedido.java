/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.dao.modelo;

import com.elektra.mapper.anotaciones.PropiedadMap;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DescuentoSAPXPedido {
    
    @PropiedadMap(campo="FCSOCIEDAD")
    private String cadenaSociedad;
    
    @PropiedadMap(campo="FCREFERENCIA")    
    private String cadenaReferencia; 
    
    @PropiedadMap(campo="FCCNOMINA")
    private String cadenaNomina;  
    
    @PropiedadMap(campo="FCTOTAL")
    private String presicionTotal;  
    
    @PropiedadMap(campo="FDFECHAPAGO")
    private String fdFechaPago;    
    
    @PropiedadMap(campo="FCSEMACTUAL")
    private String noSemanaActual; 
    
    @PropiedadMap(campo="FCSALDO")
    private String precisionSaldo;
    
    @PropiedadMap(campo="FCPAGO")
    private String precisionPago;    
    
    @PropiedadMap(campo="FCNOEMPLEADO")
    private String cadenaNumeroEmpleado;
    
    public int getNoFolioSolicitud() {
        return Integer.parseInt(this.cadenaReferencia.split("-")[0]);
    }

    public int getNoPedido() {
        return Integer.parseInt(this.cadenaReferencia.split("-")[1]);
    }

    public String getCadenaSociedad() {
        return cadenaSociedad;
    }

    public void setCadenaSociedad(String cadenaSociedad) {
        this.cadenaSociedad = cadenaSociedad;
    }

    public String getCadenaReferencia() {
        return cadenaReferencia;
    }

    public void setCadenaReferencia(String cadenaReferencia) {
        this.cadenaReferencia = cadenaReferencia;
    }

    public String getCadenaNomina() {
        return cadenaNomina;
    }

    public void setCadenaNomina(String cadenaNomina) {
        this.cadenaNomina = cadenaNomina;
    }

    public BigDecimal getPresicionTotal() {
        return new BigDecimal(presicionTotal);
    }

    public void setPresicionTotal(String presicionTotal) {
        this.presicionTotal = presicionTotal;
    }

    public java.sql.Date getFdFechaPago() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = format.parse(fdFechaPago);
        return new java.sql.Date(parsed.getTime());
    }

    public void setFdFechaPago(String fdFechaPago) {
        this.fdFechaPago = fdFechaPago;
    }

    public int getNoSemanaActual() {        
        return Integer.parseInt(noSemanaActual.substring(4,6));
    }

    public void setNoSemanaActual(String noSemanaActual) {
        this.noSemanaActual = noSemanaActual;
    }

    public BigDecimal getPrecisionSaldo() {
        return new BigDecimal(precisionSaldo);
    }

    public void setPrecisionSaldo(String precisionSaldo) {
        this.precisionSaldo = precisionSaldo;
    }

    public BigDecimal getPrecisionPago() {
        return new BigDecimal(precisionPago);
    }

    public void setPrecisionPago(String precisionPago) {
        this.precisionPago = precisionPago;
    }

    public String getCadenaNumeroEmpleado() {
        return cadenaNumeroEmpleado;
    }

    public void setCadenaNumeroEmpleado(String cadenaNumeroEmpleado) {
        this.cadenaNumeroEmpleado = cadenaNumeroEmpleado;
    }
                                  
}
