import { ListNode } from '../链表/ListNode';
// 基于链表实现的队列
class LinkedListQueue {
  private front: ListNode | null;   // 头节点front
  private rear: ListNode | null;    // 尾节点rear
  private queSize: number = 0;

  constructor() {
    this.front = null;
    this.rear = null;
  }

  // 获取队列的长度
  get size(): number {
    return this.queSize;
  }

  // 判断队列是否为空
  isEmpty(): boolean {
    return this.size === 0;
  }

  // 入队
  push(num: number): void {
    const node = new ListNode(num);
    if(!this.front) {
      this.front = node;
      this.rear = node;
    } else {
      this.rear!.next = node;
      this.rear = node;
    }
    this.queSize++;
  }

  // 出队
  pop():number {
    const num = this.peek();
    if(!this.front) throw new Error('队列为空');
    this.front = this.front.next;
    this.queSize--;
    return num;
  }

  // 访问队首元素
  peek(): number {
    if(this.size === 0) throw new Error('队列为空');
    return this.front!.val;
  }

  // 将链表转换为数组
  toArray(): number[] {
    let node = this.front;
    const res = new Array<number>(this.size);
    for(let i = 0;i < res.length; i++) {
      res[i] = node!.val;
      node = node!.next;
    }
    return res;
  }

}
