package algorithm.树常见题.层序遍历题;

import dataStructure.树.TreeNode;

import java.util.*;

/**
 *
 * [103. 二叉树的锯齿形层序遍历](https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/)
 *
 */
public class zigzagLevelOrder {

    // ❌错误解法，为什么不对？
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int j=0;j<size;j++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    if (i % 2 == 0) { // 遍历到一行的终点节点，第一个放进来的有可能不是这个终点节点的左右节点
                        if (node.right != null) queue.add(node.right);
                        if (node.left != null) queue.add(node.left);
                    } else {
                        if (node.left != null) queue.add(node.left);
                        if (node.right != null) queue.add(node.right);
                    }
                }
            }
            ret.add(level);
            i++;
        }
        return ret;
    }

    // 解法一：层序遍历 + 双端队列
    // 这跟我的有什么区别啊？
    // 这里控制的是塞的结果数组的顺序，不是控制的队列元素的顺序
    // 队列的入队顺序都是左子节点->右子节点
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i=queue.size();i>0;i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val);
                else tmp.addFirst(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    // 解法二：层序遍历+倒序
    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i=queue.size();i>0;i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), null));
        List<List<Integer>> res =  zigzagLevelOrder(tree);
    }

}
