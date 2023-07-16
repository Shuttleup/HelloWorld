package com.shuttle.threethread;

public class SyncWaitNotify {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                SyncWaitNotifyPrintABC.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                SyncWaitNotifyPrintABC.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                SyncWaitNotifyPrintABC.printC();
            }
        }, "C").start();
    }
}

class SyncWaitNotifyPrintABC {

    private static final Object LOCK = new Object();

    private static boolean isAExecuted = false;
    private static boolean isBExecuted = false;
    private static boolean isCExecuted = true;

    public static void printA() {
        synchronized (LOCK) {
            while (!isCExecuted) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("ThreadA execute...");
            isAExecuted = true;
            isCExecuted = false;
            LOCK.notifyAll();
        }
    }

    public static void printB() {
        synchronized (LOCK) {
            while (!isAExecuted) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("ThreadB execute...");
            isBExecuted = true;
            isAExecuted = false;
            LOCK.notifyAll();
        }
    }

    public static void printC() {
        synchronized (LOCK) {
            while (!isBExecuted) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("ThreadC execute...");
            isCExecuted = true;
            isBExecuted = false;
            LOCK.notifyAll();
        }
    }

}
