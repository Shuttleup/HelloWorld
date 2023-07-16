package com.shuttle.leetcode;

public class Test45 {
}

class Solution45 {
    public int jump(int[] nums) {
        int maxDistance = 0;
        int rightArea = 0;
        int distance = nums.length - 1;
        int count = 0;

        for (int i = 0; i < distance; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (i == rightArea) {
                count++;
                rightArea = maxDistance;
            }
        }

        return count;
    }
}
