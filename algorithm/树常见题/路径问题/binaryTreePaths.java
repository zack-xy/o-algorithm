package algorithm.树常见题.路径问题;

import dataStructure.树.TreeNode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * [257. 二叉树的所有路径](https://leetcode.cn/problems/binary-tree-paths/description/)
 *
 */
public class binaryTreePaths {

    /**
    public List<String> binaryTreePaths(TreeNode root) {
        root.val + rcur(root.left);
        root.val + rcur(root.right);
    }

    private String rcur(TreeNode root) {
        if (root.left == null && root.right == null) return "->" + root.val;
        if (root.left != null) return  "->" + root.val + rcur(root.left);
        if (root.right != null) return "->" + root.val + rcur(root.right);
    }

     **/

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    // 递归
    // 怎么理解这个递归
    // 为什么这个path不用remove呢？因为这个path是传入到递归函数里的，每一个递归函数的执行栈都有一个自己的path
    private static void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) return;   // 这一行怎么理解？
        if (root.left == null && root.right == null) {  // 如果左右节点都是空，root就是叶子节点，到头了
            res.add(path + root.val);  // 叶子节点的话，说明路径到头了，把这个路径加到结果数组里
            return;
        }
        dfs(root.left, path + root.val + "->", res);  // 否则，root节点不是叶子节点，递归处理
        dfs(root.right, path + root.val + "->", res);
    }

    // 回溯
    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs2(root, ans, path);
        return ans;
    }

    // 这个递归和上面的有啥区别呢？
    // 区别1: 这个递归函数传入的参数path，是外部定义的
    // 因为这个区别，所以每一个执行栈中，每一个递归函数的path都是外部同一个，所以要操作path的remove
    // 否则path的数据不对，因为都在改
    private static void dfs2(TreeNode node, List<String> ans, List<String> path) {
        if (node == null) return;
        path.add(String.valueOf(node.val));  // 尝试把当前节点加入到路径中
        if (node.left == node.right) {  // 叶子节点，这是什么判断？如果节点的左右节点都是null，说明是叶子节点
            ans.add(String.join("->", path));  // 如果是叶子节点，将数组中的每一项中间加一个->就是其中一个解，塞到结果里
        } else {   // 如果不是叶子节点
            dfs2(node.left, ans, path);  // 递归左树
            dfs2(node.right, ans, path); // 递归右树
        }
        path.remove(path.size() - 1);  // 恢复现场 当前节点的路径处理完了，要删掉
    }


    // 以上的递归都是3个参数，能不能只有1个参数，或者有2个参数呢，与上面的递归有什么区别？
    // 【理论上所有多参数递归都能转化为单参数递归】

    // 只有1个参数的递归
    // 这里为什么只需要1个参数呢？前面的path，ans都哪里去了？
    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        // 叶子节点直接返回自身
        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return paths;
        }

        // 递归处理左子树
        for (String path : binaryTreePaths3(root.left)) {
            paths.add(root.val + "->" + path);
        }

        // 递归处理右子树
        for (String path : binaryTreePaths3(root.right)) {
            paths.add(root.val + "->" + path);
        }

        return paths;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(new ArrayList<>(Arrays.asList(1,2,3,null,5)));
        List<String> ans = binaryTreePaths(root);
        System.out.println(ans.toString());

        TreeNode root2 = new TreeNode(new ArrayList<>(Arrays.asList(1,2,3,null,5)));
        List<String> ans2 = binaryTreePaths2(root2);
        System.out.println(ans2.toString());

    }

}
