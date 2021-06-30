package com.xiaoqiang.algs.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arrs = new int[]{1, 3, 2};
        new BubbleSort().sort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }
}
