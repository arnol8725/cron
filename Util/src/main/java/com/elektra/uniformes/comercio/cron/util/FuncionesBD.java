/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author kortizl
 */
@Component("funcionesBD")
public class FuncionesBD {
    //#ERROR********************************************************************
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_TIPOS_ERROR']}")
    public String FN_CONS_TIPOS_ERROR;
    //**************************************************************************  
    //#CANCELACION X USUARIO INACTIVO*******************************************
    @Value("#{propiedadesCronUniformesComercio['SP_CANCELACION_X_EMPLEADO_INAC']}")
    public String SP_CANCELACION_X_EMPLEADO_INAC;
    //**************************************************************************  
    //#ACT CD X TIENDAS*********************************************************
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_CD']}")
    public String FN_CONS_CD;
    
    @Value("#{propiedadesCronUniformesComercio['SP_INI_CD_X_TIENDAS']}")
    public String SP_INI_CD_X_TIENDAS;
    
    @Value("#{propiedadesCronUniformesComercio['SP_ACT_CD_X_TIENDAS']}")
    public String SP_ACT_CD_X_TIENDAS;
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_NUMBER_ARRAY']}")
    public String TYPE_NUMBER_ARRAY;    
    //**************************************************************************  
    //#TIENDA*******************************************************************
    @Value("#{propiedadesCronUniformesComercio['SP_ACT_TIENDAS']}")
    public String SP_ACT_TIENDAS;
    
    @Value("#{propiedadesCronUniformesComercio['CONSULTA_TIENDAS']}")
    public String CONSULTA_TIENDAS;     

    @Value("#{propiedadesCronUniformesComercio['NO_TIENDAS']}")
    public String NO_TIENDAS;     
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_TIENDADIRIP']}")
    public String TYPE_TIENDADIRIP;         
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_ARR_TIENDASDIRIP']}")
    public String TYPE_ARR_TIENDASDIRIP;   
    
    @Value("#{propiedadesCronUniformesComercio['SP_CARGA_TIENDASDIRIP']}")
    public String SP_CARGA_TIENDASDIRIP;
    
    //**************************************************************************    
    //#GRABA SOLICITUDES DE DETALLE*********************************************
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_SOL_PEND_GRABAR_TIENDA']}")
    public String FN_CONS_SOL_PEND_GRABAR_TIENDA;

    @Value("#{propiedadesCronUniformesComercio['FN_CONS_SOL_PEND_GCD_VOL_NVO_ING']}")
    public String FN_CONS_SOL_PEND_GCD_VOL_NVO_ING;
    
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_SOL_PEND_GCD_SEM']}")
    public String FN_CONS_SOL_PEND_GCD_SEM;
    
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_SOL_PEND_GCD_ACT_CD_NC_NE']}")
    public String FN_CONS_SOL_PEND_GCD_ACT_CD_NC_NE;
    //**************************************************************************    
    //#ACT. ESTATUS SOL DET*****************************************************
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_ESTATUS_ABASTO']}")
    public String FN_CONS_ESTATUS_ABASTO;
    
    @Value("#{propiedadesCronUniformesComercio['SP_ACT_SOLICITUDES_DETALLE']}")
    public String SP_ACT_SOLICITUDES_DETALLE;
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_SOLICITUD_DETALLE']}")
    public String TYPE_SOLICITUD_DETALLE;
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_ARR_SOLICITUD_DETALLE']}")
    public String TYPE_ARR_SOLICITUD_DETALLE;
    
    //**************************************************************************  
    //#ACT. NOTAS ENTRADA SALIDA************************************************
    @Value("#{propiedadesCronUniformesComercio['SP_ACT_NOTAS_CARGO_ENTRADA']}")
    public String SP_ACT_NOTAS_CARGO_ENTRADA;  
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_ARR_NOTA_CARGO_ENTRADA']}")
    public String TYPE_ARR_NOTA_CARGO_ENTRADA;  
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_NOTA_CARGO_ENTRADA']}")
    public String TYPE_NOTA_CARGO_ENTRADA;
    
    //**************************************************************************  
    //#WS DESCUENTOS SAP********************************************************
    @Value("#{propiedadesCronUniformesComercio['SP_CONSULTA_SOLICITUDES_DETALLE_DESCUENTOS_SAP']}")
    public String SP_CONSULTA_SOLICITUDES_DETALLE_DESCUENTOS_SAP;   
    
