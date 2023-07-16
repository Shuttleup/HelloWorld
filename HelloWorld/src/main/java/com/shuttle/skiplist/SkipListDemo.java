package com.shuttle.skiplist;

import java.util.ArrayList;
import java.util.List;

public class SkipListDemo {

    private Node head;

    private final List<Node> skipList;

    private int level;

    public SkipListDemo(int interval, int[] nums) {
        head = new Node();
        head.next = head;
        skipList = new ArrayList<>();
        initSkipList(interval, nums);
    }

    private void initSkipList(int interval, int[] nums) {
        Node temp = head;
        Node cur = null;
        for (int num : nums) {
            cur = new Node(num);
            cur.prev = temp;
            temp.next = cur;
            temp = temp.next;
        }
        skipList.add(head);

        temp = head.next;
        while (true) {
            int curListIndex = 0;
            int nextListSize = 0;
            Node nextListHead = new Node();
            nextListHead.next = nextListHead;
            Node nextListCur = nextListHead;
            while (temp != null) {
                if (curListIndex % interval == 0) {
                    Node node = new Node(temp.val);
                    node.nextIndexNode = temp;
                    node.prev = nextListCur;
                    nextListCur.next = node;
                    nextListCur = nextListCur.next;
                    nextListSize++;
                }
                curListIndex++;
                temp = temp.next;
            }
            skipList.add(nextListHead);
            temp = nextListHead.next;
            if (nextListSize <= 1) {
                break;
            }
        }

        level = skipList.size();
    }

    public Node get(int val) {
        Node node = skipList.get(level - 1).next;
        Node prev = null;
        while (node != null) {
            if (node.val == val) {
                return node;
            }
            if (node.val > val) {
                if (prev == null) {
                    return null;
                }
                node = prev.nextIndexNode;
                prev = null;
                continue;
            }
            prev = node;
            if (node.next != null) {
                node = node.next;
            } else {
                node = node.nextIndexNode;
            }
        }

        return null;
    }

    private static class Node {

        int val;
        Node next;
        Node prev;
        Node nextIndexNode;

        Node(int val) {
            this.val = val;
        }

        Node() {
        }

    }

}
