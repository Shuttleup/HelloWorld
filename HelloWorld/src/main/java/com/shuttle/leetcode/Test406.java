package com.shuttle.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test406 {
}

class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (people1, people2) ->
                people1[0] != people2[0] ? people2[0] - people1[0] : people1[1] - people2[1]);

        List<int[]> peopleList = new ArrayList<>();
        for (int[] person : people) {
            peopleList.add(person[1], person);
        }

        return peopleList.toArray(new int[0][0]);
    }
}
