import ListNode from "dataStructure/链表/ListNode";

function mergeInBetween(list1: ListNode, a: number, b: number, list2: ListNode): ListNode {
  let pre1: ListNode = list1, post1: ListNode = list1, post2: ListNode = list2;
  let i = 0, j = 0;
  while (pre1 !== null && post1 !== null && j < b) {
    if (i !== a - 1) {
      pre1 = pre1.next!;
      i++;
    }
    if (j !== b) {
      post1 = post1.next!;
      j++;
    }
  }
  post1 = post1.next!;
  while (post2.next !== null) {
    post2 = post2.next;
  }
  pre1.next = list2;
  post2.next = post1;
  return list1;
}
