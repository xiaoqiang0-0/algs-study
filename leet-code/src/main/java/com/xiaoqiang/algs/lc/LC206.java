package com.xiaoqiang.algs.lc;

public class LC206 {

    public static void main(String[] args) {
        ListNode h = null;
        System.out.println(h);
        System.out.println(new LC206().reverseList(h));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode next = head.next;
        while (next != null) {
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
            next = head.next;
        }
        return dummy.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return
                    "" + val +
                    "," + next;
        }
    }
}
