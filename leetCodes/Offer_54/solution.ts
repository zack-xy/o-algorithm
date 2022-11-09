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

// 二叉搜索树：左节点都小于根节点，右节点都大于根节点
const getCount = (root: TreeNode | null) => {
  if(root === null) return 0
  return getCount(root.left) + getCount(root.right) + 1
}
 function kthLargest(root: TreeNode | null, k: number): number {
  let cnt_r = getCount(root.right)
  if(k <= cnt_r) return kthLargest(root.right, k)
  if(k === cnt_r+1) return root.val
  return kthLargest(root.left, k - cnt_r - 1)
};
