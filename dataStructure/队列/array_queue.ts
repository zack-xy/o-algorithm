// 基于环形数组实现的队列
class ArrayQueue {
  private nums: number[]; // 用于存储队列元素的数组
  private front: number;  // 对首指针，指向对首元素
  private queSize: number; // 队列长度

  constructor(capacity: number) {
    this.nums = new Array(capacity);
    this.front = this.queSize = 0;
  }

  // 获取队列的容量
  get capacity(): number {
    return this.nums.length;
  }

  // 获取队列的长度
  get size(): number {
    return this.queSize;
  }

  // 判断队列是否为空
  isEmpty(): boolean {
    return this.queSize === 0;
  }

  // 入队
  push(num: number): void {
    if(this.size === this.capacity) {
      console.log('队列已满');
      return;
    }
    // 计算队尾指针，指向队尾索引 + 1
    // 通过取余操作实现 rear 越过数组尾部后回到头部
    const rear = (this.front + this.queSize) % this.capacity;
    this.nums[rear] = num;
    this.queSize++;
  }

  // 出队
  pop(): number {
    const num = this.peek();
    this.front = (this.front + 1) % this.capacity;
    this.queSize--;
    return num;
  }

  // 访问对首元素
  peek(): number {
    if(this.isEmpty()) throw new Error('队列为空');
    return this.nums[this.front];
  }

  // 返回数组
  toArray(): number[] {
    const arr = new Array(this.size);
    for(let i=0,j=this.front;i<this.size;i++,j++) {
      arr[i] = this.nums[j % this.capacity];
    }
    return arr;
  }
}

export default ArrayQueue;