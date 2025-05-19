package algorithm.树常见题.双指针;

import dataStructure.树.TreeNode;

import java.util.*;

/**
 *
 * [101. 对称二叉树](https://leetcode.cn/problems/symmetric-tree/description/)
 *
 *  进阶：要求使用递归和迭代两种方法
 *
 */
public class isSymmetric {

    // 我的解法：两个子树，一边【根左右】遍历，一边【根右左遍历】
    // 同步遍历，如果都相同的话，就是镜像树，如果不同的话，就不是镜像树
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        leftOrder(root.left, leftList);
        rightOrder(root.right, rightList);
        if (leftList.size() != rightList.size()) return false;
        for (int i=0;i<leftList.size();i++) {
            if (!Objects.equals(leftList.get(i), rightList.get(i))) return false;
        }
        return true;
    }

    private static void leftOrder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) ans.add(null);
        if (root != null) {
            ans.add(root.val);
            leftOrder(root.left, ans);
            leftOrder(root.right, ans);
        }
    }

    private static void rightOrder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) ans.add(null);
        if (root != null) {
            ans.add(root.val);
            rightOrder(root.right, ans);
            rightOrder(root.left, ans);
        }
    }

    // 我的解法：广度优先，层序遍历 (弟中之弟，比第一种方法还要慢😓)
    // 一层的话，利用栈的特性来判断是不是镜像
    // 每一层都镜像，整棵树就是镜像的，如果有一层不镜像，那么树就不是镜像的
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean ans = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int mid = (size >> 1);
            Stack<Integer> stack = new Stack<>();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (i < mid) stack.push(node == null ? null : node.val);
                else {
                    if (!stack.isEmpty()) {
                        Integer val2 = stack.pop();
                        if (node == null) {
                            if (val2 != null) {
                                ans = false;
                                break;
                            }
                        } else {
                            if (val2 == null || val2 != node.val) {
                                ans = false;
                                break;
                            }
                        }
                    }
                }
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }


    // 别人的代码：递归，来看一下代码怎么写更好
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        // 这个结果应该是true，但是现在为false
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,null,3,null,3));
        TreeNode root = new TreeNode(list);
        boolean ans = isSymmetric2(root);
        System.out.println(ans);
    }


}
