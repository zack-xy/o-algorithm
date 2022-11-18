class MinHeap<T> {
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

  public pop(): T {
    if(this.size > 0) {
      const item = this.maxHeap[1]
      this.swap(1, this.size)
      this.size--
      this.shiftDown(1)
      return item
    }
  }

  private shiftUp(index: number): void {
    while(index > 1 && this.maxHeap[Math.floor(index / 2)] > this.maxHeap[index]) {
      this.swap(Math.floor(index / 2), index)
      index = Math.floor(index / 2)
    }
  }

  private shiftDown(index: number): void {
    while(2 * index <= this.size) {
      let i = 2 * index
      if(i + 1 <= this.size && this.maxHeap[i+1] < this.maxHeap[i]) {
        i += 1
      }
      if(this.maxHeap[index] <= this.maxHeap[i]) {
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
    const arr = []
    for(let i=1;i<=this.size;i++) {
      arr.push(this.maxHeap[i])
    }
    return arr
  } 

}

class KthLargest {
  private minHeap:MinHeap<number>
  private k: number
  constructor(k: number, nums: number[]) {
    this.k = k
    this.minHeap = new MinHeap<number>(k)
    for(let item of nums) {
      this.add(item)
    }
  }

  add(val: number): number {
    if(this.minHeap.getSize() < this.k) {
      this.minHeap.push(val)
    } else {
      if(val > this.minHeap.top()) {
        this.minHeap.pop()
        this.minHeap.push(val)
      }
    }
    return this.minHeap.top()
  }
}

/**
* Your KthLargest object will be instantiated and called as such:
* var obj = new KthLargest(k, nums)
* var param_1 = obj.add(val)
*/
