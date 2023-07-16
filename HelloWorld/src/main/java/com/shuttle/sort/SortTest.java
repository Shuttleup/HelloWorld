package com.shuttle.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 5, 3};
        HeapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
