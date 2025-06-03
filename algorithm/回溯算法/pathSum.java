package algorithm.回溯算法;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * [113. 路径总和 II](https://leetcode.cn/problems/path-sum-ii/description/)
 *
 */
public class pathSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, targetSum, path);
        return res;
    }

    public void dfs(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root == null) return;
        // 这个值有很关键的作用
        targetSum-=root.val;
        path.add(root.val);
        if (targetSum == 0 && root.left == null && root.right == null) res.add(new LinkedList<>(path));
        dfs(root.left, targetSum, path);
        dfs(root.right, targetSum, path);
        path.removeLast();
    }

}
