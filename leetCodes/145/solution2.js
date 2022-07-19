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

// 后序遍历：左右根遍历
const postorderTraversal = function (root) {
  if (!root)
    return []
  const ret = []
  const s1 = []
  const s2 = [] // 程序状态栈
  s1.unshift(root)
  s2.unshift(0)
  while (s1.length > 0) {
    const status = s2[0]
    s2.shift()
    switch (status) {
      case 0: // 栈顶的左子树
        s2.unshift(1)
        if (s1[0].left) {
          s1.unshift(s1[0].left)
          s2.unshift(0)
        }
        break
      case 1: // 栈顶的右子树
        s2.unshift(2)
        if (s1[0].right) {
          s1.unshift(s1[0].right)
          s2.unshift(0)
        }
        break
      case 2: // 输出栈顶元素
        ret.push(s1[0].val)
        s1.shift()
        break
    }
  }
  return ret
}
