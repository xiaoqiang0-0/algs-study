package com.xiaoqiang.algs.lc;


import java.util.LinkedList;
import java.util.List;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        visit(root, result);
        return result;
    }

    public void visit(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        visit(node.left, arr);
        arr.add(node.val);
        visit(node.right, arr);
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int data) {
            this.val = data;
        }
    }
}

