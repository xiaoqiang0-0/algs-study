package com.xiaoqiang.algs.lc;

import java.util.*;

public class LC49 {
    public static char CHAR_STARTER = 'a';
    public static char CHAR_END = 'z';
    public static int CHARS_NUM = CHAR_END - CHAR_STARTER + 1;


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Key, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            Key k = new Key(str);
            List<String> list = map.computeIfAbsent(k, k1 -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    static class Key {
        int[] charCount;

        public Key(String str) {
            this.charCount = new int[CHARS_NUM];
            for (char c : str.toCharArray()) {
                charCount[c - CHAR_STARTER]++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Arrays.equals(charCount, key.charCount);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(charCount);
        }
    }
}
