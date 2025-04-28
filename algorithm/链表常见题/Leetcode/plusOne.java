package algorithm.链表常见题.Leetcode;

import dataStructure.链表.ListNode;

import java.util.Stack;

public class plusOne {

    /**
     *
     * [369.给单链表加一](https://leetcode.cn/problems/plus-one-linked-list/description/)
     *
     *  用非空单链表来表示一个非负整数，将这个整数加一
     *  你可以假设这个整数除了0本身，没有任何前导的0
     *  这个整数的各个数位按照高位在链表头部，低位在链表尾部的顺序排列
     *
     */


    // 解法一：使用栈
    // 这里用了一个虚拟头节点，头节点的位置固定
    // 弹栈，往头节点的下一个位置塞链表节点
    public static ListNode plusOne(ListNode head) {
        Stack<Integer> st = new Stack<>();
        while (head != null) {
            st.push(head.val);
            head = head.next;
        }
        int carry = 0; // 表示进位
        ListNode dummy = new ListNode(0);
        int adder = 1;  // 表示要加1
        while (!st.empty() || carry > 0) {
            int digit = st.empty() ? 0 : st.pop();
            int sum = digit + adder + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode cur = new ListNode(sum);
            cur.next = dummy.next;
            dummy.next = cur;
            adder = 0;   // 这里置为0，防止每一位都加1
        }
        return dummy.next;
    }

    // 解法二：反转链表
    public static ListNode plusOne2(ListNode head) {
        // 反转链表
        head = reverse(head);

        ListNode current = head;
        int carry = 1;

        while (current != null) {
            int sum = current.val + carry;
            current.val = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                break;
            }
            if (current.next == null && carry != 0) {
                current.next = new ListNode(carry);
                break;
            }
            current = current.next;
        }

        // 反转链表得到最终结果
        head = reverse(head);

        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // 测试代码
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode plusOne = plusOne2(head);
        plusOne.print();
        System.out.println(5/10);
    }
}
