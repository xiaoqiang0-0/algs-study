package com.xiaoqiang.algs.so;

public class SO53 {
    public static void main(String[] args) {
        System.out.println(new SO53().search(new int[]{2, 2}, 1));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 1;
            }
            return 0;
        }
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return 0;
        }
        int startIndex = -1;
        int endIndex = -1;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) {
                startIndex = m;
            }
            if (nums[m] >= target) {

                h = m - 1;
            }
            if (nums[m] < target) {
                l = m + 1;
            }
        }
        l = startIndex;
        h = nums.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) {
                endIndex = m;
            }
            if (nums[m] > target) {
                h = m - 1;
            }
            if (nums[m] <= target) {
                l = m + 1;
            }
        }
        if (endIndex == -1) {
            return 0;
        }
        return endIndex - startIndex + 1;
    }
}
