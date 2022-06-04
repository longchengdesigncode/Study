package com.demo.algorithm.leetcode.interview;

/**
 * Created by chl on 2022/6/4.
 * description : 面试题08.11. 硬币
 *
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 *
 * 示例2:
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 * 说明：
 * 注意:
 * 你可以假设：
 * 0 <= n (总金额) <= 1000000
 */
public class WaysToChange {

    private static final int MOD = 1000000007;
    private static final int[] coins = {1, 5, 10, 25};

    public int waysToChange(int n) {
        if (n == 0) {
            return 0;
        }
        int[] marks = new int[n + 1];
        marks[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; j <= n; j++) {
                if (j >= coin) {
                    marks[j] += marks[j - coin];
                    marks[j] %= MOD;
                }
            }
        }
        return marks[n];
    }
}
