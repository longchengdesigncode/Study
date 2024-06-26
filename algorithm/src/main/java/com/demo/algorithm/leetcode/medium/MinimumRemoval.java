package com.demo.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * create by chenglong on 2024/1/18
 * description : 拿出最少数目的魔法豆
 *
 * 给定一个正整数数组beans，其中每个整数表示一个袋子里装的魔法豆的数目。
 * 请你从每个袋子中拿出一些豆子（也可以不拿出），使得剩下的非空袋子中（即至少还有一颗魔法豆的袋子）魔法豆的数目相等。
 * 一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
 * 请返回你需要拿出魔法豆的最少数目。
 *
 * 示例 1：
 * 输入：beans = [4,1,6,5]
 * 输出：4
 * 解释：
 * - 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
 *   剩下袋子中魔法豆的数目为：[4,0,6,5]
 * - 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[4,0,4,5]
 * - 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[4,0,4,4]
 * 总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 4 个魔法豆更少的方案。
 *
 * 示例 2：
 * 输入：beans = [2,10,3,2]
 * 输出：7
 * 解释：
 * - 我们从有 2 个魔法豆的其中一个袋子中拿出 2 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[0,10,3,2]
 * - 然后我们从另一个有 2 个魔法豆的袋子中拿出 2 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[0,10,3,0]
 * - 然后我们从有 3 个魔法豆的袋子中拿出 3 个魔法豆。
 *   剩下袋子中魔法豆的数目为：[0,10,0,0]
 * 总共拿出了 2 + 2 + 3 = 7 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 7 个魔法豆更少的方案。
 *
 * 提示：
 * 1 <= beans.length <= 10^5
 * 1 <= beans[i] <= 10^5
 */
public class MinimumRemoval {

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        int n = beans.length;
        for (int i = 0; i < n; i++) {
            sum += beans[i];
        }
        long lastMax = 0;
        long base = 1;
        for (int i = 0; i < n; i++) {
            long cur = base * beans[i] * (n - i);
            if (cur > lastMax) {
                lastMax = cur;
            }
        }
        return sum - lastMax;
    }
}
