package com.shuttle.leetcode;

public class Test14 {
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        int count = strs.length;

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j - 1].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
