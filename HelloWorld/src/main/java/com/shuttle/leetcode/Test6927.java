package com.shuttle.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test6927 {

}

class Solution6927 {
    public int minimumIndex(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int size = nums.size();
        Map<Integer, Integer> numberCountMap = null;
        for (int i = 0; i < size - 1; i++) {
            // 计算两个部分的支配元素
            // part1
            int size1 = i;
            int num1 = 0;
            numberCountMap = new HashMap<>();
            for (int part1Index = 0; part1Index < size1 + 1; part1Index++) {
                Integer num = nums.get(part1Index);
                numberCountMap.put(num, numberCountMap.getOrDefault(num, 0) + 1);
            }
            for (int part1Index = 0; part1Index < size1 + 1; part1Index++) {
                Integer num = nums.get(part1Index);
                Integer count = numberCountMap.get(num);
                if (count * 2 > size1) {
                    num1 = num;
                }
            }

            // part2
            int size2 = size - i;
            int num2;
            numberCountMap = new HashMap<>();
            for (int part2Index = i + 1; part2Index < size; part2Index++) {
                Integer num = nums.get(part2Index);
                numberCountMap.put(num, numberCountMap.getOrDefault(num, 0) + 1);
            }
            for (int part2Index = i + 1; part2Index < size; part2Index++) {
                Integer num = nums.get(part2Index);
                Integer count = numberCountMap.get(num);
                if (count * 2 > size2) {
                    num2 = num;
                    if (num1 == num2) {
                        return i;
                    }
                }
            }
        }

        return size - 1;
    }
}
