package com.xiaoqiang.algs.search.binsearch;

public class BinSearchLastBefore {
    public static void main(String[] args) {
        System.out.println(new BinSearchLastBefore().search(new int[]{1, 2, 3, 3, 5}, 1));
        System.out.println(new BinSearchLastBefore().search(new int[]{1, 2, 3, 3, 5}, 2));
        System.out.println(new BinSearchLastBefore().search(new int[]{1, 2, 3, 3, 5}, 3));
        System.out.println(new BinSearchLastBefore().search(new int[]{1, 2, 3, 3, 5}, 4));
        System.out.println(new BinSearchLastBefore().search(new int[]{1, 2, 3, 3, 5}, 5));
        System.out.println(new BinSearchLastBefore().search(new int[]{1, 2, 3, 3, 5}, 6));
    }

    public int search(int[] arr, int target) {
        if (arr == null || arr.length < 1 || arr[0] > target) {
            return -1;
        }
        int low = 0, high = arr.length - 1;
        int index = arr.length;
        while (low <= high) {
            if (arr[low]>target||arr[high]<target) {
                break;
            }
            int m = low + ((high - low) >> 1);
            if (arr[m] > target) {
                high = m - 1;
            } else {
                index = m;
                low = m + 1;
            }
        }
        return index;
    }
}
