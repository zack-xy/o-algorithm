/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *      this.val = val
 *      this.next = null
 * }
 * 
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */

// 快慢指针解法
var hasCycle = function (head) {
  if (head === null) return false
  let p = head   // 慢指针
  let q = head.next  // 快指针
  while (p != q && q && q.next) {
    p = p.next
    q = q.next.next
  }
  return p === q  // 如果快指针和慢指针相等，则快慢指针相遇，链表有环
}