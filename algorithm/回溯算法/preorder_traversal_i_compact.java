package algorithm.回溯算法;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dataStructure.Util.PrintUtil.printTree;

/**
 *
 * 给定一棵二叉树，搜索并记录所有值为7的节点，请返回节点列表
 *
 */
public class preorder_traversal_i_compact {

    static List<TreeNode> res = new ArrayList<>();

    // 前序遍历
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        if (root.val == 7) res.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     *
     *
     *         /——— 7
     *     /——— 3
     *    |    \——— 6
     * ——— 1
     *    |    /——— 5
     *     \——— 7
     *         \——— 4
     *
     *
     *
     *
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new ArrayList<>(Arrays.asList(1,7,3,4,5,6,7)));
        preOrder(root);
        for (TreeNode node : res) {
            printTree(node);
        }
    }

}
