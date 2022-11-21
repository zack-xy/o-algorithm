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

// 依次向并查集中插入
// 插入前判断是否原本就是连通的
// 如果本来就是连通的，则当前的边就是多余的
function findRedundantConnection(edges: number[][]): number[] {
  const unionSet = new UnionSet(edges.length)

  for(let e of edges) {
    const a = e[0]
    const b = e[1]
    if(unionSet.get(a) === unionSet.get(b)) return e
    unionSet.merge(a,b)
  }
  return []
};
