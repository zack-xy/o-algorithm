import ListNode from "dataStructure/链表/ListNode";

function removeElements(head: ListNode, val: number): ListNode {
    let dummyHead: ListNode = new ListNode(0)
    dummyHead.next = head
    let pre: ListNode = dummyHead
    let cur: ListNode = dummyHead.next
    while (cur != null) {
      if (cur.val == val) {
        pre.next = cur.next
      } else {
        pre = pre.next!
      }
      cur = cur.next!
    }
    return dummyHead.next
}
