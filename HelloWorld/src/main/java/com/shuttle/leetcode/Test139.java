package com.shuttle.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test139 {
}

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        if ((wordDict == null || wordDict.size() == 0)) {
            return false;
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        int sLen = s.length();
        // dp[i] 代表用wordDict前i个字符串能否组成s
        boolean[] dp = new boolean[sLen + 1];
        dp[0] = true;

        for (int i = 1; i <= sLen; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[sLen];
    }
}
