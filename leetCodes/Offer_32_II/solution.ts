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

 const getResult = (node: TreeNode | null, k: number, ans: number[][]) => {
  if(node === null) return
  if(k === ans.length) ans.push(new Array<number>())
  ans[k].push(node.val)
  getResult(node.left, k+1, ans)
  getResult(node.right, k+1, ans)
  return 
}

 function levelOrder(root: TreeNode | null): number[][] {
  const ans:number[][] = new Array<Array<number>>()
  getResult(root, 0, ans)
  return ans
};
