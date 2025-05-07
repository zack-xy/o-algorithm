import ListNode from "dataStructure/链表/ListNode";

function middleNode(head: ListNode): ListNode | null {
  let slow: ListNode | null = head, fast: ListNode | null = head;
  while(fast !== null && fast.next !== null) {
    slow = slow!.next;
    fast = fast.next.next;
  }
  return slow;
}
