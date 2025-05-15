package algorithm.树常见题.层序遍历题;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * [515. 在每个树行中找最大值](https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/)
 *
 */
public class largestValues {

    // 我的解决办法
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ret;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    max = Math.max(max, node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            ret.add(max);
        }
        return ret;
    }

    // 深度优先搜索
    public List<Integer> largestValues2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    // 这个递归函数什么意思？
    // 初始化的时候，res是结果，root是根节点，curHeight是0
    // res的索引暗含了高度信息
    // curHeight表示的是树的高度，
    // 这个递归的结束条件是什么？我可以理解是整棵树递归完,但是怎么就结束了呢？
    private void dfs(List<Integer> res, TreeNode root, int curHeight) {
        if (curHeight == res.size()) {  // 初始的时候curHeight是0，res.size()也是0，塞 根节点
            res.add(root.val);   // 某个层没有塞过节点，就随便塞一个
        } else {  // 如果高度和结果数组长度不等，否则看这个高度的节点有没有值，比较塞个最大的
            res.set(curHeight, Math.max(res.get(curHeight), root.val));
        }
        if (root.left != null) {  // 递归左子节点,高度+1
            dfs(res, root.left, curHeight + 1);
        }
        if (root.right != null) { // 递归右子节点，高度+1
            dfs(res, root.right, curHeight + 1);
        }
    }
}
