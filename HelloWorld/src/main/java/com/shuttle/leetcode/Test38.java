package com.shuttle.leetcode;

public class Test38 {
}

class Solution38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sBuilder = new StringBuilder();
            int start = 0;
            int curIndex = 0;
            int len = str.length();
            while (curIndex < len) {
                while (curIndex < len && str.charAt(curIndex) == str.charAt(start)) {
                    curIndex++;
                }
                sBuilder.append(curIndex - start).append(str.charAt(start));
                start = curIndex;
            }
            str = sBuilder.toString();
        }

        return str;
    }
}
