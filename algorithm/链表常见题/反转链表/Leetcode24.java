package algorithm.链表常见题.反转链表;

import dataStructure.链表.ListNode;

public class Leetcode24 {

    /**
     *
     * [24. 两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/description/)
     *
     */

    // 解法一：直接解决
    // 初始化虚拟头节点，临时指针temp指向虚拟头节点
    // 交换temp.next(node1)和temp.next.next(node2)的位置
    // 每次交换后，temp指向node1
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
    // 递归终止条件：如果链表为空或者只有一个节点，无需交换，直接返回原链表
    // 新的头节点是当前头节点的下一个节点
    // 递归调用 swapPairs2 函数，处理从 newHead.next 开始的剩余链表
    // 让新的头节点 newHead 的 next 指针指向当前的 head 节点，完成当前相邻节点的交换
    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null ) return head;
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode newHead = swapPairs2(head);

        newHead.print();
    }

}
