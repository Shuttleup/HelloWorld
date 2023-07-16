package com.shuttle.leetcode;

import java.util.Arrays;

public class Test455 {
}

class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLen = g.length;
        int sLen = s.length;
        int curCookie = 0;
        int curChild = 0;
        int count = 0;

        while (curCookie < sLen && curChild < gLen) {
            while (curCookie < sLen && g[curChild] > s[curCookie]) {
                curCookie++;
            }
            if (curCookie < sLen) {
                count++;
                curChild++;
                curCookie++;
            }
        }

        return count;
    }
}
