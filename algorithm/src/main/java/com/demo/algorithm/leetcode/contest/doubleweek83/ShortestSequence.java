package com.demo.algorithm.leetcode.contest.doubleweek83;

/**
 * create on 2022/8/2
 * @author chenglong
 * description : 不可能得到的最短骰子序列
 *
 * 给你一个长度为n的整数数组rolls和一个整数k。你扔一个k面的骰子n次，骰子的每个面分别是1到k，其中第i次扔得到的数字是rolls[i]。
 * 请你返回无法从rolls中得到的最短骰子子序列的长度。
 * 扔一个k面的骰子len次得到的是一个长度为len的骰子子序列。
 * 注意，子序列只需要保持在原数组中的顺序，不需要连续。
 *
 * 示例 1：
 * 输入：rolls = [4,2,1,2,3,3,2,4,1], k = 4
 * 输出：3
 * 解释：所有长度为 1 的骰子子序列 [1] ，[2] ，[3] ，[4] 都可以从原数组中得到。
 * 所有长度为 2 的骰子子序列 [1, 1] ，[1, 2] ，... ，[4, 4] 都可以从原数组中得到。
 * 子序列 [1, 4, 2] 无法从原数组中得到，所以我们返回 3 。
 * 还有别的子序列也无法从原数组中得到。
 *
 * 示例 2：
 * 输入：rolls = [1,1,2,2], k = 2
 * 输出：2
 * 解释：所有长度为 1 的子序列 [1] ，[2] 都可以从原数组中得到。
 * 子序列 [2, 1] 无法从原数组中得到，所以我们返回 2 。
 * 还有别的子序列也无法从原数组中得到，但 [2, 1] 是最短的子序列。
 *
 * 示例 3：
 * 输入：rolls = [1,1,3,2,2,2,3,3], k = 4
 * 输出：1
 * 解释：子序列 [4] 无法从原数组中得到，所以我们返回 1 。
 * 还有别的子序列也无法从原数组中得到，但 [4] 是最短的子序列。
 *
 * 提示：
 * n == rolls.length
 * 1 <= n <= 10^5
 * 1 <= rolls[i] <= k <= 10^5
 */
public class ShortestSequence {

    public int shortestSequence(int[] rolls, int k) {
        int count = 1;
        int[] marks = new int[k + 1];
        int length = rolls.length;
        int last = k;
        for (int i = 0; i < length; i++) {
            if (marks[rolls[i]] < count) {
                marks[rolls[i]] = count;
                last--;
                if (last == 0) {
                    count++;
                    last = k;
                }
            }
        }
        return count;
    }
}
