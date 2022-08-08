/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
 function NodeInt(root, int) {
  this.node = root
  this.int = int
}
const widthOfBinaryTree = function (root) {
  let ans = 0
  const queue = []
  queue.push(new NodeInt(root, 0))
  while (queue.length > 0) {
    const cnt = queue.length
    const l = queue[0].int
    let r = queue[0].int
    for (let i = 0; i < cnt; i++) {
      const { node, int } = queue[0]
      r = int
      if (node && node.left)
        queue.push(new NodeInt(node.left, (int - l) * 2))
      if (node && node.right)
        queue.push(new NodeInt(node.right, (int - l) * 2 + 1))
      queue.shift()
    }
    ans = Math.max(ans, r - l + 1)
  }
  return ans
}
