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
 
type Pair = [TreeNode | null, number]
 
function widthOfBinaryTree(root: TreeNode | null): number {
  let ans = 0
  const queue: Pair[] = []
  queue.push([root, 0])
  while(queue.length > 0) {
    const cnt = queue.length
    const l = queue[0][1]
    let r = queue[0][1]
    for(let i=0;i<cnt;i++) {
      const node = queue[0][0]
      const ind= queue[0][1]
      r = ind
      // 处理编号的技巧：节点编号等于（父节点编号-上一行最小编号）*2 或 （父节点编号-上一行最小编号）*2 + 1
      if(node && node.left) queue.push([node.left, (ind - l)*2])
      if(node && node.right) queue.push([node.right, (ind - l)*2+1])
      queue.shift()
    }
    ans = Math.max(ans, r-l+1)
  }
  return ans
}
