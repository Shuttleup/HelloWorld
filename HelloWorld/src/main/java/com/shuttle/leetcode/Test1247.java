package com.shuttle.leetcode;

public class Test1247 {
}

class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        if (s1 == null || s2 == null
                || s1.length() == 0 || s2.length() == 0
                || s1.length() != s2.length()) {
            return -1;
        }

        int xyCount = 0;
        int yxCount = 0;
        int sLen = s1.length();

        for (int i = 0; i < sLen; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xyCount++;
            }
            if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yxCount++;
            }
        }

        if ((xyCount + yxCount) % 2 != 0) {
            return -1;
        }

        return (xyCount / 2 + yxCount / 2) + (xyCount % 2 + yxCount % 2);
    }
}
