package com.interview;

public class ReverseLong {
    public static void main(String[] args) {
        System.out.println(reverseLong(12345L));
    }

    private static Long reverseLong(long num) {
        String numStr = String.valueOf(num);
        char[] numChars = numStr.toCharArray();
        int len = numChars.length;
        for (int i = 0; i < len / 2; i++) {
            swapTwoChar(numChars, i, len - i - 1);
        }

        return Long.parseLong(new String(numChars));
    }

    private static void swapTwoChar(char[] chars, int source, int target) {
        char temp = chars[source];
        chars[source] = chars[target];
        chars[target] = temp;
    }

//    private static long reverseLong(long arg) {
//        long ans = 1;
//        boolean start = true;
//        boolean negative = arg < 0;
//        arg = Math.abs(arg);
//        while (arg >= 1) {
//            long mod = arg % 10;
//            if (start) {
//                ans = mod;
//                arg /= 10;
//                start = false;
//                continue;
//            }
//
//            if (ans > ans * 10 + mod) {
//                long tempCount = mod * 10;
//                while (ans > Long.MAX_VALUE - mod) {
//                    tempCount -= mod;
//                    ans += mod;
//                }
//                ans = mod - (Long.MAX_VALUE - ans);
//                ans += tempCount - mod;
//            } else {
//                ans = ans * 10 + mod;
//            }
//            arg /= 10;
//        }
//
//        return negative ? ans * -1 : ans;
//    }
}
