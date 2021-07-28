package com.xiaoqiang.algs.lc;

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public static void main(String[] args) {
        System.out.println(new LC76().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new LC76().minWindow("a", "a"));
        System.out.println(new LC76().minWindow("a", "aa"));
        System.out.println(new LC76().minWindow("bba", "ba"));
        System.out.println(new LC76().minWindow("cabeca", "cae"));
    }

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        int left = 0, right = 0;
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int minLen = s.length();
        int resLeft = -1;
        int count = t.length();
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                int cc = need.get(c);
                if (cc > 0) {
                    count--;
                }
                need.put(c, cc - 1);
            }

            while (count == 0) {
                if (right - left < minLen) {
                    resLeft = left;
                    minLen = right - left;
                }
                if (need.containsKey(s.charAt(left))) {
                    int cc = need.get(s.charAt(left));

                    need.put(s.charAt(left), cc + 1);
                    if (cc+1 > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        if (resLeft==-1) {
            return "";
        }
        return s.substring(resLeft, resLeft + minLen + 1);
    }

    /**
     * 用数组去替代hashmap
     * @param s
     * @param t
     * @return
     */
    public String minWindow1(String s, String t) {
        int[] chars = new int[128];
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i)]++;
        }
        //count 表示还需要多少个字符
        int start = 0, minLen = Integer.MAX_VALUE, count = t.length(), left = 0, right = 0;
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            //如果当前字符需求量已经满足，那么无论来多少个，也还缺少的字符数量不变
            if (chars[c] > 0) {
                count--;
            }
            chars[c]--;
            while (count == 0) {
                int newLen = right - left + 1;
                if (newLen < minLen) {
                    minLen = newLen;
                    start = left;
                }
                if (chars[s.charAt(left)] == 0) {
                    count++;
                }
                chars[s.charAt(left)]++;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}