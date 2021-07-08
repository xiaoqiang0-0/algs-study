package com.xiaoqiang.algs.lc;

public class LC114 {
    private TreeNode list;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        list = new TreeNode();
        TreeNode head = list;
        dfs(root);
        root.val = head.right.val;
        root.left = head.right.left;
        root.right = head.right.right;
    }

    private void dfs(TreeNode t) {
        if (t != null) {
            list.right = new TreeNode(t.val);
            list = list.right;
            dfs(t.left);
            dfs(t.right);
        }
    }


}
