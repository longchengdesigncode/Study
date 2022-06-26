package com.demo.algorithm.leetcode.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chl on 2022/6/20.
 * description : Range模块
 *
 * Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为半开区间的范围并查询它们。
 * 半开区间[left, right)表示所有left <= x < right的实数 x 。
 *
 * 实现 RangeModule 类:
 * RangeModule()初始化数据结构的对象。
 * void addRange(int left, int right) 添加半开区间[left, right)，跟踪该区间中的每个实数。
 * 添加与当前跟踪的数字部分重叠的区间时，应当添加在区间[left, right)中尚未跟踪的任何数字到该区间中。
 * boolean queryRange(int left, int right)只有在当前正在跟踪区间[left, right)中的每一个实数时，才返回true，否则返回false 。
 * void removeRange(int left, int right)停止跟踪 半开区间[left, right)中当前正在跟踪的每个实数。
 *
 * 示例 1：
 * 输入
 * ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
 * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
 * 输出
 * [null, null, null, true, false, true]
 *
 * 解释
 * RangeModule rangeModule = new RangeModule();
 * rangeModule.addRange(10, 20);
 * rangeModule.removeRange(14, 16);
 * rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
 * rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 * rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 *
 * 提示：
 * 1 <= left < right <= 10^9
 * 在单个测试用例中，对addRange、 queryRange和 removeRange 的调用总数不超过10^4次
 */
public class RangeModule {

    private TreeMap<Integer, Integer> marks = new TreeMap<>();

    public RangeModule() {
        marks.clear();
    }

    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = marks.higherEntry(left);
        if (entry != marks.firstEntry()) {
            Map.Entry<Integer, Integer> start = entry != null ? marks.lowerEntry(entry.getKey()) : marks.lastEntry();
            if (start != null && start.getValue() >= right) {
                return;
            }
            if (start != null && start.getValue() >= left) {
                left = start.getKey();
                marks.remove(start.getKey());
            }
        }
        while (entry != null && entry.getKey() <= right) {
            right = Math.max(right, entry.getValue());
            marks.remove(entry.getKey());
            entry = marks.higherEntry(entry.getKey());
        }
        marks.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = marks.higherEntry(left);
        if (entry == marks.firstEntry()) {
            return false;
        }
        entry = entry != null ? marks.lowerEntry(entry.getKey()) : marks.lastEntry();
        return entry != null && right <= entry.getValue();
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = marks.higherEntry(left);
        if (entry != marks.firstEntry()) {
            Map.Entry<Integer, Integer> start = entry != null ? marks.lowerEntry(entry.getKey()) : marks.lastEntry();
            if (start != null && start.getValue() >= right) {
                int ri = start.getValue();
                if (start.getKey() == left) {
                    marks.remove(start.getKey());
                } else {
                    marks.put(start.getKey(), left);
                }
                if (right != ri) {
                    marks.put(right, ri);
                }
                return;
            } else if (start != null && start.getValue() > left) {
                if (start.getKey() == left) {
                    marks.remove(start.getKey());
                } else {
                    marks.put(start.getKey(), left);
                }
            }
        }
        while (entry != null && entry.getKey() < right) {
            if (entry.getValue() <= right) {
                marks.remove(entry.getKey());
                entry = marks.higherEntry(entry.getKey());
            } else {
                marks.put(right, entry.getValue());
                marks.remove(entry.getKey());
                break;
            }
        }
    }
}
