/*
 * @lc app=leetcode.cn id=203 lang=typescript
 *
 * [203] 移除链表元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

// 精简 203.移除链表元素.ts 版本代码
function removeElements(head: ListNode | null, val: number): ListNode | null {
  let _head = new ListNode(0, head)
  let p = _head
  while(p.next) {
    if(p.next.val === val) {
      p.next = p.next.next
    } else {
      p = p.next
    }
  }
  return _head.next
};
// @lc code=end

