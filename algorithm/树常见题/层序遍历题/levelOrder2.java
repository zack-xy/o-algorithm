package algorithm.树常见题.层序遍历题;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

/**
 *
 * [429. N 叉树的层序遍历](https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/)
 *
 */
public class levelOrder2 {

    // 我的解法：队列
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0;i<size;i++) {
                Node node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    if (node.children != null) {
                        for (Node child : node.children) {
                            queue.offer(child);
                        }
                    }
                }
            }
            ret.add(level);
        }
        return ret;
    }

    // 解法二：两个数组
    public List<List<Integer>> levelOrder2(Node root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        List<Node> cur = List.of(root);
        while (!cur.isEmpty()) {
            List<Node> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>(cur.size());
            for (Node node : cur) {
                vals.add(node.val);
                nxt.addAll(node.children);
            }
            ans.add(vals);
            cur = nxt;
        }
        return ans;
    }
}
