package com.xiaoqiang.algs.interview;

/**
 * 2. 两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Leetcode2 {
    public static void main(String[] args) {
        Leetcode2 l2 = new Leetcode2();
        ListNode n1 = l2.intToListNode(342);
        ListNode n2 = l2.intToListNode(465);
        ListNode n3 = l2.addTwoNumbers(n1, n2);
        System.out.println(l2.listNodeToInt(n3));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode();
        ListNode c = r;
        ListNode p = r;
        int fullFlag = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += fullFlag;
            c.val = sum % 10;
            fullFlag = sum / 10;
            c.next = new ListNode();
            p = c;
            c = c.next;
        }
        if (fullFlag != 0) {
            c.val = fullFlag;
        }
        if (c.val == 0) {
            p.next = null;
        }

        return r;
    }

    private int listNodeToInt(ListNode l) {
        int result = l.val;
        int i = 1;
        while (l.next != null) {
            l = l.next;
            int curVal = l.val;
            for (int j = 0; j < i; j++) {
                curVal *= 10;
            }
            result += curVal;
            i++;
        }
        return result;
    }

    private ListNode intToListNode(int val) {
        ListNode h = new ListNode(val % 10);
        val = val / 10;
        ListNode n = h;
        while (val > 0) {
            n.next = new ListNode(val % 10);
            n = n.next;
            val = val / 10;
        }
        return h;
    }
}

class ListNode {
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
}