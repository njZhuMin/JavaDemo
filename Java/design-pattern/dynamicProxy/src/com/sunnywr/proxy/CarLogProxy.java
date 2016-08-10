package com.sunnywr.proxy;

public class CarLogProxy implements Moveable {

    private Moveable m;

    public CarLogProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("log start...");
        m.move();
        System.out.println("log end...");
    }
}
