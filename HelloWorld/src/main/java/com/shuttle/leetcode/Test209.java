package com.shuttle.leetcode;

public class Test209 {
}

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numsLen = nums.length;
        int minSubArrayLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < numsLen) {
            sum += nums[end];
            while (sum >= target) {
                minSubArrayLen = Math.min(minSubArrayLen, end - start + 1);
                sum -= nums[start];
                start++;
            }

            end++;
        }

        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }
}
