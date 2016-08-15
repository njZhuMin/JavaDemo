package com.sunnywr.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

public class FirstListener implements ServletContextListener,
        HttpSessionListener, ServletRequestListener {

    // Public constructor is required by servlet spec
    public FirstListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        String initParam = sce.getServletContext().getInitParameter("initParam");
        System.out.println("contextInitialized : initParam = " + initParam);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated" + new Date());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed" + new Date());
    }

    // -------------------------------------------------------
    // ServletRequestListener implementation
    // -------------------------------------------------------

    public void requestInitialized(ServletRequestEvent sre) {
        String name = sre.getServletRequest().getParameter("name");
        System.out.println("requestInitialized : name = " + name);
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("requestDestroyed");
    }
}
