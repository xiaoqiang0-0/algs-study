package com.xiaoqiang.algs.lc;


import java.util.Deque;
import java.util.LinkedList;

public class LC224 {
    public static void main(String[] args) {
        System.out.println(new LC224().calculate("- (3 + (4 + 5))"));
    }

    public int calculate(String s) {
        int result = 0, num = 0, op = 1;
        Deque<Integer> sign = new LinkedList<>();
        sign.push(op);
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                continue;
            }
            result += op * num;
            num = 0;

            if (c == '+') {
                op = sign.peek();
            } else if (c == '-') {
                op = -sign.peek();
            } else if (c == '(') {
                sign.push(op);
            } else if (c == ')') {
                sign.pop();
            }
        }
        return result + op * num;
    }
}
