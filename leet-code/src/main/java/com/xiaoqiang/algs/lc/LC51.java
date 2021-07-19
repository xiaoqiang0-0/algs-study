package com.xiaoqiang.algs.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(new LC51().solveNQueens(i).size());

        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(null, n, 0, result);
        return result;
    }

    private boolean solveNQueens(char[][] qm, int n, int line, List<List<String>> qms) {
        if (qm == null) {
            qm = new char[n][n];
            for (char[] chars : qm) {
                Arrays.fill(chars, '.');
            }
        }
        if (line >= qm.length) {
            return true;
        }
        int i = 0;
        for (; i < qm[line].length; i++) {

            if (isOk(qm, line, i)) {
                qm[line][i] = 'Q';
                if (!solveNQueens(qm, n, line + 1, qms)) {
                    qm[line][i] = '.';
                } else {
                    if (line == n - 1) {
                        List<String> sL = new ArrayList<>(n);
                        for (char[] chars : qm) {
                            sL.add(new String(chars));
                        }
                        qms.add(sL);
                    }
                    qm[line][i] = '.';
                }
            }
        }
        return i == qm.length;
    }

    private boolean isOk(char[][] qM, int x, int y) {

        //检测纵向
        for (int i = 0; i < x; i++) {
            if (qM[i][y] == 'Q') {
                return false;
            }
        }
        //检测对角线
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (qM[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < qM[x].length; i--, j++) {
            if (qM[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}

