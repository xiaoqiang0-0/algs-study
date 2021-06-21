package com.xiaoqiang.algs.interview;


/**
 * 1 取中将列表分隔，
 * 2 然后后半部分翻转
 * 3 将前半部分和后半部分合并
 */
public class LinkedListResort {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(listNode);
        new LinkedListResort().resort(listNode);
        System.out.println(listNode);

    }

    public void resort(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (fast == null) {
            return;
        }
        //快慢指针取中
        ListNode p = head;
        while (fast != null && fast.next != null) {
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        p.next = null;
        slow = reverse(slow);

        marge(head, slow);
//        System.out.println(head);
    }

    private ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode next = listNode.next;
        listNode.next = null;
        return reverse(listNode, next);
    }

    private ListNode reverse(ListNode processed, ListNode unprocessed) {
        if (unprocessed == null) {
            return processed;
        }
        ListNode next = unprocessed.next;
        unprocessed.next = processed;
        return reverse(unprocessed, next);
    }

    private ListNode marge(ListNode head, ListNode slow) {
        boolean flag = true;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head != null || slow != null) {
            if (flag && head != null) {
                p.next = head;
                head = head.next;
            } else {
                p.next = slow;
                slow = slow.next;
            }
            p = p.next;

            flag = !flag;
        }
        return dummy.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }
}
