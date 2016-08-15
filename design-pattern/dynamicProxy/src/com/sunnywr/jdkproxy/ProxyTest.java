package com.sunnywr.jdkproxy;

import com.sunnywr.proxy.Car;
import com.sunnywr.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler handler = new TimeHandler(car);
        Class<?> clazz = car.getClass();
        /**
         * @param loader 被代理类类加载器
         * @param interfaces 实现接口
         * @param h InvocationHandler
         */
        Moveable m = (Moveable)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
        m.move();
    }
}
