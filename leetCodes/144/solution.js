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
const preoder = function (root, ans) {
  if (root === null)
    return
  ans.push(root.val)
  preoder(root.left, ans)
  preoder(root.right, ans)
}
const preorderTraversal = function (root) {
  const ans = []
  preoder(root, ans)
  return ans
}
