package com.xiaoqiang.algorithms.sort;

import java.util.Arrays;

public class InsertSort {
    public static int[] sort(int[] array) {
/*        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i + 1]) {
                    int tmp = arr[i + 1];
                    arr[i + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }*/
        int tmp = 0, j;
        for (int i = 0; i < array.length; i++) {
            tmp = array[i];
            for (j = i; j >= 0; j = j - 1) {
                if (array[j] < tmp) {
                    array[i] = array[j];
                } else {
                    break;
                }
            }
            array[j] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = ArraysGenerator.getIntArrays(8, 20);
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + (end - start) + "ms");
    }
}
