/* eslint-disable prefer-const */
/* eslint-disable @typescript-eslint/no-unused-vars */

/**
 * // Definition for a Node.
 * function Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
const copyRandomList = function (head) {
  let p = head
  let q
  let newHead
  // 步骤1:每一个节点在其后拷贝一个相同的节点，random指向相同
  while (p) {
    q = new Node(p.val)
    q.random = p.random
    q.next = p.next
    p.next = q
    p = q.next
  }
  // 步骤2:修正拷贝的节点的random指向
  p = head && head.next
  while (p) {
    if (p.random)
      p.random = p.random.next
    p = p.next && p.next.next
  }
  // 步骤3:拆链表
  newHead = head && head.next
  p = head
  q = newHead
  while (p) {
    q = p.next
    p.next = q.next
    if (p.next)
      q.next = p.next.next
    p = p.next
  }
  return newHead
}
