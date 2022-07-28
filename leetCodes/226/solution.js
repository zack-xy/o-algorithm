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
 * @return {TreeNode}
 */
 const swap = function (root) {
  const temp = root.left
  root.left = root.right
  root.right = temp
}
const invertTree = function (root) {
  if (root === null)
    return root
  swap(root)
  invertTree(root.left)
  invertTree(root.right)
  return root
}
