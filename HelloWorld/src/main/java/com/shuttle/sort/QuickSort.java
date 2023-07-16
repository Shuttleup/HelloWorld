package com.shuttle.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 3, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        sortHelper(nums, 0, nums.length - 1);
    }

    private static void sortHelper(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = nums[left];
        int leftIndex = left;
        int rightIndex = right;

        // 从后往前找一个比pivot小的数
        while (leftIndex < rightIndex) {
            while (pivot <= nums[rightIndex] && leftIndex < rightIndex) {
                rightIndex--;
            }
            while (pivot >= nums[leftIndex] && leftIndex < rightIndex) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                swapTwoNum(nums, leftIndex, rightIndex);
            }
        }

        nums[left] = nums[leftIndex];
        nums[leftIndex] = pivot;
        sortHelper(nums, left, leftIndex - 1);
        sortHelper(nums, rightIndex + 1, right);
    }

    public static void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}
