package com.shuttle.leetcode;

import java.util.Arrays;

public class Test1710 {
}

class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (boxTypes == null || boxTypes.length == 0 || truckSize <= 0) {
            return 0;
        }
        Arrays.sort(boxTypes, (box1, box2) -> box2[1] - box1[1]);
        int maxCapacity = 0;

        for (int[] box : boxTypes) {
            int boxOfNum = box[0];
            int boxOfCapacity = box[1];
            if (boxOfNum < truckSize) {
                maxCapacity += boxOfNum * boxOfCapacity;
                truckSize -= boxOfNum;
            } else {
                maxCapacity += boxOfCapacity * truckSize;
                break;
            }
        }

        return maxCapacity;
    }
}
