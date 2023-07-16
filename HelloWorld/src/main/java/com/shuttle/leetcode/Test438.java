package com.shuttle.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test438 {
}

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return null;
        }
        List<Integer> resultList = new ArrayList<>();
        Map<Character, Integer> needCharMap = new HashMap<>();
        char[] pCharArray = p.toCharArray();
        for (char ch : pCharArray) {
            needCharMap.put(ch, needCharMap.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = p.length();
        String substr = s.substring(left, right);
        char[] substrChars = substr.toCharArray();
        Map<Character, Integer> haveCharMap = new HashMap<>();

        for (char ch : substrChars) {
            haveCharMap.put(ch, haveCharMap.getOrDefault(ch, 0) + 1);
        }

        int sLen = s.length();
        while (right <= sLen) {
            if (haveCharMap.equals(needCharMap)) {
                resultList.add(left);
            }
            char key = s.charAt(left);
            Integer count = haveCharMap.getOrDefault(key, 0);
            if (count == 0 || count == 1) {
                haveCharMap.remove(key);
            } else {
                haveCharMap.put(key, count - 1);
            }
            left++;
            if (right != sLen) {
                char charR = s.charAt(right);
                haveCharMap.put(charR, haveCharMap.getOrDefault(charR, 0) + 1);
            }
            right++;
        }

        return resultList;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return null;
        }
        List<Integer> resultList = new ArrayList<>();
        int[] asciiTable = new int[128];
        char[] pCharArray = p.toCharArray();
        for (char ch : pCharArray) {
            asciiTable[ch]++;
        }
        int left = 0;
        int right = 0;
        int pLen = p.length();
        int sLen = s.length();

        while (right < sLen) {
            if (asciiTable[s.charAt(right)] > 0) {
                asciiTable[s.charAt(right++)]--;
                if (right - left == pLen) {
                    resultList.add(left);
                }
            } else {
                asciiTable[s.charAt(left++)]++;
            }
        }

        return resultList;
    }
}
