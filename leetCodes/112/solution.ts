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

 function hasPathSum(root: TreeNode | null, targetSum: number): boolean {
  if(root === null) return false
  if(root.left === null && root.right === null) return root.val === targetSum
  if(root.left && hasPathSum(root.left, targetSum - root.val)) return true
  if(root.right && hasPathSum(root.right, targetSum - root.val)) return true
  return false
};
