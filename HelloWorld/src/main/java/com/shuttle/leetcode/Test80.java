package com.shuttle.leetcode;

public class Test80 {
}

class Solution80 {
    public int removeDuplicates(int[] nums) {
        int numsLen = nums.length;
        if (numsLen <= 2) {
            return numsLen;
        }
        int slow = 2;
        int fast = 2;

        while (fast < numsLen) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
