package com.xiaoqiang.algs.lc;

/**
 * 676. 实现一个魔法字典
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 * 思路：
 *      1. 构建字典树
 *      2. 遍历字符串
 *          1. 检测当前字符是否为结束字符，并且当前树节点下存在后续只有一个节点结束且与字符不同与的单词，则返回true
 *          2. 查找字典树，遍历同级所有除当前字符外其他所有节点，并以此节点为和当前字符位置为始，判断后学单词是否合法，合法则返回true （也就是判断修改当前位置字符后能否匹配到其他正确的单词）
 *
 */
public class LC676 {
    public final static int CHAR_SIZE = 'z' - 'a' + 1;

    private Node root;

    public static class Node {
        char c;
        Node[] childs = new Node[CHAR_SIZE];
        boolean isWordEnd;

        public Node(char c) {
            this.c = c;
            isWordEnd = false;
        }
    }

    public static int getStrDistance(String a, String b) {
        if (a == null || b == null) {
            return -1;
        }

        int[][] d = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length(); i++) {
            d[i][0] = i;
        }

        for (int i = 0; i < b.length(); i++) {
            d[0][i] = i;
        }

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                int r = 0;
                if (a.charAt(i) != b.charAt(j)) {
                    r = 1;
                }
                d[i + 1][j + 1] = Math.min(Math.min(d[i][j + 1] + 1, d[i + 1][j] + 1), d[i][j] + r);
            }
        }

        return d[a.length()][b.length()];
    }

    public LC676() {
        this.root = new Node('0');
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            char[] chars = word.toCharArray();
            Node cur = root;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (cur.childs[index] == null) {
                    cur.childs[index] = new Node(chars[i]);
                }
                if (i == chars.length - 1) {
                    cur.childs[index].isWordEnd = true;
                }
                cur = cur.childs[index];
            }
        }
    }


    public boolean isValidWord(char[] chars, int startIndex, Node n) {
        Node pre = n;
        for (int i = startIndex; i < chars.length; i++) {
            if (chars[i] > 'z' || chars[i] < 'a') {
                return false;
            }
            Node cur = pre.childs[chars[i] - 'a'];
            if (cur == null) {
                return false;
            }
            if (i == chars.length - 1 && cur.isWordEnd) {
                return true;
            }
            pre = cur;
        }
        return false;
    }

    public boolean search(String searchWord) {
        char[] chars = searchWord.toCharArray();
        Node p = root;
        for (int i = 0; i < chars.length; i++) {
            if (p == null) {
                break;
            }
            for (int i1 = 0; i1 < p.childs.length; i1++) {
                if (p.childs[i1] == null || p.childs[i1].c == chars[i]) {
                    continue;
                }
                if (i == chars.length - 1) {
                    for (Node node : p.childs) {
                        if (node != null && node.c!=chars[i] && node.isWordEnd) {
                            return true;
                        }
                    }
                }
                Node cur = p.childs[i1];
                if (cur != null && isValidWord(chars, i + 1, cur)) {
                    return true;
                }
            }
            p = p.childs[chars[i] - 'a'];
        }
        return false;
    }

    public static void main(String[] args) {
        LC676 LC676 = new LC676();
//        leetcode676.buildDict(new String[]{"hello", "leetcode"});
//        System.out.println(leetcode676.search("leetcade"));
        LC676.buildDict(new String[]{"a","b","ab","abc","abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj","abcdefghijawefe","aefawoifjowajfowafjeoawjfaow","cba","cas","aaewfawi","babcda","bcd","awefj"});
        System.out.println(LC676.search("ab"));
    }
}
