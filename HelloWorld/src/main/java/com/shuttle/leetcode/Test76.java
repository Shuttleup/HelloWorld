package com.shuttle.leetcode;

public class Test76 {
}

class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || s.equals("")
                || t == null || t.equals("")
                || s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] have = new int[128];
        char[] tCharArray = t.toCharArray();
        for (char ch : tCharArray) {
            need[ch]++;
        }

        int left = 0;
        int right = 0;
        int sLen = s.length();
        int tLen = t.length();
        int start = 0;
        int minLen = sLen + 1;
        int count = 0;

        while (right < sLen) {
            char charR = s.charAt(right);
            if (need[charR] == 0) {
                right++;
                continue;
            }
            if (need[charR] > have[charR]) {
                count++;
            }
            have[charR]++;
            right++;

            while (count == tLen) {
                if (minLen > right - left) {
                    minLen = right - left;
                    start = left;
                }
                char charL = s.charAt(left);
                if (need[charL] == 0) {
                    left++;
                    continue;
                }
                if (need[charL] == have[charL]) {
                    count--;
                }
                have[charL]--;
                left++;
            }
        }

        return minLen == sLen + 1 ? "" : s.substring(start, start + minLen);
    }
}
