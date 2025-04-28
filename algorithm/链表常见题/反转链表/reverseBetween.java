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
    // cur：指向待反转区域的第一个节点left（初始化的时候）
    // next：指向curr的下一个节点，循环过程中，curr变化以后next会变化

    /**
     *
     * 这个循环怎么悠起来，或者这个算法怎么理解
     *
     * pre指针永远指向待反转区间的前一个节点，因为就是不停的把后一个节点插到“头部”（pre的后面）来
     * cur循环开始的时候指向待反转的第一个节点，next指向cur的下一个节点
     * 循环开始：
     * 把next插到pre的下一个位置
     * 把cur插到next的位置
     * 也就是交换了cur和next的位置
     *
     * 这一次循环之后，cur正好在后一个位置，cur的next正好是下一个要处理的next
     *
     *
     */
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
            // pre.next不就是cur么，为什么不直接写成cur
            // 这是因为咱们是“头插”也就是插到pre的下一个位置，在交换cur和next的过程中，cur的位置变了
            // 就不是“头插”了
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

    // 206 反转链表
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
