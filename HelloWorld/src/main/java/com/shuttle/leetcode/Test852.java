package com.shuttle.leetcode;

public class Test852 {
}

class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 2;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                right = mid + 1;
            } else {
                left = mid;
            }
        }

        return left;
    }
}
