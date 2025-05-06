import ListNode from "dataStructure/链表/ListNode";


function getKthFromEnd(head: ListNode, k: number): ListNode {
  let fast: ListNode = head;
  let slow: ListNode = head;
  while (fast !== null && k > 0) {
    fast = fast.next!;
    k--;
  }
  while (fast !== null) {
    fast = fast.next!;
    slow = slow.next!;
  }
  return slow;
}
