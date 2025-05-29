package dataStructure.树;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树节点类
public class TreeNode {
    public int val;  // 节点值
    public TreeNode left;  // 左节点引用
    public TreeNode right; // 右节点引用
    public TreeNode() {}
    public TreeNode(int x) {
        val = x;
    }
    // 【 从层序遍历中生成一棵树 】

    // 根据一个列表创建一棵树，方便调试代码用的
    // 经常Leetcode提供一个列表表示一棵树
    // 提供的列表其实是层序遍历的结果
    // 当前节点索引i，左子树索引2i+1，右子树索引2i+2

    /**
     * @param arr
     *
     * ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,3,4,5,5,4,null,null,8,9,9,8));
     * TreeNode root = new TreeNode(list);
     *
     */
    public TreeNode(ArrayList<Integer> arr) {
        // 空树或无效输入
        if (arr == null || arr.isEmpty() || arr.get(0) == null) return;
        this.val = arr.get(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);

        int i=1;
        while (!queue.isEmpty() && i < arr.size()) {
            TreeNode current = queue.poll();

            // 处理左子节点
            if (i < arr.size() && arr.get(i) != null) {
                current.left = new TreeNode(arr.get(i));
                queue.offer(current.left);
            }
            i++;

            // 处理右子节点
            if (i < arr.size() && arr.get(i) != null) {
                current.right = new TreeNode(arr.get(i));
                queue.offer(current.right);
            }
            i++;
        }

    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 将列表反序列化为二叉树
    public static TreeNode listToTree(List<Integer> arr) {
        return listToTreeDFS(arr, 0);
    }

    // 将列表反序列化为二叉树：递归
    private static TreeNode listToTreeDFS(List<Integer> arr, int i) {
        if (i < 0 || i >= arr.size() || arr.get(i) == null) return null;
        TreeNode root = new TreeNode(arr.get(i));
        root.left = listToTreeDFS(arr, 2 * i + 1);
        root.right = listToTreeDFS(arr, 2 * i + 2);
        return root;
    }
}
