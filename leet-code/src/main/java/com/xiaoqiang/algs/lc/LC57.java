package com.xiaoqiang.algs.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new LC57().insert(new int[][]{{1, 3},{6, 9}}, new int[]{2, 5})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> res = new ArrayList<>();
        int[][] tmp = new int[2][];
        int subCount = marge(intervals[0], newInterval, tmp);
        for (int i = 1; i < intervals.length; i++) {
            if (subCount == 2) {
                res.add(tmp[0]);
            }
            subCount = marge(tmp[subCount - 1], intervals[i], tmp);
        }
        for (int i = 0; i < subCount; i++) {
            res.add(tmp[i]);
        }

        return res.toArray(new int[res.size()][2]);
    }

    /**
     * 合并两个区间
     * @param interval1 区间1
     * @param interval2 区间2
     * @param res 合并后的结果
     * @return 合并后实际剩余几个区间
     */
    private int marge(int[] interval1, int[] interval2, int[][] res) {
        if (interval1[0] > interval2[1]) {
            res[0] = interval2;
            res[1] = interval1;
            return 2;
        }
        if (interval1[1] < interval2[0]) {
            res[0] = interval1;
            res[1] = interval2;
            return 2;
        }
        if (interval1[0] >= interval2[0] && interval2[1] >= interval1[1]) {
            res[0] = interval2;
            return 1;
        }
        if (interval1[0] <= interval2[0] && interval1[1] >= interval2[1]) {
            res[0] = interval1;
            return 1;
        }
        if (interval1[0] > interval2[0]) {
            interval1[0] = interval2[0];
        } else {
            interval1[1] = interval2[1];
        }
        res[0] = interval1;
        return 1;
    }
}
