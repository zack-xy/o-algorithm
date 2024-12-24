// 基于邻接矩阵实现的无向图
class GraphAdjMat {
  // 顶点列表，元素代表“顶点值”，索引代表“顶点索引”
  vertices: number[];
  // 邻接矩阵，行列索引对应“顶点索引”
  adjMat: number[][]; 

  constructor(vertices: number[], edges: number[][]) {
    this.vertices = [];
    this.adjMat = [];
    // 添加顶点
    for(const val of vertices) {
      this.addVertex(val);
    }
    // 添加边
    // edges元素代表顶点索引，即对应vertices元素索引
    for(const e of edges) {
      this.addEdge(e[0], e[1]);
    }
  }

  // 获取顶点数量
  size(): number {
    return this.vertices.length;
  }

  // 添加顶点
  addVertex(val: number): void {
    const n: number = this.size();
    this.vertices.push(val);
    // 在邻接矩阵中添加一行
    const newRow: number[] = [];
    for(let j=0;j<n;j++) {
      newRow.push(0);
    }
    this.adjMat.push(newRow);
    for(const row of this.adjMat) {
      row.push(0);
    }
  }

  // 删除顶点
  removeVertex(index: number): void {
    if(index >= this.size()) {
      throw new RangeError('Index Out Of Bounds Exception');
    }
    this.vertices.splice(index, 1);
    this.adjMat.splice(index, 1);
    for(const row of this.adjMat) {
      row.splice(index, 1);
    }
  }

  // 添加边
  // 参数i，j对应 vertices 元素索引
  addEdge(i: number, j: number): void {
    if(i < 0 || j < 0 || i >= this.size() || j >= this.size() || i === j) {
      throw new RangeError('Index Out Of Bounds Exception');
    }
    this.adjMat[i][j] = 1;
    this.adjMat[j][i] = 1;
  }

  // 删除边
  removeEdge(i: number, j: number): void {
    // 索引越界与相等处理
    if(i < 0 || j < 0 || i >= this.size() || j >= this.size() || i === j) {
      throw new RangeError('Index Out Of Bounds Exception');
    }
    this.adjMat[i][j] = 0;
    this.adjMat[j][i] = 0;
  }

  // 打印邻接矩阵
  print(): void {
    console.log('顶点列表 = ', this.vertices);
    console.log('邻接矩阵 = ', this.adjMat);
  }
}
