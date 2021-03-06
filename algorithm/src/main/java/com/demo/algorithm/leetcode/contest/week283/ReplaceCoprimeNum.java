package com.demo.algorithm.leetcode.contest.week283;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chl on 2022/3/8.
 * description : 替换数组中的非互质数
 *
 * 给你一个整数数组nums。请你对数组执行下述操作：
 * 从nums中找出任意两个相邻的非互质数。
 * 如果不存在这样的数，终止这一过程。
 * 否则，删除这两个数，并替换为它们最小公倍数（Least Common Multiple，LCM）。
 * 只要还能找出两个相邻的非互质数就继续重复这一过程。
 * 返回修改后得到的最终数组。可以证明的是，以任意顺序替换相邻的非互质数都可以得到相同的结果。
 * 生成的测试用例可以保证最终数组中的值小于或者等于10^8 。
 * 两个数字x和y满足非互质数的条件是：GCD(x, y)>1 ，其中GCD(x, y)是x和y的最大公约数 。
 *
 * 示例 1 ：
 * 输入：nums = [6,4,3,2,7,6,2]
 * 输出：[12,7,6]
 * 解释：
 * - (6, 4) 是一组非互质数，且 LCM(6, 4) = 12 。得到 nums = [12,3,2,7,6,2] 。
 * - (12, 3) 是一组非互质数，且 LCM(12, 3) = 12 。得到 nums = [12,2,7,6,2] 。
 * - (12, 2) 是一组非互质数，且 LCM(12, 2) = 12 。得到 nums = [12,7,6,2] 。
 * - (6, 2) 是一组非互质数，且 LCM(6, 2) = 6 。得到 nums = [12,7,6] 。
 * 现在，nums 中不存在相邻的非互质数。
 * 因此，修改后得到的最终数组是 [12,7,6] 。
 * 注意，存在其他方法可以获得相同的最终数组。
 *
 * 示例 2 ：
 * 输入：nums = [2,2,1,1,3,3,3]
 * 输出：[2,1,1,3]
 * 解释：
 * - (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3,3] 。
 * - (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3] 。
 * - (2, 2) 是一组非互质数，且 LCM(2, 2) = 2 。得到 nums = [2,1,1,3] 。
 * 现在，nums 中不存在相邻的非互质数。
 * 因此，修改后得到的最终数组是 [2,1,1,3] 。
 * 注意，存在其他方法可以获得相同的最终数组。
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 生成的测试用例可以保证最终数组中的值 小于或者等于 10^8 。
 */
public class ReplaceCoprimeNum {

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        if (length == 1) {
            result.add(nums[0]);
            return result;
        }
        result.add(nums[0]);
        for (int i = 1; i < length; i++) {
            int cur = nums[i];
            while (result.size() > 0) {
                int pre = result.get(result.size() - 1);
                if (cur == 1 || pre == 1) {
                    break;
                } else {
                    int maxCommonFactor = getMaxCommonFactor(cur, pre);
                    //pre与cur互质
                    if (maxCommonFactor == 1) {
                        break;
                    } else {
                        cur = pre / maxCommonFactor * cur;
                        result.remove(result.size() - 1);
                    }
                }
            }
            result.add(cur);
        }
        return result;
    }

    private int getMaxCommonFactor(int a, int b) {
        return b != 0 ? getMaxCommonFactor(b, a % b) : a;
    }
}
