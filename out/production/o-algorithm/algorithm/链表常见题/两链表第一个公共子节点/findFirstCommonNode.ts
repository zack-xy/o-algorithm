import ListNode from "dataStructure/链表/ListNode";

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


function findFirstCommonNodeByStack(headA: ListNode | null, headB: ListNode | null): ListNode | null {
  const stackA: ListNode[] = [];
  const stackB: ListNode[] = [];

  while (headA !== null) {
    stackA.push(headA);
    headA = headA.next;
  }

  while(headB !== null) {
    stackB.push(headB);
    headB = headB.next;
  }

  let preNode: ListNode | null = null;

  while(stackA.length > 0 && stackB.length > 0) {
    if(stackA[stackA.length-1] === stackB[stackB.length-1]) {
      preNode = stackA.pop()!;
      stackB.pop();
    } else {
      break;
    }
  }

  return preNode;
}
