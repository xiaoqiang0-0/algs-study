package com.xiaoqiang.algs.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class LC1 {
    public static void main(String[] args) {
        for (int i : new LC1().twoSum(new int[]{3, 2, 3}, 6)) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target-nums[i]);
            if (index!=null) {
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
