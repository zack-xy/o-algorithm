/**
 * Definition for singly-linked list
 * function ListNode(val, next) {
 *      this.val = (val === undefined ? 0 : val)
 *      this.next = (next === undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
//解法：先找到left位置前一个节点p，反转此处后链表前right-left+1个节点
// 当left为链表第一个节点时，前一个节点p则为虚拟头节点
var reverseBetween = function (head, left, right) {
  let cnt = right - left + 1
  let vHead = new ListNode(0, head) // 构造虚拟头节点
  let p = vHead
  while (--left) p = p.next  // 将p指向left前一个节点
  p.next = reverseNNodes(p.next, cnt)
  return vHead.next
}


// 反转链表前n个节点
var reverseNNodes = function (head, n) {
  if (n == 1) return head
  let tail = head.next
  let p = reverseNNodes(head.next, n - 1)
  head.next = tail.next
  tail.next = head
  return p
}