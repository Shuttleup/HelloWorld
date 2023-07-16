package com.shuttle.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test30 {
}

class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return null;
        }
        List<Integer> resultList = new ArrayList<>();
        int sLen = s.length();
        int wordsLen = words.length;
        int singleWordLen = words[0].length();
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i + wordsLen * singleWordLen <= sLen; i++) {
            Map<String, Integer> curSubstrMap = new HashMap<>();
            String substr = s.substring(i, i + wordsLen * singleWordLen);
            int substrLen = substr.length();
            for (int j = 0; j < substrLen; j += singleWordLen) {
                String word = substr.substring(j, j + singleWordLen);
                if (!wordsMap.containsKey(word)) {
                    break;
                }
                curSubstrMap.put(word, curSubstrMap.getOrDefault(word, 0) + 1);
            }
            if (curSubstrMap.equals(wordsMap)) {
                resultList.add(i);
            }
        }

        return resultList;
    }
}
