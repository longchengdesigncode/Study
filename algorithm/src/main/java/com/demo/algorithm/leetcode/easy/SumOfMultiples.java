package com.demo.algorithm.leetcode.easy;

/**
 * create on 2023/10/17
 * @author chenglong
 * description : 倍数求和
 *
 * 给你一个正整数n，请你计算在[1，n]范围内能被3、5、7整除的所有整数之和。
 * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
 *
 * 示例 1：
 * 输入：n = 7
 * 输出：21
 * 解释：在 [1, 7] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7 。数字之和为 21 。
 *
 * 示例 2：
 * 输入：n = 10
 * 输出：40
 * 解释：在 [1, 10] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9、10 。数字之和为 40 。
 *
 * 示例 3：
 * 输入：n = 9
 * 输出：30
 * 解释：在 [1, 9] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9 。数字之和为 30 。
 *
 * 提示：
 * 1 <= n <= 10^3
 */
public class SumOfMultiples {

    public int sumOfMultiples(int n) {
        int a3 = n / 3;
        int a5 = n / 5;
        int a7 = n / 7;
        int sum = 3 * (a3 + 1) * a3 / 2 + 5 * (a5 + 1) * a5 / 2 + 7 * (a7 + 1) * a7 / 2;
        int a15 = n / 15;
        int a21 = n / 21;
        int a35 = n / 35;
        sum -= 15 * (a15 + 1) * a15 / 2;
        sum -= 21 * (a21 + 1) * a21 / 2;
        sum -= 35 * (a35 + 1) * a35 / 2;
        int a105 = n / 105;
        sum += 105 * (a105 + 1) * a105 / 2;
        return sum;
    }
}
