package com.demo.algorithm.leetcode.contest.week303;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * create on 2022/8/1
 * @author chenglong
 * description : 设计食物评分系统
 *
 * 设计一个支持下述操作的食物评分系统：
 * 修改系统中列出的某种食物的评分。
 * 返回系统中某一类烹饪方式下评分最高的食物。
 *
 * 实现 FoodRatings 类：
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
 * foods[i] 是第 i 种食物的名字。
 * cuisines[i] 是第 i 种食物的烹饪方式。
 * ratings[i] 是第 i 种食物的最初评分。
 * void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
 * String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
 * 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，或者在满足x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
 *
 * 示例：
 * 输入
 * ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
 * [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
 * 输出
 * [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
 *
 * 解释
 * FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
 * foodRatings.highestRated("korean"); // 返回 "kimchi"
 *                                     // "kimchi" 是分数最高的韩式料理，评分为 9 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 *                                       // "ramen" 是分数最高的日式料理，评分为 14 。
 * foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "sushi"
 *                                       // "sushi" 是分数最高的日式料理，评分为 16 。
 * foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 *                                       // "sushi" 和 "ramen" 的评分都是 16 。
 *                                       // 但是，"ramen" 的字典序比 "sushi" 更小。
 *
 * 提示：
 * 1 <= n <= 2 * 10^4
 * n == foods.length == cuisines.length == ratings.length
 * 1 <= foods[i].length, cuisines[i].length <= 10
 * foods[i]、cuisines[i] 由小写英文字母组成
 * 1 <= ratings[i] <= 10^8
 * foods中的所有字符串互不相同
 * 在对changeRating 的所有调用中，food 是系统中食物的名字。
 * 在对highestRated 的所有调用中，cuisine 是系统中至少一种食物的烹饪方式。
 * 最多调用changeRating和highestRated总计 2 * 10^4 次
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class FoodRatings {

    //记录食物与烹饪方式的对照表
    private final Map<String, String> foodDates = new HashMap<>();
    //记录烹饪方式与食物信息的对照表
    private final Map<String, PriorityQueue<String[]>> dates = new HashMap<>();
    //记录食物与价格的关系
    private final Map<String, Integer> marks = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodDates.clear();
        dates.clear();
        marks.clear();
        int length = foods.length;
        for (int i = 0; i < length; i++) {
            foodDates.put(foods[i], cuisines[i]);
            marks.put(foods[i], ratings[i]);
            if (dates.containsKey(cuisines[i])) {
                dates.get(cuisines[i]).offer(new String[]{"" + ratings[i], foods[i]});
            } else {
                PriorityQueue<String[]> items = new PriorityQueue<>((o1, o2) -> {
                    int a = Integer.parseInt(o1[0]);
                    int b = Integer.parseInt(o2[0]);
                    if (a == b) {
                        return o1[1].compareTo(o2[1]);
                    }
                    return b - a;
                });
                items.offer(new String[]{"" + ratings[i], foods[i]});
                dates.put(cuisines[i], items);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        dates.get(foodDates.get(food)).offer(new String[]{"" + newRating, food});
        marks.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<String[]> queue = dates.get(cuisine);
        while (!queue.isEmpty()) {
            String[] peek = queue.peek();
            int price = Integer.parseInt(peek[0]);
            if (marks.get(peek[1]) == price) {
                return peek[1];
            } else {
                queue.poll();
            }
        }
        return "";
    }
}
