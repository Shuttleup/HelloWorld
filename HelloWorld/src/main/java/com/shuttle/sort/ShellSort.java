package com.shuttle.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 3, 4};
        sort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int numsLen = nums.length;
        int increment = numsLen;

        while (increment > 1) {
            increment = increment / 3 + 1;
            for (int i = increment; i < numsLen; i++) {
                if (nums[i - increment] > nums[i]) {
                    int j = i - increment;
                    int temp = nums[i];
                    while (j >= 0 && nums[j] > temp) {
                        nums[j + increment] = nums[j];
                        j -= increment;
                    }
                    nums[j + increment] = temp;
                }
            }
        }
    }

    public static void sort2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int numsLen = nums.length;
        int increment = numsLen;

        while (increment > 1) {
            increment = increment / 3 + 1;
            for (int i = increment; i < numsLen; i++) {
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
                int j = i - increment;
                while (j >= right + 1) {
                    nums[j + increment] = nums[j];
                    j -= increment;
                }
                nums[j + increment] = temp;
            }
        }
    }

}
