package algorithm.树常见题.祖先问题;

import com.sun.source.tree.Tree;
import dataStructure.树.TreeNode;

import java.util.*;

/**
 *
 * [236. 二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/)
 *
 */
public class lowestCommonAncestor {

    // 我的思考：

    /**
     *
     * 想法一：
     *
     * 1. 如果p是q的祖先，返回p，如果q是p祖先，返回q
     * 2. 否则，p，q向上找父节点，直到相同，就找到了
     *
     * 但是2，树不好从节点开始向上遍历
     *
     * 想法二：我可不可以层序遍历
     * 利用哈希表分别记录每个值的根，key是节点值，value是这个节点的最近根节点
     * 然后我就可以根据这个哈希表做上面的事了
     *
     */

    // 可以解决：时间复杂度2N，空间复杂度2N
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root.val, null);  // 根节点之上没有根节点
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    map.put(node.left.val, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    map.put(node.right.val, node);
                    queue.offer(node.right);
                }
            }
        }
        // 代码到这里，已经整理好了所有节点的信息
        Map<Integer, TreeNode> ret = new HashMap<>();
        TreeNode pFather = p;
        TreeNode qFather = q;
        while (pFather != null || qFather != null) {
            if (pFather != null) {
                if (ret.containsKey(pFather.val)) return pFather;
                else {
                    ret.put(pFather.val, pFather);
                    pFather = map.get(pFather.val);
                }
            }
            if (qFather != null) {
                if (ret.containsKey(qFather.val)) return qFather;
                else {
                    ret.put(qFather.val, qFather);
                    qFather = map.get(qFather.val);
                }
            }
        }
        // 代码到这里，就是没找到，返回根节点
        return root;
    }

    // 想法二：
    // 我希望记录p和q的父节点,如果有一个栈记录的话，栈记录依次记录某个节点的根节点，然后依次弹栈，弹栈到相同就可以了
    // 这个应该是要深度优先遍历(感觉写不出来)
    //    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    //        Stack<TreeNode> stackP = new Stack<>();
    //        Stack<TreeNode> stackQ = new Stack<>();
    //    }


    // 别人题解：
    // 深度优先 + 递归
    // 这里涉及最近公共祖先的定义：如果root是p，q的最近公共祖先，那么root.left和root.right都不是p，q的公共祖先
    // 所以如果root是p,q的最近公共祖先，只能是下面几种情况
    // 1. p和q在root的子树中，并且分列root的异侧
    // （上面这个乍一看挺奇怪，仔细思考一下是没问题的，因为二叉树只有左右两个分支）
    // （那么如果p和q在同一侧，则必然意味着p和q有一个是另一个的祖先，也就是下面2，3的情况）
    // 2. p = root，且q在root的左或右子树中
    // 3. q = root, 且p在root的左或右子树中
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }





    public static void main(String[] args) {
        TreeNode root = new TreeNode(new ArrayList<>(Arrays.asList(1,2)));
        TreeNode commonFather = lowestCommonAncestor(root, root, root.left);
    }
}
