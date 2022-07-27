/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number[]}
 */

// N叉树的前序遍历：
// 1. 函数意义：前序遍历以root为根节点的N叉树
// 2. 边界条件：root为空时不需要遍历
// 3. 递归过程：前序遍历root下的每一棵子树
const __preorder = function (root, ans) {
  if (root === null)
    return
  ans.push(root.val)
  for (const item of root.children)
    __preorder(item, ans)
}
const preorder = function (root) {
  const ans = []
  __preorder(root, ans)
  return ans
}
