import { GraphAdjList } from './graph_adjacency_list';
import { Vertex } from './Vertex';

// 广度优先遍历
// 使用邻接表表示图，以便获取指定顶点的所有邻接顶点
function graphBFS(graph: GraphAdjList, startVet: Vertex): Vertex[] {
  // 顶点遍历序列,函数最终的返回
  const res: Vertex[] = [];
  // 哈希集合，用于记录已被访问过的顶点
  const visited: Set<Vertex> = new Set();
  visited.add(startVet);
  // 队列用于实现BFS
  const que = [startVet];
  // 以顶点vet为起点，循环直至访问完所有顶点
  while(que.length) {
    const vet = que.shift()
    res.push(vet!);
    // 遍历该顶点的所有邻接顶点
    for(const adjVet of graph.adjList.get(vet!) ?? []) {
      if(visited.has(adjVet)) continue;
      que.push(adjVet);
      visited.add(adjVet);
    }
  }
  return res;
}
