package algorithm.链表常见题.链表元素删除;

import dataStructure.链表.ListNode;

/**
 * 
 * [203. 移除链表元素](https://leetcode.cn/problems/remove-linked-list-elements/submissions/623091945/)
 * 
 */

public class Leetcode203 {
  

  // 解法一：判断当前节点是不是要移除的节点，所以需要两个指针
  // 操作移除当前节点，需要修改前一个节点的next指向
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

  // 解法二：利用虚拟头节点，判断操作当前节点的下一个节点
  // 删除的是下一个节点，所以只需要一个指针，指向当前节点就好了
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
