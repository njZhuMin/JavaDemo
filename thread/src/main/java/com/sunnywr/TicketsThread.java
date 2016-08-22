package com.sunnywr;

class MyThread extends Thread {

    private int ticketCount = 5;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(ticketCount > 0) {
            ticketCount--;
            System.out.println(name + "sold one, " + ticketCount + " tickets left.");
        }
    }
}

public class TicketsThread {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("Thread 1");
        MyThread mt2 = new MyThread("Thread 2");
        MyThread mt3 = new MyThread("Thread 3");

        mt1.start();
        mt2.start();
        mt3.start();
    }
}
