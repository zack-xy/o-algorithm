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
const isMatch = function(A: TreeNode | null, B: TreeNode | null): boolean {
  if(B === null) return true
  if(A === null) return false
  if(A.val !== B.val) return false
  return isMatch(A.left, B.left) && isMatch(A.right, B.right)

}

function isSubStructure(A: TreeNode | null, B: TreeNode | null): boolean {
  if(B === null || A === null) return false
  if(A.val === B.val && isMatch(A,B)) return true
  return isSubStructure(A.left, B) || isSubStructure(A.right, B)
};
