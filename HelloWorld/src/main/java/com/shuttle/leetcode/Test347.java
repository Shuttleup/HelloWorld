package com.shuttle.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test347 {
}

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[]{};
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // pair[数值，频率]
        Queue<int[]> pairQueue = new PriorityQueue<>(
                (pair1, pair2) -> pair1[1] == pair2[1] ? pair2[0] - pair1[0] : pair1[1] - pair2[1]);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (pairQueue.size() == k) {
                if (pairQueue.peek()[1] < freq) {
                    pairQueue.poll();
                    pairQueue.offer(new int[]{num, freq});
                }
            } else {
                pairQueue.offer(new int[]{num, freq});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k && !pairQueue.isEmpty(); i++) {
            res[i] = pairQueue.poll()[0];
        }

        return res;
    }
}
