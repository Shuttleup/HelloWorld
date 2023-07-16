package com.shuttle.leetcode;

public class Test283 {
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int numsLen = nums.length;
        int zeroIndex = 0;
        int noZeroIndex = 0;

        while (noZeroIndex < numsLen) {
            if (nums[noZeroIndex] != 0) {
                swapTwoNum(nums, zeroIndex, noZeroIndex);
                zeroIndex++;
            }
            noZeroIndex++;
        }

    }

    private void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}
