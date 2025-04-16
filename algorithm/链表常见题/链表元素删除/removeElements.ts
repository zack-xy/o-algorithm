import ListNode from "dataStructure/链表/ListNode"

function removeElements2(head: ListNode, val: number): ListNode {
    let dummyHead: ListNode = new ListNode(0)
    dummyHead.next = head
    let pre: ListNode = dummyHead
    let cur: ListNode = dummyHead.next
    while (cur != null) {
      if (cur.val == val) {
        pre.next = cur.next
      }
      cur = cur.next!
      pre = pre.next!
    }
    return dummyHead.next
}

let linkedlist = new ListNode(1, 
  new ListNode(2, 
    new ListNode(6, 
      new ListNode(3, 
        new ListNode(4, 
          new ListNode(5, 
            new ListNode(6)))))))



removeElements2(linkedlist, 6)

console.log("检查一下ts是不是运行了")
