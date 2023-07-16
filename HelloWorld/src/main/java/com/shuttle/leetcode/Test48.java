package com.shuttle.leetcode;

public class Test48 {
}

class Solution48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int matrixLen = matrix.length;

        // 先水平翻转
        for (int i = 0; i < matrixLen / 2; i++) {
            for (int j = 0; j < matrixLen; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrixLen - i - 1][j];
                matrix[matrixLen - i - 1][j] = temp;
            }
        }
        // 在主对角线翻转
        for (int i = 0; i < matrixLen; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
