package dataStructure.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binary_tree_bfs {

    // 广度优先搜索，层序遍历
    List<Integer> levelOrder(TreeNode root) {
        // 初始化队列，加入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();  // 队列出队
            list.add(node.val);            // 保存节点值
            if (node.left != null) queue.offer(node.left);  // 左子节点入队
            if (node.right != null) queue.offer(node.right); // 右子节点入队
        }
        return list;
    }
}
