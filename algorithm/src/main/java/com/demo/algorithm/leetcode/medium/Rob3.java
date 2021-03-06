package com.demo.algorithm.leetcode.medium;

import com.demo.algorithm.leetcode.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * create on 11/23/21
 * @author chenglong
 * description : 打家劫舍III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class Rob3 {

    //用于标记当前节点偷的最大金额
    Map<TreeNode, Integer> markRobs = new HashMap<>();
    //用于标记当前节点不偷的最大金额
    Map<TreeNode, Integer> markUnRobs = new HashMap<>();

    public int rob(TreeNode root) {
        //当前房屋只有两种状态,偷/不偷
        if (root == null) {
            return 0;
        }
        markRobs.clear();
        markUnRobs.clear();
        return Math.max(getUnRob(root), getRob(root) + root.val);
    }

    //root偷时子树的最大金额
    private int getRob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (markRobs.get(root) != null) {
            return markRobs.get(root);
        }
        int result = 0;
        if (root.left != null) {
            result += getUnRob(root.left);
        }
        if (root.right != null) {
            result += getUnRob(root.right);
        }
        markRobs.put(root, result);
        return result;
    }

    //root不偷时子树最大金额
    private int getUnRob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (markUnRobs.get(root) != null) {
            return markUnRobs.get(root);
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = Math.max(getUnRob(root.left), getRob(root.left) + root.left.val);
        }
        if (root.right != null) {
            right = Math.max(getUnRob(root.right), getRob(root.right) + root.right.val);
        }
        markUnRobs.put(root, left + right);
        return left + right;
    }
}
