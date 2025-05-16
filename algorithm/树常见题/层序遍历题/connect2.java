package algorithm.树常见题.层序遍历题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * [117. 填充每个节点的下一个右侧节点指针 II](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/description/)
 *
 *  ⚠️这个题和116题的区别是，这里的树不是完美二叉树
 *
 */
public class connect2 {

   static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // 如果是使用队列解决，跟116题是一样的
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();  // 这里是访问队列节点，不要出队列
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    // 解法一：深度优先遍历
    // 这个list的意义是：总是记录depth深度的从左到右未处理的节点，索引是深度depth
    private final List<Node> pre = new ArrayList<>();
    public Node connect2(Node root) {
        dfs(root, 0);
        return root;
    }
    private void dfs(Node node, int depth) {
        if (node == null) return;
        if (depth == pre.size()) { // node是这一层最左边的节点,因为总是先递归左侧节点
            pre.add(node);
        } else { // pre[depth]是node左边的节点
            // node左边的节点指向node，第二次递归回来也就是right的时候
            // pre.get(depth)是最左边的节点。操作next指针，就把最左边和现在的右边连起来了
            // 然后更新这个深度，最左边的节点
            pre.get(depth).next = node;
            pre.set(depth, node);
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }

    // 解法二：广度优先遍历
    // 为什么要两个List呢？
    public static Node connect3(Node root) {
        if (root == null) return root;
        List<Node> q = List.of(root);
        while (!q.isEmpty()) {
            List<Node> tmp = q;
            q = new ArrayList<>();
            for (int i=0;i<tmp.size();i++) {
                Node node = tmp.get(i);
                // 这里为什么要i>0呢？
                // 因为上一行代表的是当前节点，我们要得到的是下一个节点，因为要把next指向修改掉
                // 这里如果不是0的话，就是我之前想的，你就要获取i+1位置的节点，也就是下一个节点
                if (i > 0) { // 连接同一层的两个相邻节点
                    tmp.get(i-1).next = node;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return root;
    }

    // 解法三：BFS+链表 （最优）
    public static Node connect4(Node root) {
        Node dummy = new Node(); // 这个有什么用？
        Node cur = root;
        // 这里有2个循环，判断的都是cur!=null
        while (cur != null) {
            dummy.next = null;
            Node nxt = dummy;  // 【下一层的链表】，这里nxt指针和dummy是同一个

            while (cur != null) { // 【遍历当前层的链表】
                if (cur.left != null) { // 如果当前节点的左子节点不为空
                    // 这里nxt和dummy是同一个指针，所以修改了nxt的next，也就是修改dummy的next
                    // 在第一次循环，dummy的next就是第一个左子节点
                    nxt.next = cur.left;  // 【下一层的相邻节点连起来】
                    // 这里，变量nxt重新赋值，nxt和dummy指向不是同一个了
                    // nxt是第一个左子节点，也就是nxt和dummy的next是同一个
                    nxt = cur.left;
                }
                if (cur.right != null) {  // cur节点还是上一层的节点
                    // 因为nxt现在已经是第一个左子节点了
                    // 所以nxt的next，其实就是左节点的next连接到了右节点上
                    nxt.next = cur.right;  // 【下一层的相邻节点连起来】
                    // 更新nxt节点
                    nxt = cur.right;
                }
                // 程序运行到这里，连接一层里最近的2个相邻的节点
                cur = cur.next;  // 【当前层链表的下一个节点】
            }

            // 程序运行到这里，一层处理完了
            cur = dummy.next;   // 【下一层链表的头节点】下一层链表的最左一个节点
        }
        return root;
    }

    public static void main(String[] args) {
        Node tree = connect4(new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, null, new Node(7), null), null));
    }

}
