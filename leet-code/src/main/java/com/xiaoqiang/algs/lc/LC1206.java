package com.xiaoqiang.algs.lc;

import java.util.Random;

public class LC1206 {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        int[] nums = new int[]{30, 40, 50, 60, 70, 90, 80, 45};
        for (int num : nums) {
            skiplist.add(num);
        }
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));;   // 返回 false
        skiplist.add(4);
        System.out.println(skiplist.search(1));;   // 返回 true
        System.out.println(skiplist.erase(0));;    // 返回 false，0 不在跳表中
        System.out.println(skiplist.erase(1));;    // 返回 true
        System.out.println(skiplist.search(1));;   // 返回 false，1 已被擦除
    }
}

class Skiplist {
    static int MAX_LEVEL = 16;
    private int levelCount = 1;

    private Node head;
    private Random r;


    public Skiplist() {
        head = new Node(MAX_LEVEL);
        r = new Random();
    }

    public int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    public boolean search(int target) {
        Node p = head;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < target) {
                p = p.forwards[i];
            }
        }
        return p.forwards[0] != null && p.forwards[0].data == target;
    }

    public void add(int num) {
        int level = head.forwards[0] == null ? 1 : randomLevel();
        if (level > levelCount) {
            level = ++levelCount;
        }
        Node newNode = new Node(level);
        newNode.data = num;
        Node p = head;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < num) {
                p = p.forwards[i];
            }
            if (level > i) {
                if (p.forwards[i] == null) {
                    p.forwards[i] = newNode;
                } else {
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }
    }

    public boolean erase(int num) {
        boolean flag = false;
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < num) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == num) {
            flag = true;
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == num) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
        return flag;
    }

    static class Node {
        private int data;
        private Node[] forwards;


        public Node(int level) {
            forwards = new Node[level];
        }
    }
}
