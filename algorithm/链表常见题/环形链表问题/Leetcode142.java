package algorithm.链表常见题.环形链表问题;

import dataStructure.链表.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * [142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/description/)
 *
 */
public class Leetcode142 {

    // 解法一：使用set
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode pos = head;
        Set<ListNode> set = new HashSet<ListNode>();
        while (pos != null) {
            if (set.contains(pos)) {
                return pos;
            } else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    // 解法二：双指针
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
