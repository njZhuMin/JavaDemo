package com.sunnywr.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy 被代理的对象
     * @param method 被代理对象的方法
     * @param args 方法的参数
     * @return Object对象，调用方法的返回值
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("car start...");
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("car stop...");
        System.out.println("time: " + (endTime - startTime) + "ms.");
        return null;
    }
}
