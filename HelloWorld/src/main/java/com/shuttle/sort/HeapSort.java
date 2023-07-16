package com.shuttle.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 3, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int numsLen = nums.length;

        for (int i = numsLen / 2 - 1; i >= 0; i--) {
            buildHeap(nums, numsLen, i);
        }

        for (int i = numsLen - 1; i > 0; i--) {
            swapTwoNum(nums, i, 0);
            buildHeap(nums, i, 0);
        }

    }

    private static void buildHeap(int[] nums, int len, int index) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != index) {
            swapTwoNum(nums, largest, index);
            buildHeap(nums, len, largest);
        }
    }

    private static void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }


}
