package com.xiaoqiang.algs.lc;

public class LC35 {
    public static void main(String[] args) {
        System.out.println(new LC35().searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(new LC35().searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(new LC35().searchInsert(new int[]{1,3,5,6}, 3));
        System.out.println(new LC35().searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(new LC35().searchInsert(new int[]{1,3,5,6}, 0));

    }

    public int searchInsert(int[] nums, int target) {
        int p = 0;
        int l = 0, r = nums.length - 1;
        if (nums[l] >= target) {
            return l;
        }
        if (nums[r] < target) {
            return r + 1;
        }
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                p = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return p;
    }
}
