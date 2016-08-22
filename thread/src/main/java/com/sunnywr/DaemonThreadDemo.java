package com.sunnywr;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class DaemonThread implements Runnable {
    public void run() {
        System.out.println("Daemon thread starts... " + Thread.currentThread().getName());
        try {
            writeToFile();
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Daemon thread ends... " + Thread.currentThread().getName());
    }

    private void writeToFile() throws Exception{
        File filename = new File("daemon.txt");
        OutputStream os = new FileOutputStream(filename, true);
        int count = 0;
        while(count < 999) {
            os.write(("\n word" + count).getBytes());
            System.out.println("Daemon thread "
                    + Thread.currentThread().getName() + " write " + count++);
            Thread.sleep(1000);
        }
    }
}

public class DaemonThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main thread starts... " + Thread.currentThread().getName());
        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("Main thread ends... " + Thread.currentThread().getName());
    }
}

