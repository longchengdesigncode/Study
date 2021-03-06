package com.demo.algorithm.leetcode.medium;

/**
 * create on 11/2/21
 * @author chenglong
 * description : 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *  
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * 进阶：
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        int index0 = 0;
        //1，将所有的0先交换到左边
        for (int i = index0; i < length; i++) {
            if (nums[i] == 0) {
                if (i == index0) {
                    index0++;
                } else {
                    nums[i] = nums[index0];
                    nums[index0] = 0;
                    index0++;
                }
            }
        }
        //2，将所有的1交换到左边
        if (index0 == length) {
            return;
        }
        for (int i = index0; i < length; i++) {
            if (nums[i] == 1) {
                if (i == index0) {
                    index0++;
                } else {
                    nums[i] = nums[index0];
                    nums[index0] = 1;
                    index0++;
                }
            }
        }
    }

    public static void sortColors2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        //使用双指针进行操作
        int index0 = 0;
        int index1 = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                if (index0 == i) {
                    index0++;
                    if (index1 < index0) {
                        index1 = index0;
                    }
                } else {
                    nums[i] = nums[index0];
                    nums[index0] = 0;
                    index0++;
                    if (index1 < index0) {
                        index1 = index0;
                    }
                    if (index1 < i && nums[i] < nums[index1]) {
                        int tem = nums[i];
                        nums[i] = nums[index1];
                        nums[index1] = tem;
                        index1++;
                    } else if (index1 == i && nums[i] == 1) {
                        index1++;
                    }
                }
            } else if (nums[i] == 1) {
                if (index1 == i) {
                    index1++;
                } else {
                    nums[i] = nums[index1];
                    nums[index1] = 1;
                    index1++;
                }
            }
        }
    }
}
