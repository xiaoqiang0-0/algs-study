package com.xiaoqiang.algs.lc;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class LC205 {
    public static void main(String[] args) {
        System.out.println(new LC205().isIsomorphic("qwertyuiop[]asdfghjkl;'\\zxcvbnm,./",
                "',.pyfgcrl/=aoeuidhtns-\\;qjkxbmwvz"));
    }

    /**
     * 双数组缓存s[i]->t[i]和t[i]->s[i]的映射
     * 若双向均为0，即为出现此字符的映射，分别将s[i]->t[i],t[i]->s[i]存入两个映射数组中
     * 如果存在一方有映射，则检查映射的字符是否为另一个字符串中的当前位置字符值，是则继续，否则返回false
     * 如果全部通过返回true
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        char[] charsTargetS = new char[96];
        char[] charsTargetT = new char[96];
        for (int i = 0; i < charsS.length; i++) {
            int indexS = charsS[i] - ' ';
            int indexT = charsT[i] - ' ';
            if (charsTargetS[indexS] == 0 && charsTargetT[indexT] == 0) {
                charsTargetS[indexS] = charsT[i];
                charsTargetT[indexT] = charsS[i];
                continue;
            }
            if (charsTargetS[indexS] != charsT[i] || charsTargetT[indexT] != charsS[i]) {
                return false;
            }
        }
        return true;
    }
}
