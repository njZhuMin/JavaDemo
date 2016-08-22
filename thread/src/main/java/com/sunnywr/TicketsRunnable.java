package com.sunnywr;

class MyThread2 implements Runnable{

    private int ticketCount = 5;

    public void run() {
        while(ticketCount > 0) {
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + "sold one, " + ticketCount + " tickets left.");
        }
    }
}

public class TicketsRunnable {

    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();

        Thread th1 = new Thread(mt, "Thread 1");
        Thread th2 = new Thread(mt, "Thread 2");
        Thread th3 = new Thread(mt, "Thread 3");
        
        th1.start();
        th2.start();
        th3.start();
    }
}