    @Value("#{propiedadesCronUniformesComercio['SP_GUARDA_DISTRIBUCION_SAP']}")
    public String SP_GUARDA_DISTRIBUCION_SAP;

    @Value("#{propiedadesCronUniformesComercio['TYPE_ARR_DISTRIBUCION_SAP']}")
    public String TYPE_ARR_DISTRIBUCION_SAP;    
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_DISTRIBUCION_SAP']}")
    public String TYPE_DISTRIBUCION_SAP;       
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_ARR_DESCUENTOS_SAP']}")
    public String TYPE_ARR_DESCUENTOS_SAP;     

    @Value("#{propiedadesCronUniformesComercio['TYPE_DESCUENTOS_SAP']}")
    public String TYPE_DESCUENTOS_SAP;     
    //**************************************************************************
    //#ACTUALIZA DESCUENTOS SAP*************************************************
    @Value("#{propiedadesCronUniformesComercio['CONSULTA_DESCUENTOS_SAP']}")
    public String CONSULTA_DESCUENTOS_SAP;

    @Value("#{propiedadesCronUniformesComercio['SP_ACTUALIZA_DESCUENTOS_SAP_X_PEDIDO']}")
    public String SP_ACTUALIZA_DESCUENTOS_SAP_X_PEDIDO;     
    
    /**
     * ***************** REMISIONES *****************************
     */
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_REMISION']}")
    public String TYPE_REMISION;
    @Value("#{propiedadesCronUniformesComercio['TYPE_ARR_REMISION']}")
    public String TYPE_ARR_REMISION;
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_REMISIONES']}")
    public String FN_CONS_REMISIONES;
    @Value("#{propiedadesCronUniformesComercio['SP_ACT_REMISION_COMERCIO']}")
    public String SP_ACT_REMISION_COMERCIO;
    @Value("#{propiedadesCronUniformesComercio['SP_ACT_EST_REMISION']}")
    public String SP_ACT_EST_REMISION;
    
    //DIFERENCIA EN REMISION
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_DIFERENCIA_REMISIONES']}")
    public String FN_CONS_DIFERENCIA_REMISIONES;
    @Value("#{propiedadesCronUniformesComercio['SP_ACT_DIFERENCIA_REMISION']}")
    public String SP_ACT_DIFERENCIA_REMISION;
    @Value("#{propiedadesCronUniformesComercio['SP_ACT_ESTADO_DIFERENCIA_REMISION']}")
    public String SP_ACT_ESTADO_DIFERENCIA_REMISION;
    
    /**
     * ***************** SPPI *****************************
     */
    
    @Value("#{propiedadesCronUniformesComercio['TYPE_CARGA_SPPI']}")
    public String TYPE_CARGA_SPPI;
    @Value("#{propiedadesCronUniformesComercio['TYPE_ARR_CARGA_SPPI']}")
    public String TYPE_ARR_CARGA_SPPI;
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_PENDIENTES_SPPI']}")
    public String FN_CONS_PENDIENTES_SPPI;
    @Value("#{propiedadesCronUniformesComercio['FN_VALIDA_DIA']}")
    public String FN_VALIDA_DIA;
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_SPPI_POR_ACTUALIZAR']}")
    public String FN_CONS_SPPI_POR_ACTUALIZAR;
    @Value("#{propiedadesCronUniformesComercio['SP_ACTUALIZA_PEDIDOS_SPPI']}")
    public String SP_ACTUALIZA_PEDIDOS_SPPI;
    
    //#ACTUALIZA TiendasXGeneralistaRH *****************************************
    @Value("#{propiedadesCronUniformesComercio['FN_CONS_TIENDAS_X_GENERALISTA_RH']}")
    public String FN_CONS_TIENDAS_X_GENERALISTA_RH;    
    @Value("#{propiedadesCronUniformesComercio['SP_GUARDA_TIENDAS_X_GENERALISTA_RH']}")
    public String SP_GUARDA_TIENDAS_X_GENERALISTA_RH;   
    @Value("#{propiedadesCronUniformesComercio['TYP_TIENDA_X_GENERALISTA']}")
    public String TYP_TIENDA_X_GENERALISTA;   
    @Value("#{propiedadesCronUniformesComercio['TYPE_ARR_TIENDA_X_GENERALISTA']}")
    public String TYPE_ARR_TIENDA_X_GENERALISTA;       
    
}
