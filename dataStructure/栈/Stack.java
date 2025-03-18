package dataStructure.栈;

public class Stack {
    private int arr[];
    private int top;
    private int capacity;

    // 创建一个栈
    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // 往栈中添加一个元素
    public void push(int x) {
        if(isFull()) {
            System.out.println("OverFlow\nProgram Terminated\n");
            System.exit(0);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    // 从栈中取出一个元素
    public int pop() {
        if(isEmpty()) {
            System.out.println("STACK EMPTY");
            System.exit(1);
        }
        return arr[top--];
    }

    // 返回栈的大小
    public int size() {
        return top + 1;
    }

    // 检查一个栈是不是空的
    public Boolean isEmpty() {
        return top == -1;
    }

    // 检查栈是不是满了
    public Boolean isFull() {
        return top == capacity - 1;
    }

    // 打印栈
    public void printStack() {
        for(int i=0;i<=top;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println("\nAfter popping out");

        stack.printStack();
    }
}
