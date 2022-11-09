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

 const reverse = (arr: Array<unknown>) => {
  for(let i=0,j=arr.length-1;i<j;i++,j--) {
    const temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
  }
  return 
}

const getResult = (root: TreeNode | null, k: number, ans: Array<Array<number>>) => {
  if(root === null) return
  if(k === ans.length) ans.push(new Array<number>())
  ans[k].push(root.val)
  getResult(root.left, k+1, ans)
  getResult(root.right, k+1, ans)
  return
}
 function zigzagLevelOrder(root: TreeNode | null): number[][] {
  const result:number[][] = new Array<Array<number>>()
  getResult(root, 0, result)
  for(let i=1;i<result.length;i+=2) {
    reverse(result[i])
  }
  return result
};
