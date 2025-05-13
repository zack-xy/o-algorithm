package dataStructure.树;

import java.util.ArrayList;

public class binary_tree_dfs {

    // 保存遍历结果
    ArrayList<Integer> list = new ArrayList<>();

    // 前序遍历
    void preOrder(TreeNode root) {
        if (root == null) return;
        // 访问优先级：根节点 -> 左子树 -> 右子树
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if (root == null) return;
        // 访问优先级：左子树 -> 根节点 -> 右子树
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if (root == null) return;
        // 访问优先级：左子树 -> 右子树 -> 根节点
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }

}
