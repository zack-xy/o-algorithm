package algorithm.树常见题.层序遍历题;

import java.util.*;

/**
 *
 * [116. 填充每个节点的下一个右侧节点指针](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/)
 *
 */

public class connect {

    // 节点定义
    class Node {
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

    // 我的解决方案：
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size == 1) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                node.next = null;
            } else {
                int j=1;
                Node node = queue.poll();
                while (j < size) {
                    Node nextNode = queue.poll();
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                    if (nextNode.left != null) queue.offer(nextNode.left);
                    if (nextNode.right != null) queue.offer(nextNode.right);
                    node.next = nextNode;
                    node = nextNode;
                    j++;
                }
            }
        }
        return root;
    }

    // 官方题解1
    // 官方题解和我的解决思想是一样的
    // 我的代码很啰嗦，根节点是不用处理的，本身就是null
    public Node connect2(Node root) {
        if (root == null) return root;

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // 外层的while循环迭代的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i=0;i<size;i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
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

    // 官方题解2：这个代码更简练了，稍微难理解一些
    public Node connect3(Node root) {
        if (root == null) return root;

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {
            // 遍历这一层节点组织成的链表，为下一层节点更新next指针
            Node head = leftmost;  // 初始循环的时候，head就是根节点

            while (head != null) {
                head.left.next = head.right; // 外层while已经判断了left不为空，right为不为空无所谓
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;  // 下面之所以只用处理left节点，就是因为这里处理了right节点
            }
            // 上面这个循环是处理leftmost的子层级的
            // 上面这个循环走完，一层就处理完了
            leftmost = leftmost.left;
        }
        return root;
    }
}
