package algorithm.链表常见题.环形链表问题;

import dataStructure.链表.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * [142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/description/)
 *
 */
public class detectCycle {

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
}
