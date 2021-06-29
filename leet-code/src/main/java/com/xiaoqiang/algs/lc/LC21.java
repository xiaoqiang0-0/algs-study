package com.xiaoqiang.algs.lc;


public class LC21 {

    public static void main(String[] args) {
        System.out.println(new LC21().mergeTwoLists(new ListNode(1,new ListNode(3)), new ListNode(2)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
                continue;
            }
            if (l2.val>l1.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
