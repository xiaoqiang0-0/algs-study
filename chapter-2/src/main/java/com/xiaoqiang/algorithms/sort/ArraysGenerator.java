package com.xiaoqiang.algorithms.sort;

import java.util.Random;

public class ArraysGenerator {

    public static int[] getIntArrays(int length) {
        return getIntArrays(length, length);
    }

    public static int[] getIntArrays(int length, int max) {
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getRandomInt(0, max);
        }
        return arr;
    }

    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
