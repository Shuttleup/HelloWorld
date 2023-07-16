package com.shuttle.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Test20 {
}

class Solution20 {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');
        char[] sCharArray = s.toCharArray();
        Deque<Character> bracketStack = new ArrayDeque<>();

        for (char ch : sCharArray) {
            if (bracketMap.containsKey(ch)) {
                if (bracketStack.isEmpty() || bracketStack.pop() != bracketMap.get(ch)) {
                    return false;
                }
            } else {
                bracketStack.push(ch);
            }
        }

        return bracketStack.isEmpty();
    }
}
