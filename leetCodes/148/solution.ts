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

class ListNode {
  val: number
  next: ListNode | null
  constructor(val?: number, next?: ListNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
  }
}

// eslint-disable-next-line @typescript-eslint/no-unused-vars
function sortList(head: ListNode | null): ListNode | null {
  if (head === null)
    return head
  let l: number = head.val
  let r: number = head.val
  let p: ListNode = head
  let q: ListNode | null = null
  let h1: ListNode | null = null
  let h2: ListNode | null = null
  while (p) {
    l = Math.min(p.val, l)
    r = Math.max(p.val, r)
    p = p.next
  }
  if (l === r)
    return head
  const mid = Math.floor((l + r) / 2)
  p = head
  while (p) {
    q = p.next
    if (p.val <= mid) {
      p.next = h1
      h1 = p
    }
    else {
      p.next = h2
      h2 = p
    }
    p = q
  }
  h1 = sortList(h1)
  h2 = sortList(h2)
  p = h1
  while (p.next) p = p.next
  p.next = h2
  return h1
}

