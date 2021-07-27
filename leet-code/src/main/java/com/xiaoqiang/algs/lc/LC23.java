package com.xiaoqiang.algs.lc;

public class LC23 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        System.out.println(new LC23().mergeKLists(new ListNode[]{l1, l2, l3}));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode n = head;
        while (true){
            ListNode min = head;
            int minIndex = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (lists[i].val < min.val) {
                    min = lists[i];
                    minIndex = i;
                }
            }
            if (min == head) {
                break;
            }
            n.next = min;
            n = n.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return head.next;
    }
}
