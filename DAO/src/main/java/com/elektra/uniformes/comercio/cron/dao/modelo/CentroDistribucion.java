/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao.modelo;

import com.elektra.mapper.anotaciones.PropiedadMap;

/**
 *
 * @author lrodriguez
 */
public class CentroDistribucion {
    
    @PropiedadMap(id=true, campo="FIPAIS")
    private int noPais;
    @PropiedadMap(id=true, campo="FICD")
    private int noCD;
    @PropiedadMap(campo="FCDESCRIPCION")
    private String cadenaDescripcion;
    @PropiedadMap(campo="FIIDMANHATAN")
    private int noIDManhatan;

    public int getNoPais() {
        return noPais;
    }

    public void setNoPais(int noPais) {
        this.noPais = noPais;
    }

    public int getNoCD() {
        return noCD;
    }

    public void setNoCD(int noCD) {
        this.noCD = noCD;
    }

    public String getCadenaDescripcion() {
        return cadenaDescripcion;
    }

    public void setCadenaDescripcion(String cadenaDescripcion) {
        this.cadenaDescripcion = cadenaDescripcion;
    }

    public int getNoIDManhatan() {
        return noIDManhatan;
    }

    public void setNoIDManhatan(int noIDManhatan) {
        this.noIDManhatan = noIDManhatan;
    }
    
}
