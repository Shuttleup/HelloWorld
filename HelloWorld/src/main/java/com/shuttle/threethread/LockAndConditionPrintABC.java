package com.shuttle.threethread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndConditionPrintABC {
    public static void main(String[] args) {
        new Thread(() -> {
            printA(5);
        }, "ThreadA").start();
        new Thread(() -> {
            printB(5);
        }, "ThreadB").start();
        new Thread(() -> {
            printC(5);
        }, "ThreadC").start();
    }

    private static final Lock LOCK = new ReentrantLock();
    private static final Condition CONDITION = LOCK.newCondition();

    private static volatile int state = 1;


    public static void printA(int count) {

        LOCK.lock();
        try {
            for (int i = 0; i < count; ) {
                if (state == 1) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + " execute...");
                    state = 2;
                    CONDITION.signalAll();
                } else {
                    CONDITION.await();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            LOCK.unlock();
        }

    }

    public static void printB(int count) {

        LOCK.lock();
        try {
            for (int i = 0; i < count; ) {
                if (state == 2) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + " execute...");
                    state = 3;
                    CONDITION.signalAll();
                } else {
                    CONDITION.await();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            LOCK.unlock();
        }

    }

    public static void printC(int count) {

        LOCK.lock();
        try {
            for (int i = 0; i < count; ) {
                if (state == 3) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + " execute...");
                    state = 1;
                    CONDITION.signalAll();
                } else {
                    CONDITION.await();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            LOCK.unlock();
        }

    }

}

interface A {

    default void test() {}

}

class B implements A {
}
