package com.sunnywr.proxy;
import com.sunnywr.proxy.InvocationHandler;
import java.lang.reflect.Method;
public class $Proxy0 implements com.sunnywr.proxy.Moveable {
    private InvocationHandler h;
    public $Proxy0(InvocationHandler h) {
        this.h = h;
    }
    public void move() {
        try { 
            Method method = com.sunnywr.proxy.Moveable.class.getMethod("move");
            h.invoke(this, method);
        } catch(Exception e) { e.printStackTrace(); }
    }
}