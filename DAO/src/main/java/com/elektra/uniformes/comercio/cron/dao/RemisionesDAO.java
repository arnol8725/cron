/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.RemisionPedido;
import com.elektra.uniformes.comercio.cron.util.FuncionesBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
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
@Component("remisionesDAO")
public class RemisionesDAO {

    @Autowired
    @Qualifier("funcionesBD")
    private FuncionesBD funcionesBD;
    @Autowired
    @Qualifier("fabricaDAO")
    private FabricaDAO fabricaDAO;

    public String actualizaRemisionesPedido(ArrayList<RemisionPedido> remisiones) throws Exception {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        String errGral = "";
        try {
            conn = fabricaDAO.getConexion();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            for (RemisionPedido rem : remisiones) {
                cs = conn.prepareCall(funcionesBD.SP_ACT_REMISION_COMERCIO);
                cs.setInt(1, rem.getSucursal());
                cs.setInt(2, rem.getPedido());
                cs.setInt(3, rem.getSku());
                cs.setInt(4, rem.getRemision());
                cs.setInt(5, rem.getCantidad());
                cs.setInt(6, rem.getEmpleado());
                cs.registerOutParameter(7, OracleTypes.NUMBER);
                cs.execute();
                int r = (int) cs.getInt(7);
                if (r == 0) {
                    rem.setObs("Pedido no encontrado");
                } else {
                    rem.setObs("Remision guardada correctamente");
                    rem.setDiv("DIV. COMERCIO");
                    rem.setEstatus(3);
                }
            }
            errGral = "Remisiones grabadas correctamente";
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: " + nombreMetodo + "\n"
                    + "3. Excepcion: " + e.getMessage());
            errGral = e.getMessage();
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            close(conn, cs, rs);
            return errGral;
        }
    }

    public String actualizaDiferenciaRemision(ArrayList<RemisionPedido> remisiones) throws Exception {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        String errGral = "";
        
        try {
            conn = fabricaDAO.getConexion();
            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            for (RemisionPedido rem : remisiones) {
                cs = conn.prepareCall(funcionesBD.SP_ACT_DIFERENCIA_REMISION);
                cs.setInt(1, rem.getSucursal());
                cs.setInt(2, rem.getPedido());
                cs.setInt(3, rem.getSku());
                cs.setInt(4, rem.getRemision());
                cs.registerOutParameter(5, OracleTypes.NUMBER);
                cs.execute();
                int r = (int) cs.getInt(5);
                if (r == 0) {
                    rem.setObs("Pedido no encontrado");
                    rem.setEstatus(2);
                } else {
                    rem.setObs("Pedido cancelado por diferencia en remision");
                    rem.setEstatus(1);
                }
            }
            errGral = "Diferencia de Remisiones grabada correctamente";
        } catch (Exception e) {
            LogeoDAO.getInstancia().logExcepcion(
                    "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: " + nombreMetodo + "\n"
                    + "3. Excepcion: " + e.getMessage());
            LogeoDAO.getInstancia().logStackExcepcion(e);
            errGral = e.getMessage();
        } finally {
            close(conn, cs, rs);
            return errGral;
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
