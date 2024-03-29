package com.demo.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * Created by chl on 2022/9/4.
 * description : 最长数对链
 *
 * 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 示例：
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 * 提示：
 * 给出数对的个数在[1, 1000] 范围内。
 */
public class FindLongestChain {

    public int findLongestChain(int[][] pairs) {
        int length = pairs.length;
        if (length == 1) {
            return 1;
        }
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        int count = 1;
        int last = pairs[0][1];
        for (int i = 1; i < length; i++) {
            if (pairs[i][0] > last) {
                count++;
                last = pairs[i][1];
            }
        }
        return count;
    }
}
