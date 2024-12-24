import { Vertex } from './Vertex';
import { GraphAdjList } from './graph_adjacency_list';

// 深度优先遍历辅助函数
function dfs(
  graph: GraphAdjList,
  visited: Set<Vertex>,
  res: Vertex[],
  vet: Vertex
): void {
  res.push(vet); // 记录访问顶点
  visited.add(vet); // 标记该顶点已被访问
  for(const adjVet of graph.adjList.get(vet) ?? []) {
    if(visited.has(adjVet)) continue;
    dfs(graph, visited, res, adjVet);
  }
}

// 深度优先遍历
// 使用邻接表表示图，以便获取指定顶点和所有邻接顶点
function graphDFS(graph: GraphAdjList, startVet: Vertex): Vertex[] {
  // 顶点遍历序列
  const res: Vertex[] = [];
  // 哈希集合，用于记录已被访问过的顶点
  const visited: Set<Vertex> = new Set();
  dfs(graph, visited, res, startVet);
  return res;
}



