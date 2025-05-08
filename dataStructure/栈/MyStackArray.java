package dataStructure.栈;

import java.util.Arrays;

/**
 * 数组实现的栈结构
 */
public class MyStackArray<T> {
    // 实现栈的数组
    private Object[] stack;
    // 栈顶元素索引
    private int top;

    MyStackArray() {
        // 初始容量为10
        stack = new Object[10];
    }

    // 判断是否为空
    public boolean isEmpty() {
        return top == 0;
    }

    // 返回栈顶元素
    // 这里的栈顶指的是栈顶元素的上一个空单位
    // 换一句话说，实际的栈顶元素是top-1存的数据
    public T peek() {
        T t = null;
        if (top > 0) t = (T) stack[top-1];
        return t;
    }

    // 入栈
    public void push(T t) {
        expandCapacity(top + 1);
        stack[top] = t;
        top++;
    }

    // 出栈
    // 实际top-1的位置存的是真实的数据，所以top-1设置为null
    public T pop() {
        T t = peek();
        if (top > 0) {
            stack[top - 1] = null;
            top--;
        }
        return t;
    }

    // 扩大容量
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1; // 每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }

    public static void main(String[] args) {
        MyStackArray<String> stack = new MyStackArray<>();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}
