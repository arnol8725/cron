/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.EstatusAbasto;
import com.elektra.uniformes.comercio.cron.dao.modelo.TipoError;
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
@Component("tiposErrorDAO")
public class TiposErrorDAO {
    
    @Autowired
    @Qualifier("funcionesBD")
    private FuncionesBD funcionesBD;
    
    @Autowired
    @Qualifier("fabricaDAO")
    private FabricaDAO fabricaDAO; 
   
    public ArrayList<TipoError> tiposError;
    
    /**
     * Obtiene las solicitudes pendientes de grabar en tienda
     * @return
     */
    public void creaTiposError(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();        
        Connection conn = null;
        CallableStatement cs = null;
        ArrayList<TipoError> tiposError = null;
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
            
            LogeoDAO.getInstancia().logExcepcion("Inicia la Funcion llamada: " + funcionesBD.FN_CONS_TIPOS_ERROR);             
            cs = conn.prepareCall(funcionesBD.FN_CONS_TIPOS_ERROR);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            this.tiposError = (ArrayList<TipoError>) m.mapperArrayBean(rs, TipoError.class);
            LogeoDAO.getInstancia().logExcepcion("Termino la Funcion llamada: " + funcionesBD.FN_CONS_TIPOS_ERROR);
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
    
    public TipoError busquedaTipoErrorIDError(int IDError){
        TipoError cadena = null;
        for (TipoError tipoError : this.tiposError) {
            if(tipoError.getNoIDError() == IDError){
                cadena = tipoError;
            }
        }
        return cadena;
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
