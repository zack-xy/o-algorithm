// 层序遍历
function levelOrder(root: TreeNode | null): number[] {
  // 初始化队列，加入根节点
  const queue = [root];
  // 初始化一个列表，用于保存遍历序列
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
  return list
}
