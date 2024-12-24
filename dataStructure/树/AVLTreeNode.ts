// AVL树节点
// 增加height --- 节点高度
class TreeNode {
  val: number;  // 节点值
  height: number;  // 节点高度
  left: TreeNode | null;  // 左子节点指针
  right: TreeNode | null; // 右子节点指针

  constructor(
    val?: number,
    height?: number,
    left?: TreeNode | null,
    right?: TreeNode | null
  ) {
    this.val = val === undefined ? 0 : val;
    this.height = height === undefined ? 0 : height;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

export { TreeNode }
