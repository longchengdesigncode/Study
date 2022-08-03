package com.demo.algorithm.leetcode.contest.week301;

/**
 * create on 2022/8/3
 * @author chenglong
 * description : 统计理想数组的数目
 *
 * 给你两个整数n和maxValue，用于描述一个理想数组 。
 * 对于下标从0开始、长度为n的整数数组arr，如果满足以下条件，则认为该数组是一个理想数组 ：
 * 每个 arr[i] 都是从 1 到 maxValue 范围内的一个值，其中 0 <= i < n 。
 * 每个 arr[i] 都可以被 arr[i - 1] 整除，其中 0 < i < n 。
 * 返回长度为 n 的 不同 理想数组的数目。由于答案可能很大，返回对 10^9 + 7 取余的结果。
 *
 * 示例 1：
 * 输入：n = 2, maxValue = 5
 * 输出：10
 * 解释：存在以下理想数组：
 * - 以 1 开头的数组（5 个）：[1,1]、[1,2]、[1,3]、[1,4]、[1,5]
 * - 以 2 开头的数组（2 个）：[2,2]、[2,4]
 * - 以 3 开头的数组（1 个）：[3,3]
 * - 以 4 开头的数组（1 个）：[4,4]
 * - 以 5 开头的数组（1 个）：[5,5]
 * 共计 5 + 2 + 1 + 1 + 1 = 10 个不同理想数组。
 *
 * 示例 2：
 * 输入：n = 5, maxValue = 3
 * 输出：11
 * 解释：存在以下理想数组：
 * - 以 1 开头的数组（9 个）：
 *    - 不含其他不同值（1 个）：[1,1,1,1,1]
 *    - 含一个不同值 2（4 个）：[1,1,1,1,2], [1,1,1,2,2], [1,1,2,2,2], [1,2,2,2,2]
 *    - 含一个不同值 3（4 个）：[1,1,1,1,3], [1,1,1,3,3], [1,1,3,3,3], [1,3,3,3,3]
 * - 以 2 开头的数组（1 个）：[2,2,2,2,2]
 * - 以 3 开头的数组（1 个）：[3,3,3,3,3]
 * 共计 9 + 1 + 1 = 11 个不同理想数组。
 *
 * 提示：
 * 2 <= n <= 10^4
 * 1 <= maxValue <= 10^4
 */
public class IdealArrays {

    public int idealArrays(int n, int maxValue) {
        return 0;
    }
}
