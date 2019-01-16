/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.CentroDistribucion;
import com.elektra.uniformes.comercio.cron.dao.modelo.CentroDistribucionXTiendas;
import com.elektra.uniformes.comercio.cron.util.FuncionesBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("cdDAO")
public class CDDAO {
    
    @Autowired
    @Qualifier("funcionesBD")
    private FuncionesBD funcionesBD;
    
    @Autowired
    @Qualifier("fabricaDAO")
    private FabricaDAO fabricaDAO;
    
    @Autowired
    @Qualifier("correoDAO")
    private CorreoDAO correoDAO;  
    
    /**
     * Consulta los Centros de distribucion disponibles.
     * @return 
     */
    public ArrayList<CentroDistribucion> getCentrosDistribucion(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();         
        ArrayList<CentroDistribucion> centrosDistribucion = null;        
        Mapper m = new Mapper();
        Connection connUC = null;
        CallableStatement cs = null;
        ResultSet rs = null;      
        String error = "";
        Date inicio = new Date();        
        try {
            LogeoDAO.getInstancia().logExcepcion("Inicia conexion con UNIFORMES.");            
            connUC = fabricaDAO.getConexion();

            if (connUC == null) {                
                throw new Exception("La conexion no se creo.");
            }
            
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure llamado: " + funcionesBD.FN_CONS_CD);            
            cs = connUC.prepareCall(funcionesBD.FN_CONS_CD);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            centrosDistribucion = (ArrayList<CentroDistribucion>) m.mapperArrayBean(rs, CentroDistribucion.class);
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado: " + funcionesBD.FN_CONS_CD);    
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );   
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {               
            close(connUC, cs, rs);
        }
        return centrosDistribucion;
    }      
    
     /**
     * Inicializa CDXTIENDAS como FIACTIVO = 1
     */
    public void inicializaCDXTiendas(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();   
        Connection connAdn = null;
        Connection connUC = null;
        PreparedStatement ps = null;
        CallableStatement cs = null;
        ResultSet rsAdnT = null;
        ResultSet rsUC = null;        
        Mapper m = new Mapper();
        String error = "";
        Date inicio = new Date();
        try{                                              
            LogeoDAO.getInstancia().logExcepcion("Conexion con Uniformes Comercio.");                 
            connUC = fabricaDAO.getConexion();
            
            if (connUC == null) {                
                throw new Exception("La conexion no se creo.");
            }
            
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure llamado: " + funcionesBD.SP_INI_CD_X_TIENDAS);
            cs = connUC.prepareCall(funcionesBD.SP_INI_CD_X_TIENDAS);
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.execute();
            LogeoDAO.getInstancia().logExcepcion("Se actualizaron en total :" + cs.getInt(1) + " registros");    
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado:" + funcionesBD.SP_INI_CD_X_TIENDAS);                           
        }catch(Exception e){
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );   
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally{
            close(connUC,cs,rsAdnT);
        }        
    }  
    
    
    /**
     * Actualiza la tabla TACDXTIENDAS
     * @param cd
     */
    public void actualizaCDXTiendas(CentroDistribucionXTiendas cd){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();   
        Connection connAdn = null;
        Connection connUC = null;
        PreparedStatement ps = null;
        CallableStatement cs = null;
        ResultSet rsAdnT = null;
        ResultSet rsUC = null;        
        OracleConnection oracleConnection = null;
        Mapper m = new Mapper();
        String error = "";
        Date inicio = new Date();
        try{                                              
            LogeoDAO.getInstancia().logExcepcion("Conexion con Uniformes Comercio.");                 
            connUC = fabricaDAO.getConexion();
            
            if(connUC == null){
                throw new Exception("La conexion a Uniformes no se creo.");
            }
            if(connUC.isWrapperFor(OracleConnection.class)){
                oracleConnection = connUC.unwrap(OracleConnection.class);
            }else{            
                oracleConnection = (OracleConnection) connUC;
            } 
            
            ArrayDescriptor adTiendaAT = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_NUMBER_ARRAY,(java.sql.Connection)oracleConnection);                                               
            ARRAY arrayTienda = new ARRAY(adTiendaAT,(java.sql.Connection)oracleConnection,cd.getTiendasArreglo());             
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure llamado: " + funcionesBD.SP_ACT_CD_X_TIENDAS);
            cs = connUC.prepareCall(funcionesBD.SP_ACT_CD_X_TIENDAS);
            cs.setInt(1, cd.getNoCD());
            cs.setArray(2, arrayTienda);
            cs.registerOutParameter(3, OracleTypes.NUMBER);
            cs.execute();       
            LogeoDAO.getInstancia().logExcepcion("No. Registros act:" + (int)cs.getInt(3));  
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado:" + funcionesBD.SP_ACT_CD_X_TIENDAS);                           
        }catch(Exception e){
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );   
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally{        
            close(connUC,cs,rsAdnT);
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