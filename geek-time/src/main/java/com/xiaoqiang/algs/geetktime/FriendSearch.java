package com.xiaoqiang.algs.geetktime;

import java.util.*;

/**
 * 广度优先之查找用户好友
 * 通过广度优先遍历方式获取用户的好友关系
 */
public class FriendSearch {
    static class Node {
        int userId;
        HashSet<Integer> friends;
        int degree;

        public Node(int userId) {
            this.userId = userId;
            this.friends = new HashSet<>();
            this.degree = 0;
        }

    }

    private final Node[] users;

    public FriendSearch(Node[] users) {
        this.users = users;
    }

    /**
     * 广度优先搜索 给定用户的1度好友
     *
     * @param userId 目标用户
     * @return 用户分度好友集{1=[0], 2=[1, 2, 3]}(key为度)
     */
    public Map<Integer, List<Integer>> bfsGetFriends0(int userId) {
        Map<Integer, List<Integer>> fMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        //防止出现关系环无限调用
        HashSet<Integer> visited = new HashSet<>();

        queue.offer(userId);

        while (!queue.isEmpty()) {
            int currentUserId = queue.poll();
            HashSet<Integer> friends = getUser(currentUserId).friends;
            for (Integer friend : friends) {
                if (!userExist(userId)) {
                    continue;
                }
                if (visited.contains(friend)) {
                    continue;
                }
                queue.offer(friend);
                visited.add(friend);
                getUser(friend).degree = getUser(currentUserId).degree + 1;
                fMap.computeIfAbsent(getUser(currentUserId).degree + 1, k -> new ArrayList<>()).add(friend);
            }
        }
        return fMap;
    }

    private Node getUser(int userId) {
        return users[userId];
    }

    private boolean userExist(int userId) {
        return users[userId] != null;
    }

    public static void main(String[] args) {
        int userNum = 4;
        Node[] users = new Node[userNum];
        //创建用户
        for (int i = 0; i < userNum; i++) {
            users[i] = new Node(i);
        }
        //初始化关系, zs<->ls, ls<->ww, ww<->zs, zs<->zl
        Node zs = users[0];
        zs.friends.add(1);
        zs.friends.add(2);
        zs.friends.add(3);
        Node ls = users[1];
        ls.friends.add(0);
        ls.friends.add(2);
        Node ww = users[2];
        ww.friends.add(1);
        ww.friends.add(0);
        Node zl = users[3];
        zl.friends.add(0);

        System.out.println(new FriendSearch(users).bfsGetFriends0(3));
    }
}
