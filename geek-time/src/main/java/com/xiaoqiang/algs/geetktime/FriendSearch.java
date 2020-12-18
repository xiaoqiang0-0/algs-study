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
        int fromId;

        public Node(int userId) {
            this.userId = userId;
            this.friends = new HashSet<>();
            this.degree = 0;
            this.fromId = -1;
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

    /**
     * 双路队列遍历，查找用户A,B之间的最短路径
     *
     * @param userIdA 用户A的id
     * @param userIdB 用户B的id
     * @return A->B 的最短关系链
     */
    public FriendLink getMinFriendLink(int userIdA, int userIdB) {
        LinkedList<Integer> friendLeftLink = new LinkedList<>();
        LinkedList<Integer> friendRightLink = new LinkedList<>();
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        queueA.offer(userIdA);
        queueB.offer(userIdB);
        HashSet<Integer> commonFriendSet = null;
        Node leftA = new Node(-1);
        Node rightB = new Node(-1);

        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            Node userA = getUser(queueA.poll());
            Node userB = getUser(queueB.poll());

            HashSet<Integer> friendsA = userA.friends;
            HashSet<Integer> friendsB = userB.friends;
            if (friendsA.contains(userB.userId) || friendsB.contains(userA.userId)) {
                leftA = userA;
                rightB = userB;
                break;
            }

            if (friendsA.retainAll(friendsB) || friendsB.retainAll(friendsA)) {
                leftA = userA;
                rightB = userB;
                commonFriendSet = friendsA;
                break;
            }

            for (Integer fa : friendsA) {
                getUser(fa).fromId = userA.userId;
                queueA.offer(fa);
            }

            for (Integer fb : friendsB) {
                getUser(fb).fromId = userB.userId;
                queueB.offer(fb);
            }
        }
        while (leftA.fromId != -1) {
            friendLeftLink.addFirst(leftA.userId);
        }
        friendLeftLink.add(userIdA);
        while (rightB.fromId != -1) {
            friendRightLink.addLast(leftA.userId);
        }
        friendRightLink.addLast(userIdB);

        FriendLink link = new FriendLink();
        link.aToCommon = friendLeftLink;
        link.commonToB = friendRightLink;
        link.common = commonFriendSet;
        return link;
    }

    public class FriendLink {
        LinkedList<Integer> aToCommon;
        LinkedList<Integer> commonToB;
        HashSet<Integer> common;

        private String getLinkString(LinkedList list) {
            if (list == null || list.isEmpty()) {
                return "";
            }
            if (list.size() == 1) {
                return String.valueOf(list.get(0));
            }
            return String.join(" > ", list);
        }

        @Override
        public String toString() {
            return "{" + getLinkString(aToCommon) + " > " + (common == null ? "" : (common + " > ")) + getLinkString(commonToB) + '}';
        }
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

//        System.out.println(new FriendSearch(users).bfsGetFriends0(3));
        System.out.println(new FriendSearch(users).getMinFriendLink(3, 0));

    }
}
