package com.demo.algorithm.leetcode.medium;

/**
 * create on 2024/1/9
 * @author chenglong
 * description : 字符串中的额外字符
 *
 * 给你一个下标从0开始的字符串s和一个单词字典dictionary。你需要将s分割成若干个互不重叠的子字符串，每个子字符串都在dictionary中出现过。
 * s中可能会有一些额外的字符不在任何子字符串中。
 * 请你采取最优策略分割s，使剩下的字符最少。
 *
 * 示例 1：
 * 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
 * 输出：1
 * 解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以我们返回 1 。
 *
 * 示例 2：
 * 输入：s = "sayhelloworld", dictionary = ["hello","world"]
 * 输出：3
 * 解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使用，所以我们返回 3 。
 *
 * 提示：
 * 1 <= s.length <= 50
 * 1 <= dictionary.length <= 50
 * 1 <= dictionary[i].length <= 50
 * dictionary[i]和s只包含小写英文字母。
 * dictionary 中的单词互不相同。
 */
public class MinExtraChar {

    public int minExtraChar(String s, String[] dictionary) {

        return 0;
    }
}
