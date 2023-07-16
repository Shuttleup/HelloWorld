package com.interview;

import java.util.Arrays;
import java.util.List;

public class Solution01 {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 2, 3};
        sortArray1(nums);
        System.out.println("=====方式一结果如下=====");
        System.out.println(Arrays.toString(nums));
        System.out.println();
        int[] nums2 = new int[]{-4, -1, 0, 2, 3};
        sortArray2(nums2);
        System.out.println("=====方式二结果如下=====");
        System.out.println(Arrays.toString(nums2));
    }

    // 方式二：O(N) 暂时没想到...
    public static void sortArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 先记录下所有小于0的数
        int len = nums.length;
        List<Integer> lessZeroList = Arrays.stream(nums).filter(item -> item < 0).boxed().toList();
    }

    // 方式一：转换 + 归并
    public static void sortArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 常规的转换数组后采用快排或者归并都能达到 Nlog(N)
        convertArray(nums);
        sort(nums);
    }

    // 每一个元素进行平方处理
    private static void convertArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] * nums[i];
        }
    }

    // 归并排序
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
        // 已经有顺序了
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
