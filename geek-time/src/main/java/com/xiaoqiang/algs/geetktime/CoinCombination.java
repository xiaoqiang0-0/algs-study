package com.xiaoqiang.algs.geetktime;


/**
 * 获取给定货币集合以及，目标值，求最小的组合的个数
 *     1) 当目标值小于最小货币面额时，无法完成组合，返回-1
 *     2) 当目标值等于其中某一货币面值时，只需要一份当前面值的货币即可满足，因此返回1
 *     3) 其他情况 则 minCount[target] = min(minCount[target-c1]+1,minCount[target-c2]+1,minCount[target-ci]+1)
 */
public class CoinCombination {
    public static void main(String[] args) {
        System.out.println(getMinCount(new int[]{5, 10, 20}, 100));
    }

    public static int getMinCount(int[] coinCollection, int target) {
        int minVal = Integer.MAX_VALUE;
        for (int c : coinCollection) {
            if (c == target) {
                return 1;
            }
            minVal = Math.min(c, minVal);
        }
        if (minVal > target) {
            return -1;
        }

        int min = -1;

        for (int c : coinCollection) {
            int lastMinCount = getMinCount(coinCollection, target - c);
            if (lastMinCount == -1) {
                continue;
            }
            if (lastMinCount + 1 < min || min == -1) {
                min = lastMinCount + 1;
            }
        }

        return min;
    }

}
