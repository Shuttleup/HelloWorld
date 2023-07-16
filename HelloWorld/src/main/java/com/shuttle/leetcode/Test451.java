package com.shuttle.leetcode;

import java.util.*;

public class Test451 {
}

class Solution451 {
    public String frequencySort(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        Map<Character, Integer> charFreqMap = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        for (char ch : sCharArray) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }
        // int[2] Pair {字符 : 频率}
        Queue<int[]> pairQueue = new PriorityQueue<>(
                (pair1, pair2) -> pair2[1] == pair1[1]
                        ? pair1[0] - pair2[0]
                        : pair2[1] - pair1[1]);

        Set<Character> charKeySet = charFreqMap.keySet();
        for (Character ch : charKeySet) {
            pairQueue.offer(new int[]{ch, charFreqMap.get(ch)});
        }

        StringBuilder sBuilder = new StringBuilder();
        while (!pairQueue.isEmpty()) {
            int[] pair = pairQueue.poll();
            int ch = pair[0];
            int count = pair[1];
            while (count > 0) {
                count--;
                sBuilder.append((char) ch);
            }
        }

        return sBuilder.toString();
    }
}
