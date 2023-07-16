package com.shuttle.leetcode;

public class Test718 {
}

class Solution718 {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int n1Len = nums1.length;
        int n2Len = nums2.length;

        return n1Len > n2Len ? getMaxSequence(nums1, nums2) : getMaxSequence(nums2, nums1);
    }

    private int getMaxSequence(int[] nums1, int[] nums2) {
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 1; i < n2Len; i++) {
            maxLen = Math.max(maxLen, getMaxSequence(nums1, n1Len - i, nums2, 0, i));
        }
        for (int i = n1Len - n2Len; i >= 0; i--) {
            maxLen = Math.max(getMaxSequence(nums1, i, nums2, 0, n2Len), maxLen);
        }
        for (int i = 1; i < n2Len; i++) {
            maxLen = Math.max(getMaxSequence(nums1, 0, nums2, i, n2Len - i), maxLen);
        }

        return maxLen;
    }

    private int getMaxSequence(int[] nums1, int n1Index, int[] nums2, int n2Index, int len) {
        int count = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[n1Index + i] == nums2[n2Index + i]) {
                count++;
            } else if (count > 0) {
                maxLen = Math.max(maxLen, count);
                count = 0;
            }
        }
        if (count > 0) {
            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }
}
