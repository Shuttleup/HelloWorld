package com.shuttle.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test394 {
}

class Solution394 {
    public String decodeString(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> resultStack = new ArrayDeque<>();
        char[] sCharArray = s.toCharArray();
        int count = 0;
        StringBuilder resultString = new StringBuilder();

        for (char ch : sCharArray) {
            if (ch == '[') {
                countStack.push(count);
                resultStack.push(resultString.toString());
                count = 0;
                resultString = new StringBuilder();
            } else if (ch == ']') {
                int curCount = countStack.pop();
                StringBuilder sBuilder = new StringBuilder();
                for (int i = 0; i < curCount; i++) {
                    sBuilder.append(resultString);
                }
                resultString = new StringBuilder(resultStack.pop() + sBuilder);
            } else if (ch >= '0' && ch <= '9') {
                count = count * 10 + Integer.parseInt(String.valueOf(ch));
            } else {
                resultString.append(ch);
            }
        }

        return resultString.toString();
    }
}
