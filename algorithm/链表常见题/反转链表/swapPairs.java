package algorithm.链表常见题.反转链表;

import dataStructure.链表.ListNode;

public class swapPairs {

    /**
     *
     * [24. 两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/description/)
     *
     */

    // 解法一：
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }


    // 解法二：递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
