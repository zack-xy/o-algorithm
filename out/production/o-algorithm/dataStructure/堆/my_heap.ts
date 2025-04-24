// 最大堆类
class MaxHeap {
  private maxHeap: number[];
  constructor(nums?: number[]) {
    // 将列表元素原封不动添加进堆
    this.maxHeap = nums === undefined ? [] : [...nums];
    for(let i = this.parent(this.size() - 1); i>=0; i--) {
      this.siftDown(i);
    }
  }

  // 获取左子节点的索引
  private left(i: number): number {
    return 2 * i + 1;
  }

  // 获取右子节点的索引
  private right(i: number): number {
    return 2 * i + 2;
  }

  // 获取父节点的索引
  private parent(i: number): number {
    return Math.floor((i-1)/2);
  }

  // 交换元素
  private swap(i: number, j: number): void {
    const tmp = this.maxHeap[i];
    this.maxHeap[i] = this.maxHeap[j];
    this.maxHeap[j] = tmp;
  }

  // 获取堆大小
  public size(): number {
    return this.maxHeap.length;
  }

  // 判断堆是否为空
  public isEmpty(): boolean {
    return this.size() === 0;
  }

  // 访问堆顶元素
  public peek(): number {
    return this.maxHeap[0];
  }

  // 元素入堆
  public push(val: number): void {
    // 添加节点
    this.maxHeap.push(val);
    // 从底至顶堆化
    this.shiftUp(this.size() - 1);
  }

  // 从节点i开始，从底至顶堆化
  private shiftUp(i: number): void {
    while(true) {
      // 获取节点i的父节点
      const p = this.parent(i);
      if(p < 0 || this.maxHeap[i] <= this.maxHeap[p]) break;
      this.swap(i, p);
      i = p;
    }
  }

  // 元素出堆
  public pop(): number {
    if(this.isEmpty()) throw new RangeError('Heap is empty.')
    this.swap(0, this.size() - 1);
    // 数组pop方法，弹出最后一个元素
    const val = this.maxHeap.pop() as number;
    this.siftDown(0);
    return val;
  }

  // 从节点i开始，从顶至底堆化
  private siftDown(i: number): void {
    while(true) {
      const l = this.left(i),
            r = this.right(i);
      let ma = i;
      if(l < this.size() && this.maxHeap[l] > this.maxHeap[ma]) ma = l;
      if(r < this.size() && this.maxHeap[r] > this.maxHeap[ma]) ma = r;
      // 若节点i最大或者索引l，r越界，则无需继续堆化，跳出
      if(ma === i) break;
      this.swap(i, ma);
      // 循环向下堆化
      i = ma;
    }
  }

  // 取出堆中元素
  public getMaxHeap(): number[] {
    return this.maxHeap;
  }
}

export { MaxHeap }
