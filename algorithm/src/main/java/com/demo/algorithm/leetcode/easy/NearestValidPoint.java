package com.demo.algorithm.leetcode.easy;

/**
 * create on 2022/12/1
 * @author chenglong
 * description : 找到最近的有相同X或Y坐标的点
 *
 * 给你两个整数x和y，表示你在一个笛卡尔坐标系下的(x, y)处。同时，在同一个坐标系下给你一个数组points，其中points[i] = [ai, bi]表示在(ai, bi)处有一个点。当一个点与你所在的位置有相同的x坐标或者相同的y坐标时，我们称这个点是有效的。
 * 请返回距离你当前位置曼哈顿距离最近的有效点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标最小的一个。如果没有有效点，请返回-1。
 * 两个点(x1, y1)和(x2, y2)之间的曼哈顿距离为abs(x1 - x2) + abs(y1 - y2)。
 *
 * 示例 1：
 * 输入：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * 输出：2
 * 解释：所有点中，[3,1]，[2,4] 和 [4,4] 是有效点。有效点中，[2,4] 和 [4,4] 距离你当前位置的曼哈顿距离最小，都为 1 。[2,4] 的下标最小，所以返回 2 。
 *
 * 示例 2：
 * 输入：x = 3, y = 4, points = [[3,4]]
 * 输出：0
 * 提示：答案可以与你当前所在位置坐标相同。
 *
 * 示例 3：
 * 输入：x = 3, y = 4, points = [[2,3]]
 * 输出：-1
 * 解释：没有 有效点。
 *
 * 提示：
 * 1 <= points.length <= 10^4
 * points[i].length == 2
 * 1 <= x, y, ai, bi <= 10^4
 */
public class NearestValidPoint {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int max = Integer.MAX_VALUE;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                //有效点
                int space = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (space == 0) {
                    return i;
                }
                if (space < max) {
                    max = space;
                    index = i;
                }
            }
        }
        return index;
    }
}
