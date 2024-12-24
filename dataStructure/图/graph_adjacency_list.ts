import { Vertex } from './Vertex';

// 基于邻接表实现的无向图类
class GraphAdjList {
  // 邻接表，key：顶点，value：该顶点所有邻接顶点
  adjList: Map<Vertex, Vertex[]>;

  // 参数的数据格式是下面这种
  // 表示两个点和两个点之间是邻接的，也就是边
  // [[Vertex, Vertex],[Vertex,Vertex]]
  constructor(edges: Vertex[][]) {
    this.adjList = new Map();
    // 添加所有顶点和边
    for(const edge of edges) {
      this.addVertex(edge[0]);
      this.addVertex(edge[1]);
      this.addEdge(edge[0],edge[1]);
    }
  }

  // 获取顶点数量
  size(): number {
    return this.adjList.size;
  }

  // 添加边
  addEdge(vet1: Vertex, vet2: Vertex): void {
    // 如果没有顶点vet1
    // 或者没有顶点vet2
    // 或者vet1顶点和vet2顶点是同一个顶点，都不能添加边
    if(
      !this.adjList.has(vet1) ||
      !this.adjList.has(vet2) ||
      vet1 === vet2
    ) {
      throw new Error('Illegal Argument Exception');
    }
    this.adjList.get(vet1)!.push(vet2);
    this.adjList.get(vet2)!.push(vet1);
  }

  // 删除边
  removeEdge(vet1: Vertex, vet2: Vertex): void {
    if(
      !this.adjList.has(vet1) ||
      !this.adjList.has(vet2) ||
      vet1 === vet2
    ) {
      throw new Error('Illegal Argument Exception');
    }
    // 删除边
    this.adjList.get(vet1)!.splice(this.adjList.get(vet1)!.indexOf(vet2), 1);
    this.adjList.get(vet2)!.splice(this.adjList.get(vet2)!.indexOf(vet1), 1)
  }

  // 添加顶点
  addVertex(vet: Vertex): void {
    if(this.adjList.has(vet)) return;
    this.adjList.set(vet, []);
  }

  // 删除顶点
  removeVertex(vet: Vertex): void {
    if(!this.adjList.has(vet)) {
      throw new Error('Illegal Argument Exception');
    }
    this.adjList.delete(vet);
    for(const set of this.adjList.values()) {
      const index = set.indexOf(vet);
      if(index > -1) {
        set.splice(index, 1);
      }
    }
  }

  // 打印邻接表
  print(): void {
    console.log('邻接表 = ');
    for(const [key,value] of this.adjList.entries()) {
      const tmp: number[] = [];
      for(const vertex of value) {
        tmp.push(vertex.val);
      }
      console.log(key.val + ': ' + tmp.join());
    }
  }
}

export { GraphAdjList }
