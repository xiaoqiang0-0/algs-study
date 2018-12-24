package com.xiaoqiang.algorithms;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;

public class BinarySearch {

    /**
     * 非递归实现
     *
     * @param key 待查找元素
     * @param arr 元素集
     * @return 位置，-1表示不存在
     */
    public static int rank(int key, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     *
     * @param key
     * @param arr
     * @return
     */
    public static int rankRecursion(int key, int[] arr) {
        return recursion(0, arr.length - 1, arr, key);
    }

    private static int recursion(int low, int high, int[] arr, int key) {
        if (high - low == 0) {
            return arr[low] == key ? low : -1;
        }

        int mid = (high + low) >> 1;
        if (arr[mid] > key) {
            high = mid - 1;
        } else if (arr[mid] < key) {
            low = mid + 1;
        } else {
            return mid;
        }
        return recursion(low, high, arr, key);
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 16, 21, 44, 53, 55, 78, 88, 89};
        System.out.println(Arrays.toString(arr));
        System.out.println("find 21:"+rank(21, arr));
        System.out.println("find 22:"+rank(22, arr));
        System.out.println("find 21:"+rankRecursion(21, arr));
        System.out.println("find 22:"+rankRecursion(22, arr));
    }

}
