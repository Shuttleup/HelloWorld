package com.shuttle.sort;


import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 3, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    private static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        if (nums[mid] < nums[mid + 1]) {
            return;
        }

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        // 将temp数组分为 [left, mid] [mid + 1, right] 两部分
        int leftIndex = left;
        int rightIndex = mid + 1;

        for (int i = left; i <= right; i++) {
            if (leftIndex == mid + 1) {
                nums[i] = temp[rightIndex++];
            } else if (rightIndex == right + 1) {
                nums[i] = temp[leftIndex++];
            } else if (temp[leftIndex] < temp[rightIndex]) {
                nums[i] = temp[leftIndex++];
            } else if (temp[leftIndex] >= temp[rightIndex]) {
                nums[i] = temp[rightIndex++];
            }
        }
    }

}
