package com.shuttle.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test49 {
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> groupMap = new HashMap<>();

        for (String str : strs) {
            char[] strCharArray = str.toCharArray();
            int[] freqArr = new int[26];
            for (char ch : strCharArray) {
                freqArr[ch - 'a']++;
            }

            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                int freq = freqArr[i];
                if (freq == 0) {
                    continue;
                }
                sBuilder.append(i + 'a');
                sBuilder.append(freqArr[i]);
            }
            String key = sBuilder.toString();
            List<String> strList = groupMap.getOrDefault(key, new ArrayList<>());
            strList.add(str);
            groupMap.put(key, strList);
        }

        return new ArrayList<>(groupMap.values());
    }
}
