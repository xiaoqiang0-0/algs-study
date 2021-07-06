package com.xiaoqiang.algs.search.binsearch;

public class BinSearch {

    public static void main(String[] args) {
        System.out.println(new BinSearch().search(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(new BinSearch().search(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new BinSearch().search(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(new BinSearch().search(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(new BinSearch().search(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(new BinSearch().search(new int[]{1, 2, 3, 4, 5}, 6));

    }

    public int search(int[] arr, int target) {
        if (arr == null || arr.length < 1 || arr[0] > target || arr[arr.length - 1] < target) {
            return -1;
        }
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int m = low + ((high - low) >> 1);
            if (arr[m] == target) {
                return m;
            }
            if (arr[m] < target) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return -1;
    }
}
