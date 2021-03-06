package com.demo.algorithm.leetcode.offer;

import com.demo.algorithm.leetcode.entity.ListNode;

/**
 * Created by chl on 2022/3/27.
 * description : 剑指Offer22. 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class FindKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        if (k == 1) {
            //此时尾结点
            while (head.next != null) {
                head = head.next;
            }
            return head;
        }
        ListNode fast = head;
        while (fast != null && k > 1) {
            fast = fast.next;
            k--;
        }
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }
}
