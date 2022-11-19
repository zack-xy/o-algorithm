// quick-union算法 树型实现

class UnionSet2 {
  private father: number[]
  private n: number

  constructor(n: number) {
    this.n = n
    this.father = new Array<number>(n+1)
    for(let i=0;i<=n;i++){
      this.father[i] = i // 垂死病中惊坐起，我爹竟是我自己
    }
  }

  // 返回节点所在集合的根节点编号
  find(x:number): number {
    if(this.father[x] === x) return x
    return this.find(this.father[x])
  }

  // 合并a,b两个节点所在的集合
  merge(a: number, b: number): void {
    let fa = this.find(a)
    let fb = this.find(b)
    if(fa === fb) return
    this.father[fa] = fb
  }

}
