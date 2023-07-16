package com.shuttle.leetcode;

public class Test55 {
}

class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxDistance = 0;
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            if (maxDistance >= i) {
                maxDistance = Math.max(maxDistance, i + nums[i]);
            }
            if (maxDistance >= numsLen - 1) {
                return true;
            }
        }

        return false;
    }
}
