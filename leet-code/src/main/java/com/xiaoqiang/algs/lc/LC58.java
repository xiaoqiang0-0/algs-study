package com.xiaoqiang.algs.lc;

public class LC58 {
    public static void main(String[] args) {
        System.out.println(new LC58().lengthOfLastWord("a"));
        System.out.println(new LC58().lengthOfLastWord("hello"));
        System.out.println(new LC58().lengthOfLastWord(" hello "));
        System.out.println(new LC58().lengthOfLastWord(" hello"));
        System.out.println(new LC58().lengthOfLastWord(" hello lc"));
        System.out.println(new LC58().lengthOfLastWord(" hello lc "));


    }

    public int lengthOfLastWord(String s) {
        int wordStartIndex = -1;
        int wordEndIndex = -1;

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (i == 0 || s.charAt(i - 1) == ' ') {
                wordStartIndex = i;
                break;
            }
        }
        if (wordStartIndex == -1) {
            return 0;
        }
        int i = wordStartIndex;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                wordEndIndex = i - 1;
                break;
            }
            if (i == s.length() - 1) {
                wordEndIndex = i;
                break;
            }
        }
        return wordEndIndex - wordStartIndex + 1;
    }
}
