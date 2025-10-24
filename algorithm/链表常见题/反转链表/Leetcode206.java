package algorithm.链表常见题.反转链表;

import dataStructure.链表.ListNode;

import java.util.Stack;

public class Leetcode206 {
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
    // 带虚拟头节点的算法是：
    // 不断的将节点插入到虚拟头节点的后面
    // ⚠️这里有操作的顺序：否则会形成环形链表
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
    // 这个递归函数在内部持有了一个变量newHead
    // 执行栈从后到前执行链表的每一个节点，将当前节点插入到newHead尾部，返回newHead
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 通过栈来模拟这个递归
    public static ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stk = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stk.push(cur);
            cur = cur.next;
        }
        ListNode ans = new ListNode(-1);
        cur = ans;
        while (!stk.isEmpty()) {
           ListNode node = stk.pop();
           cur.next = node;
           node.next = null;
           cur = cur.next;
        }
        return ans.next;
    }


    // 测试代码
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode newHead = reverseList4(head);

        newHead.print();

    }

}
