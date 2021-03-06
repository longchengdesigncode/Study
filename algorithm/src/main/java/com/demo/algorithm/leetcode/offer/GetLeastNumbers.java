package com.demo.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * Created by chl on 2022/4/10.
 * description : 剑指Offer40. 最小的k个数
 *
 * 输入整数数组arr，找出其中最小的k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        if (length == k) {
            return arr;
        }
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
