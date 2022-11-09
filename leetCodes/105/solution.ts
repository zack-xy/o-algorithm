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

// 在前序和中序中找到根节点 步骤1
// 获得左子树的前序和中序
// 获得右子树的前序和中序
// 递归恢复左子树，递归恢复右子树
function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
  if(preorder.length === 0) return null
  let pos = 0 // 根节点的位置
  // 题目保证了没有重复元素
  while(inorder[pos]!==preorder[0]) ++pos
  const l_pre:number[] = []
  const l_in:number[] = []
  const r_pre:number[] = []
  const r_in:number[] = []
  for(let i = 0;i<pos;i++) {
    l_pre.push(preorder[i+1])
    l_in.push(inorder[i])
  }
  for(let i = pos + 1;i<preorder.length;i++) {
    r_pre.push(preorder[i])
    r_in.push(inorder[i])
  }
  const root = new TreeNode(preorder[0], buildTree(l_pre, l_in), buildTree(r_pre, r_in))
  return root
};


