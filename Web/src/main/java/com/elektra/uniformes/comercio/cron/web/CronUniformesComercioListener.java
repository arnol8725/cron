/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.uniformes.comercio.cron.web;

import Com.Elektra.Log.Dao.LogeoDAO;
import com.elektra.uniformes.comercio.cron.dao.FabricaDAO;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author kortizl
 */
public class CronUniformesComercioListener implements ServletContextListener{

    @Autowired
    private FabricaDAO faC3;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            LogeoDAO.getInstancia().logExcepcion("INICIANDO APP...");
            WebApplicationContextUtils
                    .getRequiredWebApplicationContext(sce.getServletContext())
                    .getAutowireCapableBeanFactory()
                    .autowireBean(this);
            faC3.setContexto(new InitialContext());

        } catch (NamingException ex) {
            LogeoDAO.getInstancia().logExcepcion(this.getClass().getName() + " Se presento una excepcion al iniciar el proceso: " + ex.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LogeoDAO.getInstancia().logExcepcion("Se ha destruido el contexto");
    }
}
