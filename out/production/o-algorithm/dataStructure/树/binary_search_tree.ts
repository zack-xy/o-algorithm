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
    if(this.root === null) {
      this.root = new TreeNode(num);
      return;
    }
    let cur: TreeNode | null = this.root,
        pre: TreeNode | null = null;
    while(cur !== null) {
      if(cur.val === num) return;
      pre = cur;
      if(cur.val < num) cur = cur.right;
      else cur = cur.left;
    }
    const node = new TreeNode(num);
    if(pre!.val < num) pre!.right = node;
    else pre!.left = node;
  }

  // 删除节点
  remove(num: number): void {
    if(this.root === null) return;
    let cur: TreeNode | null = this.root,
        pre: TreeNode | null = null;
    while(cur !== null) {
      if(cur.val === num) break;
      pre = cur;
      if(cur.val < num) cur = cur.right;
      else cur = cur.left;
    }
    if(cur === null) return;
    if(cur.left === null || cur.right === null) {
      const child: TreeNode | null = cur.left !== null ? cur.left : cur.right;
      if(cur !== this.root) {
        if(pre!.left === cur) pre!.left = child;
        else pre!.right = child;
      } else {
        this.root = child;
      }
    } else {
      let tmp: TreeNode | null = cur.right;
      while(tmp!.left !== null) {
        tmp = tmp!.left;
      }
      this.remove(tmp!.val);
      cur.val = tmp!.val;
    }
  }
}
