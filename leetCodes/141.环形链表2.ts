/*
 * @lc app=leetcode.cn id=141 lang=typescript
 *
 * [141] 环形链表
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

// 双指针
function hasCycle(head: ListNode | null): boolean {
  if(head === null) return false
  let p = head
  let q = head.next
  while(p!=q && q && q.next) {
    p = p.next
    q = q.next.next
  }
  return p === q
};
// @lc code=end

