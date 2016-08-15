package com.sunnywr;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnn {
    public static void main(String[] args) {
        //第一种解析方法
        try {
            //使用类加载器加载类
            Class c = Class.forName("com.sunnywr.Child");
            //获取类的注解
            if(c.isAnnotationPresent(Description.class)) {
                //获取注解实例
                Description d = (Description)c.getAnnotation(Description.class);
                System.out.println(d.value());
            }

            //获取方法的注解
            Method[] methods = c.getMethods();
            for(Method m : methods) {
                if(m.isAnnotationPresent(Description.class)) {
                    Description d = (Description)m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }
            }

            //第二种解析方法
            for(Method m : methods) {
                Annotation[] annotations = m.getAnnotations();
                for(Annotation a : annotations) {
                    if(a instanceof Description) {
                        Description d = (Description)a;
                        System.out.println(d.value());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
