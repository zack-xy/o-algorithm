/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
// 解法：删除倒数n节点，需要找到其前一个节点即倒数n+1个节点
// 设置虚拟头结点：两个指针p、q，当p和q距离为n时，q在后到null时，p为n+1个节点
const removeNthFromEnd = function (head, n) {
  const vHead = new ListNode(0, head)
  let p = vHead
  let q = head
  while (n--) q = q.next
  while (q) {
    p = p.next
    q = q.next
  }
  p.next = p.next.next
  return vHead.next
}
