package com.shuttle.sort;

import java.util.Arrays;

public class InsertSort {
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
        for (int i = 1; i < nLen; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                swapTwoNum(nums, j, j + 1);
            }
        }
    }

    public static void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

    public static void sort2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int numsLen = nums.length;
        for (int i = 1; i < numsLen; i++) {
            int left = 0;
            int right = i - 1;
            int temp = nums[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > temp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int j;
            for (j = i - 1; j >= right + 1; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }

}
