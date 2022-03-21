/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
// 保证了链表有序，则连续删除当前指针下一个相同的即可
var deleteDuplicates = function (head) {
  if (head == null) return null
  let p = head
  while (p.next) {
    if (p.val == p.next.val) {
      p.next = p.next.next
    } else {
      p = p.next
    }
  }
  return head
};