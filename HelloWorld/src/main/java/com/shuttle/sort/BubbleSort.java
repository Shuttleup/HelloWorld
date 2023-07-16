package com.shuttle.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 3, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int nLen = nums.length;

        for (int i = 0; i < nLen - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < nLen - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    swapTwoNum(nums, j, j + 1);
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

}
