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

// 第一个索引表示父节点是否放置摄像头
// 第二个索引表示当前节点是否放置摄像头
// 存储的值表示满足上面情况下，放置的最少摄像头
// 比如[0,1]表示在父节点不放置摄像头，当前节点放置摄像头下，需要放置的最少摄像头
type NumNull = number | null
type NumTuple = [NumNull, NumNull]
type Deps = [NumTuple, NumTuple]

const getDep = function(root: TreeNode | null, dp: Deps) : void {
  if(root === null) {
    dp[0][0] = 0
    dp[0][1] = 10000
    dp[1][0] = 0
    dp[1][1] = 10000
    return
  }
  if(root.left === null && root.right === null) {
    dp[0][0] = 10000
    dp[0][1] = 1
    dp[1][0] = 0
    dp[1][1] = 1
    return
  }
  const lDep:Deps = [[null, null],[null,null]]
  const rDep:Deps = [[null, null],[null,null]]
  getDep(root.left, lDep)
  getDep(root.right, rDep)
  dp[0][0] = Math.min(Math.min(lDep[0][1] + rDep[0][0], lDep[0][0] + rDep[0][1]), lDep[0][1] + rDep[0][1])
  dp[1][0] = Math.min(dp[0][0], lDep[0][0] + rDep[0][0])
  dp[0][1] = Math.min(Math.min(lDep[1][0] + rDep[1][0], lDep[1][1] + rDep[1][1]), Math.min(lDep[1][0]+rDep[1][1],lDep[1][1]+rDep[1][0])) + 1
  dp[1][1] = dp[0][1]
  return
}

 function minCameraCover(root: TreeNode | null): number {
  const dp:Deps = [[null, null],[null,null]]
  getDep(root, dp)
  return Math.min(dp[0][1], dp[0][0])
};
