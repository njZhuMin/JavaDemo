package com.sunnywr.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener{
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequest_attributeAdded : " + srae.getName());
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequest_attributeRemoved : " + srae.getName());
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequest_attributeReplaced : " + srae.getName());
    }
}
