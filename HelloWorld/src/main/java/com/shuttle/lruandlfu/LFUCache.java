package com.shuttle.lruandlfu;

import java.util.HashMap;
import java.util.Map;

public class LFUCache<K, V> {

    private final Map<K, Node<K, V>> keyToNodeMap;

    private final Map<Integer, DoubleLinkedList<K, V>> freqListMap;

    private static final int DEFAULT_CAPACITY = 10;
    private final int capacity;
    private int size;
    private int minFrequent;

    private static final int ONE_FREQUENT = 1;

    public LFUCache(int initialCapacity) {
        if (initialCapacity <= 0) {
            this.capacity = DEFAULT_CAPACITY;
        } else {
            this.capacity = initialCapacity;
        }
        this.keyToNodeMap = new HashMap<>();
        this.freqListMap = new HashMap<>();
    }

    public V get(K key) {
        Node<K, V> node = keyToNodeMap.get(key);
        if (node == null) {
            return null;
        }
        increFrequent(node);
        return node.val;
    }

    private void increFrequent(Node<K, V> node) {
        int frequent = node.frequent;
        DoubleLinkedList<K, V> freqDoubleList = freqListMap.get(frequent);
        freqDoubleList.remove(node);
        int newFreq = frequent + 1;
        if (frequent == minFrequent && freqDoubleList.head.next == freqDoubleList.tail) {
            minFrequent = newFreq;
        }
        node.frequent = newFreq;
        DoubleLinkedList<K, V> newFreqDoubleList = freqListMap.get(newFreq);
        if (newFreqDoubleList == null) {
            newFreqDoubleList = new DoubleLinkedList<>();
            freqListMap.put(newFreq, newFreqDoubleList);
        }
        newFreqDoubleList.addFirst(node);
    }

    public void put(K key, V val) {
        Node<K, V> node = keyToNodeMap.get(key);
        if (node != null) {
            node.val = val;
            increFrequent(node);
            return;
        }
        if (size >= capacity) {
            DoubleLinkedList<K, V> minFreqList = freqListMap.get(minFrequent);
            keyToNodeMap.remove(minFreqList.tail.prev.key);
            minFreqList.remove(minFreqList.tail.prev);
            size--;
        }
        Node<K, V> newNode = new Node<>(key, val);
        keyToNodeMap.put(key, newNode);
        DoubleLinkedList<K, V> oneFreqList = freqListMap.get(ONE_FREQUENT);
        if (oneFreqList == null) {
            oneFreqList = new DoubleLinkedList<>();
            freqListMap.put(ONE_FREQUENT, oneFreqList);
        }
        oneFreqList.addFirst(newNode);
        size++;
        minFrequent = ONE_FREQUENT;
    }

    private static class DoubleLinkedList<K, V> {

        final Node<K, V> head;
        final Node<K, V> tail;

        DoubleLinkedList() {
            this.head = new Node<>();
            this.tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node<K, V> node) {
            // head <=> node <=> 1 <=> tail
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        void remove(Node<K, V> node) {
            // head <=> node <=> 1 <=> tail
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

    private static class Node<K, V> {

        K key;
        V val;
        Node<K, V> next;
        Node<K, V> prev;

        int frequent;

        Node() {
        }

        Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.frequent = ONE_FREQUENT;
        }

    }

}
