package com.shuttle.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test215 {
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }
        int numsLen = nums.length;
        Queue<Integer> numQueue = new PriorityQueue<>((num1, num2) -> num1 - num2);

        for (int i = 0; i < k; i++) {
            numQueue.offer(nums[i]);
        }
        for (int i = k; i < numsLen; i++) {
            Integer topVal = numQueue.peek();
            if (topVal < nums[i]) {
                numQueue.poll();
                numQueue.offer(nums[i]);
            }
        }

        return numQueue.peek();
    }
}
