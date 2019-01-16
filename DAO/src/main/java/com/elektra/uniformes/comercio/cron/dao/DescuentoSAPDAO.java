/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.DescuentoSAPXPedido;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDetalleDescuentoSAP;
import com.elektra.uniformes.comercio.cron.dao.modelo.ResponseSolicitudDetalleDescuentoSAP;
import com.elektra.uniformes.comercio.cron.util.FuncionesBD;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.ARRAY;
import oracle.sql.StructDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("descuentoSAPDAO")
public class DescuentoSAPDAO {

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
     * Consulta la informacion de las solicitudes de detalle de los empleados 
     * para el descuento SAP (Armado para envio por SOAP[WSAbasto])
     * @return
     * @throws Exception 
     */
    public ArrayList<SolicitudDetalleDescuentoSAP> getSolicitudesDetalleDescuentosSAP(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();         
        Connection conn = null;
        CallableStatement cs = null;
        ArrayList<SolicitudDetalleDescuentoSAP> solicitudes = new ArrayList<SolicitudDetalleDescuentoSAP>();
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
            
            LogeoDAO.getInstancia().logExcepcion("Inicia el SP: " + funcionesBD.SP_CONSULTA_SOLICITUDES_DETALLE_DESCUENTOS_SAP);            
            cs = conn.prepareCall(funcionesBD.SP_CONSULTA_SOLICITUDES_DETALLE_DESCUENTOS_SAP);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            solicitudes = (ArrayList<SolicitudDetalleDescuentoSAP>) m.mapperArrayBean(rs, SolicitudDetalleDescuentoSAP.class);
            LogeoDAO.getInstancia().logExcepcion("Termino el SP: " + funcionesBD.SP_CONSULTA_SOLICITUDES_DETALLE_DESCUENTOS_SAP);    
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );   
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {               
            correoDAO.envio(solicitudes.toArray(),this.getClass().toString(), nombreMetodo, inicio, error);
            close(conn, cs, rs);
        }
        return solicitudes;
    }      
    
    /**
     * Guarda las distribuciones sap en su tabla de base de datos, aun con errores se guardan en bitacora
     * @param distribucionesSAP
     * @throws Exception 
     */
    public void guardaDistribucionSAP(ArrayList<ResponseSolicitudDetalleDescuentoSAP> distribucionesSAP){
     String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();       
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Mapper m = new Mapper();
        OracleConnection oracleConnection = null;
        String error = "";
        Date inicio = new Date();
        try {                    
            LogeoDAO.getInstancia().logExcepcion("Inicia conexion con UNIFORMES.");
            conn = fabricaDAO.getConexion();
            
            if(conn == null){
                throw new Exception("La conexion a C3Repositorio no se creo.");
            }
            if(conn.isWrapperFor(OracleConnection.class)){
                oracleConnection = conn.unwrap(OracleConnection.class);
            }else{
                oracleConnection = (OracleConnection) conn;
            }
            
            StructDescriptor sdSeguimientoPedidosDescuentos = StructDescriptor.createDescriptor(funcionesBD.TYPE_DISTRIBUCION_SAP, (java.sql.Connection)oracleConnection);
            ArrayList<STRUCT> listaStruct = new ArrayList<STRUCT>();
            
            for (ResponseSolicitudDetalleDescuentoSAP seguimiento : distribucionesSAP) {
                Object[] objetoSeguimiento = new Object[13];
                objetoSeguimiento[0] = seguimiento.getNoFolioSolicitud();
                objetoSeguimiento[1] = seguimiento.getNoIDDetalle();
                objetoSeguimiento[2] = seguimiento.getNoPais();
                objetoSeguimiento[3] = seguimiento.getNoCanal();
                objetoSeguimiento[4] = seguimiento.getNoIDSucursal();
                objetoSeguimiento[5] = seguimiento.getNoPedido();
                objetoSeguimiento[6] = seguimiento.getNoSKU();
                objetoSeguimiento[7] = seguimiento.getCadenaRefenciaSAP();
                objetoSeguimiento[8] = seguimiento.getNoEstatusCorrectoResponseSAP(); //FIESTATUSSAP
                Clob request = conn.createClob();
                request.setString(1, seguimiento.getCadenaXMLRequest());
                objetoSeguimiento[9] = request;
                Clob response = conn.createClob();
                response.setString(1, seguimiento.getCadenaXMLResponse());
                objetoSeguimiento[10] = response;
                objetoSeguimiento[11] = seguimiento.getCadenaTEXTXMLResponse(); 
                objetoSeguimiento[12] = seguimiento.getNoError();        
                
                STRUCT struct = new STRUCT(sdSeguimientoPedidosDescuentos,(java.sql.Connection)oracleConnection,objetoSeguimiento);
                listaStruct.add(struct);
            }
            
            STRUCT arregloStructSeguimiento[] = listaStruct.toArray(new STRUCT[listaStruct.size()]);
            ArrayDescriptor adSeguimiento = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_ARR_DISTRIBUCION_SAP, (java.sql.Connection) oracleConnection);
            ARRAY arraySeguimiento = new ARRAY(adSeguimiento,(java.sql.Connection)oracleConnection,arregloStructSeguimiento);
            
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure para guardar el seguimiento del descuento SAP. llamado: " + funcionesBD.SP_GUARDA_DISTRIBUCION_SAP);
            
            cs = conn.prepareCall(funcionesBD.SP_GUARDA_DISTRIBUCION_SAP);
            cs.setArray(1, arraySeguimiento);
            cs.execute();
            
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado:" + funcionesBD.SP_GUARDA_DISTRIBUCION_SAP);                        
        } catch (Exception e) {            
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );   
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            correoDAO.envio(distribucionesSAP.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);
            close(conn, cs, rs);
        }        
    }      
    
    /**
     * Proceso para actualizar descuentos SAP (tabla TADESCUENTOSSAPXPEDIDOS) semanal
     * @throws Exception 
     */
    public void actualizaDescuentosSAPXPedidos(){
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();
        ArrayList<DescuentoSAPXPedido> descuentosSAP = null;
        Connection connRHSAP = null;
        Connection connUC = null;
        CallableStatement cs = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Mapper m = new Mapper();
        OracleConnection oracleConnection = null;  
        String error = "";
        Date inicio = new Date();        
        try{
            //1. CONSULTA RHSAP
            LogeoDAO.getInstancia().logExcepcion("Inicia conexion con RHSAP.");
            
            connRHSAP = fabricaDAO.getConexionRHSAP();
            
            if(connRHSAP == null){
                throw new Exception("La conexion no se creo.");
            }
            
            LogeoDAO.getInstancia().logExcepcion("Inicia la consulta a la base de datos: RHSAP");            
            ps = connRHSAP.prepareStatement(funcionesBD.CONSULTA_DESCUENTOS_SAP);
            rs = ps.executeQuery();
            LogeoDAO.getInstancia().logExcepcion("Termino la consulta a ADNTransc.Tiendas."); 
            descuentosSAP = (ArrayList<DescuentoSAPXPedido>) m.mapperArrayBean(rs, DescuentoSAPXPedido.class); 
            //2. ACTUALIZA TODOS LOS DIAS LOS DESCUENTOS SAP DENTRO DE 15 DIAS
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

            StructDescriptor sdDescuentoSAP = StructDescriptor.createDescriptor(funcionesBD.TYPE_DESCUENTOS_SAP,(java.sql.Connection)oracleConnection);
            ArrayList<STRUCT> listaStruct = new ArrayList<STRUCT>();
            
            for (DescuentoSAPXPedido descuento : descuentosSAP) {
                Object[] objetoDescuentoSAP = new Object[10];
                objetoDescuentoSAP[0] = descuento.getNoFolioSolicitud();
                objetoDescuentoSAP[1] = descuento.getNoPedido();
                objetoDescuentoSAP[2] = descuento.getCadenaSociedad();
                objetoDescuentoSAP[3] = descuento.getCadenaReferencia();
                objetoDescuentoSAP[4] = descuento.getCadenaNomina();
                objetoDescuentoSAP[5] = descuento.getPresicionTotal();
                objetoDescuentoSAP[6] = descuento.getFdFechaPago();
                objetoDescuentoSAP[7] = descuento.getNoSemanaActual();
                objetoDescuentoSAP[8] = descuento.getPrecisionSaldo();
                objetoDescuentoSAP[9] = descuento.getPrecisionPago();
                STRUCT struct = new STRUCT(sdDescuentoSAP,(java.sql.Connection)oracleConnection,objetoDescuentoSAP);
                listaStruct.add(struct);
                
            }
            
            STRUCT arregloStructDescuentosSAP[] = listaStruct.toArray(new STRUCT[listaStruct.size()]);
            ArrayDescriptor adDescuentoSAP = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_ARR_DESCUENTOS_SAP,(java.sql.Connection)oracleConnection);
            ARRAY arrayDescuentoSAP = new ARRAY(adDescuentoSAP,(java.sql.Connection)oracleConnection,arregloStructDescuentosSAP);
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure para insertar los nuevos Descuentos SAP. llamado: " + funcionesBD.SP_ACTUALIZA_DESCUENTOS_SAP_X_PEDIDO );   
            
            cs = connUC.prepareCall(funcionesBD.SP_ACTUALIZA_DESCUENTOS_SAP_X_PEDIDO);
            cs.setArray(1, arrayDescuentoSAP);
            cs.registerOutParameter(2, OracleTypes.NUMBER);
            cs.execute();
            
            LogeoDAO.getInstancia().logExcepcion("En total se consiguieron insertar No. Descuentos SAP: " + (int)cs.getInt(2));               
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado: " + funcionesBD.SP_ACTUALIZA_DESCUENTOS_SAP_X_PEDIDO );
            
        }catch(Exception e){            
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );   
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally{
            correoDAO.envio(descuentosSAP.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);
            close(connRHSAP,cs,rs);
            close(connUC,cs,rs);
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
