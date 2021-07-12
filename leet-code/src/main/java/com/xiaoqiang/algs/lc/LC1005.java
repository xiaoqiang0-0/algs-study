package com.xiaoqiang.algs.lc;

import java.util.Arrays;

public class LC1005 {
    public static void main(String[] args) {
//        [-2,5,0,2,-2]
//3
        System.out.println(new LC1005().largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 3));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        int[] minIndex = new int[k];
        Arrays.fill(minIndex, -1);
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length; j++) {
                if (minIndex[i] == j) {
                    continue;
                }
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex[i] = j;
                }
            }
            nums[minIndex[i]] = -nums[minIndex[i]];
        }
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
