/**
 * Definition for singly-linked list
 * function ListNode(val, next) {
 *      this.val = (val === undefined ? 0 : val)
 *      this.next = (next === undefined ? null : next)
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */

// 通过3个指针进行反转：pre、cur、next(p)
// pre指向反转后的链表头节点
// cur指向当前链表头节点
// next(p)指向cur下一个节点
// 过程：将cur指向pre，pre移动至头，cur重指回原链表next(p)，next(p)移动指下一位，重复这个过程
var reverseList = function (head) {
  if (head == null) return head
  let pre = null
  let cur = head
  let p = head.next
  while (cur) {
    cur.next = pre
    pre = cur
    cur = p
    p = p && p.next
  }
  return pre
}


// 基于递归的回溯反转链表
var reverseList = function (head) {
  if (head == null || head.next == null) return head;
  let tail = head.next;
  let p = reverseList(head.next);
  head.next = tail.next
  tail.next = head;
  return p;
};
