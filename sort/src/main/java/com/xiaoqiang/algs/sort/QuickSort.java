package com.xiaoqiang.algs.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arrs = new int[]{1, 3, 2};
        new QuickSort().sort(arrs);
        System.out.println(Arrays.toString(arrs));
    }
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);
        sort(arr, p, q - 1);
        sort(arr, q + 1, r);
    }

    private int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r - 1; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
        return i;
    }
}
