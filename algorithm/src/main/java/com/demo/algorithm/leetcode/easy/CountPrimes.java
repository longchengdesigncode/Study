package com.demo.algorithm.leetcode.easy;

/**
 * create by chenglong on 9/15/21
 * description : 计数质数
 *
 *  统计所有小于非负整数 n 的质数的数量。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 *  
 * 提示：
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int count = 1;
        for (int i = 3; i < n; i+=2) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    //判断当前数是否为质数
    private static boolean isPrime(int number) {
        int divisor = 3;
        while ((number % divisor) != 0 && (divisor < number / divisor)) {
            divisor += 2;
        }
        if (number % divisor == 0) {
            return number == divisor;
        }
        return true;
    }

    //使用厄拉多塞筛法
    public static int countPrimes2(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] isPrimes = new boolean[n];
        isPrimes[0] = true;
        isPrimes[1] = true;
        for (int i = 2; i*i < n; i++) {
            if (!isPrimes[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isPrimes[i]) {
                count++;
            }
        }
        return count;
    }
}
