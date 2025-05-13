package algorithm.树常见题.层序遍历题;

import com.sun.source.tree.Tree;
import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    /**
     *
     * [102. 二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/description/)
     *
     */

    // 我的题解：两个队列来回倒腾
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> subQueue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null && node.left != null) subQueue.offer(node.left);
            if (node != null && node.right != null) subQueue.offer(node.right);
            if (node != null) level.add(node.val);
            if (queue.isEmpty()) {
                queue = subQueue;
                ans.add(level);
                subQueue = new LinkedList<>();
                level = new ArrayList<>();
            }
        }
        return ans;
    }

    // 官方题解：
    // 我也想到计数了，但是没想到怎么写
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size(); // 采用计数的方法,这为啥计数是对的呢？
            for (int i=1;i<=currentLevelSize;++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ret.add(level);
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> ans = levelOrder(tree);
        System.out.println(ans.toString());
    }
}
