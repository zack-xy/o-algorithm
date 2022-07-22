/* eslint-disable no-console */
/* eslint-disable @typescript-eslint/no-unused-vars */
// 二叉树节点
class Node {
  constructor(key) {
    this.key = key
    this.left = null
    this.right = null
  }
}

// 向树中随机插入节点
const randomInsert = function (root, key) {
  if (root === null)
    return new Node(key)
  // 随机向左子树和右子树插入节点
  // 如果随机数[1-4]整除2，插入右子树，否则插入左子树
  if (Math.floor((Math.random() * 4 + 1)) % 2)
    root.left = randomInsert(root.left, key)

  else
    root.right = randomInsert(root.right, key)

  return root
}

// 前序遍历：根 左 右
const preOrder = function (root, nodes = []) {
  if (root === null)
    return
  nodes.push(root.key)
  preOrder(root.left, nodes)
  preOrder(root.right, nodes)
  return nodes
}

// 中序遍历： 左 根 右
const inOrder = function (root, nodes = []) {
  if (root === null)
    return
  inOrder(root.left, nodes)
  nodes.push(root.key)
  inOrder(root.right, nodes)
  return nodes
}

// 生成一个maxNum个节点的二叉树
const generateBinaryTree = function (maxNum) {
  let root = null
  for (let i = 1; i <= maxNum; i++)
    root = randomInsert(root, i)

  console.log('二叉树>>', root)
  console.log('前序>', preOrder(root).join(' ')) // 前序遍历
  console.log('中序>', inOrder(root).join(' ')) // 中序遍历
}
