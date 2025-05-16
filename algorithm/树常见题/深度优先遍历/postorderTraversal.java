package algorithm.树常见题.深度优先遍历;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * [145. 二叉树的后序遍历](https://leetcode.cn/problems/binary-tree-postorder-traversal/description/)
 *
 */
public class postorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    // 解法一：递归
    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // 解法二：迭代法
    // 后序遍历顺序是[左，右，根]


    // 这个迭代的步骤是：
    //   大循环：判断栈和节点是否为空，只要有一个不空，就继续处理
    //           小循环：当前节点不为空
    //                 1. 栈中塞入当前节点（因为顺序是左右根，所以要一直找到最左的节点，要把当前节点存起来）
    //                 2. 当前节点 = 当前节点.left
    //           小循环结束后，栈顶元素就是最左一个元素
    //           if else 什么意思？
    //           （当前弹出的节点是最左节点，节点right是null的，把左节点塞到结果里）
    //            // TODO 这里有点儿难理解了
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<Integer> res = postorderTraversal2(tree);
        System.out.println(res.toString());
    }
}
