package com.xiaoqiang.algs.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 旋转输出矩阵
 */
public class LC54 {
    public static void main(String[] args) {
        System.out.println(new LC54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        int h = matrix.length;
        int w = matrix[0].length;
        int count = 0;
        int total = h * w;
        int hIndex = 0;
        int wIndex = -1;
        while (count < total) {
            for (int i = 0; i < w && count < total; i++) {
                list.add(matrix[hIndex][++wIndex]);
                count++;
            }
            h--;
            for (int i = 0; i < h && count < total; i++) {
                list.add(matrix[++hIndex][wIndex]);
                count++;
            }
            w--;
            for (int i = 0; i < w && count < total; i++) {
                list.add(matrix[hIndex][--wIndex]);
                count++;
            }
            h--;
            for (int i = 0; i < h && count < total; i++) {
                list.add(matrix[--hIndex][wIndex]);
                count++;
            }
            w--;
        }
        return list;
    }
}