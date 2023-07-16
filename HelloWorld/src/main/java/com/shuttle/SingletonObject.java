package com.shuttle;

public class SingletonObject {

    private static SingletonObject singletonObject = null;

    private SingletonObject() {
    }

    public static SingletonObject getSingletonObject() {
        if (singletonObject == null) {
            synchronized (SingletonObject.class) {
                singletonObject = new SingletonObject();
            }
        }

        return singletonObject;
    }

}
