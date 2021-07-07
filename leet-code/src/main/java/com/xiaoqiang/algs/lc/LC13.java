package com.xiaoqiang.algs.lc;

import java.util.HashMap;
import java.util.Map;

public class LC13 {
    public static void main(String[] args) {
        System.out.println(new LC13().romanToInt("III"));
        System.out.println(new LC13().romanToInt("VI"));
        System.out.println(new LC13().romanToInt("VII"));
        System.out.println(new LC13().romanToInt("LVIII"));

    }

    public int romanToInt(String s) {
        int num = 0;
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < rom.length; i++) {
            map.put(rom[i], values[i]);
        }
        if (s.length() == 1) {
            return map.get(s);
        }
        if (s.length() == 2) {
            Integer n = null;
            if ((n = map.get(s)) != null) {
                return n;
            }
        }
        char[] chars = s.toCharArray();
        int i = 0;
        for (; i < chars.length - 1; i++) {
            String key = null;
            Integer v = null;
            if ((v = map.get(String.valueOf(chars[i]))) < map.get(String.valueOf(chars[i + 1]))) {
                key = String.valueOf(new char[]{chars[i], chars[i + 1]});
                v = map.get(key);
                i++;
            }
            num += v;
        }
        if (i == chars.length - 1) {
            num += map.get(String.valueOf(chars[i]));
        }
        return num;
    }
}
