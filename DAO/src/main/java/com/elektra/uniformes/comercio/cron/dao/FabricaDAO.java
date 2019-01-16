/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author kortizl
 */
@Component("fabricaDAO")
public class FabricaDAO {

    private Context contexto;
    private Connection conexion;
    private DataSource dataSourceUC;
    private DataSource dataSourceADN;
    private DataSource dataSourceRHSAP;
    private DataSource dataSourceRHEKT;
    private DataSource dataSourceDistrital;
    @Value("#{propiedadesCronUniformesComercio['DATASOURCE']}")
    private String DS;
    @Value("#{propiedadesCronUniformesComercio['DATASOURCE_ADNTRANSAC']}")
    private String DSADNTRANSAC;
    @Value("#{propiedadesCronUniformesComercio['DATASOURCE_RHSAP']}")
    private String DSRHSAP;
    @Value("#{propiedadesCronUniformesComercio['DATASOURCE_RHEKT']}")
    private String DSRHEKT;
    @Value("#{propiedadesCronUniformesComercio['DATASOURCE_DISTRITAL']}")
    private String DSAgendaOperaciones;    
    
    /**
     * Conexion Uniformes Comercio
     *
     * @return
     * @throws Exception
     */
    public Connection getConexion() throws Exception {
        try {

            if (dataSourceUC == null) {
                dataSourceUC = ((DataSource) contexto.lookup(DS));
            }
            if (dataSourceUC != null) {
                conexion = dataSourceUC.getConnection();

            }
        } catch (Exception ne) {
            //ConfigLogueo.logeoAbstractoDAO.logExcepcion("FabricaDAO: Ocurrio un Error en la conexion " + ne.getMessage());
            throw new Exception("FabricaDAO: Ocurrio un Error en la conexion " + ne.getMessage());
        }
        return conexion;
    }

    /**
     * Conexion: DSAdnTransac
     *
     * @return
     * @throws Exception
     */
    public Connection getConexionAdnT() throws Exception {
        try {

            if (dataSourceADN == null) {
                dataSourceADN = ((DataSource) contexto.lookup(DSADNTRANSAC));
            }
            if (dataSourceADN != null) {
                conexion = dataSourceADN.getConnection();

            }
        } catch (Exception ne) {
            throw new Exception("FabricaDAO: Ocurrio un Error en la conexion " + ne.getMessage());
        }
        return conexion;
    }

    /**
     * Conexion: DSRHSAP
     *
     * @return
     * @throws Exception
     */
    public Connection getConexionRHSAP() throws Exception {
        try {
            if (dataSourceRHSAP == null) {
                dataSourceRHSAP = ((DataSource) contexto.lookup(DSRHSAP));
            }
            if (dataSourceRHSAP != null) {
                conexion = dataSourceRHSAP.getConnection();
            }
        } catch (Exception ne) {
            throw new Exception("FabricaDAO: Ocurrio un Error en la conexion " + ne.getMessage());
        }
        return conexion;
    }
    
    /**
     * Conexion: Uniformes Banco
     * @return
     * @throws Exception 
     */
    public Connection getConexionRHEKT() throws Exception {
        try {
            if (dataSourceRHEKT == null) {
                dataSourceRHEKT = ((DataSource) contexto.lookup(DSRHEKT));
            }
            if (dataSourceRHEKT != null) {
                conexion = dataSourceRHEKT.getConnection();
            }
        } catch (Exception ne) {
            throw new Exception("FabricaDAO: Ocurrio un Error en la conexion RHEKT" + ne.getMessage());
        }
        return conexion;
    }
    
    /**
     * Conexion: Agenda comercio
     * @return
     * @throws Exception 
     */
    public Connection getConexionAgendaOperaciones() throws Exception {
        try {
            if (dataSourceDistrital == null) {
                dataSourceDistrital = ((DataSource) contexto.lookup(DSAgendaOperaciones));
            }
            if (dataSourceDistrital != null) {
                conexion = dataSourceDistrital.getConnection();
            }
        } catch (Exception ne) {
            throw new Exception("FabricaDAO: Ocurrio un Error en la conexion DSAgendaOperaciones" + ne.getMessage());
        }
        return conexion;
    }    

    public void setContexto(Context contex) {
        contexto = contex;
    }
}
