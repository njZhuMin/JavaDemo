package com.sunnywr;

public class Child extends Person {
    @Override
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {
        System.out.println("Singing...");
    }
}
