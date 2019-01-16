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
public class GeneralistaRHXTienda {
    
    @PropiedadMap(id=true, campo="FIPAIS")
    private int pais;
    @PropiedadMap(id=true, campo="FINUMEMPLEADO")
    private int noEmpleado;
    @PropiedadMap(id=true, campo="FINOTIENDA")
    private int noTienda;

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public int getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(int noEmpleado) {
        this.noEmpleado = noEmpleado;
    }

    public int getNoTienda() {
        return noTienda;
    }

    public void setNoTienda(int noTienda) {
        this.noTienda = noTienda;
    }    
        
}
