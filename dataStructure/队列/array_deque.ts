// 基于环形数组实现的双向队列
class ArrayDeque {
  private nums: number[];  // 用于存储双向队列元素的数组
  private front: number;  // 队首指针，指向对首元素
  private queSize: number;  // 双向队列长度

  constructor(capacity: number) {
    this.nums = new Array(capacity);
    this.front = 0;
    this.queSize = 0;
  }

  // 获取双向队列的容量
  capacity(): number {
    return this.nums.length;
  }

  // 获取双向队列的长度
  size(): number {
    return this.queSize;
  }

  // 判断双向队列是否为空
  isEmpty(): boolean {
    return this.queSize === 0;
  }

  // 计算环形数组索引
  // 这里加上容量再对容量取余，是为了照顾到i为负数的情况
  index(i: number): number {
    return (i + this.capacity()) % this.capacity();
  }

  // 对首入队
  pushFirst(num: number): void {
    if(this.queSize === this.capacity()) {
      console.log('双向队列已满');
      return;
    }
    this.front = this.index(this.front - 1);
    this.nums[this.front] = num;
    this.queSize++;
  }

  // 队尾入队
  pushLast(num: number): void {
    if(this.queSize === this.capacity()) {
      console.log('双向队列已满');
      return;
    }
    const rear: number = this.index(this.front + this.queSize);
    this.nums[rear] = num;
    this.queSize++;
  }

  // 队首出队
  popFirst(): number {
    const num: number = this.peekFirst();
    this.front = this.index(this.front + 1);
    this.queSize--;
    return num;
  }

  // 队尾出队
  popLast(): number {
    const num: number = this.peekLast();
    this.queSize--;
    return num;
  }

  // 访问对首元素
  peekFirst(): number {
    if(this.isEmpty()) throw new Error('队列为空');
    return this.nums[this.front];
  }

  // 访问队尾元素
  peekLast(): number {
    if(this.isEmpty()) throw new Error('队列为空');
    const last = this.index(this.front + this.queSize - 1);
    return this.nums[last];
  }

  // 返回数组
  toArray(): number[] {
    const res: number[] = [];
    for(let i=0,j=this.front;i<this.queSize;i++,j++) {
      res[i] = this.nums[this.index(j)];
    }
    return res;
  }
}
