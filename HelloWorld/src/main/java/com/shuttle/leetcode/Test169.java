package com.shuttle.leetcode;

public class Test169 {
}

class Solution169 {
    public int majorityElement(int[] nums) {
        int group = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                group = num;
            }
            count += num == group ? 1 : -1;
        }

        return group;
    }
}
