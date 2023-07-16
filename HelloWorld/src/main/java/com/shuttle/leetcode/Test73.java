package com.shuttle.leetcode;

public class Test73 {
}

class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        boolean row0 = false;
        boolean column0 = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        column0 = true;
                    }
                    if (j == 0) {
                        row0 = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (column0) {
            for (int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }

    }
}
