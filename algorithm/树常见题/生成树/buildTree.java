package algorithm.树常见题.生成树;

import com.sun.source.tree.Tree;
import dataStructure.树.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)
 *
 */
public class buildTree {

    // 解法一：递归
    /**
     * 因为前序遍历可以知道根节点，从中序序列中找到这个根节点可以把中序一劈为2，分别是左子树和右子树
     * 所以可以递归的进行操作，来生成二叉树。
     */

    // 因为每次要从中序遍历中找根节点，map这里存了中序遍历的数据，为了方便找节点
    // 显然，key是中序遍历的值，value是相应值在中序遍历中的索引
    private Map<Integer, Integer> indexMap;

    // 构造二叉树的递归函数

    /**
     * @param preorder 前序遍历序列
     * @param inorder  中序遍历序列
     * @param preorder_left 前序遍历左边界，初始0
     * @param preorder_right 前序遍历右边界，初始n-1
     * @param inorder_left  中序遍历左边界，初始0
     * @param inorder_right 中序遍历右边界，初始n-1
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right , int inorder_left, int inorder_right) {
        // 如果前序序列中左索引大于有索引了，就不需要继续执行了，这就是递归终止条件
        if (preorder_left > preorder_right) return null;

        // 前序遍历中的第一个节点就是根节点
        // （这里是前序遍历的左边界，递归最开始是0，进入递归后，是左半边的初始值和右半边的初始值）
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        // 在hash表中在中序序列中查找根的索引
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;

        // 递归地构造左子树，并连接到根节点
        // 进入递归，中序序列和前序序列不动传进去
        // 前序的左子树的左边界索引：左边界+1，
        // 前序的左子树的右边界索引：左边界+左子树节点数目（为什么不用+1？加1会跨到右树上了，不对）
        // 中序的左子树的左边界索引：原中序左边界索引
        // 中序的左子树的右边界索引：找的根节点的索引-1
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 进入递归，中序序列和前序序列不动传进去
        // 前序的右子树的左边界索引：左边界+左子树节点数目+1，就是上面的为什不加1，加1现在跨到右子树了
        // 前序的右子树的右边界索引：前序右边界
        // 中序的右子树的左边界索引：找的的根的位置+1
        // 中序的右子树的右边界索引：中序的右边界
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i=0;i<n;i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    // 解法二：迭代
    // TODO 这个迭代根本理解不了啊，放着之后再来看吧，实在不好理解
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        // 初始化一个栈，栈里存的是TreeNode节点
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i=1;i<preorder.length;i++) {
            int preprderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preprderVal);
                stack.push(node.left);
            } else {
                // 这一段是什么意思？
                while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preprderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    // 测试代码
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,8,5,4,10,20,15,7};
        int[] inorder = new int[]{4,5,8,10,9,3,15,20,7};
        TreeNode tree = buildTree2(preorder, inorder);
        System.out.println(tree);
    }
}
