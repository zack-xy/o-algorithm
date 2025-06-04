package algorithm.回溯算法;

import com.sun.source.tree.Tree;
import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径
 *
 */
public class preorder_traversal_ii_compact {

    List<List<TreeNode>> res = new ArrayList<>();
    List<TreeNode> path = new ArrayList<>();

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) return;
        // 尝试
        path.add(root);
        if (root.val == 7) {
            // 记录解
            res.add(new ArrayList<>(path));
        }
        preOrder(root.left);
        preOrder(root.right);
        // 回退
        path.remove(path.size() - 1);
    }

}
