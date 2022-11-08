/* 
 * Definition for node.
 * class Node {
 *     val: number
 *     children: Node[]
 *     constructor(val?: number) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.children = []
 *     }
 * }
 */

const preorderNTree = (node: Node | null, ans: number[]) => {
  if(node === null) return
  ans.push(node.val)
  for (const childNode of node.children) {
    preorderNTree(childNode, ans)
  }
  return
}

 function preorder(root: Node | null): number[] {
  const ans:number[] = []
  preorderNTree(root, ans)
  return ans
};


