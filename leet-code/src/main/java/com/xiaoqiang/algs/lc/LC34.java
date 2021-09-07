package com.xiaoqiang.algs.lc;

/**
 * 搜索第一个出现的值和最后一个
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return res;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (r + l) / 2;
            if (nums[m] == target) {
                res[0] = m;
                if (res[1] == -1) {
                    res[1] = m;
                }
            }
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (res[0] == -1) {
            return res;
        }
        l = res[1];
        r = nums.length - 1;
        while (l <= r) {
            int m = (r + l) / 2;
            if (nums[m] == target) {
                res[1] = m;
            }
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}
