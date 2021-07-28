package com.xiaoqiang.algs.lc;

import java.util.Arrays;

public class LC16 {
    public static void main(String[] args) {
//        System.out.println(new LC16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//        System.out.println(new LC16().threeSumClosest(new int[]{1,1,1,1}, 0));
        System.out.println(new LC16().threeSumClosest(new int[]{1,1,-1,-1,3}, -1));


    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long minSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length-2; ) {
            int cur = nums[i];
            int twoClosestSum = twoSumClosest(nums, i + 1, target - nums[i]);
            int sum = cur + twoClosestSum;
            if (sum==target) {
                return sum;
            }
            if (Math.abs(target - sum) < Math.abs(target - minSum)) {
                minSum = sum;
            }
            while (i < nums.length-2 && nums[i] == cur) i++;
        }
        return (int) minSum;
    }

    /**
     * 找出最接近目标值的两数之和
     * @param nums
     * @param start
     * @param target
     * @return
     */
    int twoSumClosest(int[] nums, int start, int target) {
        long minSum = Integer.MAX_VALUE;
        int end = nums.length - 1;
        for (; start < end; ) {
            int left = nums[start], right = nums[end], sum = left + right;
            if (sum==target) {
                return sum;
            }
            if (Math.abs(target - sum) < Math.abs(target - minSum)) {
                minSum = sum;
            }
            if (Math.abs(nums[start+1]+nums[end]-target)<Math.abs(nums[start]+nums[end-1]-target)) {
                while (start < end && nums[start] == left) start++;
            } else {
                while (start < end && nums[end] == right) end--;
            }
        }
        return (int) minSum;
    }
}
