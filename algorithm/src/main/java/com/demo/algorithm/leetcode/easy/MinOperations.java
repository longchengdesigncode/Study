package com.demo.algorithm.leetcode.easy;

/**
 * create on 2022/9/9
 * @author chenglong
 * description : 文件夹操作日志搜集器
 *
 * 每当用户执行变更文件夹操作时，LeetCode文件系统都会保存一条日志记录。
 * 下面给出对变更操作的说明：
 * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则继续停留在当前文件夹 。
 * "./" ：继续停留在当前文件夹。
 * "x/" ：移动到名为 x 的子文件夹中。题目数据保证总是存在文件夹x。
 * 给你一个字符串列表logs，其中logs[i]是用户在i步执行的操作。
 * 文件系统启动时位于主文件夹，然后执行logs中的操作。
 * 执行完所有变更文件夹操作后，请你找出返回主文件夹所需的最小步数 。
 *
 * 示例 1：
 * 输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 *
 * 示例 2：
 * 输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出：3
 *
 * 示例 3：
 * 输入：logs = ["d1/","../","../","../"]
 * 输出：0
 *
 * 提示：
 * 1 <= logs.length <= 10^3
 * 2 <= logs[i].length <= 10
 * logs[i] 包含小写英文字母，数字，'.' 和 '/'
 * logs[i] 符合语句中描述的格式
 * 文件夹名称由小写英文字母和数字组成
 */
public class MinOperations {

    public int minOperations(String[] logs) {
        int deep = 0;
        int length = logs.length;
        for (int i = 0; i < length; i++) {
            String cur = logs[i];
            if (cur.startsWith("../")) {
                if (deep > 0) {
                    deep--;
                }
            } else if (cur.startsWith("./")) {
                continue;
            } else {
                deep++;
            }
        }
        return deep;
    }
}