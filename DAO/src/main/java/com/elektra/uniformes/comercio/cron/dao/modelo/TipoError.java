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
public class TipoError {
    
    @PropiedadMap(id=true, campo="FIIDERROR")
    private int noIDError; 
    
    @PropiedadMap(campo="FCDESCRIPCION")
    private String cadenaDescripcion; 

    public int getNoIDError() {
        return noIDError;
    }

    public void setNoIDError(int noIDError) {
        this.noIDError = noIDError;
    }

    public String getCadenaDescripcion() {
        return cadenaDescripcion;
    }

    public void setCadenaDescripcion(String cadenaDescripcion) {
        this.cadenaDescripcion = cadenaDescripcion;
    }

}
