package com.demo.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * create by chenglong on 9/16/21
 * description : 存在重复元素 II
 *
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums[i] = nums[j]，并且i和j的差的绝对值至多为 k。
 *
 * 示例1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class SameNumber2 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length < 2) {
            return false;
        }
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (findSameNum(nums, i + 1, i + k, nums[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean findSameNum(int[] datas, int start, int end, int num) {
        if (end > datas.length - 1) {
            end = datas.length - 1;
        }
        for (int i = start; i <= end; i++) {
            if (datas[i] == num) {
                return true;
            }
        }
        return false;
    }

    //使用hash表记录数据并查找重复
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) {
            return false;
        }
        if (k == 0) {
            return false;
        }
        //记录当前位置的值+位置index
        Map<Integer, Integer> marks = new HashMap<>();
        marks.put(nums[0], 0);
        for (int i = 1; i < length; i++) {
            if (marks.containsKey(nums[i]) && (i - marks.get(nums[i]) <= k)) {
                return true;
            }
            marks.put(nums[i], i);
        }
        return false;
    }

    //使用hash表+滑动窗口。优化了空间复杂度
    public static boolean containsNearbyDuplicate3(int[] nums, int k) {
        int length = nums.length;
        if (length == 1 || k == 0) {
            return false;
        }
        Set<Integer> marks = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!marks.add(nums[i])) {
                return true;
            }
            if (i >= k) {
                marks.remove(nums[i - k]);
            }
        }
        return false;
    }
}
