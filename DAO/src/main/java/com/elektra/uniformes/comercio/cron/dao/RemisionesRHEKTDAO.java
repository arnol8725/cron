/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.RemisionPedido;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDTO;
import com.elektra.uniformes.comercio.cron.util.FuncionesBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@Component("remisionesRHEKTDAO")
public class RemisionesRHEKTDAO {

    @Autowired
    @Qualifier("funcionesBD")
    private FuncionesBD funcionesBD;
    @Autowired
    @Qualifier("fabricaDAO")
    private FabricaDAO fabricaDAO;
    @Autowired
    @Qualifier("correoDAO")
    private CorreoDAO correoDAO;

    public ArrayList<RemisionPedido> getRemisionesPedido() throws Exception {
        ArrayList<RemisionPedido> remisiones = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Mapper m = new Mapper();
        String nombreMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        String error = "";
        try {

            conn = fabricaDAO.getConexionRHEKT();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure llamado: " + funcionesBD.FN_CONS_REMISIONES);
            cs = conn.prepareCall(funcionesBD.FN_CONS_REMISIONES);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado:" + funcionesBD.FN_CONS_REMISIONES);                        
            remisiones = (ArrayList<RemisionPedido>) m.mapperArrayBean(rs, RemisionPedido.class);
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: " + nombreMetodo + "\n"
                    + "3. Excepcion: " + e.getMessage());
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            close(conn, cs, rs);
        }
        return remisiones;
    }

    public void actualizaEstatusRemisionesPedido(ArrayList<RemisionPedido> remisiones) throws Exception {
        Connection conn = null;
        OracleConnection oracleConnection = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Mapper m = new Mapper();
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        String error = "";

        try {
            conn = fabricaDAO.getConexionRHEKT();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            if (conn.isWrapperFor(OracleConnection.class)) {
                oracleConnection = conn.unwrap(OracleConnection.class);
            } else {
                oracleConnection = (OracleConnection) conn;
            }
            StructDescriptor rem = StructDescriptor.createDescriptor(funcionesBD.TYPE_REMISION, (java.sql.Connection) oracleConnection);
            ArrayDescriptor arrRem = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_ARR_REMISION, (java.sql.Connection) oracleConnection);

            ArrayList<STRUCT> listaStructRem = new ArrayList<STRUCT>();
            for (RemisionPedido rm : remisiones) {
                Object[] objRem = new Object[9];
                objRem[0] = rm.getSucursal();
                objRem[1] = rm.getPedido();
                objRem[2] = rm.getRemision();
                objRem[3] = rm.getSku();
                objRem[4] = rm.getCantidad();
                objRem[5] = rm.getEmpleado();
                objRem[6] = rm.getDiv();
                objRem[7] = rm.getObs();
                objRem[8] = rm.getEstatus();
                STRUCT strRem = new STRUCT(rem, (java.sql.Connection) oracleConnection, objRem);
                listaStructRem.add(strRem);
            }

            STRUCT arrRemStr[] = listaStructRem.toArray(new STRUCT[listaStructRem.size()]);
            ARRAY arrayRem = new ARRAY(arrRem, (java.sql.Connection) oracleConnection, arrRemStr);
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure llamado: " + funcionesBD.SP_ACT_EST_REMISION);
            cs = conn.prepareCall(funcionesBD.SP_ACT_EST_REMISION);
            cs.setArray(1, arrayRem);
            cs.execute();
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado: " + funcionesBD.SP_ACT_EST_REMISION);
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: " + nombreMetodo + "\n"
                    + "3. Excepcion: " + e.getMessage());
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            //correoDAO.envio(solicitudesPendientes.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);
            close(conn, cs, rs);
        }
    }

    public ArrayList<RemisionPedido> getDiferenciaRemisiones() throws Exception {
        ArrayList<RemisionPedido> remisiones = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Mapper m = new Mapper();
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        String error = "";
        try {
            conn = fabricaDAO.getConexionRHEKT();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure llamado: " + funcionesBD.FN_CONS_DIFERENCIA_REMISIONES);
            cs = conn.prepareCall(funcionesBD.FN_CONS_DIFERENCIA_REMISIONES);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado: " + funcionesBD.FN_CONS_DIFERENCIA_REMISIONES);
            remisiones = (ArrayList<RemisionPedido>) m.mapperArrayBean(rs, RemisionPedido.class);
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: " + nombreMetodo + "\n"
                    + "3. Excepcion: " + e.getMessage());
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            close(conn, cs, rs);
        }
        return remisiones;
    }

    public void actualizaEstatusDiferenciaRemision(ArrayList<RemisionPedido> remisiones) throws Exception {
        Connection conn = null;
        OracleConnection oracleConnection = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Mapper m = new Mapper();
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        String error = "";

        try {
            conn = fabricaDAO.getConexionRHEKT();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            if (conn.isWrapperFor(OracleConnection.class)) {
                oracleConnection = conn.unwrap(OracleConnection.class);
            } else {
                oracleConnection = (OracleConnection) conn;
            }
            StructDescriptor rem = StructDescriptor.createDescriptor(funcionesBD.TYPE_REMISION, (java.sql.Connection) oracleConnection);
            ArrayDescriptor arrRem = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_ARR_REMISION, (java.sql.Connection) oracleConnection);

            ArrayList<STRUCT> listaStructRem = new ArrayList<STRUCT>();
            for (RemisionPedido rm : remisiones) {
                Object[] objRem = new Object[9];
                objRem[0] = rm.getSucursal();
                objRem[1] = rm.getPedido();
                objRem[2] = rm.getRemision();
                objRem[3] = rm.getSku();
                objRem[4] = rm.getCantidad();
                objRem[5] = rm.getEmpleado();
                objRem[6] = rm.getDiv();
                objRem[7] = rm.getObs();
                objRem[8] = rm.getEstatus();
                STRUCT strRem = new STRUCT(rem, (java.sql.Connection) oracleConnection, objRem);
                listaStructRem.add(strRem);
            }

            STRUCT arrRemStr[] = listaStructRem.toArray(new STRUCT[listaStructRem.size()]);
            ARRAY arrayRem = new ARRAY(arrRem, (java.sql.Connection) oracleConnection, arrRemStr);
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure llamado: " + funcionesBD.SP_ACT_ESTADO_DIFERENCIA_REMISION);
            cs = conn.prepareCall(funcionesBD.SP_ACT_ESTADO_DIFERENCIA_REMISION);
            cs.setArray(1, arrayRem);
            cs.execute();
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado: " + funcionesBD.SP_ACT_ESTADO_DIFERENCIA_REMISION);
        } catch (Exception e) {
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: " + nombreMetodo + "\n"
                    + "3. Excepcion: " + e.getMessage());
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            close(conn, cs, rs);
        }
    }

    private void close(Connection conn, CallableStatement cs, ResultSet rs) throws SQLException {
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
    }
}
