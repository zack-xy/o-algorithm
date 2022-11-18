class MaxHeap<T> {
  // 实现堆的数组（T代表用户可以存储任意数据类型）
  private maxHeap: T[]
  // 堆中数据量
  private size: number = 0
  // 堆容量
  // 根据用户指定的容量初始化一个数组，实际上js数组是动态的
  // 是不需要指定数组长度的，可以不需要指定容量
  // 这里我们限制为一个有容量限制的堆
  private capacity!: number
  // 构造堆的时候，支持传入容量或者容量和一个初始化数组
  constructor(capacity: number)
  constructor(capacity: number, arr: T[])

  constructor(capacity: number, arr?: T[]) {
    // 从索引1位置开始实现
    this.capacity = capacity
    this.maxHeap = new Array(capacity + 1)
    // heapify过程
    if(arr) {
      for(let i = 0; i < Math.min(capacity, arr.length); i++) {
        this.push(arr[i])
      }
    }
  }

  // 返回堆中有多少个元素
  public getSize(): number {
    return this.size
  }

  // 堆是否为空
  public isEmpty(): boolean {
    return this.size === 0
  }

  // 向最大堆中添加元素shift up
  // 首先，元素放置在堆末尾，然后依次比较其和父节点的大小，比父节点大
  // 则和父节点交换位置，直到不大于父节点为止
  public push(item: T): void {
    // 从索引1位置开始
    if(this.size + 1 <= this.capacity) {
      this.maxHeap[this.size + 1] = item
      this.size++
      this.shiftUp(this.size)
    }
  }


  public pop(): T | void {
    if(this.size > 0) {
      const item = this.maxHeap[1]
      // 交换堆顶和堆尾元素
      this.swap(1, this.size)
      // 没有必要删除，size--后，不会访问到了
      this.size--
      this.shiftDown(1)
      return item
    }
  }

  // 实现元素从index位置向上移动到正确位置的过程
  private shiftUp(index: number): void {
    // 对于一个节点，索引为i，其父节点parent: Math.floor(i/2)
    // 注意，这里比较大小的方法，可能会根据堆中存储元素类型的不同做改变
    while(index > 1 && this.maxHeap[Math.floor(index / 2)] < this.maxHeap[index]) {
      this.swap(Math.floor(index / 2), index)
      index = Math.floor(index / 2)
    }
  }

  // 实现元素从index位置向下移动到正确位置的过程
  private shiftDown(index: number): void {
    while(2 * index <= this.size) {
      let i = 2 * index
      // 注意，这里比较大小的方法，可能会根据堆中存储元素类型的不同做改变
      if(i + 1 <= this.size && this.maxHeap[i+1] > this.maxHeap[i]) {
        i += 1
      }
      // 已经移到了正确位置
      if(this.maxHeap[index] >= this.maxHeap[i]) {
        break
      }
      this.swap(index, i)
      index = i
    }
  }

  // 交换数组两个索引位置的元素
  private swap(i: number, j: number): void {
    const temp = this.maxHeap[i]
    this.maxHeap[i] = this.maxHeap[j]
    this.maxHeap[j] = temp
  }

  public outArr(): T[] {
    const arr: T[] = []
    for(let i=1;i<=this.size;i++) {
      arr.push(this.maxHeap[i])
    }
    return arr
  } 

}

function getLeastNumbers(arr: number[], k: number): number[] {
  const maxHeap = new MaxHeap<number>(k+1)
  for(let item of arr) {
    maxHeap.push(item)
    if(maxHeap.getSize() > k) maxHeap.pop()
  }
  return maxHeap.outArr()
};
