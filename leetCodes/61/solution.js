/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
// 解法：寻找到链表尾结点，记录链表长度
// 对k进行n取余(防止k>>n则多次循环移动)
// 将尾结点衔接头结点，移动n-k次断开即可
// 可以这样理解：假如入k=2，n=5，则向右移2步，尾结点2个移动到头，相当于环形移动n-k=3次处断开
var rotateRight = function (head, k) {
  if (head == null) return null
  let n = 1
  let p = head
  while (p.next) {
    p = p.next
    n += 1
  }
  p.next = head
  k %= n
  k = n - k
  while (k--) p = p.next
  head = p.next
  p.next = null
  return head
};