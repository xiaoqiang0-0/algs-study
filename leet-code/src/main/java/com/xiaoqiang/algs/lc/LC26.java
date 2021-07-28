package com.xiaoqiang.algs.lc;

public class LC26 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = new LC26().removeDuplicates(nums);
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int curEle = nums[0];
        int count = 1;
        int index1 = 1, index2 = 1;
        while (index2 < nums.length) {
            if (nums[index2] == curEle) {
                index2++;
                continue;
            }
            curEle = nums[index2];
            count++;
            nums[index1++] = nums[index2++];
        }
        return count;
    }
}
