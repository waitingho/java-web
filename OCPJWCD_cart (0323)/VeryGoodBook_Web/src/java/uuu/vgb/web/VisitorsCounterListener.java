/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Administrator
 */
//@WebListener
public class VisitorsCounterListener implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        application.log("vgb網站應用系統啟動了...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        application.log("vgb網站應用系統即將結束....");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext application = se.getSession().getServletContext();
        application.log("vgb網站應用系統建立了一個session: " + se.getSession().getId());
        Integer visitors = (Integer)application.getAttribute("app.visitors");
        if(visitors==null){
            visitors = 0;
        }        
        application.setAttribute("app.visitors", ++visitors);
        se.getSession().setAttribute("app.visitors", visitors);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext application = se.getSession().getServletContext();
        application.log("vgb網站應用系統即將結束一個session: " + se.getSession().getId());        
    }
}
