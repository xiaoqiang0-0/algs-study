package com.xiaoqiang.algs.lc;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class LC59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new LC59().generateMatrix(3)));
        System.out.println(Arrays.deepToString(new LC59().generateMatrix(1)));
        System.out.println(Arrays.deepToString(new LC59().generateMatrix(2)));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int h = n;
        int w = n;
        int count = 0;
        int total = h * w;
        int hIndex = 0;
        int wIndex = -1;
        while (count < total) {
            for (int i = 0; i < w && count < total; i++) {
                matrix[hIndex][++wIndex] = 1 + count++;
            }
            h--;
            for (int i = 0; i < h && count < total; i++) {
                matrix[++hIndex][wIndex] = 1 + count++;
            }
            w--;
            for (int i = 0; i < w && count < total; i++) {
                matrix[hIndex][--wIndex] = 1 + count++;
            }
            h--;
            for (int i = 0; i < h && count < total; i++) {
                matrix[--hIndex][wIndex] = 1 + count++;
            }
            w--;
        }
        return matrix;
    }
}
