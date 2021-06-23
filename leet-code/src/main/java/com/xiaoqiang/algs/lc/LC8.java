package com.xiaoqiang.algs.lc;

public class LC8 {

    public static void main(String[] args) {
        System.out.println(new LC8().myAtoi("9223372036854775808"));
    }


    public int myAtoi(String s) {
        long result = 0;
        char[] chars = s.toCharArray();
        boolean flag = false;
        boolean over0 = true;
        for (char c : chars) {
            if (!flag) {
                if (c != '-' && c != '+' && c != ' ' && (c < '0' || c > '9')) {
                    break;
                }
                if (c == ' ') {
                    continue;
                }
            } else {
                if (c < '0' || c > '9') {
                    break;
                }
            }

            if (!flag && (c == '-' || c == '+' || (c >= '0' && c <= '9'))) {
                flag = !flag;
                if (c == '-') {
                    over0 = false;
                } else if (c == '+') {
                    continue;
                } else {
                    result = result * 10 + (c - '0');
                }
                continue;
            }
            result = result * 10 + (c - '0');
            if (result>Integer.MAX_VALUE||-result<Integer.MIN_VALUE) {
                break;
            }
        }
        result = over0 ? result : -result;
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) result;
    }
}
