/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao.modelo;

import java.util.ArrayList;

/**
 *
 * @author lrodriguez
 */
public class CentroDistribucionXTiendas {
    
    private int noCD;
    private ArrayList<Integer> tiendas;
    private boolean error;
    private String msj;
    
    public CentroDistribucionXTiendas(){
        tiendas = new ArrayList<Integer>();
        this.error = false;
    }

    public int getNoCD() {
        return noCD;
    }

    public void setNoCD(int noCD) {
        this.noCD = noCD;
    }

    public ArrayList<Integer> getTiendas() {
        return tiendas;
    }

    public void setTiendas(ArrayList<Integer> tiendas) {
        this.tiendas = tiendas;
    }
    
    public int[] getTiendasArreglo(){
        int arreglo[] = new int[tiendas.size()];
        for (int i = 0; i < tiendas.size(); i++) {
            arreglo[i] = tiendas.get(i);
        }
        return arreglo;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
    
}
