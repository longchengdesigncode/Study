package com.demo.algorithm.leetcode.medium;

/**
 * Created by chl on 2022/3/20.
 * description : 统计按位或能得到最大值的子集数目
 *
 * 给你一个整数数组nums，请你找出nums子集按位或可能得到的最大值，并返回按位或能得到最大值的不同非空子集的数目。
 * 如果数组a可以由数组b删除一些元素（或不删除）得到，则认为数组a是数组b的一个子集。如果选中的元素下标位置不一样，则认为两个子集不同 。
 * 对数组a执行按位或，结果等于a[0]ORa[1]OR ... OR a[a.length - 1]（下标从0开始）。
 *
 * 示例 1：
 * 输入：nums = [3,1]
 * 输出：2
 * 解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
 * - [3]
 * - [3,1]
 *
 * 示例 2：
 * 输入：nums = [2,2,2]
 * 输出：7
 * 解释：[2,2,2] 的所有非空子集的按位或都可以得到 2 。总共有 23 - 1 = 7 个子集。
 *
 * 示例 3：
 * 输入：nums = [3,2,1,5]
 * 输出：6
 * 解释：子集按位或可能的最大值是 7 。有 6 个子集按位或可以得到 7 ：
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]
 *
 * 提示：
 * 1 <= nums.length <= 16
 * 1 <= nums[i] <= 105
 */
public class MaxStrByOr {

    public int countMaxOrSubsets(int[] nums) {
        /**
         * 分析：枚举所有子集并计算按位或的值，记录大小与数量
         */
        int max = 0;
        int count = 0;
        int n = nums.length;
        for (int i = 1; i < 1 << n; i++) {
            int result = calculation(i, nums);
            if (result == max) {
                count++;
            } else if (result > max) {
                max = result;
                count = 1;
            }
        }
        return count;
    }

    private int calculation(int num, int[] dates) {
        int n = dates.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if ((num & (1 << i)) != 0) {
                //当前位置被选中
                sum |= dates[i];
            }
        }
        return sum;
    }

    public int countMaxOrSubsets2(int[] nums) {
        /**
         * 分析：数组所有的数按位或可以取得最大值。如果重复数字对结果不会有变化，重复位也不会对结果有变化
         * 可以转换为：查找按位或成指定大小的子集数量
         */
        int length = nums.length;
        //1，获取最大值
        int max = 0;
        for (int i = 0; i < length; i++) {
            max |= nums[i];
        }
        //2，查找按位或为max的子集数量
        return dfs(0, 0, max, nums);
    }

    private int dfs(int index, int sum, int max, int[] nums) {
        int length = nums.length;
        if (sum == max) {
            //当前位或到max时，后面都是重复的位，此时取或不取，结果一样。故数量为2的(length-index)次方
            return 1 << (length - index);
        }
        int count = 0;
        for (int i = index; i < length; i++) {
            int tem = sum | nums[i];
            count += dfs(i + 1, tem, max, nums);
        }
        return count;
    }
}
