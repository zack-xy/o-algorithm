package dataStructure.链表;

public class DoublyLinkList {
    private DoubleNode first;
    private DoubleNode last;
    public DoublyLinkList() {
        first = null;
        last = first;
    }
    // 从头部开始打印
    public void displayForward() {
        System.out.println("List(first--->last): ");
        DoubleNode current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }
    // 从尾部开始打印
    public void displayBackward() {
        System.out.println("List(last--->first): ");
        DoubleNode current = last;
        while (current != null) {
            current.displayNode();
            current = current.prev;
        }
        System.out.println();
    }

    // 头部插入
    public void insertFirst(int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        if (first == null) {
            last = newDoubleNode;
        } else {
            first.prev = newDoubleNode;
        }
        newDoubleNode.next = first;
        first = newDoubleNode;
    }

    // 尾部插入
    public void insertLast(int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        if (first == null) {
            first = newDoubleNode;
        } else {
            newDoubleNode.prev = last;
            last.next = newDoubleNode;
        }
        last = newDoubleNode;
    }

    // 在某处插入
    public void insertAfter(int key, int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        DoubleNode current = first;
        while ((current != null) && (current.data != key)) {
            current = current.next;
        }
        // 若当前节点current为空,也就是没找到要插入的位置
        if (current == null) {
            // 如果链表是空的
            if (first == null) {
                first = newDoubleNode;
                last = newDoubleNode;
            } else {
                // 否则插入到最后
                last.next = newDoubleNode;
                newDoubleNode.prev = last;
                last = newDoubleNode;
            }
        } else {
            // 找到了插入的位置
            // 要插入的位置在最后一个节点
            if (current == last) {
                newDoubleNode.next = null;
                last = newDoubleNode;
            } else {
                // 在2个节点之间插入
                newDoubleNode.next = current.next;
                current.next.prev = newDoubleNode;
            }
            current.next = newDoubleNode;
            newDoubleNode.prev = current;
        }
    }

    // 删除首节点（返回被删除的节点）
    public DoubleNode deleteFirst() {
        DoubleNode temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;
        return temp;
    }

    // 删除尾节点（返回被删除的节点）
    public DoubleNode deleteLast() {
        DoubleNode temp = last;
        if(first.next == null) {
            first = null;
        } else {
            last.prev.next = null;
        }
        last = last.prev;
        return temp;
    }

    // 删除指定节点 (返回被删除的节点)
    public DoubleNode deleteKey(int key) {
        DoubleNode current = first;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            return null;
        } else {
            // 如果current是第一个节点
            if (current == first) {
                first = current.next;
                current.next.prev = null;
            } else if (current == last) {
                last = current.prev;
                current.prev.next = null;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
        return current;
    }
}
