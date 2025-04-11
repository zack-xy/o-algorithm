class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val: number = 0, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function findFirstCommonNodeBySet(headA: ListNode | null, headB: ListNode | null): ListNode | null  {
  const set = new Set<ListNode>();
  while(headA !== null) {
    set.add(headA);
    headA = headA.next;
  }

  while(headB !== null) {
    if(set.has(headB)) return headB;
    headB = headB.next;
  }
  return null;
}

export default ListNode
