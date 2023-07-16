package com.shuttle.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test01 {
}

class Solution01 {
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> sumMap = new HashMap<>();
        int nLen = nums.length;

        for (int i = 0; i < nLen; i++) {
            int num = nums[i];
            if (sumMap.containsKey(target - num)) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = sumMap.get(target - num);
                return res;
            }

            sumMap.put(num, i);
        }

        return null;
    }
}
