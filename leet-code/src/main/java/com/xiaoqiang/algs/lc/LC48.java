package com.xiaoqiang.algs.lc;

public class LC48 {
    public static void main(String[] args) {
        new LC48().rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
        System.out.println();
    }

    public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }
        int[][] tmp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            tmp[i] = new int[matrix[i].length];
            System.arraycopy(matrix[i], 0, tmp[i], 0, matrix[i].length);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = tmp[matrix.length - j - 1][i];
            }
        }
    }
}
