package com.shuttle.lruandlfu;

import java.util.HashMap;
import java.util.Map;

public class LFUDemo<K, V> {

    /** 访问频率 1 常量 */
    private static final int ONE_FREQUENT = 1;

    /** key 与 节点的映射 */
    private final Map<K, Node<K, V>> lfuMap;

    // freqMap
    private final Map<Integer, DoubleLinkedList<K, V>> freqMap;
    private final int capacity;
    private int size;
    private int minFreq;

    public LFUDemo(int capacity) {
        lfuMap = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public V get(K key) {
        Node<K, V> node = lfuMap.get(key);
        if (node == null) {
            return null;
        }
        increFrequent(node);

        return node.value;
    }

    public void put(K key, V value) {
        if (capacity == 0) {
            return;
        }
        Node<K, V> node = lfuMap.get(key);
        if (node != null) {
            node.value = value;
            increFrequent(node);
        } else {
            if (size == capacity) {
                DoubleLinkedList<K, V> minFreqLinkedList = freqMap.get(minFreq);
                lfuMap.remove(minFreqLinkedList.tail.prev.key);
                minFreqLinkedList.remove(minFreqLinkedList.tail.prev);
                size--;
            }
            Node<K, V> newNode = new Node<>(key, value);
            lfuMap.put(key, newNode);
            DoubleLinkedList<K, V> oneFreqLinkedList = freqMap.get(ONE_FREQUENT);
            if (oneFreqLinkedList == null) {
                oneFreqLinkedList = new DoubleLinkedList<>();
                freqMap.put(ONE_FREQUENT, oneFreqLinkedList);
            }
            oneFreqLinkedList.addNode(newNode);
            size++;
            minFreq = ONE_FREQUENT;
        }
    }

    /**
     *
     *
     * @param node 待添加的节点
     */
    private void increFrequent(Node<K, V> node) {
        int frequent = node.frequent;
        DoubleLinkedList<K, V> freqLinkedList = freqMap.get(frequent);
        freqLinkedList.remove(node);
        if (frequent == minFreq && freqLinkedList.head.next == freqLinkedList.tail) {
            minFreq = frequent + 1;
        }
        node.frequent++;
        int newFreq = frequent + 1;
        freqLinkedList = freqMap.get(newFreq);
        if (freqLinkedList == null) {
            freqLinkedList = new DoubleLinkedList<>();
            freqMap.put(newFreq, freqLinkedList);
        }
        freqLinkedList.addNode(node);
    }

    private static class DoubleLinkedList<K, V> {

        private final Node<K, V> head;
        private final Node<K, V> tail;

        private DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(Node<K, V> node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            LRUDemo<Object, Object> objectObjectLRUDemo = new LRUDemo<>(1);
        }

        private void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

    private static class Node<K, V> {

        private K key;
        private V value;
        int frequent = ONE_FREQUENT;
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
