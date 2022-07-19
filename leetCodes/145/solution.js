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
 * @return {number[]}
 */

// 后序遍历：左右根遍历
const postorderTraversal = function (root) {
  const ret = []
  const postOrder = (root) => {
    if (!root)
      return
    postOrder(root.left)
    postOrder(root.right)
    ret.push(root.val)
  }
  postOrder(root)
  return ret
}
