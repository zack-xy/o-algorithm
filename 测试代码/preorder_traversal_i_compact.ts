import { TreeNode } from 'dataStructure/树/TreeNode';

// 给定一棵二叉树，搜索并记录所有值为7的节点，返回节点列表

// 前序遍历
function preOrder(root: TreeNode | null, res: TreeNode[]): void {
  if(root === null) {
    return;
  }
  if(root.val === 7) {
    res.push(root);
  }
  preOrder(root.left, res);
  preOrder(root.right, res);
}


// 在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径
function preOrder2(
  root: TreeNode | null,
  path: TreeNode[],
  res: TreeNode[][]
): void {
  if(root === null) {
    return;
  }
  // 尝试
  path.push(root);
  if(root.val === 7) {
    // 记录解
    res.push([...path]);
  }
  preOrder2(root.left, path, res);
  preOrder2(root.right, path, res);
  // 回退
  path.pop();
}


// 在二叉树中搜索所有值为7的节点，请返回根节点到这个节点的路径，并要求路径中不包含3的节点
function preOrder3(
  root: TreeNode | null,
  path: TreeNode[],
  res: TreeNode[][]
): void {
  // 剪枝
  if(root === null || root.val === 3) {
    return;
  }
  // 尝试
  path.push(root);
  if(root.val === 7) {
    // 记录解
    res.push([...path]);
  }
  preOrder3(root.left, path, res);
  preOrder3(root.right, path, res);
  // 回退
  path.pop();
}
