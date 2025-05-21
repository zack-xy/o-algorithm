package algorithm.树常见题.二叉搜索树.AVL树;

import dataStructure.树.TreeNode;

/**
 *
 * [108. 将有序数组转换为二叉搜索树](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/)
 *
 *  将有序数组转为平衡二叉搜索树
 */
public class sortedArrayToBST {

    // 二分查找
    // 假如left=0，right=4 【1，2，3，4，5】，中间是索引4/2=2的位置
    // 假如left=0，right=5 【1，2，3，4，5，6】，中间是索引5/2=2的位置
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        // 也可以总是选择中间位置右边的数字作为根节点
        // int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}
