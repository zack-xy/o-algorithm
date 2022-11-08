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
 const getResult = (root: TreeNode | null, k: number, ans: Array<Array<number>>) => {
  if(root === null) return
  if(k === ans.length) ans.push(new Array<number>())
  ans[k].push(root.val)
  getResult(root.left, k+1, ans)
  getResult(root.right, k+1, ans)
  return
}

const swap = (left: number[], right: number[]) => {
  let temp = left.slice()
  left.length = 0
  left.push(...right.slice())
  right.length = 0
  right.push(...temp)
}

 function levelOrderBottom(root: TreeNode | null): number[][] {
  const res = new Array<Array<number>>()
  getResult(root, 0, res)
  for(let i=0,j=res.length-1;i<j;i++,j--) {
    swap(res[i], res[j])
  }
  return res
};
