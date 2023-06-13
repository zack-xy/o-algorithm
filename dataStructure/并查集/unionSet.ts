// 并查集的实现(染色法) quick-find算法
class UnionSet {
  private color: number[] // 节点颜色
  private n: number  // 节点数量
  constructor(n: number) {
    this.n = n
    this.color = new Array(n+1)
    for(let i = 0;i<=n;i++) {
      this.color[i] = i  // 索引作为节点颜色
    }
  }

  // 返回x点的集合颜色 O(1)
  find(x: number): number {
    return this.color[x]
  }

  // a,b两个点连接到一起 O(n)
  merge(a: number, b: number): void {
    if(this.color[a] === this.color[b]) return
    let cb = this.color[b]
    for(let i=0;i<=this.n;i++) {
      if(this.color[i] === cb) this.color[i] = this.color[a]
    }
  }
}
