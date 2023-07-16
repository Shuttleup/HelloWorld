package com.shuttle.leetcode;

public class Test154 {
}

class Solution154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] < nums[right]){
                // [left, mid]
                right = mid;
            } else {
                right--;
            }
        }

        return nums[left];
    }
}
