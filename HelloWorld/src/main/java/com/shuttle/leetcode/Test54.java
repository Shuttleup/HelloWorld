package com.shuttle.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test54 {
}

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return resultList;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = column - 1;
        int top = 0;
        int bottom = row - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                resultList.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                resultList.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    resultList.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    resultList.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        return resultList;
    }
}
