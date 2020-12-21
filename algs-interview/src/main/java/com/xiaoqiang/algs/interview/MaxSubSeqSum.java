package com.xiaoqiang.algs.interview;

/**
 * 面试题: 求给定一个数组中，求最大连续子数组之和
 * 例如：[1,3,-1,2,-4,5], 最大连续子数组[1,3,-1,2,-4,5],结果为6
 *      [-2,1,-3,4,-1,2,1,-5,4], 最大连续子数组[4,-1,2,1],结果为6
 * 思路：
 *     r1 = max(n1)
 *     r2 = max(n1,n2)
 *     r3 = max(n1,n2,n3, n1+n2, n2+n3)
 *     ri = max(n1...i,n1+n2,...ni-1+ni, ... n1+n2+...ni)
 *     r = [
 *     [n1,n2,n3,...ni],
 *     [n1+n2,n2+n3,...ni-1+ni],
 *     [n1+n2+n3,n2+n3+n4, ni-2 + ni-1 +ni],
 *     ...
 *     ]
 * 归纳：
 *     r[i][j] = r[i-1][j]+r[0][j-i]
 */
public class MaxSubSeqSum {
    public static void main(String[] args) {
        System.out.println(maxSubSeqSum(new int[]{1, 3, -1, 2, -4, 5}));
        System.out.println(maxSubSeqSum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubSeqSum(int[] arr){
        int[][]r = new int[arr.length][];
        int max = Integer.MIN_VALUE;
        r[0] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            r[0][i] = arr[i];
            max = Math.max(arr[i], max);
        }
        for (int i = 1; i < arr.length; i++) {
            r[i] = new int[arr.length-i];
            for (int j = 0; j < arr.length - i; j++) {
                r[i][j] = r[i-1][j]+r[0][j+i];
                max = Math.max(r[i][j], max);
            }
        }
        return max;
    }
}
