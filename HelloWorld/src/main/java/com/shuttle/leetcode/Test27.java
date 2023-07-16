package com.shuttle.leetcode;

public class Test27 {
}

class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curIndex = 0;
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            if (nums[i] != val) {
                nums[curIndex++] = nums[i];
            }
        }

        return curIndex;
    }
}
