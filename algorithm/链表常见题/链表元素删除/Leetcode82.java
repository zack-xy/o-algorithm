package algorithm.链表常见题.链表元素删除;

import dataStructure.链表.ListNode;

/**
 * [82. 删除排序链表中的重复元素 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/)
 *
 *  🤔1: 这个算法的主旨思想是：判断虚拟头节点后2个节点(cur.next,cur.next.next)是不是连续相同(cur.next.val == cur.next.next.val)
 *  如果连续相同，则循环删除，所以删除的节点是cur.next节点（所以里面的判断实际cur.next.val），操作的是cur的next
 *  当cur的后两个节点也就是cur.next.next为null的时候，已经不可能有重复节点了，所以可以跳出循环了
 *
 *  🤔2:会不会出现cur.val = cur.next.val = cur.next.next.val的情况？
 *
 *  答：不会，因为前置操作已经删除了重复的节点
 *
 */

public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        // 🤔1：这里为什么判断cur.next.next为空就可以跳出循环了？
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
