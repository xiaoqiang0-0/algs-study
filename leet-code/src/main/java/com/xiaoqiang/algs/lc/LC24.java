package com.xiaoqiang.algs.lc;

public class LC24 {
    public static void main(String[] args) {
        System.out.println(new LC24().swapPairs(null));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        ListNode p = head.next;
        while (p != null) {
            pre.next.next = p.next;
            p.next = pre.next;
            pre.next = p;
            pre = pre.next.next;
            p = p.next.next;
            if (p != null) {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
