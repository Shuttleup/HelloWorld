package com.shuttle.leetcode;

import java.util.Arrays;

public class Test16 {
}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int numsLen = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < numsLen; i++) {
            int curNum = nums[i];
            int left = i + 1;
            int right = numsLen - 1;
            while (left < right) {
                int sum = curNum + nums[left] + nums[right];
                result = Math.abs(sum - target) > Math.abs(result - target) ? result : sum;
                if (result == target) {
                    return result;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
