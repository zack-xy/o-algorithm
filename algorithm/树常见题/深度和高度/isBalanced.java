package algorithm.树常见题.深度和高度;

import dataStructure.树.TreeNode;

/**
 *
 * [110. 平衡二叉树](https://leetcode.cn/problems/balanced-binary-tree/description/)
 *
 */
public class isBalanced {

    public boolean isBalanced(TreeNode root) {
         return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;  // 如果节点是空的，高度为0
        int leftHeight = height(root.left);  // 计算左子节点高度
        int rightHeight = height(root.right);  // 计算右子节点高度
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;  // 如果左右子节点里有不平衡的，或者现在高度不平衡，返回-1
        else return Math.max(leftHeight, rightHeight) + 1;  // 返回左右子树中，高度最高的那一个，加上当前节点+1
    }

}
