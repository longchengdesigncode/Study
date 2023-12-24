package com.demo.algorithm.leetcode.lcr;

/**
 * create on 2023/12/22
 * @author chenglong
 * description : LCR 068. 搜索插入位置
 *
 * 给定一个排序的整数数组nums和一个整数目标值target，请在数组中找到target，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为O(logn)的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 *
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 *
 * 提示:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 为无重复元素的升序排列数组
 * -10^4 <= target <= 10^4
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        //1，处理边界查询
        int start = 0;
        int end = nums.length - 1;
        if (target <= nums[start]) {
            return 0;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        if (target == nums[end]) {
            return end;
        }
        //2，使用二分法进行查询
        while (start < end) {
            int middle = (end - start) / 2 + start;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }
}
