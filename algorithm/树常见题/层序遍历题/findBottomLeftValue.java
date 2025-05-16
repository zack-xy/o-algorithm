package algorithm.树常见题.层序遍历题;

import dataStructure.树.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * [513. 找树左下角的值](https://leetcode.cn/problems/find-bottom-left-tree-value/description/)
 *
 */
public class findBottomLeftValue {

    // 我的解法：不停出队列，入队列先右后左，出完队列，最后的结果就是最左面的元素值
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res = node.val;
            if (node != null) {
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
        }
        return res;
    }


    public int findBottomLeftValue2(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.right != null) q.add(node.right);
            if (node.left != null) q.add(node.left);
        }
        return node.val;
    }
}
