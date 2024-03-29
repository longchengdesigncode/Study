package com.demo.algorithm.leetcode.easy;

/**
 * create on 2023/7/5
 * @author chenglong
 * description : K件物品的最大和
 *
 * 袋子中装有一些物品，每个物品上都标记着数字1、0或-1。
 * 给你四个非负整数numOnes、numZeros、numNegOnes和k。
 * 袋子最初包含：
 * numOnes件标记为1的物品。
 * numZeroes件标记为0的物品。
 * numNegOnes件标记为-1的物品。
 * 现计划从这些物品中恰好选出k件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
 *
 * 示例 1：
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
 * 输出：2
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 2 件标记为 1 的物品，得到的数字之和为 2 。
 * 可以证明 2 是所有可行方案中的最大值。
 *
 * 示例 2：
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4
 * 输出：3
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 3 件标记为 1 的物品，1 件标记为 0 的物品，得到的数字之和为 3 。
 * 可以证明 3 是所有可行方案中的最大值。
 *
 * 提示：
 * 0 <= numOnes, numZeros, numNegOnes <= 50
 * 0 <= k <= numOnes + numZeros + numNegOnes
 * 通过
 */
public class KItemsWithMaximumSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        }
        if (k <= numOnes + numZeros) {
            return numOnes;
        }
        int last = k - numOnes - numZeros;
        return numOnes - last;
    }
}
