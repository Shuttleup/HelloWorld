package com.shuttle.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test448 {
}

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int numsLen = nums.length;
        for (int num : nums) {
            int index = (num - 1) % numsLen;
            nums[index] += numsLen;
        }
        List<Integer> disappearNumberList = new ArrayList<>();

        for (int i = 0; i < numsLen; i++) {
            if (nums[i] <= numsLen) {
                disappearNumberList.add(i + 1);
            }
        }

        return disappearNumberList;
    }
}
