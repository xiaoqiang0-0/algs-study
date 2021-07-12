package com.xiaoqiang.algs.lc;

public class LC860 {
    public static void main(String[] args) {
        System.out.println(new LC860().lemonadeChange(new int[]{
                5, 5, 5, 10, 20}));
    }

    /**
     * 直接列出来三种金额的分别处理，记录下来每种收到的钱币数量统计，优先找出10块的
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        int total = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
                total += 5;
                continue;
            }
            if (bills[i] == 10) {
                if (total > 0 && fiveCount > 0) {
                    tenCount++;
                    fiveCount--;
                    total += 5;
                    continue;
                } else {
                    return false;
                }
            }
            if (bills[i] == 20) {
                if (total >= 15 && ((tenCount >= 1 && fiveCount >= 1) || fiveCount >= 3)) {
                    total += 15;
                    if (tenCount >= 1) {
                        tenCount--;
                        fiveCount--;
                    } else {
                        fiveCount -= 3;
                    }
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
