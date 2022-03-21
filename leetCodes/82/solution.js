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
// 解法：需要借助虚拟头节点，类型83
var deleteDuplicates = function (head) {
  let vHead = new ListNode(0, head)
  let p = vHead
  let q = null
  while (p.next) {
    if (p.next.next && p.next.val == p.next.next.val) {
      q = p.next.next
      while (q && q.val == p.next.val) q = q.next
      p.next = q
    } else {
      p = p.next
    }
  }
  return vHead.next
};