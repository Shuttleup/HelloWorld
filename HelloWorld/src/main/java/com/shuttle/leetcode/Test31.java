package com.shuttle.leetcode;

public class Test31 {
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        // 从后往前找，找到一个降序数对
        int descIndex = nums.length - 2;
        while (descIndex >= 0 && nums[descIndex + 1] <= nums[descIndex]) {
            descIndex--;
        }
        // 再从后往前找一个比descIndex大的数进行交换
        if (descIndex >= 0) {
            int ascIndex = nums.length - 1;
            while (ascIndex >= 0 && nums[ascIndex] <= nums[descIndex]) {
                ascIndex--;
            }
            swapTwoNum(nums, ascIndex, descIndex);
        }
        // 再将descIndex + 1到结尾处翻转
        int end = nums.length - 1;
        descIndex++;
        while (descIndex < end) {
            swapTwoNum(nums, descIndex, end);
            descIndex++;
            end--;
        }
    }

    private void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

}
