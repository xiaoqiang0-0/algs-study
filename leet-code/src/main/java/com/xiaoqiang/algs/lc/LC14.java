package com.xiaoqiang.algs.lc;

public class LC14 {

    public static void main(String[] args) {
        char[] chars = new char[5];
        chars[0] = 'h';
        System.out.println(new String(chars));
        char flag = 'a' & 'b';

        System.out.println(String.valueOf(flag));
        System.out.println(new LC14().longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        char[] chars = strs[0].toCharArray();
        char flag = 'a' & 'b';
        for (int i = 0; i < strs.length; i++) {
            char[] strChars = strs[i].toCharArray();
            for (int i1 = 0; i1 < strChars.length && chars.length > i1; i1++) {
                chars[i1] = (char) (chars[i1] & strChars[i1]);
            }
            if (chars.length > strChars.length) {
                chars[strChars.length] = flag;
            }
        }
        return new String(chars);
    }
}
