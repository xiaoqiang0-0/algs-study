package com.xiaoqiang.algs.lc;

import java.util.*;

public class LC56 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] g = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0]>g[1]) {
                    continue;
                }
                i++;
                g[1] = Math.max(intervals[j][1], g[1]);
            }
            result.add(g);
        }

        return result.toArray(new int[result.size()][]);
    }
}
