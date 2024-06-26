package com.demo.algorithm.leetcode.medium.tree;


/**
 * create on 2024/4/13
 * @author chenglong
 * description : 找到冠军II
 *
 * 一场比赛中共有n支队伍，按从0到n-1编号。每支队伍也是有向无环图（DAG）上的一个节点。
 * 给你一个整数n和一个下标从0开始、长度为m的二维整数数组edges表示这个有向无环图，其中edges[i] = [ui,vi]表示图中存在一条从ui队到vi队的有向边。
 * 从a队到b队的有向边意味着a队比b队强，也就是b队比a队弱。
 * 在这场比赛中，如果不存在某支强于a队的队伍，则认为a队将会是冠军。
 * 如果这场比赛存在 唯一一个冠军，则返回将会成为冠军的队伍。否则，返回-1。
 * 注意
 * 环是形如a1, a2, ..., an, an+1 的一个序列，且满足：节点 a1 与节点 an+1 是同一个节点；节点 a1, a2, ..., an 互不相同；对于范围 [1, n] 中的每个 i ，均存在一条从节点 ai 到节点 ai+1 的有向边。
 * 有向无环图 是不存在任何环的有向图。
 *
 * 示例 1：
 * 输入：n = 3, edges = [[0,1],[1,2]]
 * 输出：0
 * 解释：1 队比 0 队弱。2 队比 1 队弱。所以冠军是 0 队。
 *
 * 示例 2：
 * 输入：n = 4, edges = [[0,2],[1,3],[1,2]]
 * 输出：-1
 * 解释：2 队比 0 队和 1 队弱。3 队比 1 队弱。但是 1 队和 0 队之间不存在强弱对比。所以答案是 -1 。
 *
 * 提示：
 * 1 <= n <= 100
 * m == edges.length
 * 0 <= m <= n * (n - 1) / 2
 * edges[i].length == 2
 * 0 <= edge[i][j] <= n - 1
 * edges[i][0] != edges[i][1]
 * 生成的输入满足：如果 a 队比 b 队强，就不存在 b 队比 a 队强
 * 生成的输入满足：如果 a 队比 b 队强，b 队比 c 队强，那么 a 队比 c 队强
 */
public class FindChampion2 {

    public int findChampion(int n, int[][] edges) {
        int[] counts = new int[n];
        for (int i = 0; i < edges.length; i++) {
            counts[edges[i][1]]++;
        }
        int findIndex = -1;
        for (int i = 0; i < n; i++) {
            if (counts[i] == 0) {
                if (findIndex == -1) {
                    findIndex = i;
                } else {
                    return -1;
                }
            }
        }
        return findIndex;
    }
}
