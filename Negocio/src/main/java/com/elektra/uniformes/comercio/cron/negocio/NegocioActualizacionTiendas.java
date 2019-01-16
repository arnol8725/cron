/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.negocio;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.TiendaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("negocioActualizacionTiendas")
public class NegocioActualizacionTiendas {
    
    @Autowired
    @Qualifier("tiendaDao")
    private TiendaDAO tiendaDAO;    
    
    /**
     * CRON DE ACTUALIZA TIENDAS
     */
    private void cronActualizaTiendas(){
        tiendaDAO.actualizaTiendas();
    }
    
}
