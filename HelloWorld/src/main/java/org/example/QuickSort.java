package org.example;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 4, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int arrLen = arr.length;
        sortHelper(arr, 0, arrLen - 1);
    }

    private static void sortHelper(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = arr[left];
        int leftIndex = left;
        int rightIndex = right;
        // 从前往后找一个比pivot大的，从后往前找一个比pivot小的
        while (leftIndex < rightIndex) {
            while (arr[rightIndex] >= pivot && leftIndex < rightIndex) {
                rightIndex--;
            }
            while (arr[leftIndex] <= pivot && leftIndex < rightIndex) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                swapTwoNum(arr, leftIndex, rightIndex);
            }
        }
        arr[left] = arr[leftIndex];
        arr[leftIndex] = pivot;

        sortHelper(arr, left, leftIndex - 1);
        sortHelper(arr, rightIndex + 1, right);
    }

    private static void swapTwoNum(int[] arr, int source, int target) {
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }

}
