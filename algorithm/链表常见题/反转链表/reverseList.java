package algorithm.链表常见题.反转链表;

import dataStructure.链表.ListNode;

public class reverseList {
    /**
     *
     * [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/description/)
     *
     */

    // 解法一：不带虚拟头节点的反转（重要‼️）
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 解法二：带虚拟头节点的反转
    public ListNode reverseList2(ListNode head) {
        ListNode ans = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = ans.next;
            ans.next = cur;
            cur = next;
        }
        return ans.next;
    }

    // 解法三：通过递归
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 测试代码
    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));

        ListNode ans = reverseList3(head);
        System.out.println(ans.val);
        System.out.println(head.val);

    }

}
