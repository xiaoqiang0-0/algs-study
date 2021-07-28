package com.xiaoqiang.algs.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC15 {
    public static void main(String[] args) {
        System.out.println(new LC15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new LC15().threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(new LC15().threeSum(new int[]{3, 0, -2, -1, 1, 2}));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int cur = nums[i];
            List<int[]> subRes = twoSum(nums, i + 1, -cur);
            for (int[] ints : subRes) {
                result.add(Arrays.asList(cur, ints[0], ints[1]));
            }
            while (i < nums.length && nums[i] == cur) i++;
        }
        return result;
    }

    public List<int[]> twoSum(int[] nums, int start, int target) {
        int end = nums.length - 1;
        List<int[]> res = new ArrayList<>();
        for (; start < end; ) {
            int left = nums[start], right = nums[end], sum = left + right;
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                res.add(new int[]{left, right});
                while (start < end && nums[start] == left) start++;
                while (start < end && nums[end] == left) end--;
            }
        }
        return res;
    }

}
