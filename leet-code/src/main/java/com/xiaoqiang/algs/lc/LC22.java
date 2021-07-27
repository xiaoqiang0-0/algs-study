package com.xiaoqiang.algs.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC22 {
    public static void main(String[] args) {
        System.out.println(new LC22().generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<char[]> res = new ArrayList<>();
        generateParenthesis(res, new char[n * 2], n, 0, 0);
        for (char[] re : res) {
            result.add(new String(re));
        }
        return result;
    }

    public void generateParenthesis(List<char[]> result, char[] chars, int n, int l, int lCount) {
        if (lCount > n || l - lCount > n) {
            return;
        }
        if (l == 2 * n) {
            result.add(Arrays.copyOf(chars, 2 * n));
            return;
        }
        if (lCount < n) {
            chars[l] = '(';
            if (!isValid(chars, l)) {
                return;
            }
            generateParenthesis(result, chars, n, l + 1, lCount + 1);
        }
        chars[l] = ')';
        if (!isValid(chars, l)) {
            return;
        }
        generateParenthesis(result, chars, n, l + 1, lCount);
    }

    private boolean isValid(char[] chars, int lastIndex) {
        if (lastIndex == 0) {
            return chars[lastIndex] == '(';
        }
        if (chars[0] == ')') {
            return false;
        }
        int rCount = 0;
        for (int i = 0; i <= lastIndex; i++) {
            if (chars[i] == ')') {
                rCount++;
            }
        }
        if (rCount > (lastIndex+1) / 2) {
            return false;
        }
        return true;
    }
}
