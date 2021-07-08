package com.xiaoqiang.algs.lc;

import java.util.*;

public class LC109 {
    public static void main(String[] args) {
        new LC109().sortedListToBST(new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(6)))));
    }

    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        this.head = head;
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        int i = 1;
        TreeNode root = new TreeNode(i);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode node = null;
        while (i < count && (node = q.poll()) != null) {
            i++;
            node.left = new TreeNode(i);
            q.offer(node.left);
            if (i < count) {
                i++;
                node.right = new TreeNode(i);
                q.offer(node.right);
            }
        }
        leftVisit(root);
        return root;
    }

    public void leftVisit(TreeNode treeNode) {
        if (treeNode != null) {
            leftVisit(treeNode.left);
            treeNode.val = head.val;
            head = head.next;
            leftVisit(treeNode.right);
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}