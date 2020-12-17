package com.xiaoqiang.algs.geetktime;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 字典树
 */
public class PrefixTrie {
    public final static int CHAR_SIZE = 'z' - 'a' + 1;
    public final static char CHAR_STARTER = 'a';

    public static class Node {
        char c;
        String preFix;
        Node[] childs = new Node[CHAR_SIZE];
        boolean isWordEnd;

        public Node(char c) {
            this.c = c;
            isWordEnd = false;
            preFix = "";
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
                cur.preFix += pre.preFix + lowerCaseChars[i];
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

    /**
     * 深度优先遍历获取所有单词
     *
     * @return
     */
    public List<String> dfsGetAllWord() {
        List<String> words = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.isWordEnd) {
                words.add(node.preFix);
            }
            for (Node child : node.childs) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }

        return words;
    }

    public static void main(String[] args) {
        PrefixTrie trie = new PrefixTrie();
        String line = "GitHub is built for collaboration Set up an organization to improve the way your team works together and get access to more features";
        String[] words = line.split(" ");
        for (String word : words) {
            trie.put(word);
        }
//        System.out.println(trie.isValidWord("a"));
        List<String> word = trie.dfsGetAllWord();
        System.out.println(word);
    }
}
