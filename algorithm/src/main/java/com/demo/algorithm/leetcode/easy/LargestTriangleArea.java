package com.demo.algorithm.leetcode.easy;

/**
 * Created by chl on 2022/5/15.
 * description : 最大三角形面积
 *
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 *
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 *
 * 注意:
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 * -50 <= points[i][j] <= 50.
 * 结果误差值在10^-6以内都认为是正确答案。
 */
public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        int length = points.length;
        double max = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int l = j + 1; l < length; l++) {
                    //三个点分别是：
                    int[] a = points[i];
                    int[] b = points[j];
                    int[] c = points[l];
                    double area = 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }
}
