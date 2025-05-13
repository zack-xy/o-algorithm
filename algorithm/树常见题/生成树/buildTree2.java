package algorithm.树常见题.生成树;

import dataStructure.树.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * [106. 从中序与后序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/)
 *
 *  中序：左根右
 *  后序：左右根
 *
 */

public class buildTree2 {

    // 解法一：
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 0) return null;
        int leftSize = indexOf(inorder, postorder[n-1]);  // 左子树的大小
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n-1);
        TreeNode left = buildTree2(in1, post1);
        TreeNode right = buildTree2(in2, post2);
        return new TreeNode(postorder[n-1], left, right);

    }

    private int indexOf(int[] a, int x) {
        for (int i = 0;;i++) {
            if (a[i] == x) return i;
        }
    }

    // 解法二：
    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> index = new HashMap<>();  // 预分配空间
        for (int i=0;i<n;i++) {
            index.put(inorder[i], i);
        }
        return dfs(0, n, postorder, 0, n, index);  // 左闭右开区间
    }

    private TreeNode dfs(int inL, int inR, int[] postorder, int postL, int postR, Map<Integer, Integer> index) {
        if (postL == postR) return null;
        int leftSize = index.get(postorder[postR-1]) -inL; // 左子树的大小
        TreeNode left = dfs(inL, inL+leftSize, postorder, postL, postL + leftSize, index);
        TreeNode right = dfs(inL+leftSize+1, inR, postorder, postL+leftSize, postR-1, index);
        return new TreeNode(postorder[postR-1], left, right);
    }
}
