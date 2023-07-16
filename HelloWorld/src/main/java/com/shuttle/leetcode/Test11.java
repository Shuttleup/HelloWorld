package com.shuttle.leetcode;

public class Test11 {
}

class Solution11 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxCapacity = 0;

        while (left < right) {
            int curCapacity = (right - left) * Math.min(height[left], height[right]);
            maxCapacity = Math.max(curCapacity, maxCapacity);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxCapacity;
    }
}
