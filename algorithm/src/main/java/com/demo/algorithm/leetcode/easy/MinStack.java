package com.demo.algorithm.leetcode.easy;

import com.demo.algorithm.leetcode.entity.MinListNode;

/**
 * create by chenglong on 9/13/21
 * description : 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 使用链表+数据结果
 *
 */
public class MinStack {

    private MinListNode top = null;
    private int min;

    public MinStack() {

    }

    public void push(int val) {
        MinListNode node = new MinListNode(val);
        if (top == null) {
            min = val;
            node.min = min;
            top = node;
        } else {
            if (val < min) {
                min = val;
            }
            node.min = min;
            node.next = top;
            top = node;
        }
    }

    public void pop() {
        if (top != null) {
            top = top.next;
            if (top != null) {
                min = top.min;
            }
        }
    }

    public int top() {
        if (top != null) {
            return top.value;
        }
        return 0;
    }

    public int getMin() {
        if (top != null) {
            return top.min;
        }
        return 0;
    }

}
