package com.shuttle.leetcode;

public class Test581 {
}

class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numsLen = nums.length;
        int lastLessThanMax = -1;
        int lastGreaterThanMin = -1;
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;

        for (int i = 0; i < numsLen; i++) {
            // 正序遍历，找到最后一个小于最大值的值作为倒置数组的右边索引
            if (nums[i] < curMax) {
                lastLessThanMax = i;
            } else {
                curMax = nums[i];
            }
            // 倒序遍历，找到最后一个大于最小值的值作为倒置数组的左边索引
            int index = numsLen - i - 1;
            if (nums[index] > curMin) {
                lastGreaterThanMin = index;
            } else {
                curMin = nums[index];
            }
        }

        return lastGreaterThanMin == -1 ? 0 : lastLessThanMax - lastGreaterThanMin + 1;
    }
}
