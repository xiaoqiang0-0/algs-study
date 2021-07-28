package com.xiaoqiang.algs.lc;

public class LC25 {
    public static void main(String[] args) {
        System.out.println(new LC25().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head.next;
        ListNode subHead = dummy;
        ListNode pre = head;
        int groupCount = 1;
        while (p != null) {
            if (groupCount == k) {
                int count = 0;
                ListNode n = p;
                while (n!=null){
                    count++;
                    if (count == k) {
                        break;
                    }
                    n = n.next;
                }
                if (count!=k) {
                    break;
                }
                groupCount = 1;
                subHead = pre;
                pre = subHead.next;
                p = p.next;
                continue;
            }
            pre.next = p.next;
            p.next = subHead.next;
            subHead.next = p;
            p = pre.next;
            groupCount++;
        }
        return dummy.next;
    }
}
