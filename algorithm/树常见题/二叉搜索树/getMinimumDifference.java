package algorithm.树常见题.二叉搜索树;

import dataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * [530. 二叉搜索树的最小绝对差](https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/)
 * [783. 二叉搜索树节点最小距离](https://leetcode.cn/problems/minimum-distance-between-bst-nodes/description/)
 */
public class getMinimumDifference {

    // 递归的写法
    static int ret = Integer.MAX_VALUE;
    static int pre = Integer.MIN_VALUE / 2;  // 这里的问题是前一个值的定义
    public static int getMinimumDifference(TreeNode root) {
        if (root.left != null) ret = Math.min(getMinimumDifference(root.left), ret);
        ret = Math.min(root.val - pre, ret);
        pre = root.val;
        if (root.right != null) ret = Math.min(getMinimumDifference(root.right), ret);
        return ret;
    }

    // 别人的写法
    private static int ans = Integer.MAX_VALUE;
    private static int pre2 = Integer.MIN_VALUE / 2; // 防止减法溢出

    public static int getMinimumDifference2(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        ans = Math.min(ans, node.val - pre2);
        pre2 = node.val;
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new ArrayList<>(Arrays.asList(1,0,48,null,null,12,49)));
        int ret = getMinimumDifference(root);
        System.out.println(ret);
    }


}
