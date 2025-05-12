package algorithm.栈常见题.Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * [716. 最大栈](https://leetcode.cn/problems/max-stack/description/)
 *
 *  设计一个最大栈数据结构，既支持栈操作，又支持查找栈中最大元素
 *
 *  实现MaxStack类：
 *
 *  MaxStack()  初始化栈对象
 *  void push(int val)  将元素x压入栈中
 *  int pop()  移除栈顶元素并返回这个元素
 *  int top() 返回栈顶元素，无需移除
 *  int peekMax() 检索并返回栈中最大元素，无需移除
 *  int popMax() 检索并返回栈中最大元素，并将其移除。如果有多个最大元素，只要移除最靠近栈顶的那一个
 *
 *
 */
public class MaxStack {
    Deque<Integer> xStack;
    Deque<Integer> maxStack;

    public MaxStack() {
        xStack = new LinkedList<>();
        maxStack = new LinkedList<>();
        maxStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        maxStack.push(Math.max(maxStack.peek(), val));
    }

    public int pop() {
        maxStack.pop();
        return xStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    // 额外的栈，先入栈，存一下，直到找到最大的max，删除之后
    // 再把存的数据挨个入栈
    public int popMax() {
        int max = peekMax();
        Deque<Integer> buffer = new LinkedList<>();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}

// 道理一样的，另一种写法，码一下java熟练度
class MaxStack2 {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack2() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max= peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}
