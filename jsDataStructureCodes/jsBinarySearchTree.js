export const Compare = {
  LESS_THAN: -1,
  BIGGER_THAN: 1,
  EQUALS: 0
};


export function defaultCompare (a, b) {
  if (a === b) {
    return Compare.EQUALS;
  }
  return a < b ? Compare.LESS_THAN : Compare.BIGGER_THAN;
}


export class Node {
  constructor(key) {
    this.key = key
    this.left = null
    this.right = null
  }
}

export default class BinarySearchTree {
  constructor(compareFn = defaultCompare) {
    this.compareFn = compareFn
    this.root = null
  }

  // 向树中插入一个新键
  insert (key) {
    if (this.root == null) {
      this.root = new Node(key)
    } else {
      this.insertNode(this.root, key)
    }
  }

  insertNode (node, key) {
    if (this.compareFn(key, node.key) === Compare.LESS_THAN) {
      if (node.left == null) {
        node.left = new Node(key)
      } else {
        this.insertNode(node.left, key)
      }
    } else {
      if (node.right == null) {
        node.right = new Node(key)
      } else {
        this.insertNode(node.right, key)
      }
    }
  }

  // 查找键，存在返回true，不存在返回false
  search (key) {
    return this.searchNode(this.root, key)
  }

  searchNode (node, key) {
    if (node == null) {
      return false
    }
    if (this.compareFn(key, node.key) === Compare.LESS_THAN) {
      return this.searchNode(node.left, key)
    } else if (this.compareFn(key, node.key) === Compare.BIGGER_THAN) {
      return this.searchNode(node.right, key)
    } else {
      return true
    }
  }

  // 通过中序遍历所有节点
  // 中序遍历是一种以上行顺序访问BST(二叉搜索树)所有节点的遍历方式
  // 就是从小到大的顺序访问所有节点
  // 中序遍历的一种应用就是对树进行排序操作
  inOrderTraverse (callback) {
    this.inOrderTraverseNode(this.root, callback)
  }

  inOrderTraverseNode (node, callback) {
    if (node != null) {
      this.inOrderTraverseNode(node.left, callback)
      callback(node.key)
      this.inOrderTraverseNode(node.right, callback)
    }
  }

  // 通过先序遍历所有节点
  // 先序遍历是以优先于后代节点的顺序访问每个节点
  // 个人理解：先把树左侧遍历完，遍历完左侧紧接着遍历兄弟右侧及父至左侧循环
  // 先序遍历的一种应用是打印一个结构化的文档
  preOrderTraverse (callback) {
    this.preOrderTraverseNode(this.root, callback)
  }

  preOrderTraverseNode (node, callback) {
    if (node != null) {
      callback(node.key)
      this.preOrderTraverseNode(node.left, callback)
      this.preOrderTraverseNode(node.right, callback)
    }
  }

  // 通过后序遍历所有节点
  // 后序遍历是先访问节点的后代节点，再访问节点本身
  // 后续遍历的一种应用是计算一个目录及其子目录中所有文件所占用空间的大小
  postOrderTraverse (callback) {
    this.postOrderTraverseNode(this.root, callback)
  }

  postOrderTraverseNode (node, callback) {
    if (node != null) {
      this.postOrderTraverseNode(node.left, callback)
      this.postOrderTraverseNode(node.right, callback)
      callback(node.key)
    }
  }

  // 返回树中最小的值
  min () {
    return this.minNode(this.root)
  }

  minNode (node) {
    let current = node
    while (current != null && current.left != null) {
      current = current.left
    }
    return current
  }

  // 返回树中最大的值
  max () {
    return this.maxNode(this.root)
  }

  maxNode (node) {
    let current = node
    while (current != null && current.right != null) {
      current = current.right
    }
    return current
  }

  // 从树中移除某个键
  remove (key) {
    this.root = this.removeNode(this.root, key)
  }

  removeNode (node, key) {
    if (node == null) {
      return null
    }
    if (this.compareFn(key, node.key) === Compare.LESS_THAN) {
      node.left = this.removeNode(node.left, key)
      return node
    } else if (this.compareFn(key, node.key) === Compare.BIGGER_THAN) {
      node.right = this.removeNode(node.right, key)
      return node
    } else {
      // 找到节点
      // 处理3种情况
      // 1 - 叶子节点，没有子节点
      // 2 - 只有1个子节点
      // 3 - 有2个子节点
      // 情况 1
      if (node.left == null && node.right == null) {
        node = null
        return node
      }
      // 情况 2
      if (node.left == null) {
        node = node.right
        return node
      } else if (node.right == null) {
        node = node.left
        return node
      }
      // 情况 3
      // 找到右侧树最小的节点a
      // 将a的值替换当前节点
      // 移除节点a
      const aux = this.minNode(node.right)
      node.key = aux.key
      node.right = this.removeNode(node.right, aux.key)
      return node
    }
  }
}