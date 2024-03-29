package com.demo.algorithm.leetcode.medium;

import com.demo.algorithm.leetcode.entity.ListNode;

/**
 * Created by chl on 2021/9/19.
 * description : 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class AddTwoNum {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode p = result;
        boolean isAdd = false;
        int a;
        int b;
        int sum;
        while (l1 != null || l2 != null) {
            a = 0;
            b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            sum = a + b + (isAdd ? 1 : 0);
            if (sum > 9) {
                isAdd = true;
                sum %= 10;
            } else {
                isAdd = false;
            }
            p.next = new ListNode(sum);
            p = p.next;
        }
        if (isAdd) {
            p.next = new ListNode(1);
        }
        return result.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode();
        ListNode p = root;
        int add = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            if (sum >= 10) {
                sum -= 10;
                add = 1;
            } else {
                add = 0;
            }
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                int sum = l2.val + add;
                if (sum >= 10) {
                    sum -= 10;
                    add = 1;
                } else {
                    add = 0;
                }
                p.next = new ListNode(sum);
                p = p.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                int sum = l1.val + add;
                if (sum >= 10) {
                    sum -= 10;
                    add = 1;
                } else {
                    add = 0;
                }
                p.next = new ListNode(sum);
                p = p.next;
                l1 = l1.next;
            }
        }
        if (add > 0) {
            p.next = new ListNode(add);
        }
        return root.next;
    }
}
