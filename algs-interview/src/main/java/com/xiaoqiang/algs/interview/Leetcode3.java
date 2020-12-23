package com.xiaoqiang.algs.interview;

/**
 * 3. 无重复字符的最长子串
 * dp[i] 存储到当前位置不重复的最长子串
 */
public class Leetcode3 {
    public static void main(String[] args) {
        System.out.println(new Leetcode3().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int max = 1;
        int lastStartIndex = 0;
        for (int i = 1; i < chars.length; i++) {
            int subMax = lengthOfLongestSubstring(chars, i, lastStartIndex);
            if (subMax == 1) {
                lastStartIndex = i;
            } else {
                lastStartIndex = i - subMax + 1;
            }
            max = Math.max(max, subMax);
        }
        return max;
    }

    public int lengthOfLongestSubstring(char[] chars, int index, int lowIndex) {
        int count = 1;
        for (int i = index - 1; i >= lowIndex; i--) {
            if (chars[index] == chars[i]) {
                break;
            }
            count++;
        }
        return count;
    }
}
