package com.sunnywr.proxy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        Car car = new Car();
//        CarTimeProxy ctp = new CarTimeProxy(car);
//        CarLogProxy clp = new CarLogProxy(ctp);
//        clp.move();
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class, h);
        m.move();
    }
}
