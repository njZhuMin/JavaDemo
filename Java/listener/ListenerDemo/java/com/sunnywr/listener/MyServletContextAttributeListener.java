package com.sunnywr.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("ServletContext_attributeAdded : " + event.getName());
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("ServletContext_attributeRemoved : " + event.getName());
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("ServletContext_attributeReplaced : " + event.getName());
    }
}
