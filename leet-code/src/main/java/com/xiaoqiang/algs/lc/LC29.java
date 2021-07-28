package com.xiaoqiang.algs.lc;

public class LC29 {
    public static void main(String[] args) {
        System.out.println(10/3);
    }

    public int divide(int dividend, int divisor) {
        if (dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
        return dividend/divisor;
    }
}
