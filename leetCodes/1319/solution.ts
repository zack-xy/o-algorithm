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

// 本质是判断集合数
// 假设有2个集合，则需要操作一次，将2个集合连接为1个集合
// 如果有3个集合，需要操作2次，将3个集合连接为1和集合
// n台电脑，最少需要n-1条线缆，否则不够连成一个集合
function makeConnected(n: number, connections: number[][]): number {
  if(connections.length < n - 1) return -1
  const unionSet = new UnionSet(n)
  for(let e of connections) {
    const a = e[0]
    const b = e[1]
    unionSet.merge(a, b)
  }
  let cnt = 0
  for(let i=0; i<n ;i++) {
    if(unionSet.get(i) === i) cnt+=1
  }
  return cnt - 1
};
