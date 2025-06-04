package algorithm.回溯算法;

import com.sun.source.tree.Tree;
import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点
 *
 */
public class preorder_traversal_iii_compact {

    List<TreeNode> path = new ArrayList<>();
    List<List<TreeNode>> res = new ArrayList<>();

    public void preOrder(TreeNode root) {
        // 剪枝
        if (root == null || root.val == 3) return;
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


    /// ///////////////////////////////////////////

    // 判断当前状态是否为解
    public boolean isSolution(List<TreeNode> state) {
        return !state.isEmpty() && state.get(state.size() - 1).val == 7;
    }

    // 记录解
    public void recordSolution(List<TreeNode> state, List<List<TreeNode>> res) {
        res.add(new ArrayList<>(state));
    }

    // 判断在当前状态下，该选择是否合法
    public boolean isValid(List<TreeNode> state, TreeNode choice) {
        return choice != null && choice.val != 3;
    }

    // 更新状态
    public void makeChoice(List<TreeNode> state, TreeNode choice) {
        state.add(choice);
    }

    // 恢复状态
    public void undoChoice(List<TreeNode> state, TreeNode choice) {
        state.remove(state.size() - 1);
    }

    /* 拆分的写法 */
    public void backtrack(List<TreeNode> state, List<TreeNode> choices, List<List<TreeNode>> res) {
        // 检查是否为解
        if (isSolution(state)) {
            // 记录解
            recordSolution(state, res);
        }
        // 遍历所有选择
        for (TreeNode choice : choices) {
            // 剪枝：检查选择是否合法
            if (isValid(state, choice)) {
                // 尝试：做出选择，更新状态
                makeChoice(state, choice);
                // 进行下一轮选择
                backtrack(state, Arrays.asList(choice.left, choice.right), res);
                // 回退：撤销选择，恢复到之前的状态
                undoChoice(state, choice);
            }
        }
    }


}
