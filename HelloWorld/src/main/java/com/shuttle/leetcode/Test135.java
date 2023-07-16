package com.shuttle.leetcode;

import java.util.Arrays;

public class Test135 {
}

class Solution135 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int ratLen = ratings.length;
        int[] candys = new int[ratLen];
        Arrays.fill(candys, 1);
        // A在B左边 A | B
        // 左规则：B > A -> candyB = candyA + 1
        // 右规则：A > B -> candyA = candyB + 1
        for (int i = 1; i < ratLen; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        for (int i = ratLen - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candys[i - 1] = Math.max(candys[i - 1], candys[i] + 1);
            }
        }

        return Arrays.stream(candys).sum();
    }
}
