/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

 const getHeight = function(root: TreeNode | null): number {
  if(root === null) return 0
  let l = getHeight(root.left)
  let r = getHeight(root.right)
  if(l < 0 || r < 0) return -2
  if(Math.abs(l-r) > 1) return -2
  return Math.max(l, r) + 1
 }

 function isBalanced(root: TreeNode | null): boolean {
  return getHeight(root) >= 0
};
