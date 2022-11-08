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

// 队列实现
 function levelOrder(root: TreeNode | null): number[][] {
  const queue: TreeNode[] = []
  const ans: number[][] = []
  if(root === null) return ans
  queue.push(root)
  while(queue.length > 0) {
    let numbers = new Array<number>()
    let size = queue.length
    while(size > 0) {
      let node = queue.shift()
      numbers.push(node.val)
      node.left && queue.push(node.left)
      node.right && queue.push(node.right)
      size--
    }
    ans.push(numbers)
  }
  return ans
};
