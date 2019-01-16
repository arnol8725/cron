/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.dao.modelo;

import com.elektra.mapper.anotaciones.PropiedadMap;


public class TiendaDirIP {
    
    @PropiedadMap(campo="FITIENDAID",id=true)
    private int noTiendaID;
    
    @PropiedadMap(campo="FIPAISID",id=true)
    private int noPaisID;
    
    @PropiedadMap(campo="FICANAL",id=true)
    private int noCanal;
    
    @PropiedadMap(campo="FICANALCECO",id=true)
    private int noCanalCeco;
    
    @PropiedadMap(campo="FCDESCRIPCION")
    private String cadenaDescripcion;
    
    @PropiedadMap(campo="FCDIRECCIONIP")
    private String cadenaDireccionIP;

    public int getNoTiendaID() {
        return noTiendaID;
    }

    public void setNoTiendaID(int noTiendaID) {
        this.noTiendaID = noTiendaID;
    }

    public int getNoPaisID() {
        return noPaisID;
    }

    public void setNoPaisID(int noPaisID) {
        this.noPaisID = noPaisID;
    }

    public int getNoCanal() {
        return noCanal;
    }

    public void setNoCanal(int noCanal) {
        this.noCanal = noCanal;
    }

    public int getNoCanalCeco() {
        return noCanalCeco;
    }

    public void setNoCanalCeco(int noCanalCeco) {
        this.noCanalCeco = noCanalCeco;
    }

    public String getCadenaDescripcion() {
        return cadenaDescripcion;
    }

    public void setCadenaDescripcion(String cadenaDescripcion) {
        this.cadenaDescripcion = cadenaDescripcion;
    }

    public String getCadenaDireccionIP() {
        return cadenaDireccionIP;
    }

    public void setCadenaDireccionIP(String cadenaDireccionIP) {
        this.cadenaDireccionIP = cadenaDireccionIP;
    }
        
}
