package com.shuttle.leetcode;

public class Test75 {
}

class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;

        for (int i = 0; i <= twoIndex; i++) {
            // 先把所有2放在后面
            while (i <= twoIndex && nums[i] == 2) {
                swapTwoNum(nums, i, twoIndex);
                twoIndex--;
            }
            // 再把0放前面
            if (nums[i] == 0) {
                swapTwoNum(nums, i, zeroIndex);
                zeroIndex++;
            }
        }
    }

    private void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}
