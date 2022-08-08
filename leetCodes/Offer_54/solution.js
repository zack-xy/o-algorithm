/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
// 二叉搜索树：右子树节点大于根节点，左子树小于根节点
// 所以中序遍历的结果是一个有序序列
const getCount = function (root) {
  if (root === null)
    return 0
  return getCount(root.left) + getCount(root.right) + 1
}
const kthLargest = function (root, k) {
  const cnt_r = getCount(root.right)
  if (k <= cnt_r)
    return kthLargest(root.right, k)
  if (k === cnt_r + 1)
    return root.val
  return kthLargest(root.left, k - cnt_r - 1)
}
