package algorithm.树常见题.层序遍历题;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * [637. 二叉树的层平均值](https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/)
 *
 */
public class averageOfLevels {

    // 我的解法：广度优先搜索
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double total = 0;
            for (int i=0;i<size;++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    total += node.val;
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            double ave = total / size;
            ret.add(ave);
        }
        return ret;
    }

    // 解法二：深度优先搜索
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<>();
        int size = sums.size();
        for (int i=0;i<size;i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    // 怎么理解这个递归?

    // 这个递归维护了2个动态数组，一个是sums，一个是counts
    // 动态数组的index是树的层级
    // sums中的值，是对应每个层级的和
    // counts中的值，是对应每个层级有几个节点
    private void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) return;
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }
}
