package com.sunnywr;

@Description("I am interface")
public class Person {
    @Description("I am interface method")
    public String name() {
        return null;
    }
    public int age() {
        return 0;
    }
    @Deprecated
    public void sing() {
        System.out.println("Singing...");
    }
}