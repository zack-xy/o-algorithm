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

// 二维坐标转换为一维编号，编号从1开始
function numIslands(grid: string[][]): number {
  const n:number = grid.length  // 列
  const m:number = grid[0].length // 行
  const unionSet = new UnionSet(n*m)
  const ind = (i:number, j: number):number => {
    return Number(i) * m + Number(j)
  }
  for(let i=0;i<n;i++) {
    for(let j=0;j<m;j++) {
      if(grid[i][j]==='0') continue
      // 每次连接两个方向，上和左，这里只需要连接上左即可，因为后续的循环自会连接
      if(i > 0 && grid[i-1][j]==='1') unionSet.merge(ind(i,j), ind(i-1,j)) 
      if(j > 0 && grid[i][j-1] === '1') unionSet.merge(ind(i, j), ind(i, j-1))
    }
  }

  let ans:number = 0
  for(let i=0;i<n;i++){
    for(let j=0;j<m;j++) {
      if(grid[i][j] === '1' && unionSet.get(ind(i,j)) === ind(i,j)) ans+=1
    }
  }
  return ans
};
