import { DoubleListNode } from '../链表/DoubleListNode';

// 基于双向链表实现的双向队列
class LinkedListDeque {
  private front: DoubleListNode | null;  // 头节点 front
  private rear: DoubleListNode | null;  // 尾节点 rear
  private queSize: number;       // 双向队列的长度

  constructor() {
    this.front = null;
    this.rear = null;
    this.queSize = 0;
  }

  // 队尾入队操作
  pushLast(val: number): void {
    const node: DoubleListNode = new DoubleListNode(val);
    if(this.queSize === 0) {
      this.front = node;
      this.rear = node;
    } else {
      this.rear!.next = node;
      node.prev = this.rear;
      this.rear = node;
    }
    this.queSize++;
  }

  // 队首入队操作
  pushFirst(val: number): void {
    const node: DoubleListNode = new DoubleListNode(val);
    if(this.queSize === 0) {
      this.front = node;
      this.rear = node;
    } else {
      this.front!.prev = node;
      node.next = this.front;
      this.front = node;
    }
    this.queSize++;
  }

  // 队尾出队操作
  popLast(): number | null {
    if(this.queSize === 0) {
      return null;
    }
    const value: number = this.rear!.val;
    let temp: DoubleListNode | null = this.rear!.prev;
    if(temp !== null) {
      temp.next = null;
      this.rear!.prev = null;
    }
    this.rear = temp;
    this.queSize--;
    return value;
  }

  // 队首出队操作
  popFirst(): number | null {
    if(this.queSize === 0) {
      return null
    }
    const value: number = this.front!.val;
    let temp: DoubleListNode | null = this.front!.next;
    if(temp !== null) {
      temp.prev = null;
      this.front!.next = null;
    }
    this.front = temp;
    this.queSize--;
    return value;
  }

  // 访问队尾元素
  peekLast(): number | null {
    return this.queSize === 0 ? null : this.rear!.val;
  }

  // 访问对首元素
  peekFirst(): number | null {
    return this.queSize === 0 ? null : this.front!.val;
  }

  // 获取双向队列的长度
  size(): number {
    return this.queSize;
  }

  // 判断双向队列是否为空
  isEmpty(): boolean {
    return this.queSize === 0;
  }

  // 打印双向队列
  print(): void {
    const arr: number[] = [];
    let temp = this.front;
    while(temp !== null) {
      arr.push(temp.val);
      temp = temp.next;
    }
    console.log('[' + arr.join(', ') + ']');
  }
}
