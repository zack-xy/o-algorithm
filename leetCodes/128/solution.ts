class UnionSet {
  private n:number
  private fa: number[]
  public cnt: number[]

  constructor(n:number) {
    this.n = n
    this.fa = new Array(n+1)
    this.cnt = new Array(n+1)
    for(let i=0;i<this.n;i++) {
      this.fa[i] = i
      this.cnt[i] = 1
    }
  }

  get(x: number): number {
    return this.fa[x] = (this.fa[x] === x ? x : this.get(this.fa[x]))
  }

  merge(x: number, y: number):void {
    if(this.get(x) === this.get(y)) return
    this.cnt[this.get(y)] += this.cnt[this.get(x)]
    this.fa[this.get(x)] = this.get(y)
  }
}

type HashMap = {
  [propName: number]: number | undefined
}

// 排序(nlogn)+扫描
// 数字连续关系当作联通关系->最大的集合元素数量
function longestConsecutive(nums: number[]): number {
  const unorderMap: HashMap = {}   // key为数字，value为数字所在的索引
  const unionSet = new UnionSet(nums.length)
  for(let i=0;i<nums.length;i++) {
    const x = nums[i]
    if(unorderMap[x] !== undefined) continue
    if(unorderMap[x-1] !== undefined) {
      // 联结的是数字所在的索引
      unionSet.merge(i, unorderMap[x-1])
    }
    if(unorderMap[x+1] !== undefined) {
      unionSet.merge(i, unorderMap[x+1])
    }
    if(unorderMap[x] === undefined) {
      unorderMap[x] = i
    }
  }
  let ans:number = 0
  for(let i=0;i<nums.length;i++) {
    if(unionSet.get(i) === i && unionSet.cnt[i] > ans) ans = unionSet.cnt[i]
  }
  return ans
};  
