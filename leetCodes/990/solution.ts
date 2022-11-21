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

// 认为相等关系就是连通性关系
function equationsPossible(equations: string[]): boolean {
  const unionSet = new UnionSet(26)
  
  // 如题目提示，这里的表达式只会是小写字母加==或者!=加小写字母
  for(let s of equations) {
    if(s[1] === '!') continue
    const a:number = (s[0] as string)!.charCodeAt(0) - 'a'.charCodeAt(0)
    const b:number = (s[3] as string)!.charCodeAt(0) - 'a'.charCodeAt(0)
    unionSet.merge(a, b)
  }
  for(let s of equations) {
    if(s[1] === '=') continue
    const a:number = (s[0] as string)!.charCodeAt(0) - 'a'.charCodeAt(0)
    const b:number = (s[3] as string)!.charCodeAt(0) - 'a'.charCodeAt(0)
    // 如果在不等式中，两边的符号在同一集合中，则发生冲突
    if(unionSet.get(a) === unionSet.get(b)) return false
  }
  return true
};

