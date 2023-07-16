package com.shuttle.leetcode;

public class Test738 {
}

class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        if (n < 10) {
            return n;
        }
        char[] sCharArray = String.valueOf(n).toCharArray();
        int descIndex = 0;
        int nLen = sCharArray.length;

        // 找到当前下降二元组的第一位元素
        while (descIndex + 1 < nLen && sCharArray[descIndex] <= sCharArray[descIndex + 1]) {
            descIndex++;
        }
        if (descIndex == nLen - 1) {
            return n;
        }
        // 再往前看是否有相等的数字
        while (descIndex - 1 >= 0 && sCharArray[descIndex - 1] == sCharArray[descIndex]) {
            descIndex--;
        }
        sCharArray[descIndex] = (char) (sCharArray[descIndex] - 1);
        descIndex++;
        while (descIndex < nLen) {
            sCharArray[descIndex] = '9';
            descIndex++;
        }

        return Integer.parseInt(new String(sCharArray));
    }
}
