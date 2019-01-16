/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.dao;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.mapper.Mapper;
import com.elektra.uniformes.comercio.cron.dao.modelo.NotaCargoEntrada;
import com.elektra.uniformes.comercio.cron.util.FuncionesBD;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("notaCargoEntradaDAO")
public class NotaCargoEntradaDAO {
    
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
     * Guarda en la base de datos de UNIFORMES.TANOTASCARGOENTRADA
     * @param notas
     * @throws Exception 
     */
    public void guardaNotasCargoEntrada(ArrayList<NotaCargoEntrada> notas){
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
            
            StructDescriptor sdNotasCargoEntrada = StructDescriptor.createDescriptor(funcionesBD.TYPE_NOTA_CARGO_ENTRADA, (java.sql.Connection)oracleConnection);
            ArrayList<STRUCT> listaStruct = new ArrayList<STRUCT>();     
            for (NotaCargoEntrada notaCargoEntrada : notas) {
                Object[] objeto = new Object[23];
                objeto[0] = notaCargoEntrada.getNoFolioSolicitud();             //FIFOLIOSOLICITUD
                objeto[1] = notaCargoEntrada.getNoIDDetalle();                  //FIIDDETALLE
                objeto[2] = notaCargoEntrada.getNoPais();                       //FIPAIS
                objeto[3] = notaCargoEntrada.getNoCanal();                      //FICANAL
                objeto[4] = notaCargoEntrada.getNoPedido();                     //FIPEDIDO
                objeto[5] = notaCargoEntrada.getNoTienda();                     //FISUCURSAL
                objeto[6] = notaCargoEntrada.getNoSKU();                        //FISKU
                objeto[7] = notaCargoEntrada.getNoCantidadRequerida();          //FICANTIDADREQ
                objeto[8] = notaCargoEntrada.getNoCantidadSurtida();            //FICANTIDADSURT
                objeto[9] = notaCargoEntrada.getNoFolioRemision();              //FIFOLIOREMISION
                objeto[10] = notaCargoEntrada.getFdFechaRemision();             //FDFECHAREMISION
                objeto[11] = notaCargoEntrada.getNoRuta();                      //FIRUTA
                objeto[12] = notaCargoEntrada.getNoNotaCargo();                 //FINOTACARGO
                objeto[13] = notaCargoEntrada.getNoNotaEntrada();               //FINOTAENTRADA
                objeto[14] = notaCargoEntrada.getCadenaDescripcionRemision();   //FCESTREMISION
                objeto[15] = notaCargoEntrada.getCadenaObservacionesNC();       //FCOBSERVACIONESNC
                objeto[16] = notaCargoEntrada.getCadenaObservacionesNE();       //FCOBSERVACIONESNE
                objeto[17] = notaCargoEntrada.getCadenaFechaActualizacion();    //FCFECHAACTCD
                objeto[18] = notaCargoEntrada.isError() ? 1 : 0;                //FIERROR
                objeto[19] = notaCargoEntrada.getMsjError();                    //FCMSJERROR
                Clob request = conn.createClob();
                request.setString(1, notaCargoEntrada.getCadenaXMLResponse());
                objeto[20] = request;                                           //FCXMLRESPONSE
                objeto[21] = notaCargoEntrada.getNoEstatusSol();                //FIESTATUSSOL
                objeto[22] = notaCargoEntrada.getCadenaFolioWM();               //FCFOLIOWM
                STRUCT struct = new STRUCT(sdNotasCargoEntrada,(java.sql.Connection)oracleConnection,objeto);
                listaStruct.add(struct);                   
            }
            
            STRUCT arregloStruct[] = listaStruct.toArray(new STRUCT[listaStruct.size()]);
            ArrayDescriptor ad = ArrayDescriptor.createDescriptor(funcionesBD.TYPE_ARR_NOTA_CARGO_ENTRADA, (java.sql.Connection) oracleConnection);
            ARRAY arraySeguimiento = new ARRAY(ad,(java.sql.Connection)oracleConnection,arregloStruct);
            
            LogeoDAO.getInstancia().logExcepcion("Inicia el Stored Procedure para actualizar las notas de cargo-entrada " + funcionesBD.SP_ACT_NOTAS_CARGO_ENTRADA);
            
            cs = conn.prepareCall(funcionesBD.SP_ACT_NOTAS_CARGO_ENTRADA);
            cs.setArray(1, arraySeguimiento);
            cs.registerOutParameter(2, OracleTypes.NUMBER);
            cs.execute();
            
            LogeoDAO.getInstancia().logExcepcion("Termino el Stored Procedure llamado:" + funcionesBD.SP_ACT_NOTAS_CARGO_ENTRADA);                        
        } catch (Exception e) {            
            error = e.getMessage();
            LogeoDAO.getInstancia().logExcepcion(
                "1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n" +
                "2. Nombre del metodo: " + nombreMetodo + "\n" +
                "3. Excepcion: " + e.getMessage()
            );   
            LogeoDAO.getInstancia().logStackExcepcion(e);
        } finally {
            correoDAO.envio(notas.toArray(), this.getClass().toString(), nombreMetodo, inicio, error);
            close(conn, cs, rs);
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
