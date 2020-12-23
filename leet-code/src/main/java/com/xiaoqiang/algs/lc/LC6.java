package com.xiaoqiang.algs.lc;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 思路1：
 *      n*(n/2+1)的二位数组，先纵向z字形将字符存入，再横线遍历得出结果
 *
 */
public class LC6 {
    public static void main(String[] args) {
        System.out.println(new LC6().convert("ABC", 2));
    }

    public String convert(String s, int numRows) {
        if (s.length() < 3 || numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[] newChars = new char[s.length()];

        char[][] charTable = new char[numRows][s.length() / 2 + 1];
        int[] indexX = new int[numRows];
        int indexH = 0;
        int index = 0;
        boolean flag = true;
        while (index < chars.length) {
            charTable[indexH][indexX[indexH]] = chars[index];
            indexX[indexH] += 1;
            if (indexH == numRows - 1) {
                indexH--;
                flag = false;
            } else if (indexH == 0) {
                indexH++;
                flag = true;
            } else {
                if (flag) {
                    indexH++;
                } else {
                    indexH--;
                }
            }
            index++;
        }
        index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < indexX[i]; j++) {
                newChars[index++] = charTable[i][j];
            }
        }
        return new String(newChars);
    }
}
