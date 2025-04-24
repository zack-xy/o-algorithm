import { TreeNode } from './AVLTreeNode';

class AVLTree {
  root: TreeNode | null;
  constructor() {
    this.root = null;
  }

  // 获取节点高度
  height(node: TreeNode | null): number {
    return node  === null ? -1 : node.height;
  }

  // 更新节点高度
  private updateHeight(node: TreeNode): void {
    node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
  }

  // 获取平衡因子
  balanceFactor(node: TreeNode | null): number {
    // 空节点平衡因子为0
    if(node === null) return 0;
    return this.height(node.left) - this.height(node.right);
  }

  // 右旋操作
  // 左偏树，就是左侧树比较重
  private rightRotate(node: TreeNode): TreeNode {
    const child = node.left as TreeNode;
    const grandChild = child.right;
    child.right = node;
    node.left = grandChild;
    this.updateHeight(node);
    this.updateHeight(child);
    return child;
  }

  // 左旋操作
  // 右偏树，右侧比较重
  private leftRotate(node: TreeNode): TreeNode {
    const child = node.right as TreeNode;
    const grandChild = child.left;
    child.left = node;
    node.right = grandChild;
    this.updateHeight(node);
    this.updateHeight(child);
    return child;
  }

  // 执行旋转操作，使子树重新恢复平衡
  private rotate(node: TreeNode): TreeNode {
    const balanceFactor = this.balanceFactor(node);
    if(balanceFactor > 1) {
      if(this.balanceFactor(node.left)) {
        // 右旋
        return this.rightRotate(node);
      } else {
        // 先左旋后右旋
        node.left = this.leftRotate(node.left as TreeNode);
        return this.rightRotate(node);
      }
    }
    // 右偏树
    if(balanceFactor < -1) {
      if(this.balanceFactor(node.right) <= 0) {
        // 左旋
        return this.leftRotate(node);
      } else {
        // 先右旋再左旋
        node.right = this.rightRotate(node.right as TreeNode);
        return this.leftRotate(node);
      }
    }
    // 平衡树，无需旋转，直接返回
    return node;
  }

  // 插入节点
  insert(val: number): void {
    this.root = this.insertHelper(this.root, val);
  }

  // 递归插入节点（辅助方法）
  private insertHelper(node: TreeNode | null, val: number): TreeNode {
    if(node === null) return new TreeNode(val);
    if(val < node.val) {
      // 应该要插入到当前node的左子树上
      node.left = this.insertHelper(node.left as TreeNode, val);
    } else if(val > node.val) {
      // 需要插入到当前node节点的右子树上
      node.right = this.insertHelper(node.right as TreeNode, val);
    } else {
      return node;
    }
    // 程序运行到这里，节点已经插入了
    // 需要更新高度值
    this.updateHeight(node);
    // 进行旋转，树重新恢复平衡
    node = this.rotate(node);
    return node;
  }

  // 删除节点
  remove(val: number): void {
    this.root = this.removeHelper(this.root, val);
  }

  private removeHelper(node: TreeNode | null, val: number): TreeNode | null {
    if(node === null) return null;
    if(val < node.val) {
      node.left = this.removeHelper(node.left, val);
    } else if(val > node.val) {
      node.right = this.removeHelper(node.right, val);
    } else {
      // 找到了
      if(node.left === null || node.right === null) {
        const child = node.left !== null ? node.left : node.right;
        if(child === null) {
          return null;
        } else {
          node = child;
        }
      } else {
        let temp = node.right;
        while(temp.left !== null) {
          temp = temp.left;
        }
        node.right = this.removeHelper(node.right, temp.val);
        node.val = temp.val;
      }
    }
    this.updateHeight(node);
    node = this.rotate(node);
    return node;
  }

  // 查找节点
  search(val: number): TreeNode | null {
    let cur = this.root;
    while(cur !== null) {
      if(cur.val < val) {
        cur = cur.right;
      } else if(cur.val > val) {
        cur = cur.left;
      } else {
        break;
      }
    }
    return cur;
  }
}
