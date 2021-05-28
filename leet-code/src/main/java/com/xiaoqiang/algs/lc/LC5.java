package com.xiaoqiang.algs.lc;

public class LC5 {
    public static void main(String[] args) {
        System.out.println(new LC5().longestPalindrome2("a"));
        System.out.println(new LC5().longestPalindrome2("ab"));
        System.out.println(new LC5().longestPalindrome2("aa"));
        System.out.println(new LC5().longestPalindrome2("aacabdkacaa"));

    }

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = 0;
        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(chars, j, i) && i - j > end - begin) {
                    begin = j;
                    end = i;
                }
            }
        }
        return s.substring(begin, end + 1);
    }

    public boolean isPalindrome(char[] chars, int begin, int end) {
        if (end - begin == 0) {
            return true;
        }
        while (end >= begin) {
            if (chars[begin++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = 0;
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (chars[j] == chars[i]) {
                    if (i - j < 2) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                    if (dp[j][i] && i - j > end - begin) {
                        end = i;
                        begin = j;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }

    /**
     * 中心扩展
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            int oldAround = expandAroundCenter(chars, i, i);
            int eleAround = expandAroundCenter(chars, i, i + 1);
            int len = Math.max(oldAround, eleAround);
            if (len > end - begin) {
                end = i + len / 2;
                begin = i - (len - 1) / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    public int expandAroundCenter(char[] chars, int leftCenter, int rightCenter) {
        while (leftCenter >= 0 && rightCenter < chars.length && chars[leftCenter] == chars[rightCenter]) {
            leftCenter--;
            rightCenter++;
        }
        return rightCenter - leftCenter - 1;
    }
}
