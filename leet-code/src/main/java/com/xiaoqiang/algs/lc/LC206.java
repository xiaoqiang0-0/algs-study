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
}
