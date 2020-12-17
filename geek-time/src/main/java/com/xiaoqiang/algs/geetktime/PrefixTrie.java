package com.xiaoqiang.algs.geetktime;

/**
 * 字典树
 */
public class PrefixTrie {
    public final static int CHAR_SIZE = 'z' - 'a' + 1;
    public final static char CHAR_STARTER = 'a';

    public static class Node {
        char c;
        Node[] childs = new Node[CHAR_SIZE];
        boolean isWordEnd;

        public Node(char c) {
            this.c = c;
            isWordEnd = false;
        }
    }

    private Node root;

    public PrefixTrie() {
        root = new Node('0');
    }

    public void put(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        String lowerCaseWord = word.toLowerCase();
        char[] lowerCaseChars = lowerCaseWord.toCharArray();
        Node pre = root;
        for (int i = 0; i < lowerCaseChars.length; i++) {
            Node cur = pre.childs[lowerCaseChars[i] - CHAR_STARTER];
            if (cur == null) {
                cur = new Node(lowerCaseChars[i]);
                pre.childs[lowerCaseChars[i] - CHAR_STARTER] = cur;
            }
            if (i == lowerCaseChars.length - 1) {
                cur.isWordEnd = true;
            }
            pre = cur;
        }
    }

    public boolean isValidWord(String testWord) {

        if (testWord == null || testWord.length() < 1) {
            return false;
        }
        String lowerCaseWord = testWord.toLowerCase();
        char[] lowerCaseChars = lowerCaseWord.toCharArray();
        Node pre = root;
        for (int i = 0; i < lowerCaseChars.length; i++) {
            if (lowerCaseChars[i] > 'z' || lowerCaseChars[i] < 'a') {
                return false;
            }
            Node cur = pre.childs[lowerCaseChars[i] - CHAR_STARTER];
            if (cur == null) {
                return false;
            }
            if (i == lowerCaseChars.length - 1 && cur.isWordEnd) {
                return true;
            }
            pre = cur;
        }
        return false;
    }

    public static void main(String[] args) {
        PrefixTrie trie = new PrefixTrie();
        String line = "GitHub is built for collaboration Set up an organization to improve the way your team works together and get access to more features";
        String[] words = line.split(" ");
        for (String word : words) {
            trie.put(word);
        }
        System.out.println(trie.isValidWord("github"));
    }
}
