package com.sunnywr.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    public void invoke(Object object, Method method) {
        try {
            long startTime = System.currentTimeMillis();
            System.out.println("car start...");

            method.invoke(target);

            long endTime = System.currentTimeMillis();
            System.out.println("car stop...");
            System.out.println("time: " + (endTime - startTime) + "ms.");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
