package algorithm.树常见题.深度和高度;

import dataStructure.树.TreeNode;

import java.util.LinkedList;

/**
 *
 * [111. 二叉树的最小深度](https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/)
 *
 */
public class minDepth {

    // 解法一：递归
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

    // 解法二：层次遍历
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int minDepth = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            // 获取当前队列的长度，这个长度相等于当前这一层节点个数
            int size = queue.size();
            minDepth++;
            for (int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                if (t.left == null && t.right == null) { // 第一次遇到叶子节点，就可以返回了
                    return minDepth;
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return 0;
    }

}
