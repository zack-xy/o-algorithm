package algorithm.树常见题.深度优先遍历;

import com.sun.source.tree.Tree;
import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * [144. 二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/description/)
 *
 */
public class preorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        preTraversal(root, ans);
        return ans;
    }

    // 隐式递归结束条件
    private void preTraversal(TreeNode root, List<Integer> res) {
        res.add(root.val);
        if (root.left != null) preTraversal(root.left, res);
        if (root.right != null) preTraversal(root.right, res);
    }


    // 递归：显式递归结束条件
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // 解法二：迭代
    // 前序遍历顺序是[根，左，右]

    // 这个迭代的步骤是：
    //     大循环：判断栈和节点是否为空，只要有一个不空，就继续处理
    //         小循环：当前节点不为空
    //               1.把当前节点的值塞到结果数组里（因为根左右，当前节点就是对于其子节点来说，就是根，直接塞）
    //               2.把当前节点压栈（因为当前节点的值处理，当前节点可能还有【右】节点没有处理）
    //               3.当前节点=当前节点的左子节点
    //         小循环结束后，意味着树左侧节点处理完毕，从栈中弹节点，处理未处理的【右】子节点
    //               当前节点的 = 当前节点的右子节点
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) { // 不停的将左子树压栈，并且根值塞到结果数组里
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            // 代码运行到这里，左侧子树已经在结果数组里了
            // 弹栈处理每个节点的右子节点
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    // 解法三：Morris遍历（最优）
    // TODO 暂时理解不了，后面再来看吧
    public static List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode p1 = root, p2 = null;
        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }

    public static void main(String[] args) {
        // 跑一下Morris遍历，看代码看不懂
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<Integer> ret = preorderTraversal4(root);
        System.out.println(ret.toString());
    }
}
