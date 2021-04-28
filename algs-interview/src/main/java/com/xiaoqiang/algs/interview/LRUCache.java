package com.xiaoqiang.algs.interview;

import java.util.HashMap;

/**
 * 146. LRU 缓存机制
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 */
public class LRUCache {

    static class Node<K, V> {
        K key;
        V data;
        Node<K, V> next;
        Node<K, V> prev;

        public Node(K key, V data) {
            this.key = key;
            this.data = data;
        }
    }


    private final int capacity;
    private HashMap<Integer, Node<Integer, Integer>> map;
    private Node<Integer, Integer> head;
    private Node<Integer, Integer> tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public Integer get(Integer key) {
        Node<Integer, Integer> node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveNodeToHead(node);
        return node.data;
    }

    public void put(Integer key, Integer value) {
        Node<Integer, Integer> node = map.get(key);
        Node<Integer, Integer> newNode = null;
        if (node == null) {
            if (map.size() >= capacity) {
                map.remove(tail.prev.key);
                removeNodeFromTail();
            }
            newNode = new Node<>(key, value);
        } else {
            node.data = value;
            newNode = node;
        }
        moveNodeToHead(newNode);
        map.put(key, newNode);
    }

    private void moveNodeToHead(Node<Integer, Integer> node) {
        Node<Integer, Integer> next = node.next;
        if (next != null) {
            node.prev.next = next;
            next.prev = node.prev;
        }
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeNodeFromTail() {
        Node<Integer, Integer> lastNode = tail.prev;
        lastNode.prev.next = tail;
        tail.prev = lastNode.prev;
    }

    /*
    *
    ["LRUCache","put","put","get","put","get","put","get","get","get"]
           [[2],[1,1],[2,2],[1],  [3,3],[2],  [4,4],[1],  [3],  [4]]
    * */
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
