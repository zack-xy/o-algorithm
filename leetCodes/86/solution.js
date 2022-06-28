/* eslint-disable no-undef */
/* eslint-disable @typescript-eslint/no-unused-vars */

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */
const partition = function (head, x) {
  const rs = new ListNode(0) // 虚拟头节点，存放小于x的节点
  const rb = new ListNode(0) // 虚拟头节点，存放大于等于x的节点
  let p1 = rs // 小链表的尾指针
  let p2 = rb // 大链表的尾指针
  let p = head // 总链表的指针
  let q // p的下一个节点
  while (p) {
    q = p.next
    if (p.val < x) {
      p.next = p1.next
      p1.next = p
      p1 = p
    }
    else {
      p.next = p2.next
      p2.next = p
      p2 = p
    }
    p = q
  }
  p1.next = rb.next
  return rs.next
}
