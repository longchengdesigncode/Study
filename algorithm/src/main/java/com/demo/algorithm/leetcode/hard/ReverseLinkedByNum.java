package com.demo.algorithm.leetcode.hard;

import com.demo.algorithm.leetcode.entity.ListNode;

/**
 * create on 10/8/21
 * @author chenglong
 * description : K个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *  
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 示例 3：
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 *
 * 示例 4：
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 提示：
 *
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 */
public class ReverseLinkedByNum {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        //1，获取链表节点数
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        //2，反转的次数
        int count = n / k;
        p = head;
        ListNode result = new ListNode();
        ListNode q = result;
        //3，遍历翻转
        while (count > 0) {
            //4，执行翻转
            int reverseCount = k;
            ListNode reverseNode = null;
            ListNode pre;
            while (reverseCount > 0) {
                pre = reverseNode;
                reverseNode = p;
                p = p.next;
                reverseNode.next = pre;
                reverseCount--;
            }
            while (reverseNode != null) {
                q.next = reverseNode;
                reverseNode = reverseNode.next;
                q = q.next;
            }
            count--;
        }
        q.next = p;
        return result.next;
    }
}

