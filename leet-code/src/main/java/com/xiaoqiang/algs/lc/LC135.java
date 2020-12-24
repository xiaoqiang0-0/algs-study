package com.xiaoqiang.algs.lc;

/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class LC135 {
    public static void main(String[] args) {
        System.out.println(new LC135().candy(new int[]{1, 2, 33, 2, 1}));
        System.out.println(new LC135().candy1(new int[]{1, 2, 33, 2, 1}));
    }

    /**
     * 接近暴力法
     * cs记录当前位置分发的糖果数
     * 记录上次最大值lastMaxIndex
     * cs[i]<cs[i+1}时，以此递增，更新lastMaxIndex
     * cs[i]=cs[i+1]时，cs[i+1]置1
     * cs[i]>cs[i+1]时，从上次最大值到当位置，以此检测，更新使得满足递减条件
     * 求和cs[0]->cs[cs.len-1]
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (ratings.length < 2) {
            return ratings.length;
        }
        int lastMaxIndex = 0;
        int sum = 0;
        int[] cs = new int[ratings.length];
        cs[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {
                cs[i] = 1;
                for (int j = i - 1; j >= lastMaxIndex; j--) {
                    if (cs[j] <= cs[j + 1]) {
                        cs[j] = cs[j] + 1;
                    }
                }
            } else if (ratings[i] > ratings[i - 1]) {
                cs[i] = cs[i - 1] + 1;
                lastMaxIndex = i;
            } else {
                lastMaxIndex = i;
                cs[i] = 1;
            }
        }
        for (int c : cs) {
            sum += c;
        }
        return sum;
    }

    /**
     * 左右遍历一次取最大值
     * 左/右遍历一次，按照ratings[i]>ratings[i+1]时为0，ratings[i]<ratings[i+1]时+1,求出局部满足结果集，
     * 然后反向遍历按照规则求出每一个位置应该分发的结果，取左右结果最大值累加
     *
     * @param ratings
     * @return
     */
    public int candy1(int[] ratings) {
        int[] left = new int[ratings.length];
        left[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 1;
        int sum = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            sum += Math.max(left[i], right);
        }
        return sum;
    }

}
