package com.xiaoqiang.algs.interview;

/**
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 最优解: dp[i] = dp[i-1]>0?dp[i-1]+nums[i]:nums[i]
 */
public class MaxSubSeqSum {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, 3, -1, 2, -4, 5}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
            max = Math.max(nums[i], max);
        }
        return max;
    }


}
