package com.shuttle.leetcode;

public class Test04 {
}

class Solution04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1Len = nums1.length;
        int n2Len = nums2.length;
        if (n1Len > n2Len) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = n1Len;
        int part1Max = 0;
        int part2Min = 0;

        while (left <= right) {
            // [0, n1Index - 1] [0, n2Index - 1]
            // [n1Index, n1Len] [n2Index, n2Len]
            int n1Index = (left + right) / 2;
            int n2Index = (n1Len + n2Len + 1) / 2 - n1Index;
            int n1Part1Max = (n1Index == 0 ? Integer.MIN_VALUE : nums1[n1Index - 1]);
            int n1Part2Min = (n1Index == n1Len ? Integer.MAX_VALUE : nums1[n1Index]);
            int n2Part1Max = (n2Index == 0 ? Integer.MIN_VALUE : nums2[n2Index - 1]);
            int n2Part2Min = (n2Index == n2Len ? Integer.MAX_VALUE : nums2[n2Index]);

            if (n1Part1Max <= n2Part2Min) {
                part1Max = Math.max(n1Part1Max, n2Part1Max);
                part2Min = Math.min(n1Part2Min, n2Part2Min);
                left = n1Index + 1;
            } else {
                right = n1Index - 1;
            }
        }

        return (n1Len + n2Len) % 2 == 0 ? (part1Max + part2Min) / 2.0 : part1Max;
    }
}
