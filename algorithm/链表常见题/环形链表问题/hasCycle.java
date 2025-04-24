package algorithm.链表常见题.环形链表问题;

import dataStructure.链表.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/)
 */

public class hasCycle {
    // 解法一：使用set
    public boolean hasCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return true;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return false;
    }

    // 解法二：快慢指针
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
