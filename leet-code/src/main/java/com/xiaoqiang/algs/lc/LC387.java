package com.xiaoqiang.algs.lc;

/**
 * 387. 字符串中的第一个唯一字符
 *     charTable[i][2],分别存储某一个字符出现的次数和位置, i = c - 'a'
 */
public class LC387 {
    public static void main(String[] args) {
        System.out.println(new LC387().firstUniqChar("itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb"));
    }

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[][] charTable = new int['z' - 'a' + 1][2];
        for (int i = 0; i < chars.length; i++) {
            if (charTable[chars[i] - 'a'][0]>1) {
                continue;
            }
            charTable[chars[i] - 'a'][0] += 1;
            charTable[chars[i] - 'a'][1] = i;
        }
        int firsIndex = chars.length+1;
        for (int[] charCountInfo : charTable) {
            if (charCountInfo[0] == 1) {
                firsIndex = Math.min(charCountInfo[1], firsIndex);
            }
        }
        return firsIndex == chars.length+1 ? -1 : firsIndex;
    }
}
