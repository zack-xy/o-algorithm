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
}
