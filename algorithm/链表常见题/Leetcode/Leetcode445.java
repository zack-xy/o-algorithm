package algorithm.链表常见题.Leetcode;

import dataStructure.链表.ListNode;

import java.util.Stack;

public class Leetcode445 {

    /**
     *
     * [445. 两数相加 II](https://leetcode.cn/problems/add-two-numbers-ii/)
     *
     */


    // 解法一：使用栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> st1 = new Stack<ListNode>();
        Stack<ListNode> st2 = new Stack<ListNode>();
        while (l1 != null) {
            st1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            st2.push(l2);
            l2 = l2.next;
        }
        ListNode newHead = new ListNode(-1);
        int carry = 0;
        // 这里设置carry!=0，是因为当st1,st2都遍历完时，如果carry=0,就不需要进入循环了
        while (!st1.empty() || !st2.empty() || carry != 0) {
            ListNode a = new ListNode(0);
            ListNode b = new ListNode(0);
            if (!st1.empty()) {
                a = st1.pop();
            }
            if (!st2.empty()) {
                b = st2.pop();
            }
            // 每次的和应该是对应位相加再加上进位
            int get_sum = a.val + b.val + carry;
            // 对累加的结果取余
            int ans = get_sum % 10;
            // 如果大于10，就进位
            carry = get_sum / 10;
            ListNode cur = new ListNode(ans);
            cur.next = newHead.next;
            newHead.next = cur;
        }
        return newHead.next;
    }

    // 解法二：反转链表
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = carry;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(head.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
