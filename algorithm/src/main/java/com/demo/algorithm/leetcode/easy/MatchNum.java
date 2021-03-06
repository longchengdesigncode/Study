package com.demo.algorithm.leetcode.easy;

/**
 * create on 2022/1/25
 * @author chenglong
 * description : 比赛中的配对次数
 *
 * 给你一个整数n，表示比赛中的队伍数。比赛遵循一种独特的赛制：
 * 如果当前队伍数是偶数，那么每支队伍都会与另一支队伍配对。总共进行n/2场比赛，且产生n/2支队伍进入下一轮。
 * 如果当前队伍数为奇数，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行(n-1)/2场比赛，且产生(n-1)/2+1支队伍进入下一轮。
 * 返回在比赛中进行的配对次数，直到决出获胜队伍为止。
 *
 * 示例 1：
 * 输入：n = 7
 * 输出：6
 * 解释：比赛详情：
 * - 第 1 轮：队伍数 = 7 ，配对次数 = 3 ，4 支队伍晋级。
 * - 第 2 轮：队伍数 = 4 ，配对次数 = 2 ，2 支队伍晋级。
 * - 第 3 轮：队伍数 = 2 ，配对次数 = 1 ，决出 1 支获胜队伍。
 * 总配对次数 = 3 + 2 + 1 = 6
 *
 * 示例 2：
 * 输入：n = 14
 * 输出：13
 * 解释：比赛详情：
 * - 第 1 轮：队伍数 = 14 ，配对次数 = 7 ，7 支队伍晋级。
 * - 第 2 轮：队伍数 = 7 ，配对次数 = 3 ，4 支队伍晋级。
 * - 第 3 轮：队伍数 = 4 ，配对次数 = 2 ，2 支队伍晋级。
 * - 第 4 轮：队伍数 = 2 ，配对次数 = 1 ，决出 1 支获胜队伍。
 * 总配对次数 = 7 + 3 + 2 + 1 = 13
 *
 * 提示：
 * 1 <= n <= 200
 */
public class MatchNum {

    public int numberOfMatches(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                //偶数
                n >>= 1;
                count += n;
            } else {
                //奇数
                n >>= 1;
                count += n;
                n++;
            }
        }
        return count;
    }

    public int numberOfMatches2(int n) {
        /**
         * 使用数学找规律：最终的结果只有一只队伍获胜，有n-1只队伍被淘汰。
         * 每场比赛都有一个队伍被淘汰，比赛次数转换为了淘汰队伍数量
         */
        return n - 1;
    }
}
