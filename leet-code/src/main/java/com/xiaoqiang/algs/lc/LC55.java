package com.xiaoqiang.algs.lc;

public class LC55 {
    public static void main(String[] args) {
        System.out.println(new LC55().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new LC55().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        return canJump(nums, 0, nums[0], nums.length - 1);
    }

    /**
     * 当无法前进时回溯，减小上一步的跳跃距离
     * @param nums
     * @param index
     * @param curStep
     * @param totalStep
     * @return
     */
    private boolean canJump(int[] nums, int index, int curStep, int totalStep) {
        if (totalStep != 0 && curStep == 0) {
            return false;
        }
        for (int i = curStep; i > 0; i--) {
            if (curStep >= totalStep) {
                return true;
            }
            if (canJump(nums, index + i, nums[index + i], totalStep - i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 循环遍历，每次更新当前位置出发最远能到达位置，如果超过或到达目标地直接返回true，否则继续，直到结束说明可以逐步走完，或者无法到达当前位置则返回false
     * @param nums
     * @return
     */
    public boolean canJump0(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int totalStep = nums.length - 1;
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reach > totalStep) {
                return true;
            }
            if (i > reach) {
                return false;
            }
            reach = Math.max(nums[i] + i, reach);
        }
        return true;
    }
}
