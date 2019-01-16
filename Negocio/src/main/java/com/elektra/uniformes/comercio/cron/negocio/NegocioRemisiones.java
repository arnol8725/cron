/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.negocio;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.CorreoDAO;
import com.elektra.uniformes.comercio.cron.dao.RemisionesDAO;
import com.elektra.uniformes.comercio.cron.dao.RemisionesRHEKTDAO;
import com.elektra.uniformes.comercio.cron.dao.modelo.RemisionPedido;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author kortizl
 */
@Component("negocioRemisiones")
public class NegocioRemisiones {

    @Autowired
    @Qualifier("remisionesRHEKTDAO")
    private RemisionesRHEKTDAO remisionesRHEKTDAO;
    @Autowired
    @Qualifier("remisionesDAO")
    private RemisionesDAO remisionesDAO;
    @Autowired
    @Qualifier("correoDAO")
    private CorreoDAO correoDAO;

    public void actualizaRemisiones() throws Exception {
        ArrayList<RemisionPedido> remisiones = new ArrayList<RemisionPedido>();
        ArrayList<RemisionPedido> difRemision = new ArrayList<RemisionPedido>();
        String msjErrorGral = "";
        Date inicioProc = new Date();
        try {
            LogeoDAO.getInstancia().logExcepcion("INICIA PROCESO ACTUALIZACION REMISIONES : " + new Date());
            LogeoDAO.getInstancia().logExcepcion("Consulta remisiones esquema RHEKT");
            remisiones = remisionesRHEKTDAO.getRemisionesPedido();
            int remObt = remisiones.size();
            LogeoDAO.getInstancia().logExcepcion("Remisiones obtenidas: " + remObt);
            if (remObt > 0) {
                LogeoDAO.getInstancia().logExcepcion("Actualiza remisiones en esquema UNIFORMES");
                remisionesDAO.actualizaRemisionesPedido(remisiones);
                LogeoDAO.getInstancia().logExcepcion("Actualiza estatus remisiones en esquema RHEKT");
                remisionesRHEKTDAO.actualizaEstatusRemisionesPedido(remisiones);
                LogeoDAO.getInstancia().logExcepcion("Termino actualizacion Remisiones correctamente");
            } else {
                LogeoDAO.getInstancia().logExcepcion("No se obtuvieron remisiones del esquema RHEKT");
            }
            
            LogeoDAO.getInstancia().logExcepcion("INICIA PROCESO DIFERENCIA DE REMISION : " + new Date());
            LogeoDAO.getInstancia().logExcepcion("Consulta diferencia de remisiones esquema RHEKT");
            difRemision = remisionesRHEKTDAO.getDiferenciaRemisiones();
            int remDifObt = difRemision.size();
            LogeoDAO.getInstancia().logExcepcion("Remisiones (diferencia) obtenidas: " + remDifObt);
            if (remObt > 0) {
                LogeoDAO.getInstancia().logExcepcion("Actualiza diferencia de remision en esquema UNIFORMES");
                remisionesDAO.actualizaDiferenciaRemision(difRemision);
                LogeoDAO.getInstancia().logExcepcion("Actualiza estatus diferencia de remision en esquema RHEKT");
                remisionesRHEKTDAO.actualizaEstatusDiferenciaRemision(difRemision);
                LogeoDAO.getInstancia().logExcepcion("Termino actualizacion diferencia de Remisiones correctamente");
            } else {
                LogeoDAO.getInstancia().logExcepcion("No se obtuvieron diferencias de remision del esquema RHEKT");
            }
            
        } catch (Exception ex) {
            msjErrorGral = ex.getMessage();
            LogeoDAO.getInstancia().logExcepcion("1. Ocurrio un error en la clase: " + this.getClass().getName() + "\n"
                    + "2. Nombre del metodo: actualizaRemisiones \n"
                    + "3. Excepcion: " + ex.getMessage());
        } finally {
            correoDAO.envio(remisiones.toArray(), this.getClass().toString(), "actualizaRemisiones", inicioProc, msjErrorGral);
            correoDAO.envio(difRemision.toArray(), this.getClass().toString(), "actualizaRemisiones (Diferencia)", inicioProc, msjErrorGral);
        }
    }
}
