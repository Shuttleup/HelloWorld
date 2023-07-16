package com.interview;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1, 3, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        sort(nums, 0, len - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = nums[left];
        int leftIndex = left;
        int rightIndex = right;

        while (leftIndex < rightIndex) {
            while (nums[rightIndex] >= pivot && rightIndex > leftIndex) {
                rightIndex--;
            }
            while (nums[leftIndex] <= pivot && rightIndex > leftIndex ) {
                leftIndex++;
            }
            if (rightIndex > leftIndex) {
                swapTwoNum(nums, rightIndex, leftIndex);
            }
        }
        nums[left] = nums[leftIndex];
        nums[leftIndex] = pivot;
        sort(nums, left, leftIndex - 1);
        sort(nums, rightIndex + 1, right);
    }

    private static void swapTwoNum(int[] nums, int rightIndex, int leftIndex) {
        int temp = nums[rightIndex];
        nums[rightIndex] = nums[leftIndex];
        nums[leftIndex] = temp;
    }

}
