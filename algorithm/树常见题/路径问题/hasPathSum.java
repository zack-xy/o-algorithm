package algorithm.树常见题.路径问题;

import dataStructure.树.TreeNode;

/**
 *
 * [112. 路径总和](https://leetcode.cn/problems/path-sum/description/)
 *
 * // 问题转化：是否存在从当前节点的子节点到叶子节点的路径，满足路径和为sum-val
 *
 */
public class hasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }
}
