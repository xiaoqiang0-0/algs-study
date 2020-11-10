package com.xiaoqiang.algorithms.sort;

import java.util.Arrays;

public class ShellSort {

    public static int[] sort(int array[]) {
        int[] d = {5, 3, 1};
        for (int i = 0; i < d.length; i++) {
            shell(array, d[i]);
        }
        return array;
    }

    public static void shell(int[] array, int gap) {

        int tmp = 0, j;
        for (int i = gap; i < array.length; i++) {
            tmp = array[i];
            for (j = i - gap; j >= 0; j = j - gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
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
