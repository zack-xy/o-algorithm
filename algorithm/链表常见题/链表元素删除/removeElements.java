package algorithm.链表常见题.链表元素删除;

import dataStructure.链表.ListNode;

/**
 * 
 * [203. 移除链表元素](https://leetcode.cn/problems/remove-linked-list-elements/submissions/623091945/)
 * 
 * 解法一：我自己写的，利用2个指针，前pre，当前cur，当前的值等于目标值，移动pre的next指针，否则移动pre指针
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
}
