package com.xiaoqiang.algs.lc;

import java.util.LinkedList;

public class LC20 {
    public static void main(String[] args) {
        System.out.println('(' - ')');
        System.out.println(Integer.valueOf('('));
        System.out.println(Integer.valueOf('{'));
        System.out.println(Integer.valueOf('['));

        System.out.println('[' - ']');

        System.out.println('{' - '}');
        System.out.println(new LC20().isValid("({{{{}}}))"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (Math.abs(c - stack.pop()) > 2) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
