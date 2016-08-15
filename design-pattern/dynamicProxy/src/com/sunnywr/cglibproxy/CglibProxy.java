package com.sunnywr.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor{

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 设置创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    /**
     * 拦截目标类所有方法的调用
     * @param o 目标类实例
     * @param method 目标方法反射对象
     * @param objects 方法的参数
     * @param methodProxy 代理类的实例
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("log starts...");
        // 通过代理类调用父类方法
        methodProxy.invokeSuper(o, objects);
        System.out.println("log ends...");
        return null;
    }
}
