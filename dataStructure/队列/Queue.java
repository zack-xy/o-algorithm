package dataStructure.队列;

public class Queue {
    int SIZE = 5;
    int items[] = new int[SIZE];
    int front, rear;

    Queue() {
        front = -1;
        rear = -1;
    }

    // 判断队列是否满了
    boolean isFull() {
        if(rear == SIZE - 1) {
            return true;
        }
        return false;
    }

    // 判断队列是否为空
    boolean isEmpty() {
        return front == -1;
    }

    // 入队
    void enQueue(int element) {
        if(isFull()) {
            System.out.println("Queue is full");
        } else {
            if(front == -1) front = 0;
            rear++;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    // 出队
    int deQueue() {
        int element;
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if(front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Deleted -> " + element);
            return element;
        }
    }

    // 打印队列
    void display() {
        int i;
        if(isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\nFront index-> " + front);
            System.out.println("Item -> ");
            for(i = front;i<=rear;i++) System.out.println(items[i] + " ");
            System.out.println("\nRear index-> " + rear);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        // 空队列上不能出队列
        q.deQueue();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // 第6个元素不能添加因为队列满了
        q.enQueue(6);

        q.display();

        // 出队：1
        q.deQueue();

        // 现在队列有4个元素
        q.display();
    }
}
