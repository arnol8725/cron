/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.CargaSPPIDTO;
import com.elektra.uniformes.comercio.cron.dao.modelo.RemisionPedido;
import com.elektra.uniformes.comercio.cron.dao.modelo.SolicitudDTO;
import com.elektra.uniformes.comercio.cron.util.FuncionesBD;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.CLOB;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author kortizl
 */
@Component("cargaSPPIDAO")
public class CargaSPPIDAO {

    @Autowired
    @Qualifier("funcionesBD")
    private FuncionesBD funcionesBD;
    @Autowired
    @Qualifier("fabricaDAO")
    private FabricaDAO fabricaDAO;

    public boolean validaDiaEnvio() throws Exception {
        boolean enviar = false;
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = fabricaDAO.getConexion();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            cs = conn.prepareCall(funcionesBD.FN_VALIDA_DIA);
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.execute();
            int n = (int) cs.getInt(1);
            if (n == 1) {
                enviar = true;
            }
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: validaDiaEnvio \n"
                    + "3. Excepcion: " + e.getMessage());
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            close(conn, cs, null);
        }
        return enviar;
    }

    public ArrayList<CargaSPPIDTO> consultaPendientesSPPI() throws Exception {
        Connection conn = null;
        CallableStatement cs = null;
        ArrayList<CargaSPPIDTO> listaPendientes = null;
        ResultSet rs = null;
        Mapper m = new Mapper();
        try {
            conn = fabricaDAO.getConexion();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            cs = conn.prepareCall(funcionesBD.FN_CONS_PENDIENTES_SPPI);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaPendientes = (ArrayList<CargaSPPIDTO>) m.mapperArrayBean(rs, CargaSPPIDTO.class);
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: consultaPendientesSPPI \n"
                    + "3. Excepcion: " + e.getMessage());
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            close(conn, cs, null);
        }
        return listaPendientes;
    }

    public ArrayList<CargaSPPIDTO> consultaSPPIPorActualizar() throws Exception {
        Connection conn = null;
        CallableStatement cs = null;
        ArrayList<CargaSPPIDTO> listaPendientesAct = new ArrayList<CargaSPPIDTO>();
        ResultSet rs = null;
        Mapper m = new Mapper();
        try {
            conn = fabricaDAO.getConexion();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            cs = conn.prepareCall(funcionesBD.FN_CONS_SPPI_POR_ACTUALIZAR);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaPendientesAct = (ArrayList<CargaSPPIDTO>) m.mapperArrayBean(rs, CargaSPPIDTO.class);
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: consultaSPPIPorActualizar \n"
                    + "3. Excepcion: " + e.getMessage());
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            close(conn, cs, null);
        }
        return listaPendientesAct;
    }

    public String actualizaSPPI(ArrayList<CargaSPPIDTO> pedidosSPPI) throws Exception {
        Connection conn = null;
        CallableStatement cs = null;
        OracleConnection oracleConnection = null;
        String errorGral = "";
        try {
            conn = fabricaDAO.getConexion();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            if (conn.isWrapperFor(OracleConnection.class)) {
                oracleConnection = conn.unwrap(OracleConnection.class);
            } else {
                oracleConnection = (OracleConnection) conn;
            }
            StructDescriptor carga = StructDescriptor.createDescriptor(funcionesBD.TYPE_CARGA_SPPI, (java.sql.Connection) oracleConnection);
            ArrayDescriptor arrCarga = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_ARR_CARGA_SPPI, (java.sql.Connection) oracleConnection);

            ArrayList<STRUCT> listaStructCargaSPPI = new ArrayList<STRUCT>();
            for (CargaSPPIDTO sppi : pedidosSPPI) {
                Object[] objSppi = new Object[14];
                objSppi[0] = sppi.getFoliosolicitud();
                objSppi[1] = sppi.getDetalle();
                objSppi[2] = sppi.getPedido();
                Clob request = conn.createClob();
                request.setString(1, sppi.getDatosProceso());
                objSppi[3] = request;
                objSppi[4] = sppi.getEstatusPedido();
                objSppi[5] = sppi.getPais();
                objSppi[6] = sppi.getCanal();
                objSppi[7] = sppi.getTienda();
                objSppi[8] = sppi.getSku();
                objSppi[9] = sppi.getCarga();
                objSppi[10] = sppi.getAvance();
                objSppi[11] = sppi.getDocumento();
                objSppi[12] = sppi.getObservaciones();
                objSppi[13] = sppi.getEstatus();
                STRUCT strRem = new STRUCT(carga, (java.sql.Connection) oracleConnection, objSppi);
                listaStructCargaSPPI.add(strRem);
            }

            STRUCT arrCargaStr[] = listaStructCargaSPPI.toArray(new STRUCT[listaStructCargaSPPI.size()]);
            ARRAY arrayCarga = new ARRAY(arrCarga, (java.sql.Connection) oracleConnection, arrCargaStr);

            cs = conn.prepareCall(funcionesBD.SP_ACTUALIZA_PEDIDOS_SPPI);
            cs.setArray(1, arrayCarga);
            cs.execute();
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: actualizaSPPI \n"
                    + "3. Excepcion: " + e.getMessage());
            LogeoDAO.getInstancia().logStackExcepcion(e);
            errorGral = e.getMessage();
        } finally {
            close(conn, cs, null);
            return errorGral;
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
