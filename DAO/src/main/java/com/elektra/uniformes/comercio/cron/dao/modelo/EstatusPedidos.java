/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.dao.modelo;

public class EstatusPedidos {
    
    public final static int CANCELADO = 0;
    public final static int PENDIENTE_DE_SOLICITAR_EN_CD = 1;
    public final static int SOLICITADO_A_CD = 2;
    public final static int ATENDIDO_EN_CD = 3;
    public final static int EN_CAMINO_A_TIENDA = 4;
    public final static int RECIBIDO_EN_TIENDA = 5;
    public final static int ENTREGADO = 6;
    public final static int DESCUENTO_SAP = 7;
    public final static int DESCUENTO_SPPI = 8;
                
}
