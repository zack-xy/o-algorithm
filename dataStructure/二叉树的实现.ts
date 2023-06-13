/* eslint-disable @typescript-eslint/no-unused-vars */
// 二叉树的第1级，最多只有1个节点
// 二叉树的第2级，最多只有2个节点
// 二叉树的第3级，最多只有4个节点
// ...
// ...
// 二叉树的第N级，最多只有2^(N-1)个节点
// 二叉树一共最多有1+2+...+2^(N-1) = 2^N - 1个节点

// 数组实现
// 缺失节点标记为undefined
// 父节点位于索引i (索引从1开始，所以数组大小会多1)
// 左侧子节点位于索引2*i
// 右侧子节点位于索引2*i+1

// 数组实现：如果需要增加级别，需要复制整个树
// 需要使数组的大小加倍，以便为所有可能追加的新节点留出空间

class Tree {
  nodes: (number | undefined)[] = []

  left_child_index(index: number): number {
    return index * 2
  }

  right_child_index(index: number): number {
    return index * 2 + 1
  }

  add_level() {
    const newNodes: (number | undefined)[] = new Array(this.nodes.length * 2 + 1)

    for (let i = 0; i < this.nodes.length; i++)
      newNodes[i] = this.nodes[i]

    this.nodes = newNodes
  }
}

// 上面的实现有什么问题？
// 如果稀疏二叉树，会有很多额外的空的空间浪费
// 解决就是使用引用实现
// 存储left或right属性
// 紧凑二叉树的实现
class TreeNode {
  value: number
  left: TreeNode | undefined
  right: TreeNode | undefined

  constructor(value: number) {
    this.value = value
    this.left = undefined
    this.right = undefined
  }
}
