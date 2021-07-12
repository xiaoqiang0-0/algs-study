package com.xiaoqiang.algs.interview;

/**
 * 数组分两部分，分别升序和降序
 */
public class SpecialBinarySearch {
    public static void main(String[] args) {
        System.out.println(new SpecialBinarySearch().search(new int[]{1,2,3,3,4,2,1}, 2));
    }

    public int search(int[] nums, int target) {
        int index = -1;
        int l = 0, h = nums.length - 1;
        int d = -1;
        while (l <= h) {
            d = (l+h)/2;
            if (nums[d - 1] <= nums[d] && nums[d] >= nums[d + 1]) {
                break;
            }
            if (nums[d - 1] <= nums[d] && nums[d] <= nums[d - 1]) {
                l = d + 1;
            } else {
                h = d - 1;
            }
        }
        l = 0;
        h = d;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) {
                index = m;
            }
            if (nums[m] >= target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (index!=-1) {
            return index;
        }
        l = d+1;
        h = nums.length;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) {
                index = m;
            }
            if (nums[m] <= target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }


        return index;
    }
}
