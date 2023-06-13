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

// 使用Set
function hasCycle(head: ListNode | null): boolean {
    let cache = new Set<ListNode>()
    while(head) {
      if(cache.has(head)) {
        return true
      } else {
        cache.add(head)
      }
      head = head.next
    }
    return false
};
// @lc code=end

