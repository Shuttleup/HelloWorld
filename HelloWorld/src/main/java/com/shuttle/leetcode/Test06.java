package com.shuttle.leetcode;

public class Test06 {
}

class Solution06 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2) {
            return s;
        }
        StringBuilder[] sBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sBuilders[i] = new StringBuilder();
        }
        int increOrDecre = 1;
        int curArrIndex = 0;
        int sLen = s.length();

        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            sBuilders[curArrIndex].append(ch);
            curArrIndex += increOrDecre;
            if (curArrIndex == 0 || (curArrIndex + 1) % numRows == 0) {
                increOrDecre = -increOrDecre;
            }
        }
        StringBuilder resultString = new StringBuilder();
        for (StringBuilder sBuilder : sBuilders) {
            resultString.append(sBuilder);
        }

        return resultString.toString();
    }
}
