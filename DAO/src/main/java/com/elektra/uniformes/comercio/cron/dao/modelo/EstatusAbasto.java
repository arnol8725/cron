/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao.modelo;

import com.elektra.mapper.anotaciones.PropiedadMap;

/**
 *
 * @author User
 */
public class EstatusAbasto {
    
    @PropiedadMap(id=true, campo="FIESTATUS")
    private int noEstatus; 
    
    @PropiedadMap(campo="FCMENSAJE")
    private String cadenaMensaje; 

    public int getNoEstatus() {
        return noEstatus;
    }

    public void setNoEstatus(int noEstatus) {
        this.noEstatus = noEstatus;
    }

    public String getCadenaMensaje() {
        return cadenaMensaje;
    }

    public void setCadenaMensaje(String cadenaMensaje) {
        this.cadenaMensaje = cadenaMensaje;
    }
    
}
