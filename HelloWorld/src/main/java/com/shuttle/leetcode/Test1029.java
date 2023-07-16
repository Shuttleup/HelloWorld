package com.shuttle.leetcode;

import java.util.Arrays;

public class Test1029 {
}

class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (cost1, cost2) -> (cost1[0] - cost2[0]) - (cost1[1] - cost2[1]));
        int interval = costs.length / 2;
        int minCost = 0;
        for (int i = 0; i < interval; i++) {
            minCost += costs[i][0] + costs[i + interval][1];
        }

        return minCost;
    }
}
