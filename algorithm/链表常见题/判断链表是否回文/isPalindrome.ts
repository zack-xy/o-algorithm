import ListNode from "dataStructure/链表/ListNode";

function isPalindrome(head: ListNode | null): boolean {
  let temp = head;
  const stack: number[] = [];

  // 把链表节点的值存放到栈中
  while(temp !== null) {
    stack.push(temp.val);
    temp = temp.next;
  }

  // 比较链表和栈中的数据
  while(head !== null) {
    if(head.val !== stack.pop()) {
      return false;
    }
    head = head.next;
  }

  return true;
}
