// weighted_quick_union
// 并查集优化2：路径压缩
// 只有路径压缩


class UnionSet5 {
  private fa: number[] // 存储爸爸的索引
  private n: number  // 节点数量

  constructor(n: number) {
    this.n = n
    this.fa = new Array<number>(n+1)
    for(let i=0;i<=n;i++){
      this.fa[i] = i
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
    this.fa[ra] = rb
  }
}
