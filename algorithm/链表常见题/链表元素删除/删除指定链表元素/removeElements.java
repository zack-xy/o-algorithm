package algorithm.链表常见题.链表元素删除.删除指定链表元素;

import dataStructure.链表.ListNode;

/**
 * 
 * [203. 移除链表元素](https://leetcode.cn/problems/remove-linked-list-elements/submissions/623091945/)
 * 
 * 解法一：我自己写的，利用2个指针，前pre，当前cur，当前的值等于目标值，移动pre的next指针，否则移动pre指针
 * 
 * 解法二：优化1，实际只需要1个指针就好了
 * 
 */

public class removeElements {
  

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode pre = dummyHead;
    ListNode cur = dummyHead.next;
    while (cur != null) {
      if (cur.val == val) {
        pre.next = cur.next;
      } else {
        pre = pre.next;
      }
      cur = cur.next;
    }
    return dummyHead.next;
  }

  public ListNode removeElements2(ListNode head, int val) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode cur = dummyHead;
    while (cur.next != null) {
      if (cur.next.val == val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return dummyHead.next;
  }
}
