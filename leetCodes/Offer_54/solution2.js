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
const inOrder = function (root, ans) {
  if (root === null)
    return
  inOrder(root.left, ans)
  ans.push(root.val)
  inOrder(root.right, ans)
}
const kthLargest = function (root, k) {
  const ans = []
  inOrder(root, ans)
  return ans[ans.length - k]
}
