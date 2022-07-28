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
 * @return {number[][]}
 */
 const getResult = function (root, k, ans) {
  if (root === null)
    return
  if (k === ans.length)
    ans.push([])
  ans[k].push(root.val)
  getResult(root.left, k + 1, ans)
  getResult(root.right, k + 1, ans)
}
const zigzagLevelOrder = function (root) {
  const ans = []
  getResult(root, 0, ans)
  for (let i = 1; i < ans.length; i += 2)
    ans[i] = ans[i].reverse()
  return ans
}
