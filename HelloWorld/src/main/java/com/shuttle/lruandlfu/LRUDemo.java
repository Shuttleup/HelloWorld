package com.shuttle.lruandlfu;

import java.util.HashMap;
import java.util.Map;

public class LRUDemo<K, V> {

    private final Map<K, Node<K, V>> lruMap;
    private final DoubleLinkedList<K, V> linkedList;
    private int capacity;
    private int size;

    public DoubleLinkedList<K, V> getLinkedList() {
        return this.linkedList;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return this.size;
    }

    public LRUDemo(int initialCapacity) {
        lruMap = new HashMap<>();
        linkedList = new DoubleLinkedList<>();
        capacity = initialCapacity;
        size = 0;
    }

    public V get(K key) {
        if (!lruMap.containsKey(key)) {
            return null;
        }
        moveKeyToTail(key);

        return lruMap.get(key).value;
    }

    private void moveKeyToTail(K key) {
        Node<K, V> delNode = lruMap.get(key);
        linkedList.remove(delNode);
        linkedList.addLast(delNode);
    }

    public V put(K key, V value) {
        if (lruMap.containsKey(key)) {
            addNewNode(key, value);
            return deleteKey(key);
        }
        if (this.capacity <= this.size) {
            removeFirst();
        }
        addNewNode(key, value);

        return null;
    }

    private void addNewNode(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        linkedList.addLast(newNode);
        lruMap.put(key, newNode);
        size++;
    }

    /**
     * 删除某一个键
     *
     * @param key 待删除的键
     * @return 删除键对应的value
     */
    private V deleteKey(K key) {
        Node<K, V> delNode = lruMap.get(key);
        linkedList.remove(delNode);
        size--;
        return lruMap.remove(key).value;
    }

    private void removeFirst() {
        Node<K, V> delNode = linkedList.head.next;
        if (delNode == linkedList.tail) {
            return;
        }
        linkedList.remove(delNode);
        lruMap.remove(delNode.key);
        size--;
    }

    private static class DoubleLinkedList<K, V> {

        Node<K, V> head;
        Node<K, V> tail;

        DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 添加Node 到链表尾部
         *
         * @param newNode 1
         */
        void addLast(Node<K, V> newNode) {
            newNode.prev = tail.prev;
            newNode.next = tail;
            tail.prev.next = newNode;
            tail.prev = newNode;
        }

        void remove(Node<K, V> delNode) {
            delNode.prev.next = delNode.next;
            delNode.next.prev = delNode.prev;
        }

    }

    private static class Node<K, V> {

        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
