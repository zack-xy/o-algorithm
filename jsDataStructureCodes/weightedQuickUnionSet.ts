// weighted_quick_union
// 优化后的并查集


class UnionSet3 {
  private fa: number[] // 存储爸爸的索引
  private size: number[] // 树的大小
  private n: number  // 节点数量

  constructor(n: number) {
    this.n = n
    this.fa = new Array<number>(n+1)
    this.size = new Array<number>(n+1)
    for(let i=0;i<=n;i++){
      this.fa[i] = i
      this.size[i] = 1
    }
  }


  find(x: number): number {
    if(this.fa[x] === x) return x
    return this.find(this.fa[x])
  }


  merge(a:number,b:number):void {
    let ra = this.find(a)
    let rb = this.find(b)

    if(ra === rb) return
    if(this.size[ra] < this.size[rb]) {
      this.fa[ra] = rb
      this.size[rb] += this.size[ra]
    } else {
      this.fa[rb] = ra
      this.size[ra] += this.size[rb]
    }

  }
}
