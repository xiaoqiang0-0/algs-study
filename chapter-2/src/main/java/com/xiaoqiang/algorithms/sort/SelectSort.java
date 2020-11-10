package com.xiaoqiang.algorithms.sort;

import java.util.Arrays;

public class SelectSort {
    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex!=i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = ArraysGenerator.getIntArrays(2 << 15, 100000);
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + (end - start) + "ms");
    }
}
