package com.shuttle.leetcode;

public class Test921 {
}

class Solution921 {
    public int minAddToMakeValid(String s) {
        int result = 0;
        int leftBracket = 0;
        char[] sCharArray = s.toCharArray();

        for (char ch : sCharArray) {
            if (ch == '(') {
                leftBracket++;
            } else {
                if (leftBracket > 0) {
                    leftBracket--;
                } else {
                    result++;
                }
            }
        }
        result += leftBracket;

        return result;
    }
}
