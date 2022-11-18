type Freq = {
  [propName: string]: number
}

type CompareFn = (a?:any, ...b: any[]) => boolean

class MinHeap<T> {
  private maxHeap: T[]
  private size: number = 0
  private capacity!: number
  private cmp: CompareFn
  constructor(capacity: number, cmp: CompareFn)
  constructor(capacity: number, cmp: CompareFn, arr: T[] )

  constructor(capacity: number, cmp: CompareFn, arr?: T[] ) {
    this.capacity = capacity
    this.maxHeap = new Array(capacity + 1)
    if(arr) {
      for(let i = 0; i < Math.min(capacity, arr.length); i++) {
        this.push(arr[i])
      }
    }
    if(cmp) {
      this.cmp = cmp
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
    while(index > 1 && this.cmp(this.maxHeap[Math.floor(index / 2)], this.maxHeap[index])) {
      this.swap(Math.floor(index / 2), index)
      index = Math.floor(index / 2)
    }
  }

  private shiftDown(index: number): void {
    while(2 * index <= this.size) {
      let i = 2 * index
      if(i + 1 <= this.size && this.cmp(this.maxHeap[i], this.maxHeap[i+1])) {
        i += 1
      }
      if(!this.cmp(this.maxHeap[index], this.maxHeap[i])) {
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


function topKFrequent(words: string[], k: number): string[] {
  const freq: Freq = {}
  const cmp = (a:string, b:string):boolean=> {
    if(freq[a] - freq[b]) return freq[a] > freq[b]
    return a < b
  }
  const minHeap = new MinHeap<string>(k+1,cmp)
  for(let x of words) {
    if(!freq[x]) freq[x] = 0
    freq[x]+=1
  }
  for(let x in freq) {
    minHeap.push(x)
    if(minHeap.getSize() > k) minHeap.pop()
  }
  return minHeap.outArr().sort((a,b)=> {
    if(freq[a] > freq[b]) return -1
    if(freq[a] < freq[b]) return 1
    return a.localeCompare(b)
  })
};
