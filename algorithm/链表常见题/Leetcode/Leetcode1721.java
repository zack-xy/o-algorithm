package algorithm.链表常见题.Leetcode;

import dataStructure.链表.ListNode;

public class Leetcode1721 {
    /**
     * [1721. 交换链表中的节点](https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/description/?envType=problem-list-v2&envId=linked-list)
     *
     */
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int n = 0;
        ListNode fastNode;
        while (n < k - 1) {
            fast = fast.next;
            n++;
        }
        fastNode = fast;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        int temp = fastNode.val;
        fastNode.val = slow.val;
        slow.val = temp;
        return head;
    }

    // 测试代码
    public static void main(String[] args) {
        ListNode head = swapNodes(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }
}
