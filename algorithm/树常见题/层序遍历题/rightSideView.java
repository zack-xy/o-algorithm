package algorithm.树常见题.层序遍历题;

import dataStructure.树.TreeNode;

import java.util.*;

/**
 *
 * [199. 二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/description/)
 * [LCR 046. 二叉树的右视图](https://leetcode.cn/problems/WNC0Lk/description/)
 */
public class rightSideView {

    // 我的解法：是不是层序遍历，
    // 1. 如果层只有1个节点，放到结果里
    // 2. 如果层有2个以上节点，将最后一个节点放到结果里
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ret;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {  // 这里我认为不必判断了，不会为空的，但是不写代码编辑器会报告警告cur可能为空
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    if (i == size - 1) ret.add(cur.val);
                }
            }
        }
        return ret;
    }

    // 递归解法 (最优解)
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    // 这个递归是什么功能？
    /**
     *  这个算法巧妙在，每一层其实最多只会“看到”1个节点，也就是其实深度每加1层
     *  也就暗含了多加1个节点，因为没有节点，深度不会增加，深度增加了，ans也就增加1个节点
     *  所以，ans和depth是同步增加的，所以才能用来比较相等
     */
    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) return;
        if (depth == ans.size()) ans.add(root.val);  // 这个深度首次遇到
        dfs(root.right, depth + 1, ans); // 先递归右子树，保证先遇到的是右边节点
        dfs(root.left, depth + 1, ans);
    }


    // 官方题解1:

    // 什么原理？
    // 维护了2个栈，一个是树节点栈 nodeStack，一个是树深度栈 depthStack；维护了1个哈希表，key是深度，value是节点值
    // 初始化节点栈中放入 根节点，树深度栈中放入 0
    // 循环树节点栈，直到栈为空，两个栈的栈内元素是一一对应的，就是节点，对应深度
    // 另外用了一个额外变量计数深度有多大
    public List<Integer> rightSideView3(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                // 如果这个深度，hash表中没有维护相应的节点，那么把当前深度和节点维护进去
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);  // 节点栈先压left，后压right，所以上面弹栈的时候，会先弹右节点
                depthStack.push(depth + 1);  // 深度栈压了2个相同的值
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth=0;depth<=max_depth;depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

    // 官方题解2:
    // 这个解法和上面官方解法不是一样的么
    // 队列出队列，最后出队列的是right，所以一直在覆盖值，少了一步判断存在，实际道理是一样的
    public List<Integer> rightSideView4(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                max_depth = Math.max(max_depth, depth);

                rightmostValueAtDepth.put(depth, node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth=0;depth<=max_depth;depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

}
