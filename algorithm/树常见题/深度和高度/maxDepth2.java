package algorithm.树常见题.深度和高度;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * [559. N 叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/description/)
 *
 */
public class maxDepth2 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 我的解法
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.isEmpty()) return 1;
        int maxDep = Integer.MIN_VALUE;
        for (Node child : root.children) {
            maxDep = Math.max(maxDep, maxDepth(child));
        }
        return maxDep + 1;
    }

    // 别人的解法
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            // 这里搜集所有的子高度
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) {
                heights.add(maxDepth2(item));
            }
            return Collections.max(heights) + 1;
        }
    }
}
