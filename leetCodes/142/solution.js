/**
 * Definition for singly-linked list
 * function ListNode(val) {
 *      this.val = val
 *      this.next = null
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
// 快慢指针解法
// 快慢指针相遇的节点距离环开始位置为a
// 头节点距离环开始位置也为a
// 则快慢指针相遇后，将指针重指向头节点，一步一步走，再次相遇，则为环起始点
var detectCycle = function (head) {
  if (head === null) return null;
  let p = head;
  let q = head.next;  // 这里快指针先走了1步，更早追上慢指针，所以相遇点比同时出发时，距离环起始点远了1步
  while (p != q && q && q.next) {
    p = p.next;
    q = q.next.next;
  }
  // 链表没有环
  if (p !== q) return null;
  // 链表有环
  p = head;
  q = q.next;  // 远了1步，往前1步
  while (p != q) {
    p = p.next;
    q = q.next;
  }
  return p;
};
