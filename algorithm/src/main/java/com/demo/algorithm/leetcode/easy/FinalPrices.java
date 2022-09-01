package com.demo.algorithm.leetcode.easy;

/**
 * create on 2022/9/1
 * @author chenglong
 * description : 商品折扣后的最终价格
 *
 * 给你一个数组prices，其中prices[i]是商店里第i件商品的价格。
 * 商店里正在进行促销活动，如果你要买第i件商品，那么你可以得到与prices[j]相等的折扣，其中j是满足j>i且prices[j]<=prices[i]的最小下标，如果没有满足条件的j，你将没有任何折扣。
 * 请你返回一个数组，数组中第i个元素是折扣后你购买商品i最终需要支付的价格。
 *
 * 示例 1：
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 *
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：[1,2,3,4,5]
 * 解释：在这个例子中，所有商品都没有折扣。
 *
 * 示例 3：
 * 输入：prices = [10,1,1,6]
 * 输出：[9,0,1,6]
 *
 * 提示：
 * 1 <= prices.length <= 500
 * 1 <= prices[i] <= 10^3
 */
public class FinalPrices {

    public int[] finalPrices(int[] prices) {
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            int discount = 0;
            int start = i + 1;
            while (start < length) {
                if (prices[i] >= prices[start]) {
                    discount = prices[start];
                    break;
                } else {
                    start++;
                }
            }
            prices[i] -= discount;
        }
        return prices;
    }
}
