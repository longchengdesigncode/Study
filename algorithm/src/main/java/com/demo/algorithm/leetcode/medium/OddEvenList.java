package com.demo.algorithm.leetcode.medium;

import com.demo.algorithm.leetcode.entity.ListNode;


/**
 * create on 2023/12/25
 * @author chenglong
 * description : 奇偶链表
 *
 * 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是奇数，第二个节点的索引为偶数，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
 *
 * 示例 1:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 *
 * 示例 2:
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 *
 * 提示:
 * n ==  链表中的节点数
 * 0 <= n <= 10^4
 * -106 <= Node.val <= 10^6
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //奇数起点
        ListNode p = head;
        //偶数起点
        ListNode head2 = p.next;
        ListNode q = head2;
        while (q.next != null) {
            //此时奇数位肯定有值
            p.next = p.next.next;
            if (q.next.next != null) {
                q.next = q.next.next;
                q = q.next;
            } else {
                q.next = null;
            }
            p = p.next;
        }
        p.next = head2;
        return head;
    }
}