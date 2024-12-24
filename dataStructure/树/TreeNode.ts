// 二叉树节点类
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;  // 节点值
    this.left = left === undefined ? null : left;  // 左子节点引用
    this.right = right === undefined ? null : right; // 右子节点引用
  }
}

export { TreeNode }
