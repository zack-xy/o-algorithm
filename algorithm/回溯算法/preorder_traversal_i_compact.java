package algorithm.回溯算法;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一棵二叉树，搜索并记录所有值为7的节点，请返回节点列表
 *
 */
public class preorder_traversal_i_compact {

    List<TreeNode> res = new ArrayList<>();

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) return;
        if (root.val == 7) res.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }

}
