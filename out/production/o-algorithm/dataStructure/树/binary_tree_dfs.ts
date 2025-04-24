import { TreeNode } from './TreeNode';

const list: number[] = [];

// 前序遍历
function preOrder(root: TreeNode | null): void {
  if(root === null) return;
  // 访问优先级：根节点 -> 左子树 -> 右子树
  list.push(root.val);
  preOrder(root.left);
  preOrder(root.right);
}

// 中序遍历
function inOrder(root: TreeNode | null): void {
  if(root === null) return;
  // 访问优先级：左子树 -> 根节点 -> 右子树
  inOrder(root.left);
  list.push(root.val);
  inOrder(root.right);
}

// 后序遍历
function postOrder(root: TreeNode | null): void {
  if(root === null) return;
  postOrder(root.left);
  postOrder(root.right);
  list.push(root.val);
}
