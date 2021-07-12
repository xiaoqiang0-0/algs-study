package com.xiaoqiang.algs.interview;

import java.util.Stack;

public class DelABAChars {

    public String filterABA(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() < 3) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length - 2; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            if (stack.peek() == chars[i + 2]) {
                stack.pop();
                i++;
                continue;
            }
            stack.push(chars[i++]);
            stack.push(chars[i]);
        }
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
