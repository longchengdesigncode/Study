package com.demo.algorithm.algo;


import com.chl.common.utils.LogUtil;


/**
 * Created by w on 2021/4/24.
 *
 * 链表
 *
 */
public class LinkedList {

    private static final String TAG = "LinkedList";

    private Node head = null;

    /**
     * 添加节点,便于构建数据
     * @param data :
     */
    public void add(String data) {
        Node node = new Node(data, null);
        add(node);
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
    }

    public Node getHead() {
        return head;
    }

    /**
     * 删除节点 (默认节点data不为null)
     * @param data :
     */
    public void deleteByValue(String data) {
        if (head == null) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node pre = head;
        Node current = head.next;
        while (current != null) {
            if (current.data.equals(data)) {
                pre.next = current.next;
                break;
            } else {
                pre = current;
                current = current.next;
            }
        }
    }

    /**
     *  使用单链表判断字符串是否是回文字符串
     */

    public boolean isReverseStr() {
        //链表为空,返回false
        if (head == null) {
            return false;
        }
        Node p = head;
        //链表只有一个元素,返回true
        if (p.next == null) {
            return true;
        }
        //直接反转链表,会造成原链表有变化,需要先存储一份
        Node tem = null;
        while (p != null) {
            if (tem == null) {
                tem = new Node(p.data, null);
            } else {
                tem.next = new Node(p.data, null);
            }
            p = p.next;
        }
        Node q = reverse();
        while (tem.next != null) {
            if (!tem.data.equals(q.data)) {
                return false;
            }
            tem = tem.next;
            q = q.next;
        }
        return true;
    }

    /**
     * @return : 单链表反转
     */
    public Node reverse() {
        if (head == null) {
            return null;
        }
        Node p = head;
        Node result = null;
        while(p != null) {
            Node tem = result;
            result = p;
            p = p.next;
            result.next = tem;
        }
        return result;
    }

    /**
     * @return : 链表是否为环形
     */
    public boolean isRing() {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 两个链表存入整数
     * @param head1 :
     * @param head2 :
     * @return : 两个有序的链表合并
     */
    public static Node mergeNode(Node head1, Node head2) {
        //优化方案
        Node solider = new Node("", null);
        Node p = solider;
        while (head1 != null && head2 != null) {
            if (Integer.parseInt(head1.data) < Integer.parseInt(head2.data)) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 != null) {
            p.next = head1;
        }
        if (head2 != null) {
            p.next = head2;
        }
        return solider.next;
        /*if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node result = null;
        Node p = result;
        while (head1 != null && head2 != null) {
            if (Integer.parseInt(head1.data) < Integer.parseInt(head2.data)) {
                if (result == null) {
                    result = head1;
                    p = result;
                } else {
                    p.next = head1;
                    p = p.next;
                }
                head1 = head1.next;
            } else {
                if (result == null) {
                    result = head2;
                    p = result;
                } else {
                    p.next = head2;
                    p = p.next;
                }
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            p.next = head2;
        }
        if (head2 == null) {
            p.next = head1;
        }
        return result;*/
    }

    /**
     * 删除链表倒数第k个结点
     * @param k : 倒数节点的序号
     */
    public void deleteNode(int k) {
        if (head == null) {
            return;
        }
        Node fast = head;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return;
        }
        Node p = head;
        Node pre = head;
        while (fast.next != null) {
            fast = fast.next;
            pre = p;
            p = p.next;
        }
        if (pre == p) {
            head = head.next;
        } else {
            pre.next = p.next;
        }
    }

    /**
     * @return : 求链表的中间结点
     */
    public Node quaryCenter() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    /**
     * 打印单链表的数据
     */
    public void printAll() {
        printAll(head);
    }
    
    public void printAll(Node head) {
        if (head == null) {
            LogUtil.e(TAG, "printAll: 链表为空");
            return;
        }
        int count = 0;
        Node p = head;
        while (p != null) {
            LogUtil.e(TAG, "printAll: data = " + p.data);
            p = p.next;
            count++;
        }
        LogUtil.e(TAG, "printAll: count = " + count);

    }



}


