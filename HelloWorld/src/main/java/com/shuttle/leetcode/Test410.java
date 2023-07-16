package com.shuttle.leetcode;

import java.util.Arrays;

public class Test410 {
}

class Solution410 {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (splitHelper(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean splitHelper(int[] nums, int threshold, int k) {
        int sum = 0;
        int count = 1;
        int numsLen = nums.length;
        for (int i = 0; i < numsLen; i++) {
            if (sum + nums[i] > threshold) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }

        return k >= count;
    }
}
