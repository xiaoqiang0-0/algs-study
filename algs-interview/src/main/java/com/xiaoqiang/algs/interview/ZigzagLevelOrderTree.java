package com.xiaoqiang.algs.interview;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class ZigzagLevelOrderTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new ZigzagLevelOrderTree().zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root==null) {
            return result;
        }
        Queue<TreeNode> lq = new LinkedList<>();
        Queue<TreeNode> rq = new LinkedList<>();
        lq.offer(root);
        boolean flag = true;
        LinkedList<Integer> curLevel = new LinkedList<>();
        while (!lq.isEmpty() || !rq.isEmpty()) {
            Queue<TreeNode> cq = flag ? lq : rq;
            Queue<TreeNode> nq = flag ? rq : lq;

            TreeNode n = cq.poll();
            if (n != null) {
                if (flag) {
                    curLevel.addLast(n.val);
                } else {
                    curLevel.addFirst(n.val);
                }
            }
            if (n != null && n.left != null) {
                nq.offer(n.left);
            }
            if (n != null && n.right != null) {
                nq.offer(n.right);
            }

            if (cq.isEmpty()) {
                result.add(curLevel);
                curLevel = new LinkedList<>();
                flag = !flag;
            }
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
