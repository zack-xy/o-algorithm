import { ListNode } from '../链表/ListNode';

// 基于链表实现的栈
class LinkedListStack {
  private stackPeek: ListNode | null;  // 将头节点作为栈顶
  private stkSize: number = 0;  // 栈的长度

  constructor() {
    this.stackPeek = null;
  }

  // 获取栈的长度
  get size(): number {
    return this.stkSize;
  }

  // 判断栈是否为空
  isEmpty(): boolean {
    return this.size === 0;
  }

  // 入栈
  push(num: number): void {
    const node = new ListNode(num);
    node.next = this.stackPeek;
    this.stackPeek = node;
    this.stkSize++;
  }

  // 出栈
  pop(): number {
    const num = this.peek();
    if(!this.stackPeek) throw new Error('栈为空');
    this.stackPeek = this.stackPeek.next;
    this.stkSize--;
    return num;
  }

  // 访问栈顶元素
  peek(): number {
    if(!this.stackPeek) throw new Error('栈为空');
    return this.stackPeek.val;
  }

  // 将链表转化为数组返回
  toArray(): number[] {
    let node = this.stackPeek;
    const res = new Array<number>(this.size);
    for(let i = res.length-1;i>=0;i--) {
      res[i] = node!.val;
      node = node!.next;
    }
    return res;
  }
}
