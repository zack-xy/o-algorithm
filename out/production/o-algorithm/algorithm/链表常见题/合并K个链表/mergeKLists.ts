import ListNode from "dataStructure/链表/ListNode";
import mergeTwoLists from "../合并2个有序链表/mergeTwoLists";

function mergeKLists(lists: ListNode[]): ListNode | null {
  let res: ListNode|null = null;
  for (const list of lists) {
    res = mergeTwoLists(res, list);
  }
  return res;
}
