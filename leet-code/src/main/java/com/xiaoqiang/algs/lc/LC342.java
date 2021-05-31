package com.xiaoqiang.algs.lc;

public class LC342 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "是否为4的幂:" + new LC342().isPowerOfFour(i));
        }
    }

    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        int tmp = 1;
        for (int i = 1; i < 16; i++) {
            tmp = tmp << 2;
            if (tmp == n) {
                return true;
            }
            if (tmp > n) {
                return false;
            }
        }
        return false;
    }
}
