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
// 解法：基于25题
var swapPairs = function (head) {
  return reverseKGroup(head, 2)
};


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