package com.xiaoqiang.algs.lc;

public class LC461 {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 6));
        System.out.println(new Solution().totalHammingDistance(new int[]{4, 14, 2}));
    }
}

class Solution {

    public int lowbit(int x) {
        return x & -x;
    }

    public int totalHammingDistance(int[] nums) {
        int distance = 0;
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                cnt += nums[j] >> j & 1;
            }
            distance += cnt * (nums.length - cnt);
        }
        return distance;
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
