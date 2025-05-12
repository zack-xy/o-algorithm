package algorithm.栈常见题.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * [225. 用队列实现栈](https://leetcode.cn/problems/implement-stack-using-queues/description/)
 *
 *  队列1的出栈方向是 栈顶
 *  队列2是中转使用的，因为入栈的操作，相当于在队列1的头部插入数据
 *
 *  把要入栈的元素，入队列2中
 *  把队列1的依次出队列，入队列2中，此时，新加的节点就在原队列1数据的头部
 *  队列1和队列2交换数据
 *
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 入栈操作
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());  // poll出队，offer入队
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // 出栈
    // 队列1出队
    public int pop() {
        return queue1.poll();
    }

    // 访问栈顶元素
    public int top() {
        return queue1.peek();
    }

    // 判断栈是否为空
    public boolean empty() {
        return queue1.isEmpty();
    }
}
