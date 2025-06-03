package algorithm.回溯算法;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * [257. 二叉树的所有路径](https://leetcode.cn/problems/binary-tree-paths/description/)
 *
 */
public class binaryTreePaths {

    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<>());
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> temp) {
        if (root == null) return;
        temp.add(root.val);
        // 如果是叶子节点记录结果
        if (root.left == null && root.right == null) {
            ans.add(getPathString(temp));
        }
        dfs(root.left, temp);
        dfs(root.right, temp);
        temp.remove(temp.size() - 1);
    }

    // 拼接结果
    private String getPathString(List<Integer> temp) {
        StringBuilder sb = new StringBuilder();
        sb.append(temp.get(0));
        for (int i=1;i<temp.size();i++) {
            sb.append("->").append(temp.get(i));
        }
        return sb.toString();
    }

}
