package com.shuttle.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test15 {
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resultList;
        }
        Arrays.sort(nums);
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            int curNum = nums[i];
            if (curNum > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = numsLen - 1;
            while (left < right) {
                int sum = curNum + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(Arrays.asList(curNum, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return resultList;
    }
}
