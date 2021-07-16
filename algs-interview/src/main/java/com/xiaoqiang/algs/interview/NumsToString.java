package com.xiaoqiang.algs.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 十进制阿拉伯数字转换汉字字符串
 */
public class NumsToString {
    public static void main(String[] args) {
        System.out.println(numToString(10201));
    }
    static Map<Integer, String> N_TO_S_MAP = new HashMap<>();
    static String[] UNIT = new String[]{"", "十", "百", "千", "万"};

    static {
        N_TO_S_MAP.put(0, "零");
        N_TO_S_MAP.put(1, "一");
        N_TO_S_MAP.put(2, "二");
        N_TO_S_MAP.put(3, "三");
        N_TO_S_MAP.put(4, "四");
        N_TO_S_MAP.put(5, "五");
        N_TO_S_MAP.put(6, "六");
        N_TO_S_MAP.put(7, "七");
        N_TO_S_MAP.put(8, "八");
        N_TO_S_MAP.put(9, "九");

    }

    public static String numToString(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            stack.push(num % 10);
            num = num / 10;
        }
        StringBuilder sb = new StringBuilder();
        boolean lastIsZero = false;
        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (x == 0 && lastIsZero) {
                continue;
            }
            sb.append(N_TO_S_MAP.get(x));

            if (x != 0) {
                sb.append(UNIT[stack.size()]);
                lastIsZero = false;
            } else {
                lastIsZero = true;
            }
        }
        if (lastIsZero){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
