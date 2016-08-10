package com.sunnywr.cglibproxy;

public class ProxyTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train t = (Train)proxy.getProxy(Train.class);
        t.move();
    }
}
