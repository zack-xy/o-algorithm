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

type HashMap = {
  [propName: number]: number | undefined
}

// 联通后，一个集合会剩下一块石头
// 剩下石头的数量等于集合的数量
// 减去的石头数量等于 = 总数量 - 集合数量
function removeStones(stones: number[][]): number {
  const unionSet = new UnionSet(stones.length)

  const ind_x: HashMap = {}
  const ind_y: HashMap = {}

  for(let i=0;i<stones.length;i++) {
    const [ x, y ] = stones[i]
    if(ind_x[x] !== undefined) {
      unionSet.merge(i, ind_x[x])
    }
    if(ind_y[y] !== undefined) {
      unionSet.merge(i, ind_y[y])
    }
    ind_x[x] = i
    ind_y[y] = i
  }
  

  let cnt:number = 0
  for(let i=0;i<stones.length;i++) {
    if(unionSet.get(i) === i) cnt++
  }

  return stones.length - cnt

};
