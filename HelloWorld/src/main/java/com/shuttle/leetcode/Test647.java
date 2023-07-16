package com.shuttle.leetcode;

public class Test647 {
}

class Solution647 {
    public int countSubstrings(String s) {
        int sLen = s.length();
        char[] sCharArray = s.toCharArray();
        int res = sLen;

        for (int i = 0; i < sLen; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < sLen && sCharArray[left] == sCharArray[right]) {
                res++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < sLen && sCharArray[left] == sCharArray[right]) {
                res++;
                left--;
                right++;
            }
        }

        return res;
    }
}
