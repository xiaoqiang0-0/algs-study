package com.xiaoqiang.algs.lc;

import java.util.concurrent.LinkedBlockingDeque;

public class LC28 {
    public static void main(String[] args) {
        System.out.println(new LC28().strStr("aaa", "a"));
        System.out.println("Hello world".indexOf("ld"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }
        char[] chars = needle.toCharArray();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean flag = true;

            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == haystack.charAt(i + j)) {
                    continue;
                }
                flag = false;
                break;
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
