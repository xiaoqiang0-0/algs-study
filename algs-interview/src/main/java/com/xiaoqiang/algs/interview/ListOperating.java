package com.xiaoqiang.algs.interview;

/**
 * 1 8 3 6 5 4 7 2 9 0
 * 基数位倒叙，偶数位不变，合并
 * 考察点：
 * 1. 列表的反转
 * 2. 列表的合并
 */
public class ListOperating {
    /**
     * list 节点
     */
    static class Node {
        private Integer data;
        private Node next;

        public Node() {
        }

        public Node(Integer data) {
            this.data = data;
        }

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * 在list首部插入一个元素
     *
     * @param e    带插入的元素
     * @param head 插入的目标list
     */
    public static void insertHead(int e, Node head) {
        Node next = head.next;
        Node newNode = new Node(e);
        newNode.next = next;
        head.next = newNode;
    }

    /**
     * 在list尾部插入一个元素
     *
     * @param e    带插入的元素
     * @param head 插入的目标list
     */
    public static void insertTail(int e, Node head) {
        Node curr = head.next;
        while (curr.data != -1) {
            curr = curr.next;
        }
        curr.data = e;
        curr.next = new Node(-1);
    }

    /**
     * list 反转
     *
     * @param head 待处理的list
     */
    public static void reverse(Node head) {
        Node curr, next;
        curr = head.next;

        while (curr.next != null && curr.next.data != -1) {
            next = curr.next;
            curr.next = next.next;

            next.next = head.next;
            head.next = next;
        }
    }

    /**
     * 将list分割为两个list
     *
     * @param list 原list
     * @param h1   子list1
     * @param h2   子list2
     */
    public static void division(Node list, Node h1, Node h2) {
        Node curr = list.next;
        int index = 0;
        while (curr.data != -1) {
            if (index++ % 2 == 0) {
                insertTail(curr.data, h1);
            } else {
                insertTail(curr.data, h2);
            }
            curr = curr.next;
        }
    }

    /**
     * 合并已排序的list
     *
     * @param h1 有序的list1
     * @param h2 有序的list2
     * @return 合并后的list
     */
    public static Node margeSortedList(Node h1, Node h2) {
        Node head = new Node(0, new Node(-1));
        Node curr = head.next;
        h1 = h1.next;
        h2 = h2.next;
        while (h1.data != -1 && h2.data != -1) {
            if (h1.data > h2.data) {
                curr.data = h2.data;
                h2 = h2.next;
            } else {
                curr.data = h1.data;
                h1 = h1.next;
            }
            curr.next = new Node(-1);
            curr = curr.next;
        }

        while (h1.data != -1) {
            curr.data = h1.data;
            h1 = h1.next;
        }


        while (h2.data != -1) {
            curr.data = h2.data;
            h2 = h2.next;
        }
        curr.next = new Node(-1);
        return head;
    }


    /**
     * 将数组初始化为list
     *
     * @param arr 原数组
     * @return 生成的list头结点
     */
    public static Node init(int[] arr) {
        Node head, curr = new Node();
        head = new Node(0, curr);
        for (int i : arr) {
            curr.data = i;
            curr.next = new Node();
            curr = curr.next;
        }
        curr.data = -1;
        return head;
    }

    /**
     * 隐藏首/尾节点打印list
     *
     * @param head list 头结点
     */
    public static void printList(Node head) {
        printList(head, true);
    }

    /**
     * 打印列表
     *
     * @param head          链表头结点
     * @param noHeadAndTail 是否影藏首/尾节点显示
     */
    public static void printList(Node head, boolean noHeadAndTail) {
        if (noHeadAndTail) {
            head = head.next;
        }
        while (head.next != null) {
            System.out.print(head.data + "\t");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = init(new int[]{1, 3, 4, 5});
//        insertHead(6, head);
//        insertTail(7, head);
        printList(head);
        reverse(head);
        printList(head);

        Node h1 = init(new int[]{1, 3, 5, 7});
        Node h2 = init(new int[]{2, 4, 6, 8});
        Node newList = margeSortedList(h1, h2);
        printList(newList);

        System.out.println("======================================================");
        Node divisionList = init(new int[]{1, 8, 3, 6, 5, 4, 7, 2});
        Node subList1 = new Node(0, new Node(-1));
        Node subList2 = new Node(0, new Node(-1));
        division(divisionList, subList1, subList2);
        printList(subList1);
        printList(subList2);
        System.out.println("======================================================");
        reverse(subList2);
        printList(margeSortedList(subList1, subList2));
    }
}
