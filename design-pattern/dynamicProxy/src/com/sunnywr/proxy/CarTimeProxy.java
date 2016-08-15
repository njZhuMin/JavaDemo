package com.sunnywr.proxy;

public class CarTimeProxy implements Moveable {

    private Moveable m;

    public CarTimeProxy(Moveable m) {
        this.m = m;
    }

    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("car start...");
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println("car stop...");
        System.out.println("time: " + (endTime - startTime) + "ms.");
    }
}
