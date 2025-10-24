package algorithm.链表常见题.链表操作;

import dataStructure.链表.ListNode;

public class Leetcode2 {

    // TODO 链表
    // TODO 递归
    // https://leetcode.cn/problems/add-two-numbers/?envType=problem-list-v2&envId=linked-list

    // 1.迭代
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ret = new ListNode(-1);
        ListNode p1 = l1,p2 = l2,p3=ret;
        while (p1 != null || p2 != null) {
            int p1Val = p1 == null ? 0 : p1.val;
            int p2Val = p2 == null ? 0 : p2.val;
            int result = p1Val + p2Val + carry;
            p3.next = new ListNode(result % 10);
            carry = result >= 10 ? 1 : 0;
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
            p3 = p3.next;
        }
        // 这里注意，链表+走完了，进位可能还有值，需要加上
        if (carry > 0) p3.next = new ListNode(carry);
        return ret.next;
    }

    // 2. 递归
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwo(l1, l2, 0);
    }

    // l1和l2为当前遍历的节点，carry为进位
    private ListNode addTwo(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) return carry != 0  ? new ListNode(carry) : null;
        // 如果l1是空的，此时l2一定不空
        if (l1 == null) {
            l1 = l2;
            l2 = null; // 交换l1和l2，保证l1非空，简化代码
        }
        int sum = carry + l1.val + (l2 != null ? l2.val : 0);
        l1.val = sum % 10;
        l1.next = addTwo(l1.next, (l2!=null ? l2.next : null), sum / 10);
        return l1;
    }

}
