package com.sunnywr.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("HttpSession_attributeAdded : " + event.getName());
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("HttpSession_attributeRemoved : " + event.getName());
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("HttpSession_attributeReplaced : " + event.getName());
    }
}
