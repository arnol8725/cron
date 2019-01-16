/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao.modelo;

import com.elektra.uniformes.comercio.cron.dao.clienteWS.ConsultaPedidoAbasto.Parametros3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class NotaCargoEntrada {
    
    private int noFolioSolicitud;
    private int noIDDetalle;
    private int noPais;
    private int noCanal;
    private int noCD;
    private int noTienda;
    private String cadenaFolioWM;
    private int noPedido;
    private int noSKU;
    private String cadenaDescripcion;
    private int noCantidadRequerida;
    private String fdFechaCreado;
    private String cadenaWaveNBR;
    private String cadenaEstatus;
    private int noCantidadSurtida;
    private String cadenaFechaActualizacion;
    private String cadenaPKT_CTRL_NBR;
    private int noFolioRemision;
    private String fdFechaRemision;
    private int noRuta;
    private String cadenaMensaje;
    private int noNotaCargo;
    private int noNotaEntrada;
    private String cadenaDescripcionRemision;
    private String cadenaObservacionesNC;
    private String cadenaObservacionesNE;
    private String cadenaXMLResponse;
    private int noEstatusSol;
    private boolean error;
    private String msjError;

    public NotaCargoEntrada() {}
        
    /**
     * Valida
     * @param salida
     * @param solicitud
     * @param solicitudDetalle 
     * @param cadenaXMLResponse 
     */
    public NotaCargoEntrada(Parametros3.Salida salida, SolicitudDTO solicitud, SolicitudDetalle solicitudDetalle, String cadenaXMLResponse){
        this.noFolioSolicitud = solicitud.getNoFolioSolicitud();                        //FIFOLIOSOLICITUD
        this.noIDDetalle = solicitudDetalle.getNoIDDetalle();                           //FIIDDETALLE
        this.noPais = solicitud.getNoPais();                                            //FIPAIS
        this.noCanal = solicitud.getNoCanal();                                          //FICANAL
        this.noPedido = solicitudDetalle.getNoPedido();                                 //FIPEDIDO
        this.noTienda = this.regresaNumero(salida.getTienda());                         //FISUCURSAL   
        this.noSKU = solicitudDetalle.getNoSKU();                                       //FISKU
        this.noCantidadRequerida = solicitudDetalle.getNoCantidad();                    //FICANTIDADREQ        
        this.noCantidadSurtida = this.regresaNumero(salida.getCantSur());               //FICANTIDADSURT       
        this.noFolioRemision = this.regresaNumero(salida.getFolRem());                  //FIFOLIOREMISION
        this.fdFechaRemision = salida.getFecRem();                                      //FDFECHAREMISION
        this.noRuta = this.regresaNumero(salida.getRuta());                             //FIRUTA
        this.noNotaCargo = this.regresaNumero(salida.getNotadecargo());                 //FINOTACARGO
        this.noNotaEntrada = this.regresaNumero(salida.getNotadeEntrada());             //FINOTAENTRADA
        this.cadenaDescripcionRemision = this.regresaCadena(salida.getStsRemision());   //FCESTREMISION
        this.cadenaObservacionesNC = this.regresaCadena(salida.getObservacionesNC());   //FCOBSERVACIONESNC
        this.cadenaObservacionesNE = this.regresaCadena(salida.getObservacionesNE());   //FCOBSERVACIONESNE
        this.cadenaFechaActualizacion = this.regresaCadena(salida.getModDateTime());    //FCFECHAACTCD
        this.cadenaXMLResponse = cadenaXMLResponse;                                     //FCXMLRESPONSE            
        this.noEstatusSol = solicitudDetalle.getNoEstatusSol();                         //FIESTATUSSOL
        this.noCD = this.regresaNumero(salida.getCd());                                 //FICD
        this.cadenaFolioWM = this.regresaCadena(salida.getFolioWM());                   //FCFOLIOWM
        this.cadenaDescripcion = this.regresaCadena(salida.getDescripcion());
        this.fdFechaCreado = salida.getCreateDateTime();
        this.cadenaWaveNBR = salida.getWaveNbr();
        this.cadenaEstatus = salida.getStatCode();
        this.cadenaPKT_CTRL_NBR = salida.getPktCtrlNbr();
        this.cadenaMensaje = salida.getMsg();
    }

    public int getNoFolioSolicitud() {
        return noFolioSolicitud;
    }

    public void setNoFolioSolicitud(int noFolioSolicitud) {
        this.noFolioSolicitud = noFolioSolicitud;
    }

    public int getNoIDDetalle() {
        return noIDDetalle;
    }

    public void setNoIDDetalle(int noIDDetalle) {
        this.noIDDetalle = noIDDetalle;
    }

    public int getNoPais() {
        return noPais;
    }

    public void setNoPais(int noPais) {
        this.noPais = noPais;
    }

    public int getNoCanal() {
        return noCanal;
    }

    public void setNoCanal(int noCanal) {
        this.noCanal = noCanal;
    }

    public int getNoFolioRemision() {
        return noFolioRemision;
    }

    public void setNoFolioRemision(int noFolioRemision) {
        this.noFolioRemision = noFolioRemision;
    }

    public int getNoCD() {
        return noCD;
    }

    public void setNoCD(int noCD) {
        this.noCD = noCD;
    }
   
    public int getNoTienda() {
        return noTienda;
    }

    public void setNoTienda(int noTienda) {
        this.noTienda = noTienda;
    }



    public int getNoPedido() {
        return noPedido;
    }

    public void setNoPedido(int noPedido) {
        this.noPedido = noPedido;
    }

    public int getNoSKU() {
        return noSKU;
    }

    public void setNoSKU(int noSKU) {
        this.noSKU = noSKU;
    }

    public String getCadenaDescripcion() {
        return cadenaDescripcion;
    }

    public void setCadenaDescripcion(String cadenaDescripcion) {
        this.cadenaDescripcion = cadenaDescripcion;
    }

    public int getNoCantidadRequerida() {
        return noCantidadRequerida;
    }

    public void setNoCantidadRequerida(int noCantidadRequerida) {
        this.noCantidadRequerida = noCantidadRequerida;
    }

    public String getCadenaWaveNBR() {
        return cadenaWaveNBR;
    }

    public void setCadenaWaveNBR(String cadenaWaveNBR) {
        this.cadenaWaveNBR = cadenaWaveNBR;
    }

    public String getCadenaEstatus() {
        return cadenaEstatus;
    }

    public void setCadenaEstatus(String cadenaEstatus) {
        this.cadenaEstatus = cadenaEstatus;
    }

    public int getNoCantidadSurtida() {
        return noCantidadSurtida;
    }

    public void setNoCantidadSurtida(int noCantidadSurtida) {
        this.noCantidadSurtida = noCantidadSurtida;
    }

    public String getCadenaFechaActualizacion() {
        return cadenaFechaActualizacion;
    }

    public void setCadenaFechaActualizacion(String cadenaFechaActualizacion) {
        this.cadenaFechaActualizacion = cadenaFechaActualizacion;
    }

    public String getCadenaPKT_CTRL_NBR() {
        return cadenaPKT_CTRL_NBR;
    }

    public void setCadenaPKT_CTRL_NBR(String cadenaPKT_CTRL_NBR) {
        this.cadenaPKT_CTRL_NBR = cadenaPKT_CTRL_NBR;
    }

    public int getNoRuta() {
        return noRuta;
    }

    public void setNoRuta(int noRuta) {
        this.noRuta = noRuta;
    }

    public String getCadenaMensaje() {
        return cadenaMensaje;
    }

    public void setCadenaMensaje(String cadenaMensaje) {
        this.cadenaMensaje = cadenaMensaje;
    }

    public int getNoNotaCargo() {
        return noNotaCargo;
    }

    public void setNoNotaCargo(int noNotaCargo) {
        this.noNotaCargo = noNotaCargo;
    }

    public int getNoNotaEntrada() {
        return noNotaEntrada;
    }

    public void setNoNotaEntrada(int noNotaEntrada) {
        this.noNotaEntrada = noNotaEntrada;
    }

    public String getCadenaDescripcionRemision() {
        return cadenaDescripcionRemision;
    }

    public void setCadenaDescripcionRemision(String cadenaDescripcionRemision) {
        this.cadenaDescripcionRemision = cadenaDescripcionRemision;
    }

    public String getCadenaObservacionesNC() {
        return cadenaObservacionesNC;
    }

    public void setCadenaObservacionesNC(String cadenaObservacionesNC) {
        this.cadenaObservacionesNC = cadenaObservacionesNC;
    }

    public String getCadenaObservacionesNE() {
        return cadenaObservacionesNE;
    }

    public void setCadenaObservacionesNE(String cadenaObservacionesNE) {
        this.cadenaObservacionesNE = cadenaObservacionesNE;
    }
    
    public java.sql.Date getFdFechaCreado() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed = format.parse(fdFechaCreado);
        return new java.sql.Date(parsed.getTime());
    }

    public void setFdFechaCreado(String fdFechaCreado) {
        this.fdFechaCreado = fdFechaCreado;
    }
    
    public java.sql.Date getFdFechaRemision() {
        java.sql.Date fecha = null;
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date parsed = format.parse(fdFechaRemision);
            fecha = new java.sql.Date(parsed.getTime()); 
        }catch(ParseException pe){
            fecha = null;
        }
        return fecha;
    }

    public void setFdFechaRemision(String fdFechaRemision) {
        this.fdFechaRemision = fdFechaRemision;
    }
    
    public int regresaNumero(String string) {
        try {           
            return Integer.valueOf(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    
    public String regresaCadena(String cadena){
        String espacio = " ";
        if(cadena.equals("") || cadena == null){
            return espacio;
        }else{
            return cadena;
        }
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMsjError() {
        return msjError;
    }

    public void setMsjError(String msjError) {
        this.msjError = msjError;
    }

    public String getCadenaXMLResponse() {
        return cadenaXMLResponse;
    }

    public void setCadenaXMLResponse(String cadenaXMLResponse) {
        this.cadenaXMLResponse = cadenaXMLResponse;
    }

    public int getNoEstatusSol() {
        return noEstatusSol;
    }

    public void setNoEstatusSol(int noEstatusSol) {
        this.noEstatusSol = noEstatusSol;
    }

    public String getCadenaFolioWM() {
        return cadenaFolioWM;
    }

    public void setCadenaFolioWM(String cadenaFolioWM) {
        this.cadenaFolioWM = cadenaFolioWM;
    }
    
}
