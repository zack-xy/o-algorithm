package dataStructure.队列;

// 循环队列
public class CQueue {
    int SIZE = 5;  // 循环队列的大小
    int front, rear;
    int items[] = new int[SIZE];

    CQueue() {
        front = -1;
        rear = -1;
    }

    // 检查队列是否满了
    boolean isFull() {
        if(front == 0 && rear == SIZE - 1) return true;
        if(front == rear + 1) return true;
        return false;
    }

    // 检查队列是否为空
    boolean isEmpty() {
        return front == -1;
    }

    // 入队列
    void enqueue(int element) {
        if(isFull()) {
            System.out.println("Queue is full");
        } else {
            if(front == -1) front = 0;
            rear = (rear + 1) % SIZE;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    // 出队列
    int deQueue() {
        int element;
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            element = items[front];
            if(front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % SIZE;
            }
            return element;
        }
    }

    // 打印队列
    void display() {
        int i;
        if(isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items ->");
            for(i=front;i!=rear;i=(i+1)%SIZE) {
                System.out.println(items[i] + " ");
            }
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }

    public static void main(String[] args) {
        CQueue q = new CQueue();

        // 报错，因为front = -1
        q.deQueue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        // 报错，因为front == 0 并且 rear == SIZE - 1队列已满
        q.enqueue(6);

        q.display();

        int elem = q.deQueue();

        if(elem != -1) {
            System.out.println("Deleted Element is " + elem);
        }
        q.display();

        q.enqueue(7);

        q.display();

        // 报错，因为front == rear + 1 队列已满
        q.enqueue(8);
    }
}
