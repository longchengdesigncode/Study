package com.demo.algorithm.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chl on 2022/4/21.
 * description : 剑指Offer38. 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <=s的长度 <= 8
 */
public class Permutation {


    private List<String> dates = new ArrayList<>();

    public String[] permutation(String s) {
        dates.clear();
        char[] chars = s.toCharArray();
        //1，按照字母顺序排序，便于后序处理重复的字符
        Arrays.sort(chars);
        int length = chars.length;
        int step = 1;
        dates.add("" + chars[0]);
        while (step < length) {
            char c = chars[step];
            //2，遍历dates中的字符串，将c插入
            Set<String> next = new HashSet<>();
            for (int i = 0; i < dates.size(); i++) {
                String cur = dates.get(i);
                int size = cur.length();
                for (int j = 0; j <= size; j++) {
                    //c插入左边
                    if (j == 0) {
                        next.add(c + cur);
                    } else {
                        if (cur.charAt(j - 1) != c) {
                            //插入字符
                            StringBuilder builder = new StringBuilder();
                            builder.append(cur.substring(0, j));
                            builder.append(c);
                            if (j < size) {
                                builder.append(cur.substring(j));
                            }
                            next.add(builder.toString());
                        }
                    }
                }
            }
            dates.clear();
            dates.addAll(next);
            step++;
        }
        return dates.toArray(new String[dates.size()]);
    }

    public String[] permutation2(String s) {
        dates.clear();
        char[] chars = s.toCharArray();
        //1，按照字母顺序排序，便于后序处理重复的字符
        Arrays.sort(chars);
        int length = chars.length;
        int step = 1;
        dates.add("" + chars[0]);
        while (step < length) {
            char c = chars[step];
            //2，遍历dates中的字符串，将c插入
            Set<String> next = new HashSet<>();
            for (int i = 0; i < dates.size(); i++) {
                String cur = dates.get(i);
                int size = cur.length();
                for (int j = 0; j <= size; j++) {
                    //c插入左边
                    if (j == 0) {
                        next.add(c + cur);
                    } else if (j == size) {
                        next.add(cur + c);
                    } else {
                        StringBuilder builder = new StringBuilder();
                        builder.append(cur.substring(0, j));
                        builder.append(c);
                        builder.append(cur.substring(j));
                        next.add(builder.toString());
                    }
                }
            }
            dates.clear();
            dates.addAll(next);
            step++;
        }
        String[] result = new String[dates.size()];
        for (int i = 0; i < dates.size(); i++) {
            result[i] = dates.get(i);
        }
        return result;
    }

    //使用回朔算法
    public String[] permutation3(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        List<String> dates = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, dates);


        return dates.toArray(new String[dates.size()]);
    }

    private void dfs(char[] chars, int index, List<String> dates) {
        if (index == chars.length) {
            dates.add(new String(chars));
            return;
        }
        boolean[] marks = new boolean[26];
        for (int i = index; i < chars.length; i++) {
            if (!marks[chars[i] - 'a']) {
                marks[chars[i] - 'a'] = true;
                swap(index, i, chars);
                dfs(chars, index + 1, dates);
                //数据复位
                swap (i,index, chars);
            }
        }
    }

    //两个字符交换
    private void swap(int i, int j, char[] chars) {
        char tem = chars[i];
        chars[i] = chars[j];
        chars[j] = tem;
    }
}
