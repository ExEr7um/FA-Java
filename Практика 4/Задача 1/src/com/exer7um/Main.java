package com.exer7um;

public class Main {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        System.out.println(myThread1.getState());
        System.out.println(myThread2.getState());
        myThread1.start();
        myThread2.start();
        System.out.println(myThread1.getState());
        System.out.println(myThread2.getState());
    }

    static synchronized void gg() {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
    }

    public static class MyThread extends Thread {
        public void run() {
            gg();
        }
    }
}
