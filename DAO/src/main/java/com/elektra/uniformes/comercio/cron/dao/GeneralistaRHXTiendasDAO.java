/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.GeneralistaRHXTienda;
import com.elektra.uniformes.comercio.cron.util.FuncionesBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author lrodriguez
 */
@Component("generalistaRHXTiendasDAO")
public class GeneralistaRHXTiendasDAO {
    
    @Autowired
    @Qualifier("funcionesBD")
    private FuncionesBD funcionesBD;
    
    @Autowired
    @Qualifier("fabricaDAO")
    private FabricaDAO fabricaDAO;    
    
    /**
     * Consulta la tabla C3DISTRITAL.TARELTIENDAS
     * @return 
     */
    public ArrayList<GeneralistaRHXTienda> getGeneralistasRHTiendasAgenda(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();         
        ArrayList<GeneralistaRHXTienda> lista = null;        
        Mapper m = new Mapper();
        Connection connAgendaComercio = null;
        CallableStatement cs = null;
        ResultSet rs = null;      
        String error = "";
        Date inicio = new Date();           
        try{
            LogeoDAO.getInstancia().logExcepcion("Inicia conexion con Agenda Comercio.");                 
            connAgendaComercio = fabricaDAO.getConexionAgendaOperaciones();
            
            if (connAgendaComercio == null) {                
                throw new Exception("La conexion no se creo.");
            }
            
            LogeoDAO.getInstancia().logExcepcion("Inicia FN: " + funcionesBD.FN_CONS_TIENDAS_X_GENERALISTA_RH);
            cs = connAgendaComercio.prepareCall(funcionesBD.FN_CONS_TIENDAS_X_GENERALISTA_RH);
            cs.registerOutParameter(1, OracleTypes.CURSOR);                        
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            lista = (ArrayList<GeneralistaRHXTienda>) m.mapperArrayBean(rs, GeneralistaRHXTienda.class);
            LogeoDAO.getInstancia().logExcepcion("Termina FN: " + funcionesBD.FN_CONS_TIENDAS_X_GENERALISTA_RH);
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );   
            LogeoDAO.getInstancia().logStackExcepcion(e);            
        } finally{        
            close(connAgendaComercio,cs,rs);
        }            
        return lista;
    }
    
    /**
     * Actualiza la tabla UNIFORMES.TATIENDASXGENERALISTAS
     * @param generalistas
     */
    public void actualizaTiendaXGeneralista(ArrayList<GeneralistaRHXTienda> generalistas){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();           
        Connection conn = null;        
        CallableStatement cs = null;        
        OracleConnection oracleConnection = null;
        Mapper m = new Mapper();
        String error = "";
        Date inicio = new Date();
        ResultSet rs = null;
        try{                                              
            LogeoDAO.getInstancia().logExcepcion("Inicia conexion con UNIFORMES.");
            
            conn = fabricaDAO.getConexion();            
            
            if(conn == null){
                throw new Exception("La conexion a Uniformes no se creo.");
            }
            if(conn.isWrapperFor(OracleConnection.class)){
                oracleConnection = conn.unwrap(OracleConnection.class);
            }else{
                oracleConnection = (OracleConnection) conn;
            }
            
            StructDescriptor sd = StructDescriptor.createDescriptor(funcionesBD.TYP_TIENDA_X_GENERALISTA, (java.sql.Connection)oracleConnection);
            ArrayList<STRUCT> listaStruct = new ArrayList<STRUCT>();
            
            for (GeneralistaRHXTienda generalista : generalistas) {
                Object[] objeto = new Object[3];
                objeto[0] = generalista.getPais();
                objeto[1] = Integer.parseInt(String.valueOf(generalista.getNoTienda()).substring(2));
                objeto[2] = generalista.getNoEmpleado();                     
                STRUCT struct = new STRUCT(sd,(java.sql.Connection)oracleConnection,objeto);
                listaStruct.add(struct);
            }
            
            STRUCT struct[] = listaStruct.toArray(new STRUCT[listaStruct.size()]);
            ArrayDescriptor ad = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_ARR_TIENDA_X_GENERALISTA, (java.sql.Connection) oracleConnection);
            ARRAY array = new ARRAY(ad,(java.sql.Connection)oracleConnection,struct);
            
            LogeoDAO.getInstancia().logExcepcion("Inicia el SP: " + funcionesBD.SP_GUARDA_TIENDAS_X_GENERALISTA_RH);            
            cs = conn.prepareCall(funcionesBD.SP_GUARDA_TIENDAS_X_GENERALISTA_RH);
            cs.setArray(1, array);
            cs.execute();            
            LogeoDAO.getInstancia().logExcepcion("Termino el SP: " + funcionesBD.SP_GUARDA_TIENDAS_X_GENERALISTA_RH);                                          
        }catch(Exception e){
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
