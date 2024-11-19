import { TreeNode } from './TreeNode';

// 二叉搜索树
class BinarySearchTree {
  private root: TreeNode | null;

  constructor() {
    this.root = null;
  }

  // 获取二叉树根节点
  getRoot(): TreeNode | null {
    return this.root;
  }

  // 查找节点
  search(num: number): TreeNode | null {
    let cur = this.root;
    while(cur !== null) {
      if(cur.val < num) cur = cur.right;
      else if(cur.val > num) cur = cur.left;
      else break;
     }
     return cur;
  }

  // 插入节点
  insert(num: number): void {
    // 若树为空，则初始化根节点
    if(this.root === null) {
      this.root = new TreeNode(num);
      return;
    }
    let cur: TreeNode | null = this.root,
    pre: TreeNode | null = null;
    // 循环查找，越过叶节点后跳出
    while(cur !== null) {
      if(cur.val === num) return;
      pre = cur;
      if(cur.val < num) cur = cur.right;
      else cur = cur.left;
    }
    // 插入节点
    const node = new TreeNode(num);
    if(pre!.val < num) pre!.right = node;
    else pre!.left = node;
  }

  // 删除节点
  remove(num: number): void {
    // 若树为空，直接提前返回
    if(this.root === null) return;
    let cur: TreeNode | null = this.root,
    pre: TreeNode | null = null;
    // 循环查找，越过叶节点后跳出
    while(cur !== null) {
      if(cur.val === num) break;
      pre = cur;
      if(cur.val < num) cur = cur.right;
      else cur = cur.left;
    }
    if(cur === null) return;
    // 子节点数量 = 0 or 1
    if(cur.left === null || cur.right === null) {
      // 当子节点数量 = 0 / 1 
      const child: TreeNode | null = cur.left !== null ? cur.left : cur.right;
      // 删除节点cur
      if(cur !== this.root) {
        if(pre!.left === cur) pre!.left = child;
        else pre!.right = child;
      } else {
        this.root = child;
      }
    } else {
      // 子节点数量 = 2
      let tmp: TreeNode | null = cur.right;
      while(tmp!.left !== null) {
        tmp = tmp!.left;
      }
      // 递归删除节点 tmp
      this.remove(tmp!.val);
      // 用tmp覆盖cur
      cur.val = tmp!.val;
    }
  }

}
