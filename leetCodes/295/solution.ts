// 对顶堆
class MaxMinHeap<T> {
  private maxHeap: T[]
  private size: number = 0
  private flag: 'max' | 'min' = 'max' // 默认大顶堆
  constructor()
  constructor(flag: string)
  constructor(flag: string, arr: T[])

  constructor(flag?: 'max'| 'min', arr?: T[]) {
    this.maxHeap = new Array()
    if(flag) {
      this.flag = flag
    }
    if(arr) {
      for(let i = 0; i < arr.length; i++) {
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
    this.maxHeap[this.size + 1] = item
    this.size++
    this.shiftUp(this.size)
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
    while(index > 1 && this.compareFn(this.maxHeap[Math.floor(index / 2)], this.maxHeap[index])) {
      this.swap(Math.floor(index / 2), index)
      index = Math.floor(index / 2)
    }
  }

  private shiftDown(index: number): void {
    while(2 * index <= this.size) {
      let i = 2 * index
      if(i + 1 <= this.size && this.compareFn(this.maxHeap[i], this.maxHeap[i+1])) {
        i += 1
      }
      if(!this.compareFn(this.maxHeap[index], this.maxHeap[i])) {
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

  private compareFn(a: T, b: T): boolean {
    if(this.flag === 'min') {
      return a > b
    } else {
      return a < b
    }
  }

  public outArr(): T[] {
    const arr = []
    for(let i=1;i<=this.size;i++) {
      arr.push(this.maxHeap[i])
    }
    return arr
  } 

}


class MedianFinder {
  private maxHeap = new MaxMinHeap<number>('max')
  private minHeap = new MaxMinHeap<number>('min')
  constructor() {
    
  }

  addNum(num: number): void {
    if(this.maxHeap.getSize() === 0 || num <= this.maxHeap.top()) {
      this.maxHeap.push(num)
    } else {
      this.minHeap.push(num)
    }
    // maxHeap最多比minHeap多一个元素
    if(this.minHeap.getSize() > this.maxHeap.getSize()) {
      this.maxHeap.push(this.minHeap.pop() as number)
    }
    if(this.maxHeap.getSize() === this.minHeap.getSize() + 2) {
      this.minHeap.push(this.maxHeap.pop() as number)
    }
  }

  findMedian(): number {
    const n: number = this.maxHeap.getSize() + this.minHeap.getSize()
    if(n % 2 !== 0) {
      return this.maxHeap.top()
    }
    return (this.maxHeap.top() + this.minHeap.top()) / 2
  }
}

/**
* Your MedianFinder object will be instantiated and called as such:
* var obj = new MedianFinder()
* obj.addNum(num)
* var param_2 = obj.findMedian()
*/
