package com.xiaoqiang.algs.lc;

public class LC11 {

    public static void main(String[] args) {
        System.out.println(new LC11().maxArea1(new int[]{1, 1}));
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(area(height[i], height[j], Math.abs(i - j)), max);
            }
        }
        return max;
    }

    public int area(int x, int y, int w) {
        return Math.min(x, y) * w;
    }


    public int maxArea1(int[] height) {
        int max = 0;
        int pL = 0, pH = height.length - 1;
        while (pL < pH) {
            max = Math.max(area(height[pL], height[pH], pH - pL), max);
            if (height[pL] > height[pH]) {
                pH--;
            } else {
                pL++;
            }
        }
        return max;
    }
}
