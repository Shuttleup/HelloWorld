package com.shuttle.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Test32 {
}

class Solution32 {
    public int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int maxLen = 0;
        char[] sCharArray = s.toCharArray();
        int sLen = s.length();
        Deque<Integer> indexDeque = new ArrayDeque<>();
        indexDeque.push(-1);

        for (int i = 0; i < sLen; i++) {
            if (sCharArray[i] == '(') {
                indexDeque.push(i);
            } else {
                indexDeque.pop();
                if (indexDeque.isEmpty()) {
                    indexDeque.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - indexDeque.peek());
                }
            }
        }

        return maxLen;
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int sLen = s.length();
        int[] dp = new int[sLen];

        for (int i = 1; i < sLen; i++) {
            if (s.charAt(i) == ')') {
                int preLen = dp[i - 1];
                int pre = i - 1 - preLen;
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (pre - 1 >= 0) {
                        dp[i] += dp[pre - 1];
                    }
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

}
