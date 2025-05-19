package algorithm.树常见题.LeetCode;

import dataStructure.树.TreeNode;

import java.util.LinkedList;

/**
 *
 * [226. 翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/description/)
 *
 */
public class invertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // 别人的解法代码 - 前序交换
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

    // 别人的解法代码 - 后序交换
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree3(root.left);
        TreeNode right = invertTree3(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 别人的解法代码 - 层次遍历
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return null;
        // 将二叉树中的节点逐层放入队列中，在迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 每次都从队列中拿出一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            // 如果当前节点的左子树不为空，则放入队列等待后续处理
            if (tmp.left != null) queue.add(tmp.left);
            // 如果当前节点的右子树不为空，则放入队列等待后续处理
            if (tmp.right != null) queue.add(tmp.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode ansTree = invertTree(root);
        System.out.println(ansTree);
    }
}
