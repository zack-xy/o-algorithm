package algorithm.链表常见题.双指针思想;

import dataStructure.链表.ListNode;

/**
 * 
 * [876. 链表的中间结点](https://leetcode.cn/problems/middle-of-the-linked-list/description/)
 * 
 * ##### 解法一： 

    快慢指针，慢指针一次跳1步，快指针一次跳2步，
    快指针到头，慢指针就在中间（如果有2个中间，慢指针在第2个中间）
 * 
 * 
 */

public class middleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
