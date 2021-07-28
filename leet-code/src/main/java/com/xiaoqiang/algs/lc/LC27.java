package com.xiaoqiang.algs.lc;

public class LC27 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = new LC27().removeElement1(nums, 1);
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    //移除有序数组中的数据
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, h = nums.length - 1;
        int firstPosition = -1;
        while (l <= h) {
            int m = (h + l) / 2;
            if (nums[m] >= val) {
                firstPosition = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (firstPosition == -1) {
            return nums.length;
        }
        int lastPosition = firstPosition;
        l = lastPosition;
        h = nums.length - 1;
        while (l <= h) {
            int m = (h + l) / 2;
            if (nums[m] > val) {
                h = m - 1;
            } else {
                lastPosition = m;
                l = m + 1;
            }
        }
        if (lastPosition == nums.length - 1) {
            return firstPosition;
        }
        for (int i = 0; lastPosition + i + 1 < nums.length; i++) {
            nums[firstPosition + i] = nums[lastPosition + i + 1];
        }
        return nums.length - (lastPosition - firstPosition + 1);
    }

    public int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int index1 = 0, index2 = nums.length - 1;
        while (index1 <= index2) {
            if (nums[index1] != val) {
                index1++;
                continue;
            }
            if (nums[index2] == val) {
                index2--;
                continue;
            }
            nums[index1++] = nums[index2--];
        }
        return index2 + 1;
    }
}