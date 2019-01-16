/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import com.elektra.uniformes.comercio.cron.dao.GeneralistaRHXTiendasDAO;
import com.elektra.uniformes.comercio.cron.dao.modelo.GeneralistaRHXTienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author lrodriguez
 */

@Component("negocioActualizacionGRHXTiendas")
public class NegocioActualizacionGRHXTiendas {
    
    @Autowired
    @Qualifier("generalistaRHXTiendasDAO")
    private GeneralistaRHXTiendasDAO generalistaDAO;   
    
    /**
     * CRON ACTUALIZACION GENERALISTAS X TIENDAS
     */
    private void cronActualizacionGRHXTiendas(){
        generalistaDAO.actualizaTiendaXGeneralista(generalistaDAO.getGeneralistasRHTiendasAgenda());               
    }
    
}
