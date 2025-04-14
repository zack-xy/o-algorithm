package dataStructure.链表;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
    public int getData() {
        return val;
    }
    public void setData(int data) {
        this.val = data;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }

    // 获取链表长度
    public static int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 链表插入
     * @param head 链表头节点
     * @param nodeInsert 待插入节点
     * @param position 待插入位置，从1开始
     * @return 插入后得到的链表头节点
     */
    public static ListNode insertNode(ListNode head, ListNode nodeInsert, int position) {
        if(head == null) {
            // 这里可以认为待插入的结点就是链表的头节点，也可以抛出不能插入的异常
            return nodeInsert;
        }
        // 已经存放的元素个数
        int size = getListLength(head);
        if(position > size + 1 || position < 1) {
            System.out.println("位置参数越界");
            return head;
        }

        // 链表头部插入
        if(position == 1) {
            nodeInsert.next = head;
            head = nodeInsert;
            return head;
        }

        ListNode pNode = head;
        int count = 1;
        // 这里position被上面的size限制住了，不用考虑pNode=null
        while(count < position - 1) {
            pNode = pNode.next;
            count++;
        }
        nodeInsert.next = pNode.next;
        pNode.next = nodeInsert;

        return head;
    }

    public static ListNode deleteNode(ListNode head, int position) {
        if(head == null) {
            return null;
        }
        int size = getListLength(head);
        if(position > size || position < 1) {
            System.out.println("输入的参数有误");
            return head;
        }
        if(position == 1) {
            // curNode就是链表的新head
            return head.next;
        } else {
            ListNode cur = head;
            int count = 1;
            while(count < position - 1) {
                cur = cur.next;
                count++;
            }
            ListNode curNode = cur.next;
            cur.next = curNode.next;
        }
        return head;
    }
}
