package com.xiaoqiang.algs.lc;

import java.util.*;

public class LC19 {
    public static void main(String[] args) {
        System.out.println(new LC19().removeNthFromEnd1(new ListNode(1), 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        LinkedList<ListNode> stack = new LinkedList<>();

        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode node = stack.pop();
        node.next = node.next.next;

        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int l = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            l++;
        }
        if (n == l) {
            return head.next;
        }
        int i = 0;
        p = head;
        int pos = l - n;
        while (i < pos-1) {
            p = p.next;
            i++;
        }
        p.next = p.next.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
