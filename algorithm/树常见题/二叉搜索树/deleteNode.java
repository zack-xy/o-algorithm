package algorithm.树常见题.二叉搜索树;

import dataStructure.树.TreeNode;

/**
 *
 * [450. 删除二叉搜索树中的节点](https://leetcode.cn/problems/delete-node-in-a-bst/description/)
 *
 */
public class deleteNode {

    // 迭代
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) cur = cur.left;
            else cur = cur.right;
        }
        if (cur == null) return root;
        if (cur.left == null && cur.right == null) {
            cur = null;  // 如果cur没有子节点，cur设置为null
        } else if (cur.right == null) {
            cur = cur.left;  // 如果cur没有右节点，cur设置为左节点
        } else if (cur.left == null) {
            cur = cur.right;  // 如果cur没有左节点，cur设置为右节点
        } else { // 如果cur既有左节点，也有右节点
            TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {  // 去右子树中找最小，这个节点比left值大，比其他所有right都小
                successorParent = successor;
                successor = successor.left;
            }
            // successor这个节点是要替换成cur节点的
            // successorParent是successor的父节点
            if (successorParent.val == cur.val) {
                // 如果是这种情况，要删除的节点的右节点下面没有左节点
                // 那么要删除的节点的右节点就是最小的了
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            // 上面这两个操作，删除了successor节点
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;  // 将successor替换成cur
        }
        // 代码到这里cur指针指向successor
        // cur指向的是要替换cur的节点
        // 还需要修改指向cur的指针
        if (curParent == null) {
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
    }

    // 递归
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode2(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode2(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            if (root.left == null || root.right == null) return root.left == null ? root.right : root.left;
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}
