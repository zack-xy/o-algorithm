package algorithm.树常见题.深度优先遍历;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * [94. 二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/description/)
 *
 */
public class inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    // 解法一：递归方式
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // 解法二：迭代
    // 中序遍历顺序是[左，根，右]


    // 这个迭代的步骤是：
    //   大循环：判断栈和节点是否为空，只要有一个不空，就继续处理
    //           小循环：当前节点不为空
    //                 1. 栈中塞入当前节点（因为顺序是左根右，所以要一直找到最左的节点，要把当前节点存起来）
    //                 2. 当前节点 = 当前节点.left
    //           小循环结束后，栈顶元素就是最左一个元素
    //           所以弹栈弹出来，值塞到结果数组中
    //           为什么要 root = root.right?
    //           （对于栈顶最左一个元素来说，是叶子节点，即是左，也是根了，值塞好就处理完了，左根处理完了，自然要处理右节点）
    //           （对于弹栈后的其他元素来说，自己本身作为根，刚值已经塞好了。前置的弹栈处理其左子，左值也塞好了，所以应该处理右节点）
    //
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // 解法三：Morris中序遍历
    // TODO 暂时理解不了，后面再来看吧
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
