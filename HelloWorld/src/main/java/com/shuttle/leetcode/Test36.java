package com.shuttle.leetcode;

public class Test36 {
}

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] box = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1';
                if (row[i][index] == 1) {
                    return false;
                }
                if (column[j][index] == 1) {
                    return false;
                }
                if (box[j / 3 + (i / 3) * 3][index] == 1) {
                    return false;
                }
                row[i][index] = 1;
                column[j][index] = 1;
                box[j / 3 + (i / 3) * 3][index] = 1;
            }
        }

        return true;
    }
}
