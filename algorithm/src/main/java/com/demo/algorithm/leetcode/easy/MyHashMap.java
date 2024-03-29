package com.demo.algorithm.leetcode.easy;

/**
 * create on 2023/12/1
 * @author chenglong
 * description : 设计哈希映射
 *
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现MyHashMap类：
 * MyHashMap()用空映射初始化对象
 * void put(int key, int value)向HashMap插入一个键值对(key, value)。如果key已经存在于映射中，则更新其对应的值value。
 * int get(int key) 返回特定的key所映射的value；如果映射中不包含key的映射，返回-1。
 * void remove(key) 如果映射中存在key的映射，则移除key和它所对应的value。
 *
 * 示例：
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *
 * 提示：
 *
 * 0 <= key, value <= 10^6
 * 最多调用10^4次put、get和remove方法
 */
public class MyHashMap {

    private final boolean[] keys;
    private final int[] values;

    public MyHashMap() {
        keys = new boolean[1000001];
        values = new int[1000001];
    }

    public void put(int key, int value) {
        keys[key] = true;
        values[key] = value;
    }

    public int get(int key) {
        if (keys[key]) {
            return values[key];
        }
        return -1;
    }

    public void remove(int key) {
        keys[key] = false;
    }
}
