package com.exer7um;

public class Main {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
    }

    static synchronized void gg() throws InterruptedException {
        System.out.println("------");
        Thread.sleep(1000);
    }

    public static class MyThread extends Thread {
        public void run() {
            while (true) {
                int i = 0;
                try {
                    gg();
                    System.out.println(this.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i > 20) {
                    break;
                }
            }
        }
    }
}
