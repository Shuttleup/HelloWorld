package com.shuttle.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test402 {
}

class Solution402 {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }
        Deque<Character> charStack = new ArrayDeque<>();
        char[] numCharArray = num.toCharArray();

        for (char ch : numCharArray) {
            while (!charStack.isEmpty() && k > 0 && ch < charStack.peekLast()) {
                charStack.removeLast();
                k--;
            }
            charStack.addLast(ch);
        }
        for (int i = 0; i < k; i++) {
            charStack.removeLast();
        }

        boolean isContainsPreZero = true;
        StringBuilder sBuilder = new StringBuilder();
        while (!charStack.isEmpty()) {
            Character popChar = charStack.pop();
            if (isContainsPreZero && popChar == '0') {
                continue;
            }
            sBuilder.append(popChar);
            isContainsPreZero = false;
        }

        return sBuilder.length() == 0 ? "0" : sBuilder.toString();
    }
}
