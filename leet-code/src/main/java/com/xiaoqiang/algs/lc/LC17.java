package com.xiaoqiang.algs.lc;

import java.util.*;

public class LC17 {
    public static void main(String[] args) {

    }

    static Map<String, String[]> MAP = new HashMap<>();

    static {
        MAP.put("2", new String[]{"a", "b", "c"});
        MAP.put("3", new String[]{"d", "e", "f"});
        MAP.put("4", new String[]{"g", "h", "i"});
        MAP.put("5", new String[]{"j", "k", "l"});
        MAP.put("6", new String[]{"m", "n", "o"});
        MAP.put("7", new String[]{"p", "q", "r", "s"});
        MAP.put("8", new String[]{"t", "u", "v"});
        MAP.put("9", new String[]{"w", "x", "y", "z"});
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        if (digits.length() == 1) {
            return Arrays.asList(MAP.get(digits));
        }
        List<String> result = new LinkedList<>();
        if (digits.length() == 2) {
            for (String s : MAP.get(digits.substring(0, 1))) {
                for (String s1 : MAP.get(digits.substring(1))) {
                    result.add(s + s1);
                }
            }
            return result;
        }
        if (digits.length() == 3) {
            for (String s : MAP.get(digits.substring(0, 1))) {
                for (String s1 : MAP.get(digits.substring(1, 2))) {
                    for (String s2 : MAP.get(digits.substring(2))) {
                        result.add(s + s1 + s2);
                    }
                }
            }
            return result;
        }

        if (digits.length() == 4) {
            for (String s : MAP.get(digits.substring(0, 1))) {
                for (String s1 : MAP.get(digits.substring(1, 2))) {
                    for (String s2 : MAP.get(digits.substring(2, 3))) {
                        for (String s3 : MAP.get(digits.substring(3))) {
                            result.add(s + s1 + s2 + s3);
                        }
                    }
                }
            }
        }
        return result;
    }
}
