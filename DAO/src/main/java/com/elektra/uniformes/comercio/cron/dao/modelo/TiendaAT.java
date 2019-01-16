/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.dao.modelo;

import com.elektra.mapper.anotaciones.PropiedadMap;

public class TiendaAT {
   
    @PropiedadMap(campo="fiTiendaId", id=true)
    private long noTiendaId;    
        
    @PropiedadMap(campo="fiCanalId", id=true)
    private long noCanalId;
    
    @PropiedadMap(campo="fiPaisId", id=true)
    private long noPaisId;        
    
    @PropiedadMap(campo="fcDescTienda")    
    private String cadenaDescripcionTienda;
    
    @PropiedadMap(campo="fcDirecIP")       
    private String cadenaDireccionIp;

    public long getNoTiendaId() {
        return noTiendaId;
    }

    public void setNoTiendaId(long noTiendaId) {
        this.noTiendaId = noTiendaId;
    }

    public long getNoCanalId() {
        return noCanalId;
    }    

    public void setNoCanalId(long noCanalId) {
        this.noCanalId = noCanalId;
    }
    
    /**
     * Valor futuro a asignar al Stored Procedure
     * @return 
     */
    public long getNoCanalCecoId() {
        return 0;
    }    

    public long getNoPaisId() {
        return noPaisId;
    }

    public void setNoPaisId(long noPaisId) {
        this.noPaisId = noPaisId;
    }

    public String getCadenaDescripcionTienda() {
        return cadenaDescripcionTienda;
    }

    public void setCadenaDescripcionTienda(String cadenaDescripcionTienda) {
        this.cadenaDescripcionTienda = cadenaDescripcionTienda;
    }

    public String getCadenaDireccionIp() {
        return cadenaDireccionIp;
    }

    public void setCadenaDireccionIp(String cadenaDireccionIp) {
        this.cadenaDireccionIp = cadenaDireccionIp;
    }
    
}
