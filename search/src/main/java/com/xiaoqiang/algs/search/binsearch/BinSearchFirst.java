package com.xiaoqiang.algs.search.binsearch;

public class BinSearchFirst {
    public static void main(String[] args) {
        System.out.println(new BinSearchFirst().search(new int[]{1, 2, 3, 3, 5}, 1));
        System.out.println(new BinSearchFirst().search(new int[]{1, 2, 3, 3, 5}, 2));
        System.out.println(new BinSearchFirst().search(new int[]{1, 2, 3, 3, 5}, 3));
        System.out.println(new BinSearchFirst().search(new int[]{1, 2, 3, 3, 5}, 4));
        System.out.println(new BinSearchFirst().search(new int[]{1, 2, 3, 3, 5}, 5));

    }

    public int search(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int low = 0, high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            if (arr[high] < target || arr[low] > target) {
                break;
            }
            int m = low + ((high - low) >> 1);
            if (arr[m] == target) {
                index = m;
            }
            if (arr[m] < target) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return index;
    }
}
