package com.shuttle.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test973 {
}

class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 || k <= 0) {
            return null;
        }
        int[][] res = new int[k][2];
        // int[2] pair {距离，索引}
        Queue<int[]> pairQueue = new PriorityQueue<>(
                (pair1, pair2) -> pair2[0] - pair1[0]);

        for (int i = 0; i < k; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pairQueue.offer(new int[]{distance, i});
        }
        int pointsLen = points.length;

        for (int i = k; i < pointsLen; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (pairQueue.peek()[0] > distance) {
                pairQueue.poll();
                pairQueue.offer(new int[]{distance, i});
            }
        }

        for (int i = 0; i < k; i++) {
            int[] pair = pairQueue.poll();
            int index = pair[1];
            res[i] = points[index];
        }

        return res;
    }
}
