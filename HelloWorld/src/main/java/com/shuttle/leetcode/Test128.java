package com.shuttle.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Test128 {
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestConsecutive = 0;

        for (Integer num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            int curNum = num;
            int curSequence = 1;
            while (numSet.contains(curNum + 1)) {
                curNum++;
                curSequence++;
            }

            longestConsecutive = Math.max(curSequence, longestConsecutive);
        }

        return longestConsecutive;
    }
}
