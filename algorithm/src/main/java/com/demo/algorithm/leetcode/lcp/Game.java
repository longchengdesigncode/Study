package com.demo.algorithm.leetcode.lcp;

/**
 * create on 2023/12/19
 * @author chenglong
 * description : LCP 01. 猜数字
 *
 * 小A和小B在玩猜数字。小B每次从1,2,3中随机选择一个，小A每次也从1,2,3中选择一个猜。他们一共进行三次这个游戏，请返回小A猜对了几次？
 * 输入的guess数组为小A每次的猜测，answer数组为小B每次的选择。guess和answer的长度都等于3。
 *
 * 示例 1：
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 *
 * 示例 2：
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第二次。
 *
 * 限制：
 * guess 的长度 = 3
 * answer 的长度 = 3
 * guess 的元素取值为 {1, 2, 3} 之一。
 * answer 的元素取值为 {1, 2, 3} 之一。
 */
public class Game {

    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (answer[i] == guess[i]) {
                count++;
            }
        }
        return count;
    }
}
