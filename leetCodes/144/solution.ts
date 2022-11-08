// class TreeNode {
//   val: number
//   left: TreeNode | null
//   right: TreeNode | null
//   constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
//       this.val = (val===undefined ? 0 : val)
//       this.left = (left===undefined ? null : left)
//       this.right = (right===undefined ? null : right)
//   }
// }


function preorderTraversal(root: TreeNode | null): number[] {
const ans: number[] = []
preorder(root, ans)
return ans
};


const preorder = (node: TreeNode | null, ans: number[]) => {
  if(node === null) return
  ans.push(node.val)
  preorder(node.left, ans)
  preorder(node.right, ans)
  return
}
