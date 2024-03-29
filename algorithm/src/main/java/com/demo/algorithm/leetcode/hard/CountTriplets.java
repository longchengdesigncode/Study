package com.demo.algorithm.leetcode.hard;

/**
 * create on 2023/3/30
 * @author chenglong
 * description : 按位与为零的三元组
 *
 * 给你一个整数数组nums，返回其中按位与三元组的数目。
 * 按位与三元组是由下标(i,j,k)组成的三元组，并满足下述全部条件：
 * 0 <= i < nums.length
 * 0 <= j < nums.length
 * 0 <= k < nums.length
 * nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
 *
 * 示例 1：
 * 输入：nums = [2,1,3]
 * 输出：12
 * 解释：可以选出如下 i, j, k 三元组：
 * (i=0, j=0, k=1) : 2 & 2 & 1
 * (i=0, j=1, k=0) : 2 & 1 & 2
 * (i=0, j=1, k=1) : 2 & 1 & 1
 * (i=0, j=1, k=2) : 2 & 1 & 3
 * (i=0, j=2, k=1) : 2 & 3 & 1
 * (i=1, j=0, k=0) : 1 & 2 & 2
 * (i=1, j=0, k=1) : 1 & 2 & 1
 * (i=1, j=0, k=2) : 1 & 2 & 3
 * (i=1, j=1, k=0) : 1 & 1 & 2
 * (i=1, j=2, k=0) : 1 & 3 & 2
 * (i=2, j=0, k=1) : 3 & 2 & 1
 * (i=2, j=1, k=0) : 3 & 1 & 2
 *
 * 示例 2：
 * 输入：nums = [0,0,0]
 * 输出：27
 *
 * 提示：
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < 2^16
 */
public class CountTriplets {

    public int countTriplets(int[] nums) {
        int[] marks = new int[1 << 16];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tem = nums[i] & nums[j];
                marks[tem]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < marks.length; j++) {
                if (marks[j] > 0 && (nums[i] & j) == 0) {
                    count += marks[j];
                }
            }
        }
        return count;
    }

    public int countTriplets2(int[] nums) {
        int n = nums.length;
        int[] marks = new int[1 << 16];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                marks[nums[i] & nums[j]]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i] ^ (0xffff);
            /**
             * 分析：在marks中查找和x与运算为0的值
             * 比如：x = 1110000111，x异或:y = 0001111000。此时x&y=0。这个时候y是存在1最多的值。
             * 可以依次较少1的数量：比如：0001110000，0000111000, ...0001100000，0001000000均满足&x = 0
             */
            int y = x;
            while (y != 0) {
                count += marks[y];
                y = (y - 1) & x;
            }
            count += marks[0];
        }
        return count;
    }
}
