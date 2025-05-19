package algorithm.树常见题.LeetCode;

import dataStructure.树.TreeNode;

/**
 *
 * [617. 合并二叉树](https://leetcode.cn/problems/merge-two-binary-trees/description/)
 *
 */
public class mergeTrees {

    // 我自己的解法
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        return preorder(root1, root2);
    }

    private TreeNode preorder(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode newRoot = new TreeNode();
        if (root1 == null || root2 == null) newRoot.val = root1 == null ? root2.val : root1.val;
        else newRoot.val = root2.val + root1.val;
        newRoot.left = preorder(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        newRoot.right = preorder(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return newRoot;
    }

    // 别人的代码
    public TreeNode mergeTree2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTree2(root1.left, root2.left);
        merged.right = mergeTree2(root1.right, root2.right);
        return merged;
    }

}
