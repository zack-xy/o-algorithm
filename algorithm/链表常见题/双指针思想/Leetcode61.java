package algorithm.链表常见题.双指针思想;

import dataStructure.链表.ListNode;

/**
 * [61. 旋转链表](https://leetcode.cn/problems/rotate-list/description/)
 * 
 * ⚠️这里的快慢指针，注意循环的条件，一个fast走到null，一个是fast的next走到null
 * 
 */

public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;

        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        // 取模是为了防止k大于len的情况
        if(k % len == 0) return temp;
        while ((k % len) > 0) {
            k--;
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        fast.next = temp;
        return res;
    }
}
