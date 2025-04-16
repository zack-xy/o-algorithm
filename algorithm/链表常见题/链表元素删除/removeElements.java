package algorithm.链表常见题.链表元素删除;

import dataStructure.链表.ListNode;

public class removeElements {
  

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode pre = dummyHead;
    ListNode cur = dummyHead.next;
    while (cur != null) {
      if (cur.val == val) {
        pre.next = cur.next;
      }
      cur = cur.next;
      pre = pre.next;
    }
    return dummyHead.next;
  }
}
