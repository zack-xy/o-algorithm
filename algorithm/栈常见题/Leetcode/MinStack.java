package algorithm.栈常见题.Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * [155. 最小栈](https://leetcode.cn/problems/min-stack/description/)
 * 要求在常数时间内检索到最小元素
 *
 * 这个问题是这样理解的：
 *
 *  比如栈中已经有b，c，d里，此时入栈a，只要a不出栈，b,c,d一定在栈中
 *
 *  所以a可以和a,b,c,d中最小的元素映射，只要栈顶是a元素，那么最小的元素就知道了
 *
 *  采用辅助栈的形式进行设计
 *
 *  1. 当一个元素入栈的时候，取当前辅助栈的栈顶存储的最小值，与当前元素比较的得出最小值，将这个最小值插入辅助栈中
 *  2. 当一个元素要出栈时，就把辅助栈的栈顶元素也一并弹出
 *
 */
public class MinStack {

    Deque<Integer> xStack;
    Deque<Integer> minStack;


    // 初始化堆栈对象
    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    // 将元素val推入堆栈
    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    // 删除堆栈顶部的元素
    // 这个问题难度在于，删除元素的时候，最小值是要变化的，比如说最小值被删除了
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    // 获取堆栈顶部的元素
    public int top() {
        return xStack.peek();
    }

    // 获取堆栈中的最小元素
    public int getMin() {
        return minStack.peek();
    }
}
