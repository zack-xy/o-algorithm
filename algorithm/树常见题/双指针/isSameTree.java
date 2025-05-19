package algorithm.树常见题.双指针;

import dataStructure.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * [100. 相同的树](https://leetcode.cn/problems/same-tree/description/)
 *
 */
public class isSameTree {

    // 我的解法：广度优先
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean ans = true;
        if (p == null && q == null) return ans;
        if (p == null || q == null) return !ans;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode p1 = queue1.poll();
            TreeNode q1 = queue2.poll();
            if (p1 == null && q1 == null) continue;
            if (p1 == null || q1 == null || p1.val != q1.val) {
                ans = false;
            }
            if (p1 != null) queue1.offer(p1.left);
            if (p1 != null) queue1.offer(p1.right);
            if (q1 != null) queue2.offer(q1.left);
            if (q1 != null) queue2.offer(q1.right);
        }
        if (!queue1.isEmpty() || !queue2.isEmpty()) ans = false;
        return ans;
    }

    // 我的解法：深度优先
    // 前序遍历
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        return inorder(p, q);
    }

    // 前序遍历:[根，左，右]
    public boolean inorder(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return inorder(p.left, q.left) && inorder(p.right, q.right);
    }
}
