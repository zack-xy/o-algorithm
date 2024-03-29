/* eslint-disable no-undef */
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
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
 const buildTree = function (preorder, inorder) {
  if (preorder.length===0)
    return null
  let pos = 0
  while (inorder[pos] !== preorder[0]) ++pos
  const l_pre = []
  const l_in = []
  const r_pre = []
  const r_in = []
  for (let i = 0; i < pos; i++) {
    l_pre.push(preorder[i + 1])
    l_in.push(inorder[i])
  }
  for (let i = pos + 1; i < preorder.length; i++) {
    r_pre.push(preorder[i])
    r_in.push(inorder[i])
  }
  const root = new TreeNode(preorder[0])
  root.left = buildTree(l_pre, l_in)
  root.right = buildTree(r_pre, r_in)
  return root
}
