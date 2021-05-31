package com.xiaoqiang.algs.interview;

public class BinSearch {
    public static void main(String[] args) {
        System.out.println(new BinSearch().search(new int[]{-1, 0, 5}, 5));

    }

    public int search(int[] nums, int target) {
//        return search(nums, target, 0, nums.length - 1);
        int pos = -1;
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return pos;
        }
        int h = nums.length - 1;
        int l = 0;
        while (h >= l) {

            if (h - l < 2) {
                if (nums[l] == target) {
                    return l;
                }
                if (nums[h] == target) {
                    return h;
                }
                return pos;
            }
            int m = (h + l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return pos;
    }

    public int search(int[] nums, int target, int low, int high) {

        if (high - low < 2) {
            if (nums[low] == target) {
                return low;
            }
            if (nums[high] == target) {
                return high;
            }
            return -1;
        }
        int m = (low + high) / 2;
        if (nums[m] == target) {
            return m;
        }
        if (nums[m] > target) {
            return search(nums, target, low, m - 1);
        }
        return search(nums, target, m + 1, high);
    }
}
