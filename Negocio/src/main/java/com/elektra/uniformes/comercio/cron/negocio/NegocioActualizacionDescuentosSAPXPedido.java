/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import com.elektra.uniformes.comercio.cron.dao.DescuentoSAPDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Luis
 */
@Component("negocioActualizacionDescuentosSAPXPedido")
public class NegocioActualizacionDescuentosSAPXPedido {
    
    @Autowired
    @Qualifier("descuentoSAPDAO")
    private DescuentoSAPDAO descuentoSAPDAO;  
    
    /** 
     * CRON ACTUALIZA NOTASCARGOENTRADA
     */
    public void cronActualizaDescuentosSAPXPedido(){
        descuentoSAPDAO.actualizaDescuentosSAPXPedidos();
    }

}
