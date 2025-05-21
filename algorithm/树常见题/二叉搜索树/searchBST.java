package algorithm.树常见题.二叉搜索树;

import dataStructure.树.TreeNode;

/**
 *
 * [700. 二叉搜索树中的搜索](https://leetcode.cn/problems/search-in-a-binary-search-tree/description/)
 *
 */
public class searchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
     }

     // 简化递归
     public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return val < root.val ? searchBST2(root.left, val) : searchBST2(root.right, val);
     }

     // 迭代的方式
    public TreeNode searchBST3(TreeNode root, int val) {
        while (root != null && val != root.val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
