import ListNode from "dataStructure/链表/ListNode";

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
  let preHead: ListNode = new ListNode(-1);
  let pre: ListNode = preHead;
  while (list1 !== null && list2 !== null) {
    if (list1.val <= list2.val) {
      pre.next = list1;
      list1 = list1.next;
    } else {
      pre.next = list2;
      list2 = list2.next;
    }
    pre = pre.next;
  }
  pre.next = list1 === null ? list2 : list1;
  return preHead.next;
}

export default mergeTwoLists;


