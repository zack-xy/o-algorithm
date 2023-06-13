// weighted_quick_union
// 并查集优化2：路径压缩


class UnionSet4 {
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
    const root = this.find(this.fa[x])
    // find之后将节点挂到根节点
    this.fa[x] = root
    return root
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
