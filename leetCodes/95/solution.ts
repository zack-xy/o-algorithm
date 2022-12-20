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

// 二叉搜索树：我左边的节点小于我，我右边的节点大于我
function dfs(l: number, r: number): Array<TreeNode | null> {
  const ans: Array<TreeNode | null> = []

  if (l > r) {
    ans.push(null)
    return ans
  }

  for (let i = l; i <= r; i++) {
    const leftTree = dfs(l, i - 1)
    const rightTree = dfs(i + 1, r)

    for (const left of leftTree) {
      for (const right of rightTree) {
        const t = new TreeNode(i, left, right)
        ans.push(t)
      }
    }
  }

  return ans
}

function generateTrees(n: number): Array<TreeNode | null> {
  const ans: Array<TreeNode | null> = []
  if (n === 0)
    return ans
  return dfs(1, n)
}
