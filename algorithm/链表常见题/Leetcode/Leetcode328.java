package algorithm.链表常见题.Leetcode;

import dataStructure.链表.ListNode;

public class Leetcode328 {
    /**
     *
     * [328. 奇偶链表](https://leetcode.cn/problems/odd-even-linked-list/description/?envType=problem-list-v2&envId=linked-list)
     * 要求O(1) 的额外空间复杂度和 O(n) 的时间复杂度
     */

    // 解法一：我的解法还是直给，一个奇数指针，一个偶数指针，一点点拆开链表
    // OK 官方题解和我的题解是一样的
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
