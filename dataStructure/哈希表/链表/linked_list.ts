import { ListNode } from './ListNode';

// 在链表的节点n0之后插入节点p
function insert(n0: ListNode, p: ListNode): void {
  const n1 = n0.next;
  p.next = n1;
  n0.next = p;
}


// 删除链表节点n0之后的节点
function remove(n0: ListNode): void {
  if(!n0.next) {
    return;
  }
  // n0 -> p -> n1
  const p = n0.next;
  const n1 = p.next;
  n0.next = n1;
}

// 访问链表中索引为index的节点
function access(head: ListNode | null, index: number): ListNode | null {
  for(let i = 0;i < index; i++) {
    if(!head) {
      return null;
    }
    head = head.next;
  }
  return head;
}

// 在链表中查找值为target的首个节点的index
function find(head: ListNode | null, target: number): number {
  let index = 0;
  while(head !== null) {
    if(head.val === target) {
      return index;
    }
    head = head.next;
    index += 1;
  }
  return -1;
}
