package com.shuttle.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 3, 4};
        sort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int nLen = nums.length;
        for (int i = 0; i < nLen - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nLen; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swapTwoNum(nums, i, minIndex);
        }
    }

    public static void sort2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            for (int i = left; i <= right; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
            swapTwoNum(nums, maxIndex, right);
            if (minIndex == right) {
                minIndex = maxIndex;
            }
            swapTwoNum(nums, minIndex, left);
            left++;
            right--;
        }
    }

    public static void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}
