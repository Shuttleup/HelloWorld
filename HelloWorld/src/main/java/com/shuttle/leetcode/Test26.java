package com.shuttle.leetcode;

public class Test26 {
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int numsLen = nums.length;
        if (nums.length < 2) {
            return numsLen;
        }
        int index = 0;

        for (int i = 1; i < numsLen; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return ++index;
    }
}
