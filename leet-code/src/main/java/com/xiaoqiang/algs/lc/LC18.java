package com.xiaoqiang.algs.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC18 {
    public static void main(String[] args) {
        System.out.println(new LC18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int cur = nums[i];
            List<int[]> subRes = threeSum(nums, i + 1, target-cur);
            for (int[] ints : subRes) {
                result.add(Arrays.asList(cur, ints[0], ints[1], ints[2]));
            }
            while (i < nums.length && nums[i] == cur) i++;
        }
        return result;
    }

    public List<int[]> threeSum(int[] nums, int start, int target) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = start; i < nums.length; ) {
            int cur = nums[i];
            List<int[]> subRes = twoSum(nums, i + 1, target-cur);
            for (int[] ints : subRes) {
                result.add(new int[]{cur, ints[0], ints[1]});
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
