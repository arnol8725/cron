/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.dao;
import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.TiendaAT;
import com.elektra.uniformes.comercio.cron.dao.modelo.TiendaDirIP;
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
import oracle.sql.STRUCT;
import oracle.sql.ArrayDescriptor;
import oracle.sql.StructDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tiendaDao")
public class TiendaDAO {
    
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
     * Realiza una consulta a la base de datos de ADNTRANSAC, conforme a la 
     * consulta realiza el llenado de la tabla TATIENDASDIRIP, por ultimo hace 
     * el merge para actualizar los nombres de las tiendas e ip, ademas realiza
     * los inserts de las nuevas tiendas.
     * @throws Exception 
     */
    public void actualizaTiendas(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();   
        Connection connAdn = null;
        Connection connUC = null;
        PreparedStatement ps = null;
        CallableStatement cs = null;
        ResultSet rsAdnT = null;
        ResultSet rsUC = null;        
        OracleConnection oracleConnection = null;
        Mapper m = new Mapper();
        ArrayList<TiendaAT> tiendasAT = null;
        ArrayList<TiendaDirIP> tiendasDirIPMail;
        String error = "";
        Date inicio = new Date();
        try{          
            //1.CONSULTA ADNTransac.Tiendas
            LogeoDAO.getInstancia().logExcepcion("Conexion con ADNTransc.");            
            connAdn = fabricaDAO.getConexionAdnT();                      
            
            if(connAdn == null){
                throw new Exception("La conexion a ADN T no se creo.");
            }        
            
            LogeoDAO.getInstancia().logExcepcion("Inicia la consulta a ADNTransc.Tiendas.");
            ps = connAdn.prepareStatement(funcionesBD.CONSULTA_TIENDAS); 
            rsAdnT = ps.executeQuery();                    
            LogeoDAO.getInstancia().logExcepcion("Termino la consulta a ADNTransc.Tiendas.");               
            tiendasAT = (ArrayList<TiendaAT>) m.mapperArrayBean(rsAdnT, TiendaAT.class);   
            
            //2.BORRA LOS DATOS E INSERTA NUEVOS DATOS A LA TABLA C3REPOSITORIO.TATIENDASDIRIP                                      
            LogeoDAO.getInstancia().logExcepcion("Conexion con Uniformes Comercio.");                 
            connUC = fabricaDAO.getConexion();
            
            if(connUC == null){
                throw new Exception("La conexion a Uniformes no se creo.");
            }
            if(connUC.isWrapperFor(OracleConnection.class)){
                oracleConnection = connUC.unwrap(OracleConnection.class);
            }else{
                LogeoDAO.getInstancia().logExcepcion("conversion");                   
                oracleConnection = (OracleConnection) connUC;
            }                               
            
            StructDescriptor sdTiendaAT = StructDescriptor.createDescriptor(funcionesBD.TYPE_TIENDADIRIP, (java.sql.Connection)oracleConnection);                       
            ArrayList<STRUCT> listaStruct = new ArrayList<STRUCT>();  
            
            for (TiendaAT tienda : tiendasAT) {
                Object[] objetoTienda = new Object[6];
                objetoTienda[0] = tienda.getNoTiendaId();
                objetoTienda[1] = tienda.getNoPaisId();
                objetoTienda[2] = tienda.getNoCanalId();
                objetoTienda[3] = tienda.getNoCanalCecoId();              
                objetoTienda[4] = tienda.getCadenaDescripcionTienda();
                objetoTienda[5] = tienda.getCadenaDireccionIp();           
                STRUCT struct = new STRUCT(sdTiendaAT,(java.sql.Connection)oracleConnection,objetoTienda);
                listaStruct.add(struct);
            }          
                 
            STRUCT arregloStructTienda[] = listaStruct.toArray(new STRUCT[listaStruct.size()]);            
            ArrayDescriptor adTiendaAT = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_ARR_TIENDASDIRIP,(java.sql.Connection)oracleConnection);                                               
            ARRAY arrayTienda = new ARRAY(adTiendaAT,(java.sql.Connection)oracleConnection,arregloStructTienda);
                        
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure para borrar las tiendas e insertar nuevas tiendas. llamado:" + funcionesBD.SP_CARGA_TIENDASDIRIP);
            
            cs = connUC.prepareCall(funcionesBD.SP_CARGA_TIENDASDIRIP);
            cs.setArray(1, arrayTienda);
            cs.registerOutParameter(2, OracleTypes.NUMBER);
            cs.execute();
            
            LogeoDAO.getInstancia().logExcepcion("En total se consiguieron insertar No. Tiendas: " + (int)cs.getInt(2));                        
            LogeoDAO.getInstancia().logExcepcion("Termino la carga de las nuevas tiendas en la Tabla TATIENDASDIRIP.");
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado:" + funcionesBD.SP_CARGA_TIENDASDIRIP);                       
            //REALIZA UN MERGE A UNIFORMES.TATIENDAS                          
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure con un merge con updates (IPS) a Uniformes.TaTiendas. llamado" + funcionesBD.SP_ACT_TIENDAS);  
            cs = connUC.prepareCall(funcionesBD.SP_ACT_TIENDAS);   
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.execute();         
            LogeoDAO.getInstancia().logExcepcion("En total se consiguieron actualizar No. Tiendas: " + (int)cs.getInt(1));                      
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado:" + funcionesBD.SP_ACT_TIENDAS);                           
            
        }catch(Exception e){
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );   
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally{
            correoDAO.envio(tiendasAT.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);
            close(connAdn,cs,rsAdnT);
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