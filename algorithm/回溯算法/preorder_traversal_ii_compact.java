package algorithm.回溯算法;

import com.sun.source.tree.Tree;
import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dataStructure.Util.PrintUtil.printTree;

/**
 *
 * 在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径
 *
 */
public class preorder_traversal_ii_compact {

    static List<List<TreeNode>> res = new ArrayList<>();
    static List<TreeNode> path = new ArrayList<>();

    // 前序遍历
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        // 尝试
        path.add(root);
        if (root.val == 7) {
            // 记录解
            res.add(new ArrayList<>(path));
        }
        preOrder(root.left);
        preOrder(root.right);
        // 代码运行到这里，root的左子树和右子树都尝试完了，path中最后一个现在是root
        // 为什么是root？因为左子树和右子树的代码递归完了，要么第一行直接return了，那么root没有影响
        // 如果向下走了，表明代码运行到最后一行，整个函数递归完了，递归完了，就会把塞进去的节点remove了

        // 回退
        path.remove(path.size() - 1);
    }

    // 测试代码
    /**
     *
     * 树的结构示意图
     *
     *         /——— 7
     *     /——— 3
     *    |    \——— 6
     * ——— 1
     *    |    /——— 5
     *     \——— 7
     *         \——— 4
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new ArrayList<>(Arrays.asList(1,7,3,4,5,6,7)));
        preOrder(root);
        for (List<TreeNode> list : res) {
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<list.size();i++) {
                sb.append(list.get(i).val);
                if (i != list.size() - 1) {
                    sb.append("->");
                }
            }
            System.out.println(sb.toString());
        }
    }

}
