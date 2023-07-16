package com.shuttle.lruandlfu;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    // key -> Node<K, V>
    private final Map<K, Node<K, V>> keyToNodeMap;
    // Node<K, V> <=> Node<K, V>
    private final DoubleLinkedList<K, V> linkedList;

    private final int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public LRUCache(int initialCapacity) {
        if (initialCapacity <= 0) {
            this.capacity = DEFAULT_CAPACITY;
        } else {
            this.capacity = initialCapacity;
        }
        keyToNodeMap = new HashMap<>();
        linkedList = new DoubleLinkedList<>();
        size = 0;
    }

    public V get(K key) {
        if (!keyToNodeMap.containsKey(key)) {
            return null;
        }
        // 访问当前节点需要将其先移动到队列尾部
        moveNodeToTail(key);

        return keyToNodeMap.get(key).val;
    }

    private void moveNodeToTail(K key) {
        // 先删除 后插入
        Node<K, V> node = keyToNodeMap.get(key);
        linkedList.remove(node);
        linkedList.addLast(node);
    }

    public void put(K key, V val) {
        // 如果已经存在，则直接覆盖，需要移到尾部
        if (keyToNodeMap.containsKey(key)) {
            deleteKey(key);
            addNewNode(key, val);
            return;
        }
        if (this.capacity <= this.size) {
            removeFirst();
        }
        addNewNode(key, val);
    }

    private void removeFirst() {
        Node<K, V> delNode = linkedList.head.next;
        if (delNode == linkedList.tail) {
            return;
        }
        keyToNodeMap.remove(delNode.key);
        linkedList.remove(delNode);
        size--;
    }

    private void deleteKey(K key) {
        Node<K, V> delNode = keyToNodeMap.get(key);
        linkedList.remove(delNode);
        keyToNodeMap.remove(key);
        size--;
    }

    private void addNewNode(K key, V val) {
        Node<K, V> newNode = new Node<>(key, val);
        linkedList.addLast(newNode);
        keyToNodeMap.put(key, newNode);
        size++;
    }

    private static class DoubleLinkedList<K, V> {

        final Node<K, V> head;
        final Node<K, V> tail;

        DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 添加Node到链表尾部【最新的元素】
         */
        void addLast(Node<K, V> node) {
            // head <=> Node1 <=> node <=> tail
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        /**
         * 移除指定 Node
         */
        void remove(Node<K, V> node) {
            // head <=> Node1 <=> node <=> Node2 <-> tail
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

    private static class Node<K, V> {

        K key;
        V val;
        Node<K, V> next;
        Node<K, V> prev;

        Node() {
        }

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

    }

}
