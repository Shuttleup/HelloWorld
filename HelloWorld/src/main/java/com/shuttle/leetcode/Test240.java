package com.shuttle.leetcode;

public class Test240 {
}

class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int curRow = row - 1;
        int curCol = 0;

        while (curRow >= 0 && curCol < column) {
            if (matrix[curRow][curCol] == target) {
                return true;
            }
            if (matrix[curRow][curCol] > target) {
                curRow--;
            } else {
                curCol++;
            }
        }

        return false;
    }
}
