import Dictionary from './jsDictionary';
import Queue from './jsObjectQueue';
import Stack from './jsObjectStack'


const Colors = {
  WHITE: 0,
  GREY: 1,
  BLACK: 2
}

const initializeColor = vertices => {
  const color = {}
  for (let i = 0; i < vertices.length; i++) {
    color[vertices[i]] = Colors.WHITE
  }
  return color
}

// 广度优先搜索算法BFS
export const breadthFirstSearch = (graph, startVertex, callback) => {
  const vertices = graph.getVertices()
  const adjList = graph.getAdjList()
  const color = initializeColor(vertices)
  const queue = new Queue()
  queue.enqueue(startVertex)
  while (!queue.isEmpty()) {
    const u = queue.dequeue()
    const neighbors = adjList.get(u)
    color[u] = Colors.GREY
    for (let i = 0; i < neighbors.length; i++) {
      const w = neighbors[i]
      if (color[w] === Colors.WHITE) {
        color[w] = Colors.GREY
        queue.enqueue(w)
      }
    }
    color[u] = Colors.BLACK
    if (callback) {
      callback(u)
    }
  }
}


// 利用BFS解决
// 给定图G和源顶点v，找出每个顶点u和v之间最短路径的距离
const BFS = (graph, startVertex) => {
  const vertices = graph.getVertices()
  const adjList = graph.getAdjList()
  const color = initializeColor(vertices)
  const queue = new Queue()
  const distances = {}
  const predecessors = {}
  queue.enqueue(startVertex)

  for (let i = 0; i < vertices.length; i++) {
    distances[vertices[i]] = 0
    predecessors[vertices[i]] = null
  }

  while (!queue.isEmpty()) {
    const u = queue.dequeue()
    const neighbors = adjList.get(u)
    color[u] = Colors.GREY
    for (let i = 0; i < neighbors.length; i++) {
      const w = neighbors[i]
      if (color[w] === Colors.WHITE) {
        color[w] = Colors.GREY
        distances[w] = distances[u] + 1
        predecessors[w] = u
        queue.enqueue(w)
      }
    }
    color[u] = Colors.BLACK
  }
  return {
    distances,
    predecessors
  }
}


/**
 * // 构建从顶点到其他顶点的路径
    const shortestPathA = BFS(graph, myVertices[0])
    const fromVertex = myVertices[0]
    for(i=1;i<myVertices.length;i++) {
        const toVertex = myVertices[i]
        const path = new Stack()
        for(let v = toVertex;v!==fromVertex;v=shortestPathA.predecessors[v]) {
            path.push(v)
        }
        path.push(fromVertex)
        let s = path.pop()
        while(!path.isEmpty()) {
            s += '-' + path.pop()
        }
        console.log(s)
    }
 */


// 深度优先搜索算法DFS
export const depthFirstSearch = (graph, callback) => {
  const vertices = graph.getVertices()
  const adjList = graph.getAdjList()
  const color = initializeColor(vertices)

  for (let i = 0; i < vertices.length; i++) {
    if (color[vertices[i]] === Colors.WHITE) {
      depthFirstSearchVisit(vertices[i], color, adjList, callback)
    }
  }
}

const depthFirstSearchVisit = (u, color, adjList, callback) => {
  color[u] = Colors.GREY
  if (callback) {
    callback(u)
  }
  const neighbors = adjList.get(u)
  for (let i = 0; i < neighbors.length; i++) {
    const w = neighbors[i]
    if (color[w] === Colors.WHITE) {
      depthFirstSearchVisit(w, color, adjList, callback)
    }
  }
  color[u] = Colors.BLACK
}

// 利用DFS解决
// 构建有根树的集合
const DFS = graph => {
  const vertices = graph.getVertices()
  const adjList = graph.getAdjList()
  const color = initializeColor(vertices)
  const d = {}
  const f = {}
  const p = {}
  const time = { count: 0 }
  for (let i = 0; i < vertices.length; i++) {
    f[vertices[i]] = 0
    d[vertices[i]] = 0
    p[vertices[i]] = null
  }
  for (let i = 0; i < vertices.length; i++) {
    if (color[vertices[i]] === Colors.WHITE) {
      DFSVisit(vertices[i], color, d, f, p, time, adjList)
    }
  }
  return {
    discovery: d,
    finished: f,
    predecessors: p
  }
}

const DFSVisit = (u, color, d, f, p, time, adjList) => {
  color[u] = Colors.GREY
  d[u] = ++time.count
  const neighbors = adjList.get(u)
  for (let i = 0; i < neighbors.length; i++) {
    const w = neighbors[i]
    if (color[w] === Colors.WHITE) {
      p[w] = u
      DFSVisit(w, color, d, f, p, time, adjList)
    }
  }
  color[u] = Colors.BLACK
  f[u] = ++time.count
}

export default class Graph {
  constructor(isDirected = false) {
    // 是否有向
    this.isDirected = isDirected
    // 存储所有顶点名字
    this.vertices = []
    // 存储邻接表，顶点名字作为键，邻接顶点列表作为值
    this.adjList = new Dictionary()
  }


  // 向图中添加新顶点
  addVertex (v) {
    if (!this.vertices.includes(v)) {
      this.vertices.push(v)
      this.adjList.set(v, [])
    }
  }

  // 维护邻接表
  addEdge (v, w) {
    if (!this.adjList.get(v)) {
      this.addVertex(v)
    }
    if (!this.adjList.get(w)) {
      this.addVertex(w)
    }
    this.adjList.get(v).push(w)
    if (!this.isDirected) {
      this.adjList.get(w).push(v)
    }
  }

  // 返回顶点列表
  getVertices () {
    return this.vertices
  }

  // 返回邻接表
  getAdjList () {
    return this.adjList
  }

  toString () {
    let s = ''
    for (let i = 0; i < this.vertices.length; i++) {
      s += `${this.vertices[i]} -> `
      const neighbors = this.adjList.get(this.vertices[i])
      for (let j = 0; j < neighbors.length; j++) {
        s += `${neighbors[j]}`
      }
      s += `\n`
    }
    return s
  }
}