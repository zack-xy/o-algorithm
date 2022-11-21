// 并查集
class UnionSet {
  private n:number
  private fa: number[]

  constructor(n:number) {
    this.n = n
    this.fa = new Array(n+1)
    for(let i=0;i<this.n;i++) {
      this.fa[i] = i
    }
  }

  get(x: number): number {
    return this.fa[x] = (this.fa[x] === x ? x : this.get(this.fa[x]))
  }

  merge(x: number, y: number):void {
    this.fa[this.get(x)] = this.get(y)
  }
}

// 堆
class MaxMinHeap<T> {
  private maxHeap: T[]
  private size: number = 0
  private flag: 'max' | 'min' = 'max' // 默认大顶堆
  constructor()
  constructor(flag: 'max'| 'min')
  constructor(flag: 'max'| 'min', arr: T[])

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
    const arr: T[] = []
    for(let i=1;i<=this.size;i++) {
      arr.push(this.maxHeap[i])
    }
    return arr
  } 

}

// 判断pairs联通关系
// 表示pairs对代表的字符可以随意交换，若想要字典序最小，则排序联通的字符串即可
function smallestStringWithSwaps(s: string, pairs: number[][]): string {
  const unionSet = new UnionSet(s.length)

  const hHeapArr: Array<MaxMinHeap<string>> = new Array(s.length)


  for(let p of pairs) {
    const [i,j] = p
    unionSet.merge(i,j)
  }

  for(let i=0;i<s.length;i++) {
    if(hHeapArr[unionSet.get(i)] === undefined) {
      hHeapArr[unionSet.get(i)] = new MaxMinHeap<string>('min')
    }
    hHeapArr[unionSet.get(i)].push(s[i])
  }

  let ret:string = ''
  for(let i=0;i<s.length;i++) {
    ret += hHeapArr[unionSet.get(i)].pop()
  }

  return ret
};
