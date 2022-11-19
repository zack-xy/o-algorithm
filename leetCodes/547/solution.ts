class UnionSet {
  private fa:number[]
  private n:number

  constructor(n:number) {
    this.n = n
    this.fa = new Array<number>(n+1)
    for(let i=0;i<=this.n;i++) {
      this.fa[i] = i
    }
  }

  get(x:number): number {
    return this.fa[x] = (this.fa[x] === x ? x : this.get(this.fa[x]))
  }

  merge(a: number,b:number):void {
    this.fa[this.get(a)] = this.get(b)
  }
}


function findCircleNum(isConnected: number[][]): number {
  const n:number = isConnected.length
  const unionSet = new UnionSet(n)
  for(let i=0;i<n;i++) {
    for(let j=0;j<i;j++) {
      if(isConnected[i][j]) unionSet.merge(i,j)
    }
  }
  let ans = 0
  for(let i=0;i<n;i++){
    if(unionSet.get(i) === i) ans+=1
  }
  return ans
};
