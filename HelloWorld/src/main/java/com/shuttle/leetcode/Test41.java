package com.shuttle.leetcode;

public class Test41 {
}

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int numsLen = nums.length;
        for (int i = 0; i < numsLen; i++) {
            while (nums[i] > 0 && nums[i] <= numsLen && nums[nums[i] - 1] != nums[i]) {
                swapTwoNum(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < numsLen; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return numsLen + 1;
    }

    private void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}
