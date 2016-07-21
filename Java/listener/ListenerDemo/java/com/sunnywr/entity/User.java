package com.sunnywr.entity;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class User implements HttpSessionBindingListener, HttpSessionActivationListener,
        //需要实现Serializable
        Serializable {
    private String username;
    private String password;

    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("valueBound name : " + event.getName());
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("valueUnbound name : " + event.getName());
    }

    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("sessionWillPassivate : " + se.getSource());
    }

    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("sessionDidActivate : " + se.getSource());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
