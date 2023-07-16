package com.interview;

import java.util.*;

public class Test1306 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 0, 3, 1, 2};
        Solution solution = new Solution();
        solution.canReach(arr, 5);
    }

}

class Solution {
    public boolean canReach(int[] arr, int start) {
        // 特判
        if (arr == null || arr.length == 0) {
            return false;
        }
        if (arr[0] == 0) {
            return true;
        }
        int arrLen = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[arrLen];
        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            int curNum = arr[curIndex];
            int temp1 = curIndex + curNum;
            int temp2 = curIndex - curNum;
            if (temp1 >= 0 && temp1 < arrLen) {
                if (arr[temp1] == 0) {
                    return true;
                }
                if (!isVisited[temp1]) {
                    isVisited[temp1] = true;
                    queue.offer(temp1);
                }
            }
            if (curIndex - curNum >= 0 && curIndex - curNum < arrLen) {
                if (arr[temp2] == 0) {
                    return true;
                }
                if (!isVisited[temp2]) {
                    isVisited[temp2] = true;
                    queue.offer(temp2);
                }
            }
        }

        return false;
    }
}
