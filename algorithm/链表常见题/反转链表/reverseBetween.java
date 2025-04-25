package algorithm.链表常见题.反转链表;

import dataStructure.链表.ListNode;

public class reverseBetween {
    /**
     *
     * [92. 反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/description/)
     *
     */

    // 头插法
    // 一共有3个指针
    // pre：永远指向待反转区域的第一个节点left的前一个节点，在循环中不变
    // cur：指向待反转区域的第一个节点left
    // next：指向curr的下一个节点，循环过程中，curr变化以后next会变化
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0;i < left - 1;i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0;i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    // 穿针引线法: 也就是反转left -> right的链表之后再接起来
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在for循环里，语义清晰
        for (int i = 0;i < left - 1; i++) {
            pre = pre.next;
        }
        // 第 2 步：从 pre 再走 right - left + 1步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 第 3 步：切出一个子链表
        ListNode leftNode = pre.next;
        ListNode succ = rightNode.next;
        // 思考一下，如果这里不设置next为null会怎么样
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);
        // 第 5 步：接回原来的链表中
        // 想一下，这里为什么可以用rightNode
        pre.next = rightNode;
        leftNode.next = succ;
        return dummyNode.next;
    }


    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
