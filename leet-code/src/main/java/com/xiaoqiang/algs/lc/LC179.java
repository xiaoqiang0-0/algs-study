package com.xiaoqiang.algs.lc;

import java.util.Arrays;

public class LC179 {
    public static void main(String[] args) {
        System.out.println(new LC179().largestNumber(new int[]{34323, 3432}));
    }

    /**
     * 核心要点就是x和y比较，x在前和y在前哪种拼接结果更大
     * sx表示当x要放在后边时，拼接结果值为sx*y+x,sy表示y放在后边是拼接结果为sy*x+y
     * @param x
     * @param y
     * @return
     */
    private static int compare(int x, int y) {
        long sx = 10, sy = 10;
        while (x >= sx) {
            sx *= 10;
        }
        while (y >= sy) {
            sy *= 10;
        }
        return (int) (-x * sy - y + y * sx + x);
    }


    public String largestNumber(int[] nums) {
        Integer[] numss = new Integer[nums.length];
        for (int i = 0; i < numss.length; i++) {
            numss[i] = nums[i];
        }
        Arrays.sort(numss, (LC179::compare));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(numss[i]);
        }
        return sb.toString();
    }
}