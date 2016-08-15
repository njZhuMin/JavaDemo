package com.sunnywr.proxy;

import java.util.Random;

public class Car implements Moveable {
    /**
     * 汽车行驶方法
     */
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("car driving...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
