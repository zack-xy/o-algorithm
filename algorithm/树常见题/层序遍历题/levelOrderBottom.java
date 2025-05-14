package algorithm.树常见题.层序遍历题;

import dataStructure.树.TreeNode;

import java.util.*;

/**
 *
 * [107. 二叉树的层序遍历 II](https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/)
 *
 */
public class levelOrderBottom {

    // 我的解法：102的反转
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ret;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    level.add(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
            }
            ret.add(level);
        }
        return ret.reversed();
    }

    // 解法二：2个数组
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> cur = List.of(root);
        while (!cur.isEmpty()) {
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>(cur.size());  // 预分配空间
            for (TreeNode node : cur) {
                vals.add(node.val);
                if (node.left != null) nxt.add(node.left);
                if (node.right != null) nxt.add(node.right);
            }
            cur = nxt;
            ans.add(vals);
        }
        Collections.reverse(ans);
        return ans;
    }
}
