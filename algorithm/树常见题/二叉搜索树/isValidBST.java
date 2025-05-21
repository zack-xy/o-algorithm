package algorithm.树常见题.二叉搜索树;

import dataStructure.树.TreeNode;

import java.util.ArrayList;

/**
 *
 * [98. 验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/description/)
 *
 */
public class isValidBST {

    // 二叉搜索树，不但要保证子树是正确的，而且整个左侧所有节点都要小于根节点
    // 所有右侧节点，都要大于根节点，所以这个递归是❌的
    /**
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.left.val >= root.val) return false;
        if (root.right != null && root.right.val <= root.val) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
    **/

    // 遍历完看数组是不是有序的
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        for (int i=0;i<arr.size()-1;i++) {
            if (arr.get(i+1)<=arr.get(i)) return false;
        }
        return true;
    }

    // 中序遍历
    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root.left != null) inorder(root.left, list);
        list.add(root.val);
        if (root.right != null) inorder(root.right, list);
    }

    // 解法二：
    long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        // 如果左子树下某个元素不满足要求，则退出
        if (!isValidBST2(root.left)) return false;
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回false，否则继续遍历
        if (root.val <= pre) return false;
        pre = root.val;
        // 访问右子树
        return isValidBST2(root.right);
    }

}
