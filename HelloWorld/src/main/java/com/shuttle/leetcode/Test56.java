package com.shuttle.leetcode;

import java.util.Arrays;
import java.util.BitSet;

public class Test56 {
}

class Solution56 {

    /**
     * 解法一：常规合并
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        int[][] mergeResult = new int[intervals.length][2];
        int curIndex = -1;

        for (int[] interval : intervals) {
            if (curIndex == -1 || interval[0] > mergeResult[curIndex][1]) {
                mergeResult[++curIndex] = interval;
            } else {
                mergeResult[curIndex][1] = Math.max(interval[1], mergeResult[curIndex][1]);
            }
        }

        return Arrays.copyOf(mergeResult, curIndex + 1);
    }

    /**
     * 解法二：位图法
     *
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        BitSet bitSet = new BitSet();
        int termination = 0;

        for (int[] interval : intervals) {
            int start = 2 * interval[0];
            int end = 2 * interval[1] + 1;
            bitSet.set(start, end, true);
            termination = Math.max(end, termination);
        }

        int count = 0;
        int index = 0;

        while (index < termination) {
            int start = bitSet.nextSetBit(index);
            int end = bitSet.nextClearBit(start);
            intervals[count++] = new int[]{start / 2, (end - 1) / 2};
            index = end;
        }

        return Arrays.copyOf(intervals, count);
    }

}
