package algorithm.链表常见题.双指针思想;

import dataStructure.链表.ListNode;

import java.util.ArrayList;

public class kthToLast {
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
