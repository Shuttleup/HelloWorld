package com.shuttle.leetcode;

public class Test424 {
}

class Solution424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sLen = s.length();
        if (sLen < 2) {
            return sLen;
        }

        char[] sCharArray = s.toCharArray();
        int[] table = new int[128];
        int result = 0;
        int left = 0;
        int right = 0;
        int maxCount = 0;

        while (right < sLen) {
            table[sCharArray[right]]++;
            maxCount = Math.max(maxCount, table[sCharArray[right]]);
            right++;

            if (maxCount + k < right - left) {
                table[sCharArray[left]]--;
                left++;
            }

            result = Math.max(maxCount, right - left);
        }

        return result;
    }
}
