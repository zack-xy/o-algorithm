// type NumberPair = [number, number]
class NumberPair {
  constructor(a:number,b: number) {
    return [a, b]
  }
}

class MaxHeap<NumberPair> {
  private maxHeap: NumberPair[]
  private size: number = 0
  private capacity!: number
  constructor(capacity: number)
  constructor(capacity: number, arr: NumberPair[])

  constructor(capacity: number, arr?: NumberPair[]) {
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

  public top(): NumberPair {
    return this.maxHeap[1]
  }

  public push(item: NumberPair): void {
    if(this.size + 1 <= this.capacity) {
      this.maxHeap[this.size + 1] = item
      this.size++
      this.shiftUp(this.size)
    }
  }

  public pop(): NumberPair {
    if(this.size > 0) {
      const item = this.maxHeap[1]
      this.swap(1, this.size)
      this.size--
      this.shiftDown(1)
      return item
    }
  }

  private shiftUp(index: number): void {
    while(index > 1 && this.operator(this.maxHeap[Math.floor(index / 2)], this.maxHeap[index])) {
      this.swap(Math.floor(index / 2), index)
      index = Math.floor(index / 2)
    }
  }

  private shiftDown(index: number): void {
    while(2 * index <= this.size) {
      let i = 2 * index
      if(i + 1 <= this.size && this.operator(this.maxHeap[i], this.maxHeap[i+1])) {
        i += 1
      }
      if(!this.operator(this.maxHeap[index], this.maxHeap[i])) {
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

  public operator(a: NumberPair, b: NumberPair): boolean {
    return a[0] + a[1] < b[0] + b[1]
  }

  public outArr(): NumberPair[] {
    const arr = []
    for(let i=1;i<=this.size;i++) {
      arr.push(this.maxHeap[i])
    }
    return arr
  } 

}


function kSmallestPairs(nums1: number[], nums2: number[], k: number): number[][] {
  const maxHeap = new MaxHeap<NumberPair>(k+1)
  for(let x of nums1) {
    for(let y of nums2) {
      const temp: NumberPair = new NumberPair(x, y)
      if(maxHeap.getSize() < k || maxHeap.operator(temp, maxHeap.top())) {
        maxHeap.push(temp)
        if(maxHeap.getSize() > k) maxHeap.pop()
      } else {
        break
      }
    }
  }
  return maxHeap.outArr() as number[][]
};

/**
* Your KthLargest object will be instantiated and called as such:
* var obj = new KthLargest(k, nums)
* var param_1 = obj.add(val)
*/
