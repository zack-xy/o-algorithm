package dataStructure.栈;

/**
 * 链表实现的栈结构
 * 插入和删除都在头节点
 */
public class MyStackList<T> {
    // 定义链表节点
    class Node<T> {
        public T t;
        public Node next;
    }

    public Node<T> head;
    // 构造函数初始化头指针
    MyStackList() {
        head = null;
    }

    // 入栈
    public void push(T t) {
        if (t == null) {
            throw  new NullPointerException("参数不能为空");
        }
        if (head == null) {
            head = new Node<T>();
            head.t = t;
            head.next = null;
        } else {
            Node<T> temp = head;
            head = new Node<T>();
            head.t = t;
            head.next = temp;
        }
    }

    // 出栈
    public T pop() {
        if (head == null) return null;
        T t = head.t;
        head = head.next;
        return t;
    }

    // 取栈顶元素
    public T peek() {
        if (head == null) return null;
        T t = head.t;
        return t;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        MyStackList<String> stack = new MyStackList<>();
        System.out.println(stack.isEmpty());
        stack.push("Java");
        stack.push("is");
        stack.push("beautiful");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }


}
