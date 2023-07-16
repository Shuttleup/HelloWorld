package com.shuttle.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test316 {
}

class Solution316 {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int sLen = s.length();
        char[] sCharArray = s.toCharArray();
        int[] lastIndexArr = new int[26];
        for (int i = 0; i < sLen; i++) {
            lastIndexArr[sCharArray[i] - 'a'] = i;
        }

        Deque<Character> charStack = new ArrayDeque<>();
        boolean[] isVisited = new boolean[26];
        for (int i = 0; i < sLen; i++) {
            char curChar = sCharArray[i];
            if (isVisited[curChar - 'a']) {
                continue;
            }
            // 当前栈不为空 && 字典序【栈底 > 当前】 && 待移除的字符后面还会出现
            while (!charStack.isEmpty()
                    && charStack.peekLast() > curChar
                    && lastIndexArr[charStack.peekLast() - 'a'] > i) {
                char topChar = charStack.removeLast();
                isVisited[topChar - 'a'] = false;
            }
            isVisited[curChar - 'a'] = true;
            charStack.addLast(curChar);
        }

        StringBuilder sBuilder = new StringBuilder();
        for (Character character : charStack) {
            sBuilder.append(character);
        }

        return sBuilder.toString();
    }
}
