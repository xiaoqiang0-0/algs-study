package com.xiaoqiang.algs.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arrs = new int[]{1, 3, 2};
        new InsertSort().sort(arrs, 3);
        System.out.println(Arrays.toString(arrs));
    }

    public void sort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j]; // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }
}
