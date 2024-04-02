package com.demo.algorithm.leetcode.lcp;

/**
 * create on 2023/12/28
 * @author chenglong
 * description : LCP72. 补给马车
 *
 * 远征队即将开启未知的冒险之旅，不过在此之前，将对补给车队进行最后的检查。supplies[i]表示编号为i的补给马车装载的物资数量。
 * 考虑到车队过长容易被野兽偷袭，他们决定将车队的长度变为原来的一半（向下取整），计划为：
 * 找出车队中物资之和最小两辆相邻马车，将它们车辆的物资整合为一辆。若存在多组物资之和相同的马车，则取编号最小的两辆马车进行整合；
 * 重复上述操作直到车队长度符合要求。
 * 请返回车队长度符合要求后，物资的分布情况。
 *
 * 示例 1：
 * 输入：supplies = [7,3,6,1,8]
 * 输出：[10,15]
 * 解释： 第 1 次合并，符合条件的两辆马车为 6,1，合并后的车队为 [7,3,7,8]； 第 2 次合并，符合条件的两辆马车为 (7,3) 和 (3,7)，取编号最小的 (7,3)，合并后的车队为 [10,7,8]；
 * 第 3 次合并，符合条件的两辆马车为 7,8，合并后的车队为 [10,15]； 返回 [10,15]
 *
 * 示例 2：
 * 输入：supplies = [1,3,1,5]
 * 输出：[5,5]
 * 解释：
 *
 * 2 <= supplies.length <= 1000
 * 1 <= supplies[i] <= 1000
 */
public class SupplyWagon {

    public int[] supplyWagon(int[] supplies) {
        int n = supplies.length;
        if (n < 4) {
            //此时合并到一辆车
            int sum = 0;
            for (int i = 0; i < n; i++) {
                
            }
        }
        int target = n / 2;
        int curLength = n;
        while (curLength > target) {
            //1，查找满足添加的车辆
            int findIndex = 0;
            int minTotal = supplies[0] + supplies[1];
            for (int i = 1; i < curLength - 1; i++) {
                int tem = supplies[i] + supplies[i + 1];
                if (tem < minTotal) {
                    minTotal = tem;
                    findIndex = i;
                }
            }
            //合并：findIndex，findIndex+1，findIndex+2左移
            supplies[findIndex] = supplies[findIndex] + supplies[findIndex + 1];
            for (int i = findIndex + 1; i < curLength - 1; i++) {
                supplies[i] = supplies[i + 1];
            }
            curLength--;
        }
        int[] answer = new int[target];
        for (int i = 0; i < target; i++) {
            answer[i] = supplies[i];
        }
        return answer;
    }
}