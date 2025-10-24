package algorithm.链表常见题.双指针思想;

import dataStructure.链表.ListNode;

import java.util.ArrayList;

/**
 * 
 * 
    [返回倒数第 k 个节点](https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/description/)

    ##### 快慢指针的解法：

    fast指针遍历到k+1个节点，slow指向第一个节点，此时二者间隔k个节点，之后同步向后走，当fast走到最后的时候，slow的位置就是倒数第K个节点

 * 
 */

public class Leetcode0202 {
    public int kthToLast(ListNode head, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.get(list.size() - k);
    }

    // 返回倒数k节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
