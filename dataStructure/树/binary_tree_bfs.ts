// 层序遍历 - 广度优先
import { TreeNode } from './TreeNode';

function levelOrder(root: TreeNode | null): number[] {
  // 初始化队列，加入根节点
  const queue = [root];
  const list: number[] = [];
  while(queue.length) {
    let node = queue.shift() as TreeNode;
    list.push(node.val);
    if(node.left) {
      queue.push(node.left);
    }
    if(node.right) {
      queue.push(node.right);
    }
  }
  return list;
}
