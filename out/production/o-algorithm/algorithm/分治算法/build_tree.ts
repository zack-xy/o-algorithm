import { TreeNode } from '../../dataStructure/树/TreeNode';


// 给定一棵二叉树的前序遍历preorder和中序遍历inorder，请从中构建二叉树，返回二叉树的根节点。假设二叉树中没有值重复的节点

function dfs(
  preorder: number[],  // 前序遍历
  inorderMap: Map<number, number>,  // 中序遍历hash表
  i: number, // 当前树的根节点在preorder中的索引
  l: number,  // 当前树在inorder中的左边界
  r: number   // 当前树在inorder中的右边界
): TreeNode | null {
  // 子树区间为空时终止
  if(r - l < 0) return null;
  // 初始化根节点
  const root: TreeNode = new TreeNode(preorder[i]);
  // 查询m，从而划分左右子树
  const m = inorderMap.get(preorder[i])!;
  // 子问题：构建左子树
  root.left = dfs(preorder, inorderMap, i+1, l, m-1);
  // 子问题：构建右子树
  root.right = dfs(preorder, inorderMap, i+1+m-l, m+1, r);
  // 返回根节点
  return root;
}


// 构建二叉树
function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
  // 初始化哈希表，存储inorder元素到索引的映射
  let inorderMap = new Map<number, number>();
  for(let i=0;i<inorder.length;i++) {
    inorderMap.set(inorder[i], i);
  }
  const root = dfs(preorder, inorderMap, 0, 0, inorder.length-1);
  return root;
}
