package com.demo.algorithm.leetcode.easy;

/**
 * create on 2023/11/7
 * @author chenglong
 * description : 统计范围内的元音字符串数
 *
 * 给你一个下标从0开始的字符串数组words和两个整数：left和right。
 * 如果字符串以元音字母开头并以元音字母结尾，那么该字符串就是一个元音字符串，其中元音字母是'a'、'e'、'i'、'o'、'u'。
 * 返回words[i]是元音字符串的数目，其中i在闭区间[left, right]内。
 *
 * 示例 1：
 * 输入：words = ["are","amy","u"], left = 0, right = 2
 * 输出：2
 * 解释：
 * - "are" 是一个元音字符串，因为它以 'a' 开头并以 'e' 结尾。
 * - "amy" 不是元音字符串，因为它没有以元音字母结尾。
 * - "u" 是一个元音字符串，因为它以 'u' 开头并以 'u' 结尾。
 * 在上述范围中的元音字符串数目为 2 。
 *
 * 示例 2：
 * 输入：words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
 * 输出：3
 * 解释：
 * - "aeo" 是一个元音字符串，因为它以 'a' 开头并以 'o' 结尾。
 * - "mu" 不是元音字符串，因为它没有以元音字母开头。
 * - "ooo" 是一个元音字符串，因为它以 'o' 开头并以 'o' 结尾。
 * - "artro" 是一个元音字符串，因为它以 'a' 开头并以 'o' 结尾。
 * 在上述范围中的元音字符串数目为 3 。
 *
 * 提示：
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 10
 * words[i] 仅由小写英文字母组成
 * 0 <= left <= right < words.length
 */
public class VowelStrings {

    private static final char[] COMPARES = {'a', 'e', 'i', 'o', 'u'};

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if (checkLetter(start) && checkLetter(end)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkLetter(char c) {
        for (int i = 0; i < COMPARES.length; i++) {
            if (c == COMPARES[i]) {
                return true;
            }
        }
        return false;
    }
}
