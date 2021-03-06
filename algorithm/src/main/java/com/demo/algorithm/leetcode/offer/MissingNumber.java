package com.demo.algorithm.leetcode.offer;

/**
 * Created by chl on 2022/3/26.
 * description : 剑指Offer53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 限制：
 * 1 <= 数组长度 <= 10000
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        //数据量小，可以直接遍历
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return length;
    }

    public int missingNumber2(int[] nums) {
        int length = nums.length;
        if (nums[length - 1] == length - 1) {
            return length;
        }
        int start = 0;
        int end = length - 1;
        while (start < end) {
            int middle = (start + end) >> 1;
            if (nums[middle] == middle) {
                //此时表示缺失的数字在：middle+1~end之间
                start = middle + 1;
            } else {
                //此时表示缺失的数字在：start~middle之间
                end = middle;
            }
        }
        return start;
    }
}
