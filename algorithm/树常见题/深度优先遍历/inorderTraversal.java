package algorithm.树常见题.深度优先遍历;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * [94. 二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/description/)
 *
 */
public class inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    // 解法一：递归方式
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // 解法二：迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // 解法三：Morris中序遍历
    // TODO 暂时理解不了，后面再来看吧
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
