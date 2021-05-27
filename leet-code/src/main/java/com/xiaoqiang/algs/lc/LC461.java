package com.xiaoqiang.algs.lc;

public class LC461 {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 6));
    }
}

class Solution {

    public int lowbit(int x) {
        return x & -x;
    }

    public int hammingDistance(int x, int y) {
        int result = 0;
        for (int i = x ^ y; i > 0; i -= lowbit(i)) {
            result++;
        }
        return result;
    }

    public int hammingDistance1(int x, int y) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int a = (x >> i) & 1, b = (y >> i) & 1;
            if (a != b) {
                result++;
            }
        }
        return result;
    }
}
