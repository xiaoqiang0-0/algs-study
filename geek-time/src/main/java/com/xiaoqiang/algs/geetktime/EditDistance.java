package com.xiaoqiang.algs.geetktime;

/**
 * 编辑距离：
 *     I = a.len, J = b.len
 *     采用d[I+1][J+1]存储d[i][j]的编辑距离
 *     推导过程：
 *         1)如果 i 为 0，且 j 也为 0，那么 d[i, j]为 0。
 *         2)如果 i 为 0，且 j 大于 0，那么 d[i, j]为 j。
 *         3)如果 i 大于 0，且 j 为 0，那么 d[i, j]为 i。
 *         4)如果 i 大于 0，且 j 大于 0，那么 d[i, j]=min(d[i-1, j] + 1, d[i, j-1] + 1, d[i-1, j-1] + r(i, j))。
 *     可根据 1，2，3 得出d[0][0-J]以及d[0-I][0]，以此为基础便可推到出d[i+1][j+1],即，可以获得最终的编辑距离d[I][J]
 */
public class EditDistance {

    public static int getStrDistance(String a, String b) {
        if (a == null || b == null) {
            return -1;
        }

        int[][] d = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length(); i++) {
            d[i][0] = i;
        }

        for (int i = 0; i < b.length(); i++) {
            d[0][i] = i;
        }

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                int r = 0;
                if (a.charAt(i) != b.charAt(j)) {
                    r = 1;
                }
                d[i + 1][j + 1] = Math.min(Math.min(d[i][j + 1] + 1, d[i + 1][j] + 1), d[i][j] + r);
            }
        }

        return d[a.length()][b.length()];
    }

    public static void main(String[] args) {
        System.out.println(getStrDistance("Hello1", "hello"));
    }
}
