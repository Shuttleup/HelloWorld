package com.shuttle.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test560 {
}

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int subarraySumCount = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int prefixSum = 0;
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            prefixSum += nums[i];
            if (prefixSumMap.containsKey(prefixSum - k)) {
                subarraySumCount += prefixSumMap.get(prefixSum - k);
            }
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return subarraySumCount;
    }
}
