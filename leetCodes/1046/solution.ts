class MaxHeap<T> {
  private maxHeap: T[]
  private size: number = 0
  private capacity!: number
  constructor(capacity: number)
  constructor(capacity: number, arr: T[])

  constructor(capacity: number, arr?: T[]) {
    this.capacity = capacity
    this.maxHeap = new Array(capacity + 1)
    if(arr) {
      for(let i = 0; i < Math.min(capacity, arr.length); i++) {
        this.push(arr[i])
      }
    }
  }

  public getSize(): number {
    return this.size
  }

  public isEmpty(): boolean {
    return this.size === 0
  }

  public top(): T {
    return this.maxHeap[1]
  }

  public push(item: T): void {
    if(this.size + 1 <= this.capacity) {
      this.maxHeap[this.size + 1] = item
      this.size++
      this.shiftUp(this.size)
    }
  }

  public pop(): T | void {
    if(this.size > 0) {
      const item = this.maxHeap[1]
      this.swap(1, this.size)
      this.size--
      this.shiftDown(1)
      return item
    }
  }

  private shiftUp(index: number): void {
    while(index > 1 && this.maxHeap[Math.floor(index / 2)] < this.maxHeap[index]) {
      this.swap(Math.floor(index / 2), index)
      index = Math.floor(index / 2)
    }
  }

  private shiftDown(index: number): void {
    while(2 * index <= this.size) {
      let i = 2 * index
      if(i + 1 <= this.size && this.maxHeap[i+1] > this.maxHeap[i]) {
        i += 1
      }
      if(this.maxHeap[index] >= this.maxHeap[i]) {
        break
      }
      this.swap(index, i)
      index = i
    }
  }

  private swap(i: number, j: number): void {
    const temp = this.maxHeap[i]
    this.maxHeap[i] = this.maxHeap[j]
    this.maxHeap[j] = temp
  }

  public outArr(): T[] {
    const arr:T[] = []
    for(let i=1;i<=this.size;i++) {
      arr.push(this.maxHeap[i])
    }
    return arr
  } 

}

function lastStoneWeight(stones: number[]): number {
  const maxHeap = new MaxHeap<number>(stones.length)
  for(let item of stones) {
    maxHeap.push(item)
  }
  while(maxHeap.getSize() > 1) {
    let y = maxHeap.pop() as number
    let x = maxHeap.pop() as number
    if(x === y) continue
    maxHeap.push(y-x)
  }
  if(maxHeap.getSize() === 0) return 0
  return maxHeap.top()
};