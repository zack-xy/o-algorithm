package algorithm.树常见题.二叉搜索树;

import dataStructure.树.TreeNode;

import java.util.*;

/**
 *
 * [501. 二叉搜索树中的众数](https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/)
 *
 */
public class findMode {


    // 思路没问题，代码没写对😓
    List<Integer> answer = new ArrayList<>();
    // base 是前一个元素
    // count 计数
    // maxCount 记录最大数
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i=0;i<answer.size();++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int x) {
        if (x == base) {  // 如果当前的值和前一个值相等，count++
            ++count;
        } else {  // 否则，count设置为1，前一个数设置为当前数
            count = 1;
            base = x;
        }
        if (count == maxCount) {  // 如果计数等于最大计数，塞到结果里
            answer.add(base);
        }
        if (count > maxCount) {  // 如果计数大于最大计数，更新最大计数，结果清空，把数据塞到结果里
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
}
