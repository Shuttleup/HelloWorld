package com.shuttle.leetcode;

public class Test28 {
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || "".equals(haystack) || needle == null || "".equals(needle)) {
            return -1;
        }
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        for (int i = 0; i <= haystackLen - needleLen; i++) {
            int haystackIndex = i;
            int needleIndex = 0;
            while (needleIndex < needleLen
                    && needle.charAt(needleIndex) == haystack.charAt(haystackIndex)) {
                needleIndex++;
                haystackIndex++;
            }
            if (needleIndex == needleLen) {
                return i;
            }
        }

        return -1;
    }
}
