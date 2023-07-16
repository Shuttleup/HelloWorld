package com.shuttle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        List<SingletonObject> singletonObjects = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                SingletonObject singletonObject = SingletonObject.getSingletonObject();
                singletonObjects.add(singletonObject);
            }).start();
        }
//        Thread.sleep(1000);
        int num = 0;
        SingletonObject temp = singletonObjects.get(0);
        for (SingletonObject singletonObject : singletonObjects) {
            if (temp != singletonObject) {
                num++;
                System.out.println("创建了多个单例对象");
            }
        }
        System.out.println(num);
        Map<SingletonObject, Integer> groupSingletonMap = new HashMap<>();
        for (SingletonObject singletonObject : singletonObjects) {
            groupSingletonMap.put(singletonObject, groupSingletonMap.getOrDefault(singletonObject, 0) + 1);
        }
        for (Map.Entry<SingletonObject, Integer> singletonObjectIntegerEntry : groupSingletonMap.entrySet()) {
            SingletonObject key = singletonObjectIntegerEntry.getKey();
            Integer value = singletonObjectIntegerEntry.getValue();
            System.out.println("当前单例对象:" + key + "创建了: " + value + "次");
        }
        System.out.println(groupSingletonMap.size());
    }


}
