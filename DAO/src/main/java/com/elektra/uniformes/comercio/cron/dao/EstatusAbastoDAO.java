/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.EstatusAbasto;
import com.elektra.uniformes.comercio.cron.util.FuncionesBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Luis
 */
@Component("estatusAbastoDAO")
public class EstatusAbastoDAO {
    
    @Autowired
    @Qualifier("funcionesBD")
    private FuncionesBD funcionesBD;
    
    @Autowired
    @Qualifier("fabricaDAO")
    private FabricaDAO fabricaDAO;
    
    private ArrayList<EstatusAbasto> estatusAbasto;
    
    /**
     * Obtiene los estatus de la tabla TAESTATUSABASTO
     * @return
     */
    public void creaEstatusAbasto(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();        
        Connection conn = null;
        CallableStatement cs = null;
        ArrayList<EstatusAbasto> estatusAbasto = null;
        ResultSet rs = null;
        Mapper m = new Mapper();
        String error = "";
        Date inicio = new Date();               
        try {
            LogeoDAO.getInstancia().logExcepcion("Inicia conexion con UNIFORMES.");   
            conn = fabricaDAO.getConexion();
            
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            
            LogeoDAO.getInstancia().logExcepcion("Inicia la Funcion llamada: " + funcionesBD.FN_CONS_ESTATUS_ABASTO);             
            cs = conn.prepareCall(funcionesBD.FN_CONS_ESTATUS_ABASTO);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            this.estatusAbasto = (ArrayList<EstatusAbasto>) m.mapperArrayBean(rs, EstatusAbasto.class);
            LogeoDAO.getInstancia().logExcepcion("Termino la Funcion llamada: " + funcionesBD.FN_CONS_ESTATUS_ABASTO);
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );            
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally{
            close(conn,cs,rs);
        }
    }
    
    /**
     * Busca el estatus de la tabla TAESTATUSABASTO
     * @param estatus
     * @param cadenaMensaje
     * @return 
     */
    public EstatusAbasto busquedaEstatusAbasto(int estatus, String cadenaMensaje){
        EstatusAbasto estatusAbastoAux = null;
        for (EstatusAbasto estatusAbasto : this.estatusAbasto) {
            if(estatus == estatusAbasto.getNoEstatus() && cadenaMensaje.trim().toUpperCase().equals(estatusAbasto.getCadenaMensaje().trim())){
                estatusAbastoAux = estatusAbasto;
            }
        }  
        return estatusAbastoAux;
    }
    
    public boolean isEstatusAbasto(String estatus, String cadenaMensaje){
        boolean bandera = false;
        if(this.busquedaEstatusAbasto(convertirNumero(estatus), cadenaMensaje) != null){
            bandera = true;
        }
        return bandera;
    }
    
    private int convertirNumero(String string) {
        int numero;
        try {           
            numero = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            numero = 0;
        }
        return numero;
    }    
        
    private void close(Connection conn, CallableStatement cs, ResultSet rs){
        try{
            if (cs != null) {
                cs.close();
                cs = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
        }catch (SQLException e){
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: close" + "\n" +
                "3. Excepcion: " + e.getMessage()
            );            
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } 
    }       
}
