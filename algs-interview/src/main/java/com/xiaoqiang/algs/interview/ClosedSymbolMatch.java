package com.xiaoqiang.algs.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 要求：校验字符串中是否存在非法闭合的符号（包括未闭合）
 * 通过括号演示
 */
public class ClosedSymbolMatch {
    private static final Map<Character, Character> SYMBOL_PAIR_MAP = new HashMap<>();

    static {
        SYMBOL_PAIR_MAP.put('<', '>');
        SYMBOL_PAIR_MAP.put('(', ')');
        SYMBOL_PAIR_MAP.put('[', ']');
        SYMBOL_PAIR_MAP.put('{', '}');
    }

    public static void main(String[] args) {
        String test1 = "()[]{}<>";
        System.out.printf("test string: '%s' \tresult: %s \n", test1, testString(test1));
        test1 = "()[]{<>}";
        System.out.printf("test string: '%s' \tresult: %s \n", test1, testString(test1));
        test1 = "()[]{<}>";
        System.out.printf("test string: '%s' \tresult: %s \n", test1, testString(test1));
        test1 = "()[]}{<>";
        System.out.printf("test string: '%s' \tresult: %s \n", test1, testString(test1));
        test1 = "()[{}<>]";
        System.out.printf("test string: '%s' \tresult: %s \n", test1, testString(test1));
        test1 = "([]{}<)>";
        System.out.printf("test string: '%s' \tresult: %s \n", test1, testString(test1));
    }

    public static boolean testString(String source) {
        //符号栈
        Stack<Character> bracketStack = new Stack<>();
        //遍历字符串
        for (char c : source.toCharArray()) {
            //当字符为左括号时，进栈
            if (SYMBOL_PAIR_MAP.containsKey(c)) {
                bracketStack.push(c);
            } else if (SYMBOL_PAIR_MAP.containsValue(c)) {
                //为右括号时，如果当符号栈为空，或者当前符号栈顶无法与当前符号匹配，则说明存在非法闭合符号
                if (bracketStack.isEmpty() || SYMBOL_PAIR_MAP.get(bracketStack.pop()) != c) {
                    return false;
                }
            }
        }
        //如果经过遍历，最终发现符号栈不为空，则说明字符串中存在未闭合的符号，即存在非法闭合符号
        return bracketStack.isEmpty();
    }
}
