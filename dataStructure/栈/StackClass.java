package dataStructure.栈;

import java.util.Stack;

public class StackClass {
    // java.util提供的栈类
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("栈顶元素为： " + stack.peek());
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
        System.out.println("栈顶元素为： " + stack.peek());
    }
}
