package com.demo.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chl on 2022/2/10.
 * description : 最简分数
 *
 * 给你一个整数n，请你返回所有0到1之间（不包括0和1）满足分母小于等于n的最简分数。分数可以以任意顺序返回。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 *
 * 示例 3：
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 *
 * 示例 4：
 * 输入：n = 1
 * 输出：[]
 *
 * 提示：
 * 1 <= n <= 100
 */
public class SimplestFractions {

    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            return result;
        }
        //1，添加分子为1的分数
        for (int i = 2; i <= n; i++) {
            result.add("1/" + i);
        }
        //2，遍历枚举分子/分母。分子从2开始，分母从分子+1开始
        for (int i = 2; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(i);
                    builder.append("/");
                    builder.append(j);
                    result.add(builder.toString());
                }
            }
        }
        return result;
    }

    //获取a，b之间的最大公约数
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public List<String> simplifiedFractions2(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            return result;
        }
        //1，添加分子为1的分数
        for (int i = 2; i <= n; i++) {
            result.add("1/" + i);
        }
        //2，获取从2~n-1的所有质数
        boolean[] marks = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (marks[i]) {
                continue;
            }
            for (int j = 2 * i; j < n; j += i) {
                marks[j] = true;
            }
        }
        List<Integer> dates = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (!marks[i]) {
                dates.add(i);
            }
        }
        //3，将分子拆分成不同的质数相乘，最后对分母进行打表
        for (int i = 2; i < n; i++) {
            List<Integer> items = split(i, dates);
            boolean[] visit = new boolean[n + 1];
            for (int j = 0; j < items.size(); j++) {
                int tem = items.get(j);
                for (int k = i + tem; k <= n; k += tem) {
                    visit[k] = true;
                }
            }
            for (int j = i + 1; j <= n; j++) {
                if (!visit[j]) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(i);
                    builder.append("/");
                    builder.append(j);
                    result.add(builder.toString());
                }
            }
        }
        return result;
    }

    //将num拆分为不同的质数相乘
    private List<Integer> split(int num, List<Integer> dates) {
        Set<Integer> result = new HashSet<>();
        while (num > 1) {
            for (int i = 0; i < dates.size(); i++) {
                int tem = dates.get(i);
                //使用while防止num拆分中出现重复的质数tem。比如4 = 2*2
                while (num % tem == 0) {
                    result.add(tem);
                    num /= tem;
                }
            }
        }
        return new ArrayList<>(result);
    }
}


