package com.xiaoqiang.algs.struct;

import java.util.ArrayList;
import java.util.List;

public class DictTree {

    public static int MAX_CHILDS_LEN = 128;
    public static char START_CHAR = 'a';

    private Node root;

    public DictTree() {
        root = new Node();
        root.childs = new Node[MAX_CHILDS_LEN];
        root.isEnd = false;
    }

    public void add(String string) {
        Node n = root;
        for (char c : string.toCharArray()) {
            Node p = null;
            if ((p = n.childs[c]) == null) {
                p = n.childs[c] = new Node(c);
            }
            n = p;
        }
        n.isEnd = true;
    }

    public List<String> match(String prefix, int limit) {
        List<String> result = new ArrayList<>();
        Node prefixNode = matchNode(prefix);
        if (prefixNode != null) {
            StringBuilder sb = new StringBuilder(prefix);

        }
        return result;
    }

    private Node matchNode(String prefix) {
        Node n = root;
        for (char c : prefix.toCharArray()) {
            if (n.childs[c] == null) {
                return null;
            }
            n = n.childs[c];
        }
        return n;
    }

    class Node {
        char val;
        Node[] childs;
        boolean isEnd;

        public Node() {
        }

        public Node(char val) {
            this.val = val;
            this.childs = new Node[MAX_CHILDS_LEN];
        }
    }

    public static void main(String[] args) {
        DictTree dictTree = new DictTree();
        dictTree.add("baidu.com");
        dictTree.add("baida.com");
        dictTree.add("baidb.com");
        dictTree.add("baidc.com");
        dictTree.add("baidd.com");
        dictTree.add("baide.com");
        System.out.println();
    }
}
