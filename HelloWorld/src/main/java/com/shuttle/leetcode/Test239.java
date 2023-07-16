package com.shuttle.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test239 {
}

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        Deque<Integer> indexStack = new ArrayDeque<>();
        int numsLen = nums.length;
        int[] res = new int[numsLen - k + 1];

        for (int i = 0; i < numsLen; i++) {
            int curNum = nums[i];
            while (!indexStack.isEmpty() && curNum >= nums[indexStack.peekLast()]) {
                indexStack.removeLast();
            }
            indexStack.addLast(i);
            if (i - k >= indexStack.peek()) {
                indexStack.pop();
            }
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[indexStack.peek()];
            }
        }

        return res;
    }
}
