package com.shuttle.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test03 {
}

class Solution03 {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int longestSubStrLen = 0;
        int sLen = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;

        for (int end = 0; end < sLen; end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }

            map.put(ch, end);
            longestSubStrLen = Math.max(longestSubStrLen, end - start + 1);
        }

        return longestSubStrLen;
    }
}
