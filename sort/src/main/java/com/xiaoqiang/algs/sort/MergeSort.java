package com.xiaoqiang.algs.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arrs = new int[]{1, 3, 2};
        new MergeSort().sort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (end == start) {
            return;
        }
        int m = (start + end) / 2;
        sort(arr, start, m);
        sort(arr, m + 1, end);
        merge(arr, start, m, m + 1, end);
    }

    public void merge(int[] arr, int p, int m, int j, int r) {
        int i = p, k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= m && j <= r) {
            if (arr[i] > arr[j]) {
                tmp[k++] = arr[j++];
            } else {
                tmp[k++] = arr[i++];
            }
        }
        int start = i, end = m;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        System.arraycopy(tmp, 0, arr, p, tmp.length);
    }
}
