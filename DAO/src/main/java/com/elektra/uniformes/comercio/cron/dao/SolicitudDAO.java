/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDTO;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDetalle;
import com.elektra.uniformes.comercio.cron.util.FuncionesBD;
import java.sql.CallableStatement;
import java.sql.Clob;
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
 * @author kortizl
 */
@Component("solicitudDAO")
public class SolicitudDAO {

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
     * 
     * Actualiza la tabla de TASOLICITUDESDETALLE en base a consultas del Uniformes y WSAbasto
     * @param solicitudes
     * @throws Exception 
     */
    public void actualizaEstatusSolicitudesDetalle(ArrayList<SolicitudDTO> solicitudes){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();        
        Connection connUC = null;
        CallableStatement cs = null; 
        OracleConnection oracleConnection = null;
        Mapper m = new Mapper();
        String error = "";
        Date inicio = new Date();  
        ResultSet rs = null;
        try {
            LogeoDAO.getInstancia().logExcepcion("Inicia conexion con UNIFORMES.");  
            connUC = fabricaDAO.getConexion();
            if(connUC == null){
                throw new Exception("La conexion a Uniformes no se creo.");
            }
            if(connUC.isWrapperFor(OracleConnection.class)){
                oracleConnection = connUC.unwrap(OracleConnection.class);
            }else{                
                oracleConnection = (OracleConnection) connUC;
            }                               

            StructDescriptor sdSolicitudDetalle = StructDescriptor.createDescriptor(funcionesBD.TYPE_SOLICITUD_DETALLE,(java.sql.Connection)oracleConnection);
            ArrayList<STRUCT> listaStruct = new ArrayList<STRUCT>();
			
            for (SolicitudDTO solicitud : solicitudes) {
                for(SolicitudDetalle solicitudDetalle : solicitud.getSolicitudesDetalle()){
                        Object[] objeto = new Object[17];

                        objeto[0] = solicitud.getNoFolioSolicitud();
                        objeto[1] = solicitudDetalle.getNoIDDetalle();
                        objeto[2] = solicitud.getNoPais();
                        objeto[3] = solicitud.getNoCanal();
                        objeto[4] = solicitud.getNoSucursal();
                        objeto[5] = solicitudDetalle.getNoPedido();
                        objeto[6] = solicitudDetalle.getNoSKU();
                        objeto[7] = solicitudDetalle.getNoRutaCDWS();
                        objeto[8] = solicitudDetalle.getNoEstatusCDWS();
                        objeto[9] = solicitudDetalle.getNoEstatusSol();
                        Clob request = connUC.createClob();
                        request.setString(1, solicitudDetalle.getCadenaXMLResponseWS());
                        objeto[10] = request;
                        objeto[11] = solicitudDetalle.getCadenaDescripcionBitacora();                    
                        objeto[12] = solicitudDetalle.getCadenaMensajeCDWS();
                        objeto[13] = solicitudDetalle.getNoEstatusRemisionWS();
                        objeto[14] = solicitudDetalle.isError() ? 1 : 0;
                        objeto[15] = solicitudDetalle.getMensaje();
                        objeto[16] = solicitudDetalle.getNoIDManhantan();
                        STRUCT struct = new STRUCT(sdSolicitudDetalle,(java.sql.Connection)oracleConnection,objeto);
                        listaStruct.add(struct);                  
                }
            }
            
            STRUCT arregloStructSolicitudDetalle[] = listaStruct.toArray(new STRUCT[listaStruct.size()]);
            ArrayDescriptor adSolicitudDetalle = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_ARR_SOLICITUD_DETALLE,(java.sql.Connection)oracleConnection);
            ARRAY arraySolicitudDetalle = new ARRAY(adSolicitudDetalle,(java.sql.Connection)oracleConnection,arregloStructSolicitudDetalle);
            
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure llamado: " + funcionesBD.SP_ACT_SOLICITUDES_DETALLE);            
            cs = connUC.prepareCall(funcionesBD.SP_ACT_SOLICITUDES_DETALLE);            
            cs.setArray(1, arraySolicitudDetalle);
            cs.registerOutParameter(2, OracleTypes.NUMBER);
            cs.execute();            
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure  llamado: " + funcionesBD.SP_ACT_SOLICITUDES_DETALLE);
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            correoDAO.envio(solicitudes.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);
            close(connUC, cs, rs);
        }
    }
    
    /**
     * Ejecuta el Stored Procedure SPCANCELACIONXEMPLEADOINAC
     */
    public void actualizaCancelacionesXEmpleadoInactivo() {
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();          
        Connection conn = null;
        CallableStatement cs = null;
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
            
            LogeoDAO.getInstancia().logExcepcion("Inicia el SP: " + funcionesBD.SP_CANCELACION_X_EMPLEADO_INAC);
            cs = conn.prepareCall(funcionesBD.SP_CANCELACION_X_EMPLEADO_INAC);
            cs.execute();
            LogeoDAO.getInstancia().logExcepcion("Termina el SP: " + funcionesBD.SP_CANCELACION_X_EMPLEADO_INAC);
        }   catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );            
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {     
            close(conn, cs, rs);
        }
    }  
    
    /**
     * Obtiene las solicitudes pendientes de grabar en tienda
     * @return 
     */
    public ArrayList<SolicitudDTO> getSolicitudesPendientesTienda(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();        
        Connection conn = null;
        CallableStatement cs = null;
        ArrayList<SolicitudDTO> solicitudesPendientes = null;
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
            
            LogeoDAO.getInstancia().logExcepcion("Inicia la Funcion llamada: " + funcionesBD.FN_CONS_SOL_PEND_GRABAR_TIENDA);             
            cs = conn.prepareCall(funcionesBD.FN_CONS_SOL_PEND_GRABAR_TIENDA);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            solicitudesPendientes = (ArrayList<SolicitudDTO>) m.mapperArrayBean(rs, SolicitudDTO.class);
            LogeoDAO.getInstancia().logExcepcion("Termino la Funcion llamada: " + funcionesBD.FN_CONS_SOL_PEND_GRABAR_TIENDA);
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );            
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            correoDAO.envio(solicitudesPendientes.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);            
            close(conn, cs, rs);
        }
        return solicitudesPendientes;
    }

    /**
     * Obtiene las solicitudes pendientes de grabar en CD (Voluntarias y nuevo ingreso)
     * @return 
     */
    public ArrayList<SolicitudDTO> getSolicitudesPendientesGCDVolNvoIngreso() {
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();          
        Connection conn = null;
        CallableStatement cs = null;
        ArrayList<SolicitudDTO> solicitudesPendientes = new ArrayList<SolicitudDTO>();
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
            
            LogeoDAO.getInstancia().logExcepcion("Inicia la Funcion llamada: " + funcionesBD.FN_CONS_SOL_PEND_GCD_VOL_NVO_ING);
            cs = conn.prepareCall(funcionesBD.FN_CONS_SOL_PEND_GCD_VOL_NVO_ING);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            solicitudesPendientes = (ArrayList<SolicitudDTO>) m.mapperArrayBean(rs, SolicitudDTO.class);
            LogeoDAO.getInstancia().logExcepcion("Termina la Funcion llamada: " + funcionesBD.FN_CONS_SOL_PEND_GCD_VOL_NVO_ING);
        }   catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );            
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            correoDAO.envio(solicitudesPendientes.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);          
            close(conn, cs, rs);
        }
        return solicitudesPendientes;
    }
 
    /**
     * Obtiene las solicitudes pendientes de grabar en CD (Semestrales)
     * @return 
     */
    public ArrayList<SolicitudDTO> getSolicitudesPendientesGCDSem() {
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();          
        Connection conn = null;
        CallableStatement cs = null;
        ArrayList<SolicitudDTO> solicitudesPendientes = new ArrayList<SolicitudDTO>();
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
            
            LogeoDAO.getInstancia().logExcepcion("Inicia la Funcion llamada: " + funcionesBD.FN_CONS_SOL_PEND_GCD_SEM);
            cs = conn.prepareCall(funcionesBD.FN_CONS_SOL_PEND_GCD_SEM);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            solicitudesPendientes = (ArrayList<SolicitudDTO>) m.mapperArrayBean(rs, SolicitudDTO.class);
            LogeoDAO.getInstancia().logExcepcion("Termina la Funcion llamada: " + funcionesBD.FN_CONS_SOL_PEND_GCD_SEM);
        }   catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );            
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            correoDAO.envio(solicitudesPendientes.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);          
            close(conn, cs, rs);
        }
        return solicitudesPendientes;
    }    
    
    /**
     * Obtiene las solicitudes pendientes de grabar en CD (1) (NO UTILIZAR)
     * Obtiene las solicitudes pendientes de actualizar en CD (2)
     * Obtiene las solicitudes pendientes de actualizar para consultar NE y NC (3)
     * @param tipoSolicitud
     * @return 
     */
    public ArrayList<SolicitudDTO> getSolicitudesPendientesGCDACTCDNCNE(int tipoSolicitud) {
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();          
        Connection conn = null;
        CallableStatement cs = null;
        ArrayList<SolicitudDTO> solicitudesPendientes = new ArrayList<SolicitudDTO>();
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
            LogeoDAO.getInstancia().logExcepcion("Inicia la Funcion llamada: " + funcionesBD.FN_CONS_SOL_PEND_GCD_ACT_CD_NC_NE);
            cs = conn.prepareCall(funcionesBD.FN_CONS_SOL_PEND_GCD_ACT_CD_NC_NE);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, tipoSolicitud);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            solicitudesPendientes = (ArrayList<SolicitudDTO>) m.mapperArrayBean(rs, SolicitudDTO.class);
            LogeoDAO.getInstancia().logExcepcion("Termina la Funcion llamada: " + funcionesBD.FN_CONS_SOL_PEND_GCD_ACT_CD_NC_NE);
        }   catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );            
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            correoDAO.envio(solicitudesPendientes.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);          
            close(conn, cs, rs);
        }
        return solicitudesPendientes;
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
