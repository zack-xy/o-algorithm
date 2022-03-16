/**
 * Definition for singly-linked list
 * function ListNode(val, next) {
 *      this.val = (val === undefined ? 0 : val)
 *      this.next = (next === undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */

// 解法：构造虚拟头节点vHead
// p指向虚拟头节点(指向反转链表的前一个节点)
// q指向虚拟头节点的下一个节点（指向反转链表的第一个节点）
// 反转q节点后前k个节点(reverseNNodes方法，如果不足k个返回原链表)
// 反转后，则q的位置为第k个，即从k+1处继续反转，则p=q
// q需要指向反转链表第一个，则q=p.next重复上述操作
// 直至p.next == q说明链表没有反转，则反转结束
// 返回虚拟头节点的下一个节点
var reverseKGroup = function (head, k) {
  let vHead = new ListNode(0, head); // 构造虚拟头节点
  let p = vHead;
  let q = p.next;
  p.next = reverseNNodes(q, k)
  while (p.next != q) {
    p = q;
    q = p.next;
    p.next = reverseNNodes(q, k);
  }
  return vHead.next;
};

// 反转链表前n个节点
var __reverseN = function (head, n) {
  if (n == 1) return head;
  let tail = head.next;
  let p = __reverseN(head.next, n - 1);
  head.next = tail.next;
  tail.next = head;
  return p;
};

// 如果链表足够n个节点
// 反转链表前n个节点
var reverseNNodes = function (head, n) {
  let p = head;
  let cnt = n;
  while (--n && p) p = p.next;
  if (p == null) return head;
  return __reverseN(head, cnt);
};
