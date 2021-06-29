package com.xiaoqiang.algs.lc;

import java.util.Deque;
import java.util.LinkedList;

public class LC844 {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stack1 = new LinkedList<>();
        Deque<Character> stack2 = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
